import { createRouter, createWebHistory } from "vue-router";
import Game from '../pages/Game.vue';
import Menu from '../pages/Start.vue';

const routes = [
  { path: "/", component: Menu },
  { path: "/game", component: Game },
];

const history = createWebHistory();

const router = createRouter({
  history,
  routes,
});

export default router;
