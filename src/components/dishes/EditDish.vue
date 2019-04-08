<template>
    <div id = 'container'>
        <header id = 'header'>
            <h1 style = 'text-align: center'>Edit dish</h1>
        </header>

        <main>
            <figure  class = 'foto'>
                <img v-bind:src="image" v-if="image">
                <input type="text" v-model="image"  placeholder="Image URL"/>
            </figure>

            <section>
                <h1>Name <input type="text" v-model="name"></h1>
                <table id = 'table-specification'>
                    <tr>
                        <td>Description</td>
                        <td><textarea cols="30" rows="10" v-model="description"></textarea></td>
                    </tr>
                    <tr>
                        <td>Calories</td>
                        <td><input type="number" v-model="calories"> kl.</td>
                    </tr>
                </table>
            </section>

            <section>
                <h1>You will need:</h1>
                <div class = 'ingredients'>
                    <div v-for="ingredient in ingredients">
                        <img v-bind:src="ingredient.image">
                        <figcaption>{{ingredient.name}}</figcaption>
                        <figcaption>Weight <input type="number" v-model="ingredient.weight"> gr.</figcaption>
                        <span @click="removeIngredient(ingredient)" style="color: red;">x</span>
                    </div>
                </div>
                <button class = 'button' @click="openIngredientsPopup">Add ingredient</button>
                <div class = 'ingredients' v-if="ingredientsPopup">
                    <div v-for="ingredient in restIngredients"  @click="addIngredient(ingredient)">
                        <img v-bind:src="ingredient.image">
                        <figcaption>{{ingredient.name}}</figcaption>
                        <figcaption>{{ingredient.description}}</figcaption>
                    </div>
                </div>
            </section>

            <section id = 'sectionCook'>
                <h1>Preparation instructions</h1>
                <textarea cols="30" rows="10" v-model="preparationInstructions"></textarea>
                <input type = 'submit' value = 'Save' class = 'button' @click="save">
            </section>
        </main>
    </div>
</template>

<script lang="ts">
    import { Vue, Component } from "vue-property-decorator";
    @Component
    export default class EditDish extends Vue {
        id: String | null = null;
        image: String | null = null;
        name: String = '';
        description: String = '';
        calories: Number = 0;
        preparationInstructions: String = '';
        ingredients: any[] = [];
        restIngredients: any[] = [];
        ingredientsPopup: boolean = false;

        removeIngredient(ingredient: any) {
            this.ingredients.splice(this.ingredients.indexOf(ingredient), 1);
        }
        openIngredientsPopup() {
            const selectedIngredientsIds = this.ingredients.map((ingredient: any) => ingredient.id);
            this.restIngredients = this.$store.state.ingredients
                .filter((ingredient: any) => selectedIngredientsIds.indexOf(ingredient.id) === -1);

            if(this.removeIngredient.length > 0) {
                this.ingredientsPopup = true;
            }
        }
        addIngredient(ingredient: any) {
            this.ingredients.push(ingredient);
            this.ingredientsPopup = false;
        }
        async save() {
            const dish = {
                id: this.id,
                image: this.image,
                name: this.name,
                description: this.description,
                calories: this.calories,
                preparationInstructions: this.preparationInstructions,
                ingredients: this.ingredients.map((ingredient: any) => {
                    return {
                        id: ingredient.id,
                        count: 0,
                        weight: +ingredient.weight || 0
                    }
                })
            };
            await this.$store.dispatch('UPDATE_DISH', dish);
            this.$router.push({name: 'dishes'});
        }
        async mounted() {
            this.$store.dispatch('GET_INGREDIENTS');
            const dish = await this.$store.dispatch('GET_DISH_BY_ID', this.$route.params.id);
            this.id = dish.id;
            this.image = dish.image;
            this.name = dish.name;
            this.description = dish.description;
            this.calories = dish.calories;
            this.preparationInstructions = dish.preparationInstructions;
            this.ingredients = dish.ingredients;
        }
    }

</script>

<style>
    body {
        color: #3B0B24;
        border-top: 5px solid #7e7e7e;
        width: 80%;
        font-family: "Monotype Corsiva";
        font-size: 22px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        margin: auto;
    }

    #container {
        /* margin-top: 10px; */
        border-radius: 25px;
        width: 70%;
        background-color: rgb(250, 245, 240);
        display: flex;
        flex-direction: column;
        justify-content: center;
        margin: auto;
    }

    header {
        padding: 20px 0;
    }

    p {
        margin: 20px 0;
    }

    h1 {
        font-size:2em;
    }

    main {
        /* max-width: 960px; */
        display: flex;
        flex-direction: column;
        justify-content: center;
        margin: 30px;
        border-radius: 30px;
    }

    table {
        border-spacing: 30px;
    }

    .foto  {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    section {
        border-radius: 30px;
        text-align: center;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .foto img {
        width: 60%;
        height: 60%;
        border-radius: 35px;
    }

    hr {
        border: none;
        background-color: rgb(204, 115, 115);
        color: rgb(204, 115, 115);
        height: 2px;
    }

    .ingredients {
        display: flex;
        flex-direction: row;
        justify-content: space-around;
        flex-wrap: wrap;
        align-content: space-around;
        margin: auto;

    }

    .ingredients img {
        width: 150px;
        height: 120px;
        border-radius: 25px;
    }

    #button {
        margin: auto;
    }

    .button {
        margin-top: 40px;
        padding: 5px 5px;
        border-radius: 10px;
        border: 2px solid;
        font: 16px 'Open Sans', sans-serif;
        text-transform: uppercase;
        background: none;
        outline: none;
        cursor: pointer;
        transition: all .5s;

        color: rgb(185, 80, 103);
        border-color:rgb(185, 80, 103);
        background: linear-gradient(left, #A3F7BF, #A3F7BF) no-repeat;
        background-size: 0% 100%;
    }

    #footer {
        background-color: rgb(250, 245, 240);
        color: #2E2E2E;
        /* border-radius: 30px; */
        padding: 5px; clear : both;
    }

    #footer a {
        color: #2E2E2E;
    }

    #footer a:hover {
        color: #F5A9BC;
    }

    #footer p {
        padding: 2px;
        text-align: center;
    }
    input {
        border-radius: 5px;
        height: 30px;
        width: 250px;
    }
</style>
