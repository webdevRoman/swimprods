import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import errors from './errors'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    idCounter: 0,
    products: [],
    isProducing: false
  },
  actions: {
    GET_PRODUCTS({ commit }) {
      return new Promise((resolve, reject) => {
        axios({ url: '/warehouse', method: 'GET' })
          .then(resp => {
            resp.data.forEach(product => { commit('SET_NEW_PRODUCT', product) })
            resolve()
          })
          .catch(err => {
            commit('SET_ERROR', err)
            reject(err)
          })
      })
    },
    CHECK_NEW_PRODUCT({ commit }) {
      return new Promise((resolve, reject) => {
        axios({ url: '/warehouse/new', method: 'GET' })
          .then(resp => {
            if (resp.data !== '') {
              commit('SET_NEW_PRODUCT', resp.data)
              commit('SET_PRODUCING', false)
            }
            resolve()
          })
          .catch(err => {
            commit('SET_ERROR', err)
            reject(err)
          })
      })
    },
    PRODUCE_PRODUCT({ commit }) {
      commit('SET_PRODUCING', true)
      return new Promise((resolve, reject) => {
        axios({ url: '/manufacturer', method: 'POST' })
          .then(res => {
            if (res.data === 'no space') {
              commit('SET_ERROR', 'На складе больше нет места. Необходимо потребить продукты.')
              commit('SET_PRODUCING', false)
            }
            resolve()
          })
          .catch(err => {
            commit('SET_PRODUCING', false)
            commit('SET_ERROR', err)
            reject(err)
          })
      })
    }
  },
  mutations: {
    SET_NEW_PRODUCT(state, product) {
      state.idCounter++
      const newProduct = {
        id: state.idCounter,
        name: product.name,
        manufacturer: product.manufacturer,
        price: product.price
      }
      state.products = [...state.products, newProduct]
    },
    SET_PRODUCING(state, payload) {
      state.isProducing = payload
    }
  },
  getters: {
    products: (state) => state.products,
    isProducing: (state) => state.isProducing
  },
  modules: {
    errors
  }
})