<template>
    <div>
        <h2>Edit ingredient</h2>
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
            <button @click="save">Save</button>
        </div>
    </div>
</template>

<script lang="ts">
    import Vue from "vue";

    export default Vue.extend({
        data() {
            return {
                id: null,
                name: '',
                description: '',
                calories: 0
            }
        },
        methods: {
            async save() {
                const ingredient = {
                    id: this.$data.id,
                    name: this.name,
                    description: this.description,
                    calories: this.calories
                };
                await this.$store.dispatch('UPDATE_INGREDIENT', ingredient);
                this.$router.push({name: 'ingredients'});
            }
        },
        async mounted() {
            const ingredient = await this.$store.dispatch('GET_INGREDIENT_BY_ID', this.$route.params.id);
            this.$data.id = ingredient.id;
            this.name = ingredient.name;
            this.description = ingredient.description;
            this.calories = ingredient.calories;
        }
    });
</script>

<style>

</style>
