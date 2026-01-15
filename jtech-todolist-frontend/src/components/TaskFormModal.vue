<template>
  <div v-if="open" class="fixed inset-0 z-50">
    <div class="absolute inset-0 bg-black/40" @click="close"></div>

    <div class="absolute inset-0 flex items-center justify-center p-4">
      <div class="w-full max-w-lg rounded-2xl bg-white shadow-xl border">
        <div class="p-5 border-b flex items-start justify-between">
          <div>
            <h2 class="text-lg font-semibold">{{ isEdit ? "Editar tarefa" : "Nova tarefa" }}</h2>
            <p class="text-sm text-gray-500">Preencha os campos e salve.</p>
          </div>
          <button class="text-gray-500 hover:text-gray-900" @click="close">✕</button>
        </div>

        <form class="p-5 space-y-4" @submit.prevent="onSubmit">
          <div>
            <label class="text-sm font-medium">Título</label>
            <input v-model.trim="form.title" type="text"
              class="mt-1 w-full rounded-xl border bg-white px-3 py-2 text-sm outline-none focus:ring-2 focus:ring-gray-900/20"
              placeholder="Ex: Implementar documentação" />
            <p v-if="errors.title" class="mt-1 text-xs text-red-600">{{ errors.title }}</p>
          </div>

          <div>
            <label class="text-sm font-medium">Descrição</label>
            <textarea v-model.trim="form.description" rows="3"
              class="mt-1 w-full rounded-xl border bg-white px-3 py-2 text-sm outline-none focus:ring-2 focus:ring-gray-900/20"
              placeholder="Detalhes da tarefa..."></textarea>
          </div>

          <div>
            <label class="text-sm font-medium">Status</label>
            <select v-model="form.status"
              class="mt-1 w-full rounded-xl border bg-white px-3 py-2 text-sm outline-none focus:ring-2 focus:ring-gray-900/20">
              <option value="PENDENTE">Pendente</option>
              <option value="CONCLUIDA">Concluída</option>


            </select>
          </div>

          <div v-if="serverError" class="rounded-xl border border-red-200 bg-red-50 p-3 text-sm text-red-700">
            {{ serverError }}
          </div>

          <div class="flex items-center justify-end gap-2 pt-2">
            <button type="button" class="rounded-xl px-4 py-2 text-sm font-semibold text-gray-700 hover:bg-gray-100"
              @click="close">
              Cancelar
            </button>
            <button type="submit" :disabled="loading"
              class="rounded-xl bg-gray-900 px-4 py-2 text-sm font-semibold text-white hover:bg-black disabled:opacity-60">
              {{ loading ? "Salvando..." : "Salvar" }}
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script setup>
import { computed, reactive, watch, ref } from "vue";

const props = defineProps({
  open: { type: Boolean, default: false },
  initial: { type: Object, default: null }, // {id,title,description,status}
});

const emit = defineEmits(["close", "submit"]);

const loading = ref(false);
const serverError = ref("");

const form = reactive({
  title: "",
  description: "",
  status: "pendente",
});

const errors = reactive({ title: "" });

const isEdit = computed(() => !!props.initial?.id);

watch(
  () => props.initial,
  (val) => {
    serverError.value = "";
    errors.title = "";
    form.title = val?.title ?? "";
    form.description = val?.description ?? "";
    form.status = val?.status ?? "pendente";
  },
  { immediate: true }
);

function close() {
  emit("close");
}

function validate() {
  errors.title = "";
  if (!form.title || !form.title.trim()) {
    errors.title = "Título é obrigatório.";
    return false;
  }
  return true;
}

async function onSubmit() {
  serverError.value = "";
  if (!validate()) return;

  loading.value = true;
  try {
    await emit("submit", {
      title: form.title,
      description: form.description,
      status: form.status,
    });
    close();
  } catch (e) {
    serverError.value = e?.message || "Falha ao salvar.";
  } finally {
    loading.value = false;
  }
}
</script>
