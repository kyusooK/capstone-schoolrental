<template>
    <v-card outlined>
        <v-card-title>
            AssignManager
        </v-card-title>

        <v-card-text>
            <String label="ManagerId" v-model="value.managerId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="assignManager"
            >
                AssignManager
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
        name: 'AssignManagerCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.managerId = '';
            this.value.id = 0;
        },
        watch: {
        },
        methods: {
            assignManager() {
                this.$emit('assignManager', this.value);
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

