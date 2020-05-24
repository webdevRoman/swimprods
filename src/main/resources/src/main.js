import Vue from 'vue'
import '@babel/polyfill'
import App from './App.vue'
import store from './store/store'

new Vue({
  el: '#app',
  store,
  render: a => a(App)
})