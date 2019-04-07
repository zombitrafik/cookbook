<template>
    <div>
        <h2>Create ingredient</h2>
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
        <div>
            <button @click="create">Create</button>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from "vue";

    export default Vue.extend({
        data() {
            return {
                name: '',
                description: '',
                calories: 0
            }
        },
        methods: {
            async create() {
                const ingredient = {
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

</style>
