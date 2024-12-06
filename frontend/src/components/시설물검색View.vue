<template>

    <v-data-table
        :headers="headers"
        :items="시설물검색"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: '시설물검색View',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            시설물검색 : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/시설물검색'))

            temp.data._embedded.시설물검색.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.시설물검색 = temp.data._embedded.시설물검색;
        },
        methods: {
        }
    }
</script>

