import Axios from 'axios';

export default {
    state: {
        dishes: [],
        products: [],
        ingredients: []
    },
    mutations: {
        SET_DISHES(state: any, dishes: any[]) {
            state.dishes = dishes;
        },
        SET_INGREDIENTS(state: any, ingredients: any[]) {
            state.ingredients = ingredients;
        },
        SET_PRODUCTS(state: any, products: any[]) {
            state.products = products;
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
            await Axios.put(`http://82.209.201.172:9003/dishes/${payload.id}`, payload);
        },
        async GET_DISH_BY_ID(context: any, id: any): Promise<any> {
            const {data: dish} = await Axios.get(`http://82.209.201.172:9003/dishes/${id}`);
            return dish;
        },
        async CREATE_INGREDIENT(context: any, payload: any): Promise<any> {
            await Axios.post('http://82.209.201.172:9003/ingredients', payload);
        },
        async UPDATE_INGREDIENT(context: any, payload: any): Promise<any> {
            await Axios.put(`http://82.209.201.172:9003/ingredients/${payload.id}`, payload);
        },
        async GET_INGREDIENT_BY_ID(context: any, id: any): Promise<any> {
            const {data: ingredient} = await Axios.get(`http://82.209.201.172:9003/ingredients/${id}`);
            return ingredient;
        },
        async GET_PRODUCTS(context: any): Promise<any> {
            const {data: products} = await Axios.get('http://82.209.201.172:9003/products');
            context.commit('SET_PRODUCTS', products);
        },
        async CREATE_PRODUCT(context: any, payload: any): Promise<any> {
            await Axios.post('http://82.209.201.172:9003/products', payload);
        },
        async UPDATE_PRODUCT(context: any, payload: any): Promise<any> {
            await Axios.put(`http://82.209.201.172:9003/products/${payload.id}`, payload);
        },
        async GET_PRODUCT_BY_ID(context: any, id: any): Promise<any> {
            const {data: product} = await Axios.get(`http://82.209.201.172:9003/products/${id}`);
            return product;
        },
    }
};
