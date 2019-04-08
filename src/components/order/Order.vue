<template>
    <div>
        <h2 style="text-align: center">Ingredients mapping</h2>
        <div style="text-align: center;">
            <button class="pay" @click="pay" v-bind:disabled="true">Pay</button>
        </div>
    </div>
</template>

<script lang="ts">
    import {Vue, Component} from "vue-property-decorator";

    @Component
    export default class Order extends Vue {

        async pay() {
            console.log('pay');
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
    .pay:disabled {
        border-color: silver;
        color: silver;
    }
</style>
