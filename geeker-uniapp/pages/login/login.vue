<template>
	<view>
		<uniStatusBar></uniStatusBar>
		<view style="width: 100rpx; height: 100rpx;margin-left: 10rpx;"  @click="back">
			<text class="iconfont font-lg" style="font-size: 55rpx;">
				&#xe6aa;
			</text>
		</view>
		
		<view class="action-box">
			{{status ? '手机验证登录' : '账号密码登录'}}
		</view>
		
		<view class="input-box">
			<view class="phone-box">
				<view style="align-items: center; justify-content: center; padding-left: 10rpx; padding-right: 20rpx;">+86</view>
				<input type="text" v-model="phone" placeholder="请输入手机号"/>
			</view>
			<template v-if="!status">
				<view class="password-box">
					<input type="password" v-model="password" placeholder="请输入密码"/>
					<view class="forget-box" @click="forgetPassword">忘记密码？</view>
				</view>
			</template>
			<template v-else>
				<view class="password-box">
					<input type="text" v-model="code" placeholder="请输入验证码"/>
					<view class="get-code-box" @click="getCode">获取验证码</view>
				</view>
			</template>
		</view>
		
		<view class="login-box">
			<button type="primary"  @click="login" >
				⚡ 即刻开始
			</button>
		</view>
		<view class="code-login-box">
			<view style="" @click="changeStatus">
				{{status?'账号密码登录':'验证码登陆'}}
			</view>
			<text style="color: #6c757d; margin-left: 20rpx; margin-right: 20rpx;">|</text>
			<view>登录遇到问题</view>
		</view>
		<view class="other-login-box">
			<view style="color: #dddddd;">————</view>
			<view style="margin-left: 20rpx; margin-right: 20rpx;">社交账号登录</view>	
			<view style="color: #dddddd;">————</view>
		</view>
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
				status:false,
				loading:false,
				phone:'',
				password:'',
				code:''
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
				let url = ""
				let data = ""
				if(this.status){
					// 手机验证码登录
					//if (!this.validate()) return;
					url = '/codelogin'
					data = {
						phone:this.phone,
						password:this.code
					}
				} else {
					// 账号密码登录 13656457563 123456 Evan Su
					
					//   测试账号2 13450772008 123456
					url = '/login'
					data = {
						phone:this.phone,
						password:this.password
					}
				}
				// 提交后端
				this.loading = true
				this.$H.post(url,data).then(res=>{
					console.log(res);
					if (res.data.code === '200') {
												
						console.log(res.data);
						console.log("USER:-->");
						console.log(res.data.data);
						// 修改vuex的state,持久化存储
						this.$store.commit('login', res.data.data)
						// 开启socket
						//this.$store.dispatch('openSocket')
						// 提示和跳转
						uni.navigateBack({
							delta: 1
						}); 
						uni.showToast({
							title: '登录成功',
							icon: 'none'
						});
						this.$store.dispatch('initUser')
					} else {
						uni.showToast({
							title: res.data.msg,
							icon: 'none'
						});
					}
				});
			},
			changeStatus() {
				this.status = !this.status;
			},
			forgetPassword() {
				console.log("forgetPassword!");
			},
			getCode() {
				let param = new FormData;
				param.append("phone", this.phone);
				this.$axios.post('/sendcode', param).then(res=>{
					console.log(res)
					let msg = res.data
					uni.showToast({
						title: msg,
						icon: 'none',
						duration:2000
					});
				})
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
