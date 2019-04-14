<template>
    <div>
        <h2 style="text-align: center">Ingredients mapping</h2>
        <section class = 'specification'>
            <table>
                <tr v-for="ingredient in ingredients">
                    <td style="width: 50%;">
                        <div class="ingredients" style="text-align: center">
                            <img v-bind:src="ingredient.image">
                            <div style="width: 100%;">{{ingredient.name}}</div>
                        </div>
                    </td>
                    <td style="width: 50%;">
                        <select v-model="ingredient.productId">
                            <option v-for="option in ingredient.products" v-bind:value="option.id">
                                {{option.name}} (${{option.price}})
                            </option>
                        </select>
                    </td>
                </tr>
            </table>

        </section>
        <div style="text-align: center;">
            <button class="pay" @click="pay" v-bind:disabled="payDisabled">Pay</button>
        </div>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Order extends Vue {
        ingredients: any[] = [];

        async pay() {
            console.log('pay', this.ingredients);
        }

        get payDisabled() {
            return this.ingredients.some((ingredient: any) => !ingredient.productId);
        }

        async mounted() {
            const {menuId} = this.$route.params;
            const ingredients = await this.$store.dispatch('GET_MENU_INGREDIENTS', menuId);
            this.ingredients = ingredients.map((ingr: any) => {
                ingr.products = [];
                return ingr;
            });
            this.ingredients.forEach((ingr: any) => this.getIngredientProducts(ingr));
        }

        async getIngredientProducts(ingredient: any) {
            ingredient.products = await this.$store.dispatch('GET_INGREDIENT_PRODUCTS', ingredient.id);
        }
    }

</script>

<style>
    .pay:disabled {
        border-color: silver;
        color: silver;
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
