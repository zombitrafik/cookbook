<template>
    <div>
        <h2>Ingredients mapping</h2>
        TODO map ingredients to products
        <div>
            <button @click="order">Next</button>
        </div>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Order extends Vue {

        async order() {
            //TODO
        }

        async mounted() {
            this.$store.dispatch('GET_PRODUCTS');
            const {menuId} = this.$route.params;
            const menu = await this.$store.dispatch('GET_MENU_BY_ID', menuId);
            console.log(menu);
        }
    }

</script>

<style>

</style>
