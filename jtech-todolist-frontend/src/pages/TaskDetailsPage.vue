<template>
  <div class="space-y-4">
    <div class="flex items-center justify-between">
      <div>
        <RouterLink to="/tasks" class="text-sm font-semibold text-gray-700 hover:text-gray-900 hover:underline">
          ← Voltar
        </RouterLink>
        <h2 class="mt-2 text-2xl font-semibold">Detalhes da tarefa</h2>
      </div>

      <div class="flex gap-2">
        <button class="rounded-xl px-4 py-2 text-sm font-semibold text-gray-700 hover:bg-gray-100" @click="openEdit">
          Editar
        </button>
        <button class="rounded-xl px-4 py-2 text-sm font-semibold text-red-700 hover:bg-red-50" @click="remove">
          Excluir
        </button>
      </div>
    </div>

    <div v-if="loading" class="rounded-2xl border bg-white p-8 text-center text-sm text-gray-500">
      Carregando...
    </div>

    <div v-else-if="!task" class="rounded-2xl border bg-white p-8 text-center">
      <p class="text-lg font-semibold">Tarefa não encontrada</p>
      <p class="text-sm text-gray-500 mt-1">Verifique o ID e tente novamente.</p>
    </div>

    <div v-else class="rounded-2xl border bg-white p-6">
      <div class="flex items-start justify-between gap-4">
        <div class="min-w-0">
          <div class="flex items-center gap-2">
            <h3 class="text-xl font-semibold">{{ task.title }}</h3>
            <TaskStatusBadge :status="task.status" />
          </div>
          <p class="mt-2 text-sm text-gray-600 whitespace-pre-wrap">
            {{ task.description || "Sem descrição." }}
          </p>
        </div>

        <div class="text-right">
          <p class="text-xs text-gray-400">ID</p>
          <p class="text-sm font-semibold">{{ task.id }}</p>
        </div>
      </div>
    </div>

    <TaskFormModal
      :open="modalOpen"
      :initial="task"
      @close="modalOpen = false"
      @submit="handleSubmit"
    />
  </div>
</template>

<script setup>
import { onMounted, ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import { TasksApi } from "../api/tasks";
import TaskFormModal from "../components/TaskFormModal.vue";
import TaskStatusBadge from "../components/TaskStatusBadge.vue";

const route = useRoute();
const router = useRouter();

const loading = ref(false);
const task = ref(null);
const modalOpen = ref(false);

async function fetchOne() {
  loading.value = true;
  task.value = null;
  try {
    const { data } = await TasksApi.getById(route.params.id);
    task.value = data;
  } catch (e) {
    task.value = null;
  } finally {
    loading.value = false;
  }
}

function openEdit() {
  modalOpen.value = true;
}

async function handleSubmit(payload) {
  try {
    await TasksApi.update(task.value.id, payload);
    await fetchOne();
  } catch (e) {
    const msg = e?.response?.data?.message || e?.message || "Erro ao salvar";
    throw new Error(msg);
  }
}

async function remove() {
  const ok = confirm(`Excluir a tarefa "${task.value?.title}"?`);
  if (!ok) return;

  try {
    await TasksApi.remove(task.value.id);
    router.push("/tasks");
  } catch (e) {
    alert(e?.response?.data?.message || "Falha ao excluir.");
  }
}

onMounted(fetchOne);
watch(() => route.params.id, fetchOne);
</script>
