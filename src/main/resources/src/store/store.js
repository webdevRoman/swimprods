import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    products: []
  },
  actions: {
    PRODUCE_PRODUCT({ commit }) {
      return new Promise((resolve, reject) => {
        axios({ url: '/manufacturer', method: 'POST' })
          .then(resp => {
            console.log(resp.data)
            // commit('ADD_FAVOURITE', data.dish)
            resolve()
          })
          .catch(err => {
            reject(err)
          })
      })
    }
  },
  mutations: {
    // produceProduct(state) {
    //   state.count++
    // }
  },
  getters: {
    products: (state) => state.products
  }
})