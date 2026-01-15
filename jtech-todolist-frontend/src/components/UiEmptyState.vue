<template>
  <div class="rounded-2xl border bg-white p-8 text-center">
    <p class="text-lg font-semibold">Nenhuma tarefa encontrada</p>
    <p class="mt-1 text-sm text-gray-500">Crie uma nova tarefa para começar.</p>
    <button
      v-if="cta"
      @click="$emit('cta')"
      class="mt-4 inline-flex items-center justify-center rounded-xl bg-gray-900 px-4 py-2 text-sm font-semibold text-white hover:bg-black"
    >
      {{ cta }}
    </button>
  </div>
</template>

<script setup>
defineProps({ cta: { type: String, default: "" } });
defineEmits(["cta"]);
</script>
