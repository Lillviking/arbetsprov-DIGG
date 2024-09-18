import { createRouter, createWebHistory } from 'vue-router'
import CustomersView from '../views/CustomersView.vue'
import AddCustomerView from '../views/AddCustomerView.vue';

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
      component: AddCustomerView
    }
  ]
})

export default router
