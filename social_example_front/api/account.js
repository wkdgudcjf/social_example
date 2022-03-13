import req from './req-wrapper'

const ACCOUNT_URI = {
  LOGIN: '/auth/login',
  USER: '/user/me'
}

export default {
  login (body, success, fail) {
    req.post(ACCOUNT_URI.LOGIN, body, success, fail)
  },
  getUser (token, success) {
    req.get(ACCOUNT_URI.USER, token, success)
  }
}
