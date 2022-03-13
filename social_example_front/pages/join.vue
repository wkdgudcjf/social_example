
<template>
  <v-col>
    <v-card-title class="headline">
    회원가입
    </v-card-title>
    <hr class="my-3">
    <input id="email" v-model="email" class="base_input" type="text" placeholder="email" style="background: #fff; border: 1px solid #fff" />
    <br><br>
    <input v-model="password" class="base_input" type="password" placeholder="password" style="background: #fff; border: 1px solid #fff" />
    <br><br>
    <input id="name" v-model="name" class="base_input" type="text" placeholder="name" style="background: #fff; border: 1px solid #fff" />
    <br><br>
    <input id="photo" class="base_input" type="file" placeholder="photo" style="background: #fff; border: 1px solid #fff" />
    <br><br>
    <v-btn color="warning" @click="join">join</v-btn>
  </v-col>
</template>

<script>
  import axios from 'axios'

  export default {
    data() {
      return {
        id: '',
        password: '',
        email: '',
        phone: '',
        name: ''
      }
    },

    methods:{
       join() {
          const frm = new FormData();
          const photoFile = document.getElementById("photo");

          frm.append("image", photoFile.files[0]);
          frm.append('password', this.password)
          frm.append('email', this.email)
          frm.append('name', this.name)
          axios.post('http://localhost:9285/api/v1/auth/join', frm, {
            headers: {
              'Content-Type': 'multipart/form-data'
            }
          })
          .then(res => {
             this.$router.replace('/')
          });
       }
    }
  }
</script>