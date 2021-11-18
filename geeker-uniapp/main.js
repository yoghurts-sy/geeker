import Vue from 'vue'
import App from './App'
import store from './store/index.js';
import axios from './axios/axios.js';
Vue.prototype.$axios = axios;

Vue.prototype.$store = store

Vue.config.productionTip = false

import divider from '@/components/common/divider.vue';
Vue.component('divider', divider)
import Nothing from '@/components/common/Nothing.vue';
Vue.component('Nothing', Nothing)

App.mpType = 'app'

// 引入配置文件
import $C from './common/config.js';
Vue.prototype.$C = $C
// 挂在助手函数库
import $U from './common/util.js';
Vue.prototype.$U = $U
// 引入请求库
import $H from './common/request.js';
Vue.prototype.$H = $H

const app = new Vue({
    ...App
})
app.$mount()
