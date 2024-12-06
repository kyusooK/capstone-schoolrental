<template>

    <v-data-table
        :headers="headers"
        :items="facilityUtilizationRate"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'FacilityUtilizationRateView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "placeName", value: "placeName" },
                { text: "useCount", value: "useCount" },
            ],
            facilityUtilizationRate : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/facilityUtilizationRates'))

            temp.data._embedded.facilityUtilizationRates.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.facilityUtilizationRate = temp.data._embedded.facilityUtilizationRates;
        },
        methods: {
        }
    }
</script>

