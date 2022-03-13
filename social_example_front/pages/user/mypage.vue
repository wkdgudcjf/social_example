
<template>
	<div>
		<h1>유저 마이페이지</h1>
		<p>name</p>
		<p>{{ username }}</p>
		<p>email</p>
		<p>{{ email }}</p>
		<img :src="image">
		<h2>class</h2>
		<ul v-for="tempInfo of tempList" :key="tempInfo.id">
     	 	<li> email : {{ tempInfo.email }}  tempname : {{ tempInfo.tempname }}</li>
      		<br>
    	</ul>
	</div>
</template>


<script>
	import { mapGetters } from 'vuex'
	import axios from 'axios';
	const appendAuth = (token, config) => {
		if (token) {
			if (!config) config = { headers: {} }
			if (!config.headers) config.headers = {}
			config.headers.Authorization = `Bearer ${token}`
		}
		return config
	}
	export default {
		middleware: ["redirect", "student"],
		data() {
			return {
				tempList:{},
			}
		},
		mounted () {
			this.getTemp();
		},
		// eslint-disable-next-line vue/order-in-components
		computed: {
			...mapGetters(['token', 'user']),
			isLoggedIn () {
			return this.token != null
			},
			isAdmin () {
			return this.user && this.user.roleCode === 'ROLE_ADMIN'
			},
			username () {
			if (!this.user) return ''
			return this.user.username
			},
			image () {
			if (!this.user) return ''
			return this.user.profileImageUrl
			},
			email () {
			if (!this.user) return ''
			return this.user.email
			}
		},
		methods:{
			getTemp () {
				axios.get(`http://localhost:9285/api/v1/temp/list`,appendAuth(this.token))
				.then((res) => {
					this.tempList = res.data.body.tempList;
				})
			},
		}
  	}
</script>