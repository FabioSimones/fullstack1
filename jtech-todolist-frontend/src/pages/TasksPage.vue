
<template>
  <div class="space-y-6">
    <div class="flex flex-col gap-3 md:flex-row md:items-end md:justify-between">
      <div>
        <h2 class="text-2xl font-semibold">Tarefas</h2>
        <p class="text-sm text-gray-500">Gerencie seu backlog com uma interface limpa.</p>
      </div>

      <div class="flex gap-2">
        <div class="relative">
          <input
            v-model.trim="query"
            type="text"
            class="w-full md:w-72 rounded-xl border bg-white px-3 py-2 text-sm outline-none focus:ring-2 focus:ring-gray-900/20"
            placeholder="Buscar por título/descrição..."
          />
        </div>
        <button
          @click="openCreate"
          class="rounded-xl bg-gray-900 px-4 py-2 text-sm font-semibold text-white hover:bg-black"
        >
          + Nova
        </button>
      </div>
    </div>

    <div class="grid grid-cols-1 gap-3">
      <div class="rounded-2xl border bg-white p-4 flex items-center justify-between">
        <div class="flex items-center gap-2">
          <span class="text-sm text-gray-500">Total:</span>
          <span class="text-sm font-semibold">{{ filtered.length }}</span>
        </div>

        <div class="flex items-center gap-2">
          <button
            class="rounded-xl px-3 py-2 text-sm font-semibold text-gray-700 hover:bg-gray-100"
            @click="fetchTasks"
          >
            Recarregar
          </button>
          <select
            v-model="statusFilter"
            class="rounded-xl border bg-white px-3 py-2 text-sm outline-none focus:ring-2 focus:ring-gray-900/20"
          >
            <option value="">Todos</option>
            <option value="pendente">Pendentes</option>
            <option value="concluída">Concluídas</option>
          </select>
        </div>
      </div>

      <UiEmptyState v-if="!loading && filtered.length === 0" cta="Criar tarefa" @cta="openCreate" />

      <div v-if="loading" class="rounded-2xl border bg-white p-8 text-center text-sm text-gray-500">
        Carregando tarefas...
      </div>

      <div
        v-for="t in filtered"
        :key="t.id"
        class="rounded-2xl border bg-white p-4 hover:shadow-sm transition"
      >
        <div class="flex items-start justify-between gap-4">
          <div class="min-w-0">
            <div class="flex items-center gap-2">
              <h3 class="truncate text-base font-semibold">{{ t.title }}</h3>
              <TaskStatusBadge :status="t.status" />
            </div>
            <p class="mt-1 text-sm text-gray-600 line-clamp-2">
              {{ t.description || "Sem descrição" }}
            </p>

            <div class="mt-3 flex items-center gap-3">
              <RouterLink
                :to="`/tasks/${t.id}`"
                class="text-sm font-semibold text-gray-900 hover:underline"
              >
                Ver detalhes
              </RouterLink>
              <span class="text-xs text-gray-400">ID: {{ t.id }}</span>
            </div>
          </div>

          <div class="flex shrink-0 items-center gap-2">
            <button
              class="rounded-xl px-3 py-2 text-sm font-semibold text-gray-700 hover:bg-gray-100"
              @click="openEdit(t)"
            >
              Editar
            </button>
            <button
              class="rounded-xl px-3 py-2 text-sm font-semibold text-red-700 hover:bg-red-50"
              @click="remove(t)"
            >
              Excluir
            </button>
          </div>
        </div>
      </div>
    </div>

    <TaskFormModal
      :open="modalOpen"
      :initial="selected"
      @close="modalOpen = false"
      @submit="handleSubmit"
    />
  </div>
</template>

<script setup>
import { computed, onMounted, ref } from "vue";
import { TasksApi } from "../api/tasks";
import TaskFormModal from "../components/TaskFormModal.vue";
import TaskStatusBadge from "../components/TaskStatusBadge.vue";
import UiEmptyState from "../components/UiEmptyState.vue";

const loading = ref(false);
const tasks = ref([]);
const query = ref("");
const statusFilter = ref("");

const modalOpen = ref(false);
const selected = ref(null);

const filtered = computed(() => {
  const q = query.value.toLowerCase();
  return tasks.value
    .filter((t) => {
      const okStatus = !statusFilter.value || (t.status || "").toLowerCase() === statusFilter.value;
      const okQuery =
        !q ||
        (t.title || "").toLowerCase().includes(q) ||
        (t.description || "").toLowerCase().includes(q);
      return okStatus && okQuery;
    })
    .sort((a, b) => (b.id ?? 0) - (a.id ?? 0));
});

async function fetchTasks() {
  loading.value = true;
  try {
    const { data } = await TasksApi.list();
    tasks.value = Array.isArray(data) ? data : [];
  } finally {
    loading.value = false;
  }
}

function openCreate() {
  selected.value = null;
  modalOpen.value = true;
}

function openEdit(task) {
  selected.value = { ...task };
  modalOpen.value = true;
}

async function handleSubmit(payload) {
  try {
    if (selected.value?.id) {
      await TasksApi.update(selected.value.id, payload);
    } else {
      await TasksApi.create(payload);
    }

    modalOpen.value = false;
    selected.value = null;

    await fetchTasks();
  } catch (e) {
    console.error("API ERROR:", e?.response?.status, e?.response?.data || e);
    alert(
      e?.response?.data?.message ||
      `Falha ao salvar (HTTP ${e?.response?.status || "?"})`
    );
  }
}

async function remove(task) {
  const ok = confirm(`Excluir a tarefa "${task.title}"?`);
  if (!ok) return;

  try {
    await TasksApi.remove(task.id);
    await fetchTasks();
  } catch (e) {
    alert(e?.response?.data?.message || "Falha ao excluir.");
  }
}

onMounted(fetchTasks);
</script>

<style scoped>
/* opcional se quiser clamp sem plugin */
.line-clamp-2 {
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  overflow: hidden;
}
</style>
