<template>
    <v-card outlined>
        <v-card-title>
            MaintainSpace
        </v-card-title>

        <v-card-text>
            <Boolean label="IsMaintenance" v-model="value.isMaintenance" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="maintainSpace"
            >
                MaintainSpace
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'MaintainSpaceCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.isMaintenance = false;
            this.value.id = 0;
        },
        watch: {
        },
        methods: {
            maintainSpace() {
                this.$emit('maintainSpace', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

