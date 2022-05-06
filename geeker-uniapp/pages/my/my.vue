<template>
	<view>
		<!-- 未登录 -->
		<template v-if="!loginStatus">
			<view class="flex align-center justify-center py-2 font">
				登录Geeker社区，体验更多功能
			</view>
			<other-login></other-login>
			<view class="flex align-center justify-center py-2 font text-secondary" @click="openLogin">
				微信登录/手机登录 <text class="ml-1 iconfont icon-jinru"></text>
			</view>
		</template>

		<!-- 已登录 -->
		<view v-else class="flex align-center p-2" hover-class="bg-light">
			<image :src="avatar"
			style="width: 100rpx;height: 100rpx;"
			class="rounded-circle"></image>
			<view class="flex flex-column flex-1 px-2">
				<text class="font-lg font-weight-bold text-dark">{{user.username}}</text>
				<text class="font text-muted">
					总帖子{{myData[0].num}}  今日发帖{{myData[1].num}}</text>
			</view>
			<text class="iconfont icon-jinru"></text>
		</view>
		
		
		<!-- 标签 -->
		<view class="flex flex-wrap px-4">
			<view class="border  rounded font font-weight-normal mx-2 my-1 px-2"
			v-for="(item,index) in list" :key="index"
			hover-class="bg-light">{{item}}</view>
		</view>
		
		<view class="flex align-center px-3 py-2">
			<view class="flex-1 flex flex-column align-center justify-center"
			v-for="(item,index) in myData" :key="index">
				<text class="font-lg font-weight-bold">{{item.num}}</text>
				<text class="font text-muted">{{item.name}}</text>
			</view>
		</view>
		
		<view class="px-3 py-2">
			<image src="/static/demo/banner1.jpg" mode="aspectFill"
			style="height: 170rpx;width: 100%;" class="rounded"></image>
		</view>
		<uni-list-item title="我的简历"  showExtraIcon @click="openResume">
			<text slot="icon" class="iconfont icon-user-detail"></text>
		</uni-list-item>
		<uni-list-item title="浏览历史"  showExtraIcon @click="openHistory">
			<text slot="icon" class="iconfont icon-liulan"></text>
		</uni-list-item>
		<uni-list-item title="社区认证"  showExtraIcon>
			<text slot="icon" class="iconfont icon-huiyuanvip"></text>
		</uni-list-item>
		<uni-list-item title="审核帖子"  showExtraIcon>
			<text slot="icon" class="iconfont icon-keyboard"></text>
		</uni-list-item>
		<!-- #ifdef MP -->
		<navigator url="../user-set/user-set" hover-class="none">
		<uni-list-item title="我的设置" showExtraIcon>
			<text slot="icon" class="iconfont icon-shezhi"></text>
		</uni-list-item>
		</navigator>
		<!-- #endif -->
		
		
	</view>
</template>

<script>
	import uniListItem from '@/components/uni-ui/uni-list-item/uni-list-item.vue';
	import otherLogin from '@/components/common/other-login.vue';
	import { mapState } from 'vuex'
	export default {
		components: {
			uniListItem,
			otherLogin
		},
		data() {
			return {
				myData:[{
					name:"沟通过",
					num:2
				},{
					name:"已投简历",
					num:0
				},{
					name:"浏览",
					num:0
				},{
					name:"被浏览",
					num:1
				}],
				list:["Java", "Python", 'Go']
			}
		},
		onNavigationBarButtonTap() {
			uni.navigateTo({
				url: '../user-set/user-set'
			});
		},
		computed: {
			...mapState({
				loginStatus:state=>state.loginStatus,
				user:state=>state.user
			}),
			// 用户头像
			avatar(){
				console.log(this.user)
				console.log(this.loginStatus)
				return this.user.avatar ? this.user.avatar : '/static/default.jpg'
			}
		},
		onShow() {
		},
		watch: {
		},
		methods: {
			// 获取用户相关数据
			getCounts(){
				this.$H.get('/user/getcounts/'+this.user.id,{},{
					token:true,
					notoast:true
				}).then(res=>{
					if(res){
						this.myData[0].num = res.post_count
						this.myData[1].num = res.today_posts_count
						this.myData[2].num = res.comments_count
						this.myData[3].num = res.withfen_count
					}
				})
			},
			// 打开登录页
			openLogin(){
				uni.navigateTo({
					url: '../login/login',
				});
			},
			openHistory(){
				uni.navigateTo({
					url: '../history/history'
				});
			}, 
			openResume() {
				let resume = this.$store.state.user.resume;
				console.log("resume", resume);
				if (resume !== null && resume !== "") {
					uni.navigateTo({
						url: '../resume/resume?url=' + resume
					});
				} else {
					uni.showModal({
						content: '暂无简历，是否要上传简历？',
						success: (res)=>{
							if (res.confirm) {
								uni.navigateTo({
									url: '../upload-file/upload-file?type=resume'
								});
							}
						}
					});
				}
				
			}
		}
	}
</script>

<style>

</style>
