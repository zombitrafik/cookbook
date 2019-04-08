import Vue from "vue";
import Vuex from "vuex";
import Store from './store';
import router from './router';
import DishesComponent from "./components/dishes/Dishes.vue";
import IngredientsComponent from "./components/ingredients/Ingredients.vue";

Vue.use(Vuex);

const store = new Vuex.Store(Store);

let v = new Vue({
    el: "#app",
    store,
    router,
    template: `
    <div>
    <button class="button" @click="dishes">Dishes</button>
    <button class="button" @click="ingredients">Ingredients</button>
    <button class="button" @click="products">Products</button>
    <router-view></router-view>
    </div>
    `,
    methods: {
        dishes() {
            this.$router.push({name: 'dishes'});
        },
        ingredients() {
            this.$router.push({name: 'ingredients'});
        },
        products() {
            this.$router.push({name: 'products'});
        }
    },
    components: {
        DishesComponent,
        IngredientsComponent
    },
    mounted() {
        console.log(this.$route.path);
        //this.dishes();
    }
});
