export default {
  state: {
    notification: null,
    timeoutId: null
  },
  actions: {
    SET_ERROR({commit}, message) {
      commit('SET_ERROR', message)
    },
    SET_SUCCESS_NOTIFICATION({commit}, message) {
      commit('SET_SUCCESS_NOTIFICATION', message)
    },
    RESET_NOTIFICATION({commit}) {
      commit('RESET_NOTIFICATION')
    },
    SET_TIMEOUT_ID({commit}, payload) {
      commit('SET_TIMEOUT_ID', payload)
    }
  },
  mutations: {
    SET_ERROR(state, message) {
      state.notification = {
        type: 'error',
        title: 'Ошибка',
        message: message
      }
    },
    SET_SUCCESS_NOTIFICATION(state, message) {
      state.notification = {
        type: 'success',
        title: 'Операция выполнена',
        message: message
      }
    },
    RESET_NOTIFICATION(state) {
      state.notification = null
      if (state.timeoutId !== null) {
        clearTimeout(state.timeoutId)
        state.timeoutId = null
      }
    },
    SET_TIMEOUT_ID(state, payload) {
      state.timeoutId = payload
    }
  },
  getters: {
    notification: (state) => state.notification
  }
}