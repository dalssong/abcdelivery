<template>

    <v-data-table
        :headers="headers"
        :items="myPageShop"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MyPageShopView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "storeName", value: "storeName" },
                { text: "menuId", value: "menuId" },
                { text: "menuName", value: "menuName" },
                { text: "menuPrice", value: "menuPrice" },
                { text: "deliveryStatus", value: "deliveryStatus" },
            ],
            myPageShop : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/myPageShops'))

            temp.data._embedded.myPageShops.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.myPageShop = temp.data._embedded.myPageShops;
        },
        methods: {
        }
    }
</script>

