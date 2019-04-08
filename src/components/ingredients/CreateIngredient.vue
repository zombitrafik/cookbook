<template>
    <div id = 'container'>
        <header id = 'header'>
            <h1 style = 'text-align: center'>Create ingredient</h1>
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
            <section id = 'sectionCook'>
                <input type = 'submit' value = 'Create' class = 'button' @click="create">
            </section>
        </main>
    </div>
</template>

<script lang="ts">
    import Vue from "vue";

    export default Vue.extend({
        data() {
            return {
                image: '',
                name: '',
                description: '',
                calories: 0
            }
        },
        methods: {
            async create() {
                const ingredient = {
                    image: this.image,
                    name: this.name,
                    description: this.description,
                    calories: this.calories
                };
                await this.$store.dispatch('CREATE_INGREDIENT', ingredient);
                this.$router.push({name: 'ingredients'});
            }
        }
    });
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
