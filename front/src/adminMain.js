// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Admin from './Admin'
import router from './router'
import ElementUI from 'element-ui'  //引入Element UI时添加
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios';
import VueCookies from 'vue-cookies'

Vue.use(VueCookies)
Vue.use(axios)
Vue.use(ElementUI)
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#admin',
  router,
  components: {Admin},
  template: '<Admin/>'
})
