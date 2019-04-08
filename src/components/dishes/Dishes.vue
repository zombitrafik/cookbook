<template>
    <div>
        <div style="text-align: center; font-size: 25px;">
            <span>Dishes</span>
            <button class="button" @click="createDish">Create dish</button>
        </div>
        <section class = 'ingredients'>
            <div  v-for="dish in dishes" @click="editDish(dish)">
                <img v-bind:src="dish.image" alt="">
                <figcaption>{{dish.name}}</figcaption>
                <figcaption>{{dish.description}}</figcaption>
                <figcaption>{{dish.calories}} kl.</figcaption>
            </div>
        </section>
    </div>
</template>

<script lang="ts">
    import Vue from "vue";
    import {mapState} from 'vuex';

    export default Vue.extend({
        computed: {
            ...mapState(['dishes'])
        },
        mounted() {
            this.$store.dispatch('GET_DISHES');
        },
        methods: {
            createDish() {
                this.$router.push({name: 'dishes.create'});
            },
            editDish(dish: any) {
                this.$router.push({name: 'dishes.edit', params: {id: dish.id}});
            }
        }
    });
</script>

<style>
    .ingredients {
        display: flex;
        flex-direction: row;
        justify-content: space-around;
        flex-wrap: wrap;
        align-content: space-around;
        text-align: center;
        margin: 30px auto 0 auto;
    }

    .ingredients img {
        width: 160px;
        height: 130px;
        border-radius: 25px;

        -webkit-filter: brightness(100%);
        -webkit-transition: all 1s ease;
        -moz-transition: all 1s ease;
        -o-transition: all 1s ease;
        -ms-transition: all 1s ease;
        transition: all 1s ease;
    }

    .ingredients img:hover {
        -webkit-filter: brightness(60%);
        margin: auto;
    }
</style>
