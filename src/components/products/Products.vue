<template>
    <div>
        <div style="text-align: center; font-size: 25px;">
            <span>Products</span>
            <button class="button" @click="createProduct">Create product</button>
        </div>
        <section class = 'ingredients'>
            <div  v-for="product in products" @click="editProduct(product)">
                <img v-bind:src="product.image" alt="">
                <figcaption>{{product.name}}</figcaption>
                <figcaption>{{product.description}}</figcaption>
                <figcaption>{{product.price}} $</figcaption>
            </div>
        </section>
    </div>
</template>

<script lang="ts">
    import { Vue, Component } from "vue-property-decorator";
    @Component
    export default class Products extends Vue {
        get products() {
            return this.$store.state.products;
        }
        createProduct() {
            this.$router.push({name: 'products.create'});
        }
        editProduct(product: any) {
            this.$router.push({name: 'products.edit', params: {id: product.id}});
        }
        async mounted() {
            this.$store.dispatch('GET_PRODUCTS');
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
