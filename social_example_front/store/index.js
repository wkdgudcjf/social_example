import accountApi from '@/api/account'

export const state = () => {
  return {
    user: null,
    token: null
  };
};

export const mutations = {
  setUser(state, user) {
    state.user = user;
  },
  setToken(state, token) {
    state.token = token;
  }
};

export const getters = {
  user(state) {
    return state.user;
  },
  token(state) {
    return state.token;
  }
};

export const actions = {
  fetchUser ({state, commit}, callback) {
    console.log("token", state.token)
    state.user
      ? callback && callback()
      : accountApi.getUser(state.token,
        res => {
          console.log("user", res.user)
          commit('setUser', res.user)
          callback && callback()
        }
      )
  }
};
