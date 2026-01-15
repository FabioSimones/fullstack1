<template>
  <header class="border-b bg-white/80 backdrop-blur">
    <div class="mx-auto max-w-6xl px-4 py-4 flex items-center justify-between">
      <div class="flex items-center gap-2">
        <div class="h-9 w-9 rounded-xl bg-gray-900 text-white grid place-items-center font-bold">JT</div>
        <div>
          <p class="text-sm text-gray-500 leading-none">JTech Challenge</p>
          <h1 class="text-lg font-semibold leading-tight">TODO List</h1>
        </div>
      </div>

      <nav class="flex items-center gap-3">
        <RouterLink to="/tasks" class="text-sm font-medium text-gray-700 hover:text-gray-900">
          Tarefas
        </RouterLink>
        <a
          class="text-sm font-medium text-gray-700 hover:text-gray-900"
          href="https://vuejs.org/"
          target="_blank"
          rel="noreferrer"
        >
          Vue
        </a>
      </nav>
    </div>
  </header>
</template>
