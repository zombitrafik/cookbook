import Vue from "vue";
import Vuex from "vuex";
import Store from './store';
import router from './router';

Vue.use(Vuex);

const store = new Vuex.Store(Store);

let v = new Vue({
    el: "#app",
    store,
    router,
    template: `
    <div>
    <router-view></router-view>
    </div>
    `
});
