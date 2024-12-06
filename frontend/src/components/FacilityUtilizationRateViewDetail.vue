<template>

    <v-card outlined>
        <v-card-title>
            FacilityUtilizationRate # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="PlaceName" v-model="item.placeName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="UseCount" v-model="item.useCount" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'FacilityUtilizationRateViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/facilityUtilizationRates/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

