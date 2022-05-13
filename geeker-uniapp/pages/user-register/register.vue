<template>
	<view>
		<uniStatusBar></uniStatusBar>
		<view style="width: 100rpx; height: 100rpx;margin-left: 10rpx;"  @click="back">
			<text class="iconfont font-lg" style="font-size: 55rpx;">
				&#xe6aa;
			</text>
		</view>
		
		<view class="action-box">
			手机注册登录
		</view>
		
		<view class="input-box">
			<view class="phone-box">
				<view style="align-items: center; justify-content: center; padding-left: 10rpx; padding-right: 20rpx;">+86</view>
				<input type="text" v-model="phone" placeholder="请输入手机号"/>
			</view>
			<view class="phone-box">
				<input type="text" v-model="nickname" placeholder="请输入昵称"/>
			</view>
			<view class="password-box">
				<input type="password" v-model="password" placeholder="请输入密码"/>
			</view>
			<view class="password-box">
				<input type="password" v-model="password2" placeholder="请再次确认密码"/>
			</view>
		</view>
		
		<view class="login-box">
			<button type="primary"  @click="login" >
				⚡ 即刻注册
			</button>
		</view>
		<!-- <view class="code-login-box">
			<view style="" @click="changeStatus">
				{{status?'账号密码登录':'验证码登陆'}}
			</view>
			<text style="color: #6c757d; margin-left: 20rpx; margin-right: 20rpx;">|</text>
			<view @click="register">注册即刻账号</view>
		</view>
		<view class="other-login-box">
			<view style="color: #dddddd;">————</view>
			<view style="margin-left: 20rpx; margin-right: 20rpx;">社交账号登录</view>	
			<view style="color: #dddddd;">————</view>
		</view> -->
	</view>
</template>

<script>
	import uniStatusBar from '@/components/uni-ui/uni-status-bar/uni-status-bar.vue';
	export default {
		components:{
			uniStatusBar
		},
		data() {
			return {
				phone:'',
				password:'',
				password2:'',
				nickname:''
			}
		},
		onLoad() {
			
		},
		methods: {
			back() {
				uni.navigateBack({
					delta: 1
				});
			},
			login() {
				if (this.password !== this.password2) {
					uni.showToast({
						title: '两次输入的密码不一致！',
						icon: 'none'
					});
					return;
				} else if (this.nickname === '') {
					uni.showToast({
						title: '昵称不能为空！',
						icon: 'none'
					});
					return;
				}
				
				
				let url = ""
				let data = ""
				url = '/register'
				data = {
					phone:this.phone,
					password:this.password,
					nickname:this.nickname
				}
				
				this.$H.post(url, data).then(res=>{
					console.log(res);
					if (res.data.code === 200) {
						uni.showToast({
							title: '注册成功',
							icon: 'none'
						});
						uni.navigateBack({
							delta: 1
						}); 
					} else {
						uni.showToast({
							title: res.data.msg,
							icon: 'none'
						});
					}
				});				
			}
		}
	}
</script>

<style>
.action-box {
	text-align: center;
	padding-top: 130rpx;
	padding-bottom: 70rpx;
	font-size: 55rpx;
}
.input-box {
	padding-left: 20rpx;
	padding-right: 20rpx;
}
.phone-box {
	margin-bottom: 25rpx;
	border-bottom: #E9EBEE 2rpx solid;
	padding: 20rpx;
	display: flex;
}
.password-box {
	margin-bottom: 25rpx;
	display:flex;
	flex-direction:row;
	align-items: stretch;
	padding: 20rpx;
	border-bottom: #E9EBEE 2rpx solid;
}
.get-code-box{
	margin-left: auto;
	align-items: center;
	justify-content: center;
	border-radius: 50rpx;border: 0;
	background-color: #2F55D4;
	color: #FFFFFF;
	font-weight: 300;
	width: 150rpx;
	padding-top: 7rpx;
	padding-bottom: 7rpx;
	padding-left: 20rpx;
	padding-right: 15rpx;
}
.forget-box {
	margin-left: auto;
	align-items: center;
	justify-content: center;
	color: #6C757D;
	width: 150rpx;
	padding-top: 7rpx;
	padding-bottom: 7rpx;
	padding-left: 20rpx;
	padding-right: 15rpx;
}
.login-box {
	padding-top: 20rpx; 
	padding-bottom: 20rpx;
	padding-left: 50rpx; 
	padding-right: 50rpx;
}

.login-box > button {
	color: #FFFFFF;
	font-weight: 1000;
	background-color: #2F55D4;
	border-radius: 50rpx;border: 0;
}
.code-login-box {
	display: flex;
	align-items: center;
	justify-content: center;
	padding-top: 20rpx;
	padding-bottom: 20rpx;
}
.other-login-box {
	display: flex;
	align-items: center;
	justify-content: center;
	padding-bottom: 40rpx;
}
</style>
