<template>
	<view>
		我的
		<button @click="pushLogin" style="margin-top: 200rpx;">登录</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			pushLogin() {
				uni.navigateTo({
					url:'../login/login'
				})
			}
		}
	}
</script>

<style>

</style>
