
<template>
  <v-col>
    <v-card-title class="headline">
      로그인
    </v-card-title>

    <v-btn color="success" @click="google">구글</v-btn>
    <v-btn color="success" @click="facebook">페이스북</v-btn>
    <v-btn color="success" @click="kakao">카카오</v-btn>
    <v-btn color="success" @click="naver">네이버</v-btn>

    <hr class="my-3">
    <input id="email" v-model="email" class="base_input" type="text" placeholder="email" style="background: #fff; border: 1px solid #fff" />
    <br><br>
    <input v-model="password" class="base_input" type="password" placeholder="password" style="background: #fff; border: 1px solid #fff" />
    <br><br>
    <v-btn color="warning" @click="login">Login</v-btn>
  </v-col>
</template>

<script>
  import axios from 'axios'
  import { mapMutations, mapActions } from 'vuex'

  export default {
    data() {
      return {
        email: '',
        password: ''
      }
    },

    methods:{
       kakao(){
          location.href = 'http://localhost:9285/oauth2/authorization/kakao?redirect_uri=http://localhost:3000/oauth/redirect';
       },
        google(){
          location.href = 'http://localhost:9285/oauth2/authorization/google?redirect_uri=http://localhost:3000/oauth/redirect';
       },
        naver(){
          location.href = 'http://localhost:9285/oauth2/authorization/naver?redirect_uri=http://localhost:3000/oauth/redirect';
       },
        facebook(){
          location.href = 'http://localhost:9285/oauth2/authorization/facebook?redirect_uri=http://localhost:3000/oauth/redirect';
       },
       ...mapActions(['fetchUser']),
       ...mapMutations(['setToken']),
       login() {
          axios.post('http://localhost:9285/api/v1/auth/login',{email:this.email,password:this.password})
            .then(res => {
            const token = res.data.body.token
            if (token) {
              this.setToken(token)
              this.fetchUser()
            }
            
            this.$router.replace('/')
         });
      }
    }
  }
</script>