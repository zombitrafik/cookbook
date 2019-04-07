import VueRouter from 'vue-router';
import Vue from 'vue';

Vue.use(VueRouter);

import MenuComponent from '../components/menu/Menu.vue';
import OrderComponent from '../components/order/Order.vue';

const routes = [
    {
        path: '/menu',
        name: 'menu',
        component: MenuComponent
    },
    {
        path: '/order/:menuId',
        name: 'order',
        component: OrderComponent
    },
    {
        path: '/',
        redirect: {name: 'menu'}
    },
    {
        path: "*",
        redirect: {name: 'menu'}
    }
];

export default new VueRouter({
    routes // сокращённая запись для `routes: routes`
});
