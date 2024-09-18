import { createRouter, createWebHistory } from 'vue-router'
import CustomersView from '../views/CustomersView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'customersView',
      component: CustomersView
    },
    {
      path: '/addCustomer',
      name: 'addCustomer',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AddCustomerView.vue')
    }
  ]
})

export default router
