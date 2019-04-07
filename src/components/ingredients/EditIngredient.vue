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
    import { Vue, Component } from "vue-property-decorator";
    @Component
    export default class EditIngredient extends Vue {
        id: String | null = null;
        name: String = '';
        description: String = '';
        calories: Number = 0;

        async save() {
            const ingredient = {
                name: this.name,
                description: this.description,
                calories: this.calories
            };
            await this.$store.dispatch('UPDATE_INGREDIENT', ingredient);
            this.$router.push({name: 'ingredients'});
        }
        async mounted() {
            const {id} = this.$route.params;
            const ingredient = await this.$store.dispatch('GET_INGREDIENT_BY_ID', id);
            this.id = ingredient.id;
            this.name = ingredient.name;
            this.description = ingredient.description;
            this.calories = ingredient.calories;
        }
    }
</script>

<style>

</style>
