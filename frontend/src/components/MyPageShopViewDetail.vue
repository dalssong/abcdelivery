<template>

    <v-card outlined>
        <v-card-title>
            MyPageShop # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="StoreName" v-model="item.storeName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="MenuId" v-model="item.menuId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="MenuName" v-model="item.menuName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="MenuPrice" v-model="item.menuPrice" :editMode="editMode" @change="change" />
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
    name: 'MyPageShopViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/myPageShops/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

