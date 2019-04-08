import Axios from 'axios';

export default {
    state: {
        dishes: [],
        products: []
    },
    mutations: {
        SET_DISHES(state: any, dishes: any[]) {
            state.dishes = dishes;
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
        async GET_PRODUCTS(context: any): Promise<any> {
            const {data: products} = await Axios.get('http://82.209.201.172:9003/products');
            context.commit('SET_PRODUCTS', products);
        },
        async CREATE_MENU(context: any, payload: any): Promise<any> {
            const {data: menu} = await Axios.post('http://82.209.201.172:9003/menus', payload);
            return menu.id;
        },
        async GET_MENU_BY_ID(context: any, id: any): Promise<any> {
            const {data: menu} = await Axios.get(`http://82.209.201.172:9003/menus/${id}`);
            return menu;
        },
        async ADD_DISH_TO_MENU(context: any, payload: any): Promise<any> {
            await Axios.post(`http://82.209.201.172:9003/menus/${payload.menuId}/${payload.dishId}`);
        }
    }
};