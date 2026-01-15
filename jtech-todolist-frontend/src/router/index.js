import { createRouter, createWebHistory } from "vue-router";
import TasksPage from "../pages/TasksPage.vue";
import TaskDetailsPage from "../pages/TaskDetailsPage.vue";

export default createRouter({
  history: createWebHistory(),
  routes: [
    { path: "/", redirect: "/tasks" },
    { path: "/tasks", component: TasksPage },
    { path: "/tasks/:id", component: TaskDetailsPage, props: true },
  ],
});
