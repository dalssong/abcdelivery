<template>

    <v-card outlined>
        <v-card-title>
            MyPageRider # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="RiderName" v-model="item.riderName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="StoreName" v-model="item.storeName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="MenuName" v-model="item.menuName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Qty" v-model="item.qty" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DeliveryStatus" v-model="item.deliveryStatus" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MyPageRiderViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/myPageRiders/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

