<template>

    <v-data-table
        :headers="headers"
        :items="foodMaterialQtySearch"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'FoodMaterialQtySearchView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            foodMaterialQtySearch : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/foodMaterialQtySearches'))

            temp.data._embedded.foodMaterialQtySearches.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.foodMaterialQtySearch = temp.data._embedded.foodMaterialQtySearches;
        },
        methods: {
        }
    }
</script>

