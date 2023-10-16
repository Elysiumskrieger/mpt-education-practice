import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'Home',
    meta: {
      title: 'Учебная практика УП.04.01 П50-5-20',
    },
    component: () => import('@/views/Home.vue'),
  },
  {
    path: '/task1/calculator',
    name: 'Task1Calculator',
    meta: {
      title: 'Задание 1. Калькулятор',
    },
    component: () => import('@/views/task1/Calculator.vue'),
  },
  {
    path: '/task1/cash-converter',
    name: 'Task1Converter',
    meta: {
      title: 'Задание 1. Конвертер валют',
    },
    component: () => import('@/views/task1/Converter.vue'),
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

const DEFAULT_TITLE = 'Учебная практика';
router.afterEach((to, from) => {
  nextTick(() => {
    // @ts-ignore
    document.title = to.meta.title || DEFAULT_TITLE;
  })
})

export default router
