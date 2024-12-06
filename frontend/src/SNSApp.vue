<template>
    <v-app id="inspire">
        <div>
            <v-app-bar color="primary" app clipped-left flat>
                <v-toolbar-title>
                    <span class="second-word font uppercase"
                        style="font-weight:700;"
                    >
                        <v-app-bar-nav-icon
                            @click="openSideBar()"
                            style="z-index:1;
                            height:56px;
                            width:30px;
                            margin-right:10px;
                            font-weight:300;
                            font-size:55px;"
                        >
                            <div style="line-height:100%;">≡</div>
                        </v-app-bar-nav-icon>
                    </span>
                </v-toolbar-title>
                <span v-if="urlPath!=null" 
                    class="mdi mdi-home" 
                    key="" 
                    to="/" 
                    @click="goHome()"
                    style="margin-left:10px; font-size:20px; cursor:pointer;"
		        ></span> 
                <v-spacer></v-spacer>

            </v-app-bar>

            <v-navigation-drawer app clipped flat v-model="sideBar">
                <v-list>
                    <v-list-item
                        class="px-2"
                        key="spaces"
                        to="/spaces/spaces"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        공간
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="facilities"
                        to="/reserves/facilities"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        시설
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="시설물검색"
                        to="/reserves/시설물검색"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        시설물검색
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="myPages"
                        to="/centers/myPages"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        MyPage
                    </v-list-item>
                    <v-list-item
                        class="px-2"
                        key="analyses"
                        to="/analyses/analyses"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        Analysis
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="facilityUtilizationRates"
                        to="/analyses/facilityUtilizationRates"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        FacilityUtilizationRate
                    </v-list-item>
                </v-list>
            </v-navigation-drawer>
        </div>

        <v-main>
            <v-container style="padding:0px;" v-if="urlPath" fluid>
                <router-view></router-view>
            </v-container>
            <v-container style="padding:0px;" v-else fluid>
                <div style="width:100%; margin:0px 0px 20px 0px; position: relative;">
                    <v-img style="width:100%; height:300px;"
                        src=""
                    ></v-img>
                    <div class="App-main-text-overlap"></div>
                    <div class="App-sub-text-overlap"></div>
                </div>
                <v-row>
                    <v-col cols="4" class="d-flex justify-center" v-for="(aggregate, index) in aggregate" :key="index">
                        <div 
                            class="flip-card"
                            @mouseover="flipCard(index)"
                            @mouseleave="unflipCard(index)"
                            :class="{ 'is-flipped': flipped[index] }"
                        >
                            <div class="flip-card-inner">
                                <div class="flip-card-front">
                                    <v-card
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                        </v-list-item>
                                        <div style="text-align: left; padding:10px 15px 15px 15px; margin-top:-10px;">
                                            <h2>{{ aggregate.title }}</h2>
                                            <div>{{ aggregate.description }}</div>
                                        </div>
                                    </v-card>
                                </div>
                                <div class="flip-card-back">
                                    <v-card
                                        color="primary"
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                        :key="aggregate.key"
                                        :to="aggregate.route"
                                        @click="changeUrl()"
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                        </v-list-item>
                                        <h2 style="color:white;">{{ aggregate.title }} 관리</h2>
                                    </v-card>
                                </div>
                            </div>
                        </div>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>

export default {
    name: "App",
    data: () => ({
        useComponent: "",
        drawer: true,
        components: [],
        sideBar: true,
        urlPath: null,
        flipped: [],
        ImageUrl: '',
        aggregate: [
            { 
                title: '공간', 
                description: 'Space을 관리하는 화면입니다.', 
                key: 'spaces', 
                route: '/spaces/spaces',
                ImageUrl: '',
            },
            { 
                title: '시설', 
                description: 'Facility을 관리하는 화면입니다.', 
                key: 'facilities', 
                route: '/reserves/facilities',
                ImageUrl: '',
            },
            { 
                title: 'Analysis', 
                description: 'analysis을 관리하는 화면입니다.', 
                key: 'analyses', 
                route: '/analyses/analyses',
                ImageUrl: '',
            },
            { 
                title: '시설물검색', 
                description: '시설물 검색을 관리하는 화면입니다.', 
                key: '시설물검색', 
                route: '/reserves/시설물검색',
                ImageUrl: '',
            },
            { 
                title: 'MyPage', 
                description: 'MyPage을 관리하는 화면입니다.', 
                key: 'myPages', 
                route: '/centers/myPages',
                ImageUrl: '',
            },
            { 
                title: '시설이용률', 
                description: 'FacilityUtilizationRate을 관리하는 화면입니다.', 
                key: 'facilityUtilizationRates', 
                route: '/analyses/facilityUtilizationRates',
                ImageUrl: '',
            },
            
        ],
    }),
    
    async created() {
      var path = document.location.href.split("#/")
      this.urlPath = path[1];

    },
    watch: {
        cards(newCards) {
            this.flipped = new Array(newCards.length).fill(false);
        },
    },

    mounted() {
        var me = this;
        me.components = this.$ManagerLists;
    },

    methods: {
        openSideBar(){
            this.sideBar = !this.sideBar
        },
        changeUrl() {
            var path = document.location.href.split("#/")
            this.urlPath = path[1];
            this.flipped.fill(false);
        },
        goHome() {
            this.urlPath = null;
        },
        flipCard(index) {
            this.$set(this.flipped, index, true);
        },
        unflipCard(index) {
            this.$set(this.flipped, index, false);
        },
    }
};
</script>
<style>
</style>
