<template>

    <v-data-table
        :headers="headers"
        :items="foodSearch"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'FoodSearchView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            foodSearch : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/foodSearches'))

            temp.data._embedded.foodSearches.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.foodSearch = temp.data._embedded.foodSearches;
        },
        methods: {
        }
    }
</script>

