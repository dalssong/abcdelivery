<template>

    <v-data-table
        :headers="headers"
        :items="myPageCustomer"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MyPageCustomerView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "userId", value: "userId" },
                { text: "storeName", value: "storeName" },
                { text: "menuName", value: "menuName" },
                { text: "orderStatus", value: "orderStatus" },
                { text: "menuPrice", value: "menuPrice" },
            ],
            myPageCustomer : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/myPageCustomers'))

            temp.data._embedded.myPageCustomers.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.myPageCustomer = temp.data._embedded.myPageCustomers;
        },
        methods: {
        }
    }
</script>

