<template>
    <div>
        <h2 style="text-align: center;">Menu</h2>
        <div v-if="id" style="overflow: hidden; text-align: center">
            <button @click="order" style="color: #8BC34A; border-color: #8BC34A;">Order an ingredients</button>
        </div>
        <div>
            <section class = 'ingredients'>
                <div v-for="dish in allDishes">
                    <img v-bind:src="dish.image" @click="viewDish(dish)">
                    <figcaption>{{dish.name}}</figcaption>
                    <figcaption>{{dish.description}}</figcaption>
                    <figcaption>{{dish.calories}}</figcaption>
                    <button style="margin: 0;" @click="addDish(dish)">Add to menu</button>
                </div>
            </section>
        </div>
        <div v-if="viewableDish" style="position: absolute;top: 0;left: 0;right: 0;bottom: 0;background: #fff;overflow: auto;">
            <header>
                <h1 style = 'text-align: center'>{{viewableDish.name}}</h1>
                <a href="javascript:void(0)"><span class="close" @click="closeViewable"></span></a>
            </header>
            <main>
                <img v-bind:src="viewableDish.image" style = 'width: 400px; height: 300px; margin-top: 50px'>
                <h1>Ingredients</h1>

                <section class = 'specification'>
                    <table>
                        <tr>
                            <td>Description</td>
                            <td>{{viewableDish.description}}</td>
                        </tr>
                        <tr>
                            <td>Calories</td>
                            <td>{{viewableDish.calories}}</td>
                        </tr>
                    </table>

                </section>

                <section class = 'ingredients'>
                    <div v-for="ingredient in viewableDish.ingredients">
                        <img v-bind:src="ingredient.image">
                        <figcaption>{{ingredient.name}}</figcaption>
                    </div>
                </section>

                <section id = 'cooking-method'>
                    <h1>Preparation instructions</h1>
                    <ol>
                        <p>{{viewableDish.preparationInstructions}}</p>
                    </ol>
                </section>

                <button style="margin: 0;" @click="addDish(viewableDish)">Add to menu</button>
            </main>
        </div>
    </div>
</template>

<script lang="ts">
    import { Vue, Component } from "vue-property-decorator";

    @Component
    export default class Menu extends Vue {
        id: String = '';
        viewableDish: any = null;

        get allDishes() {
            return this.$store.state.dishes;
        }
        async addDish(dish: any) {
            if(this.id !== '') {
                this.$store.dispatch('ADD_DISH_TO_MENU', {
                    menuId: this.id,
                    dishId: dish.id
                });
            } else {
                this.id = await this.$store.dispatch('CREATE_MENU', {
                    dishes: [{
                        id: dish.id,
                        count: 1
                    }]
                });
                if(typeof this.id === 'string') {
                    this.$router.push({query: {id: this.id}});
                }
            }
            this.closeViewable();
        }

        viewDish(dish: any) {
            this.viewableDish = dish;
        }

        closeViewable() {
            this.viewableDish = null;
        }

        async order() {
            if(typeof this.id === 'string' && this.id !== '') {
                this.$router.push({name: 'order', params: {menuId: this.id}});
            }
        }
        async mounted() {
            this.$store.dispatch('GET_DISHES');

            const {id} = this.$route.query;
            this.id = (id as string) || '';
        }
    }

</script>

<style>
    .ingredients {
        display: flex;
        flex-direction: row;
        justify-content: space-around;
        flex-wrap: wrap;
        align-content: space-around;
        text-align: center;
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

    /**/

    header {
        position: relative;
        min-height: 50px;
        padding: 20px 0;
    }

    main {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-content: space-around;
        margin: auto;
        background-color: #FBEFFB;
        border-radius: 30px;
    }

    .specification {
        width: 60%;
        margin: auto;
        display: flex;
        flex-direction: column;
        justify-content: center;
    }

    table {
        font-family: Arial, Helvetica, sans-serif;
        text-align: center;
        border: 1px solid #F5BCA9;
        margin: 20px;
        border-spacing: 30px;
    }

    img {
        width: 400px;
        height: 250px;
        border-radius: 20px;
        margin: auto;
    }

    h1 {
        text-align: center;
    }

    .close {
        position: absolute;
        right: 32px;
        top: 32px;
        width: 32px;
        height: 32px;
        opacity: 0.3;
    }

    .close:hover {
        opacity: 1;
    }

    .close:before, .close:after {
        position: absolute;
        left: 15px;
        content: ' ';
        height: 33px;
        width: 2px;
        background-color: #333;
    }

    .close:before {
        transform: rotate(45deg);
    }

    .close:after {
        transform: rotate(-45deg);
    }

    .ingredients {
        display: flex;
        flex-direction: row;
        justify-content: space-around;
        flex-wrap: wrap;
        align-content: space-around;
        text-align: center;
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

    #cooking-method {
        display: flex;
        flex-direction: column;
        justify-content: center;
        margin: auto;
        width: 80%;
    }

    .button {
        display: flex;
        margin: auto;
        padding: 40px;
    }

    #button {
        cursor: pointer;
        color: #fff;
        border-radius: 10px;
        text-decoration: none;
        user-select: none;
        background: #CC9999;
        padding: .7em 1.5em;
        outline: none;
        width: 200px;
    }
</style>
