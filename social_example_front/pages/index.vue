<template>
  <v-row justify="center" align="center">
    <v-col cols="12" sm="8" md="6">
      <v-card class="logo py-4 d-flex justify-center">
        <NuxtLogo />
        <VuetifyLogo />
      </v-card>
      <v-card>
        <v-card-title class="headline">
          과탑 앱
        </v-card-title>
        <v-card-text>
          <p>
            gwatop
          </p>
        </v-card-text>
        <v-card-actions v-if='isLoggedIn'>
          <v-btn v-if='isAdmin' color="primary" nuxt to="admin/mypage"> 관리자 {{username}} </v-btn>
          <v-btn v-else color="primary" nuxt to="user/mypage"> 유저 {{username}} </v-btn>
        </v-card-actions>
        <v-card-actions v-else>
          <v-spacer />
          <v-btn color="success" nuxt to="/login"> Login </v-btn>
          <v-btn color="success" nuxt to="/join"> Join </v-btn>
        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
</template>
<script>

import { mapGetters } from 'vuex'
export default {
  name: 'IndexPage',
  computed: {
    ...mapGetters(['token', 'user']),
    isLoggedIn () {
      return this.token != null
    },
    username () {
      if (!this.user) return ''
      return this.user.username
    },
    isAdmin () {
			return this.user && this.user.roleCode === 'ROLE_ADMIN'
		}
  }
}
</script>
