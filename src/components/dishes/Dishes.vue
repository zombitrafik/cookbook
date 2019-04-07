<template>
    <div>
        <span>Dishes</span>
        <button @click="createDish">Create dish</button>
        <div v-for="dish in dishes" @click="editDish(dish)">
            <span>{{dish.name}}</span>
        </div>
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
    .greeting {
        font-size: 20px;
    }
</style>
