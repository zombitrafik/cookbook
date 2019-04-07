<template>
    <div>
        <h2>Create dish</h2>
        <div>
            <label for="name">
                <span>Name</span>
                <input type="text" v-model="name" id="name">
            </label>
        </div>
        <div>
            <label for="description">
                <span>Description</span>
                <input type="text" v-model="description" id="description">
            </label>
        </div>
        <div>
            <label for="calories">
                <span>Calories</span>
                <input type="number" v-model="calories" id="calories">
            </label>
        </div>
        <h4>You will need:</h4>
        <div v-for="ingredient in ingredients">
            <div>{{ingredient.name}}</div>
            <div>{{ingredient.description}}</div>
            <div>{{ingredient.calories}}</div>
            <span @click="removeIngredient(ingredient)">x</span>
        </div>
        <button @click="openIngredientsPopup">Add ingredient</button>
        <h4>Preparation instructions:</h4>
        <textarea name="" id="" cols="30" rows="10" v-model="preparationInstructions"></textarea>
        <div>
            <button @click="create">Create</button>
        </div>
        <div v-if="ingredientsPopup">
            <div v-for="ingredient in restIngredients" @click="addIngredient(ingredient)">
                <div>{{ingredient.name}}</div>
                <div>{{ingredient.description}}</div>
                <div>{{ingredient.calories}}</div>
            </div>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from "vue";

    export default Vue.extend({
        data() {
            const ingredients:any = [];
            const restIngredients:any = [];
            return {
                name: '',
                description: '',
                calories: 0,
                preparationInstructions: '',
                ingredients,
                restIngredients,
                ingredientsPopup: false
            }
        },
        methods: {
            removeIngredient(ingredient: any) {
                this.ingredients.splice(this.ingredients.indexOf(ingredient), 1);
            },
            openIngredientsPopup() {
                const selectedIngredientsIds = this.ingredients.map((ingredient: any) => ingredient.id);
                this.restIngredients = this.$store.state.ingredients
                    .filter((ingredient: any) => selectedIngredientsIds.indexOf(ingredient.id) === -1);

                if(this.removeIngredient.length > 0) {
                    this.ingredientsPopup = true;
                }
            },
            addIngredient(ingredient: any) {
                this.ingredients.push(ingredient);
                this.ingredientsPopup = false;
            },
            async create() {
                const dish = {
                    name: this.name,
                    description: this.description,
                    calories: this.calories,
                    preparationInstructions: this.preparationInstructions,
                    ingredients: this.ingredients.map((ingredient: any) => {
                        return {
                            id: ingredient.id,
                            count: 0,
                            weight: 0
                        }
                    })
                };
                await this.$store.dispatch('CREATE_DISH', dish);
                this.$router.push({name: 'dishes'});
            }
        },
        mounted() {
            this.$store.dispatch('GET_INGREDIENTS');
        }
    });
</script>

<style>

</style>
