<template>

    <v-card outlined>
        <v-card-title>
            시설물검색 # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: '시설물검색ViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/시설물검색/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

