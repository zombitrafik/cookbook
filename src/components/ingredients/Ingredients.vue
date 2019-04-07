<template>
    <div>
        <span>Ingredients</span>
        <button @click="createIngredient">Create ingredient</button>
        <div v-for="ingredient in ingredients" @click="editIngredient(ingredient)">
            <span>{{ingredient.name}}</span>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from "vue";
    import {mapState} from 'vuex';

    export default Vue.extend({
        computed: {
            ...mapState(['ingredients'])
        },
        mounted() {
            this.$store.dispatch('GET_INGREDIENTS');
        },
        methods: {
            createIngredient() {
                this.$router.push({name: 'ingredients.create'});
            },
            editIngredient(ingredient: any) {
                this.$router.push({name: 'ingredients.edit', params: {id: ingredient.id}});
            }
        }
    });
</script>

<style>
    .greeting {
        font-size: 20px;
    }
</style>
