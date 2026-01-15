<template>
  <span :class="badgeClass" class="inline-flex items-center rounded-full px-2.5 py-1 text-xs font-semibold">
    {{ label }}
  </span>
</template>

<script setup>
import { computed } from "vue";

const props = defineProps({
  status: { type: String, default: "pendente" },
});

const normalized = computed(() => (props.status || "").toLowerCase());

const label = computed(() => {
  if (normalized.value.includes("concl")) return "Concluída";
  if (normalized.value.includes("pend")) return "Pendente";
  return props.status || "—";
});

const badgeClass = computed(() => {
  if (normalized.value.includes("concl")) return "bg-emerald-100 text-emerald-700";
  if (normalized.value.includes("pend")) return "bg-amber-100 text-amber-800";
  return "bg-gray-100 text-gray-700";
});
</script>
