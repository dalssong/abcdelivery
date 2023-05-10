<template>

    <v-data-table
        :headers="headers"
        :items="myPageRider"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MyPageRiderView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "riderName", value: "riderName" },
                { text: "storeName", value: "storeName" },
                { text: "menuName", value: "menuName" },
                { text: "qty", value: "qty" },
                { text: "deliveryStatus", value: "deliveryStatus" },
            ],
            myPageRider : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/myPageRiders'))

            temp.data._embedded.myPageRiders.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.myPageRider = temp.data._embedded.myPageRiders;
        },
        methods: {
        }
    }
</script>

