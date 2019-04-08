<template>
    <div>
        <div style="text-align: center; font-size: 25px;">
            <span>Ingredients</span>
            <button class="button" @click="createIngredient">Create ingredient</button>
        </div>
        <section class = 'ingredients'>
            <div  v-for="ingredient in ingredients" @click="editIngredient(ingredient)">
                <img v-bind:src="ingredient.image" alt="">
                <figcaption>{{ingredient.name}}</figcaption>
                <figcaption>{{ingredient.description}}</figcaption>
                <figcaption>{{ingredient.calories}} kl.</figcaption>
            </div>
        </section>
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
