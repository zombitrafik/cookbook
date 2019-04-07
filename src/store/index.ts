import Axios from 'axios';

export default {
    state: {
        dishes: [],
        ingredients: [{
            name: 'ingredient 1 name',
            description: 'ingredient 1 description',
            calories: 42,
            id: 1
        },{
            name: 'ingredient 2 name',
            description: 'ingredient 2 description',
            calories: 142,
            id: 2
        }]
    },
    mutations: {
        SET_DISHES(state: any, dishes: any[]) {
            state.dishes = dishes;
        },
        SET_INGREDIENTS(state: any, ingredients: any[]) {
            state.ingredients = ingredients;
        }
    },
    actions: {
        async GET_DISHES(context: any): Promise<any> {
            const {data: dishes} = await Axios.get('http://82.209.201.172:9003/dishes');
            context.commit('SET_DISHES', dishes);
        },
        async GET_INGREDIENTS(context: any): Promise<any> {
            const {data: ingredients} = await Axios.get('http://82.209.201.172:9003/ingredients');
            context.commit('SET_INGREDIENTS', ingredients);
        },
        async CREATE_DISH(context: any, payload: any): Promise<any> {
            await Axios.post('http://82.209.201.172:9003/dishes', payload);
        },
        async UPDATE_DISH(context: any, payload: any): Promise<any> {
            await Axios.put('http://82.209.201.172:9003/dishes', payload);
        },
        async GET_DISH_BY_ID(context: any, id: any): Promise<any> {
            const {data: dish} = await Axios.get(`http://82.209.201.172:9003/dishes/list?ids=${id}`);
            return dish[0];
        },
        async CREATE_INGREDIENT(context: any, payload: any): Promise<any> {
            await Axios.post('http://82.209.201.172:9003/ingredients', payload);
        },
        async UPDATE_INGREDIENT(context: any, payload: any): Promise<any> {
            await Axios.put('http://82.209.201.172:9003/ingredients', payload);
        },
        async GET_INGREDIENT_BY_ID(context: any, id: any): Promise<any> {
            const {data: ingredient} = await Axios.get(`http://82.209.201.172:9003/ingredients/list?ids=${id}`);
            return ingredient[0];
        }
    }
};