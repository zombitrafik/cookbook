<template>
    <div>
        <h2>Menu</h2>
        <div>
            <label for="name">
                <span>Name</span>
                <input type="text" v-model="name" id="name">
            </label>
        </div>
        <div v-for="dish in dishes">
            <div>{{dish.name}}</div>
            <div>{{dish.description}}</div>
            <div>{{dish.calories}}</div>
            <span @click="removeDish(dish)">x</span>
        </div>
        <div>
            <button @click="order">Order an ingredients</button>
        </div>

        <div>
            <div>Dishes</div>
            <div v-for="dish in allDishes" @click="addDish(dish)">
                <div>{{dish.name}}</div>
                <div>{{dish.description}}</div>
                <div>{{dish.calories}}</div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
    import { Vue, Component } from "vue-property-decorator";

    @Component
    export default class Menu extends Vue {
        id: String | null = null;
        name: String = '';
        dishes: any[] = [];

        get allDishes() {
            return this.$store.state.dishes;
        }

        removeDish(dish: any) {
            this.dishes.splice(this.dishes.indexOf(dish), 1);
        }
        addDish(dish: any) {
            this.dishes.push(dish);
        }
        async order() {
            const menu = {
                id: this.id,
                name: this.name,
                dishes: this.dishes.map(dish => {
                    return {
                        id: dish.id,
                        count: 1
                    }
                })
            };
            const menuId = await this.$store.dispatch('CREATE_MENU', menu);
            this.$router.push({name: 'order', params: {menuId}});
        }
        async mounted() {
            this.$store.dispatch('GET_DISHES');
        }
    }

</script>

<style>

</style>
