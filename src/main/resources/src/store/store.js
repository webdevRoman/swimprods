import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import notifications from './notifications'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    idCounter: 0,
    products: [],
    isProducing: false,
    isConsuming: false
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
    CHECK_PRODUCED_PRODUCT({ commit }) {
      return new Promise((resolve, reject) => {
        axios({ url: '/warehouse/produced', method: 'GET' })
          .then(resp => {
            if (resp.data !== '') {
              commit('SET_NEW_PRODUCT', resp.data)
              commit('SET_SUCCESS_NOTIFICATION', `Произведен товар "${resp.data.name}"`)
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
    CHECK_CONSUMED_PRODUCT({ commit }) {
      return new Promise((resolve, reject) => {
        axios({ url: '/warehouse/consumed', method: 'GET' })
          .then(resp => {
            if (resp.data !== '') {
              commit('REMOVE_PRODUCT', resp.data)
              commit('SET_SUCCESS_NOTIFICATION', `Потреблен товар "${resp.data.name}"`)
              commit('SET_CONSUMING', false)
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
            if (res.data === 'full') {
              commit('SET_ERROR', 'На складе больше нет места. Необходимо потребить товары.')
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
    },
    CONSUME_PRODUCT({ commit }) {
      commit('SET_CONSUMING', true)
      return new Promise((resolve, reject) => {
        axios({ url: '/customer', method: 'POST' })
          .then(res => {
            if (res.data === 'empty') {
              commit('SET_ERROR', 'На складе нет товаров. Необходимо произвести их.')
              commit('SET_CONSUMING', false)
            }
            resolve()
          })
          .catch(err => {
            commit('SET_CONSUMING', false)
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
    REMOVE_PRODUCT(state, product) {
      let ind = -1
      for (let i = 0; i < state.products.length; i++) {
        const el = state.products[i];
        if (el.name === product.name && el.manufacturer === product.manufacturer && el.price === product.price) {
          ind = i
          break
        }
      }
      if (ind !== -1)
        state.products.splice(ind, 1)
    },
    SET_PRODUCING(state, payload) {
      state.isProducing = payload
    },
    SET_CONSUMING(state, payload) {
      state.isConsuming = payload
    }
  },
  getters: {
    products: (state) => state.products,
    isProducing: (state) => state.isProducing,
    isConsuming: (state) => state.isConsuming
  },
  modules: {
    notifications
  }
})