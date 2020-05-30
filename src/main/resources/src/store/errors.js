export default {
  state: {
    error: {
      type: 'error',
      title: 'Ошибка',
      message: ''
    }
  },
  actions: {
    SET_ERROR({commit}, message) {
      commit('SET_ERROR', message)
    }
  },
  mutations: {
    SET_ERROR(state, message) {
      state.error = {
        type: 'error',
        title: 'Ошибка',
        message: message
      }
    }
  },
  getters: {
    error: (state) => state.error
  }
}