import VueRouter from 'vue-router';
import Vue from 'vue';

Vue.use(VueRouter);

import DishesComponent from '../components/dishes/Dishes.vue';
import EditDishComponent from '../components/dishes/EditDish.vue';
import CreateDishComponent from '../components/dishes/CreateDish.vue';
import IngredientsComponent from '../components/ingredients/Ingredients.vue';
import CreateIngredientComponent from '../components/ingredients/CreateIngredient.vue';
import EditIngredientComponent from '../components/ingredients/EditIngredient.vue';

const routes = [
    {
        path: '/dishes',
        name: 'dishes',
        component: DishesComponent
    },
    {
        path: '/dishes/:id/edit',
        name: 'dishes.edit',
        component: EditDishComponent
    },
    {
        path: '/dishes/create',
        name: 'dishes.create',
        component: CreateDishComponent
    },
    {
        path: '/ingredients',
        name: 'ingredients',
        component: IngredientsComponent
    },
    {
        path: '/ingredients/create',
        name: 'ingredients.create',
        component: CreateIngredientComponent
    },
    {
        path: '/ingredients/:id/edit',
        name: 'ingredients.edit',
        component: EditIngredientComponent
    },
    {
        path: '/',
        redirect: {name: 'dishes'}
    },
    {
        path: "*",
        redirect: {name: 'dishes'}
    }
];

export default new VueRouter({
    routes // сокращённая запись для `routes: routes`
});
