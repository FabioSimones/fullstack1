import { http } from "./http";

const BASE = "/tasks";

export const TasksApi = {
  list: () => http.get(BASE),
  getById: (id) => http.get(`${BASE}/${id}`),
  create: (payload) => http.post(BASE, payload),
  update: (id, payload) => http.put(`${BASE}/${id}`, payload),
  remove: (id) => http.delete(`${BASE}/${id}`),
};
