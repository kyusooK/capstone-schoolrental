
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import SpaceSpaceManager from "./components/listers/SpaceSpaceCards"
import SpaceSpaceDetail from "./components/listers/SpaceSpaceDetail"

import ReserveFacilityManager from "./components/listers/ReserveFacilityCards"
import ReserveFacilityDetail from "./components/listers/ReserveFacilityDetail"

import 시설물검색View from "./components/시설물검색View"
import 시설물검색ViewDetail from "./components/시설물검색ViewDetail"

import MyPageView from "./components/MyPageView"
import MyPageViewDetail from "./components/MyPageViewDetail"
import AnalysisAnalysisManager from "./components/listers/AnalysisAnalysisCards"
import AnalysisAnalysisDetail from "./components/listers/AnalysisAnalysisDetail"

import FacilityUtilizationRateView from "./components/FacilityUtilizationRateView"
import FacilityUtilizationRateViewDetail from "./components/FacilityUtilizationRateViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/spaces/spaces',
                name: 'SpaceSpaceManager',
                component: SpaceSpaceManager
            },
            {
                path: '/spaces/spaces/:id',
                name: 'SpaceSpaceDetail',
                component: SpaceSpaceDetail
            },

            {
                path: '/reserves/facilities',
                name: 'ReserveFacilityManager',
                component: ReserveFacilityManager
            },
            {
                path: '/reserves/facilities/:id',
                name: 'ReserveFacilityDetail',
                component: ReserveFacilityDetail
            },

            {
                path: '/reserves/시설물검색',
                name: '시설물검색View',
                component: 시설물검색View
            },
            {
                path: '/reserves/시설물검색/:id',
                name: '시설물검색ViewDetail',
                component: 시설물검색ViewDetail
            },

            {
                path: '/centers/myPages',
                name: 'MyPageView',
                component: MyPageView
            },
            {
                path: '/centers/myPages/:id',
                name: 'MyPageViewDetail',
                component: MyPageViewDetail
            },
            {
                path: '/analyses/analyses',
                name: 'AnalysisAnalysisManager',
                component: AnalysisAnalysisManager
            },
            {
                path: '/analyses/analyses/:id',
                name: 'AnalysisAnalysisDetail',
                component: AnalysisAnalysisDetail
            },

            {
                path: '/analyses/facilityUtilizationRates',
                name: 'FacilityUtilizationRateView',
                component: FacilityUtilizationRateView
            },
            {
                path: '/analyses/facilityUtilizationRates/:id',
                name: 'FacilityUtilizationRateViewDetail',
                component: FacilityUtilizationRateViewDetail
            },


    ]
})
