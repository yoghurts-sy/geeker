<template>
	<view>
		<!-- #ifdef MP -->
		<uni-nav-bar :shadow="false" :fixed="true" :border="false" right-text="菜单" @click-right="clickNavigationButton"></uni-nav-bar>
		<!-- #endif -->
		<!-- 头部 -->
		<view class="flex align-center p-3 border-bottom border-light-secondary">
			<image :src="userinfo.userpic" 
			style="width: 180rpx;height: 180rpx;"
			class="rounded-circle"></image>
			<view class="pl-3 flex flex-column flex-1">
				<view class="flex align-center">
					<view class="flex-1 flex flex-column align-center justify-center" v-for="(item,index) in counts" :key="index">
						<text class="font-lg font-weight-bold">{{item.num}}</text>
						<text class="font text-muted">{{item.name}}</text>
					</view>
				</view>
				<view class="flex justify-center align-center">
					
					<button v-if="true"
					 type="default" size="mini"
					style="width: 400rpx;" @click="openResume">
						查看Ta的简历
					</button>
					
					<button v-else
					type="default" size="mini" 
					:class="userinfo.isFollow ? 'bg-light text-dark' : 'bg-main'"
					style="width: 400rpx;" @click="doFollow">
						{{userinfo.isFollow ? '已关注' : '关注'}}
					</button>

				</view>
			</view>
		</view>
		
		<!-- tab -->
		<view class="flex align-center" style="height: 100rpx;">
			<view class="flex-1 flex align-center justify-center"
			v-for="(item,index) in tabBars" :key="index"
			:class="index === tabIndex ? 'font-lg font-weight-bold text-main':'font-md'"
			@click="changeTab(index)">
			{{item.name}}</view>
		</view>
		
		<template v-if="tabIndex === 0">
			<view class="animated fast fadeIn">
				<view class="p-3 border-bottom">
					<view class="font-md">用户信息</view>
					<view class="font">昵称：{{userinfo.username}}</view>
					<view class="font">电话：{{userinfo.phone}}</view>
					<view class="font">邮箱：{{userinfo.email}}</view>
					<view class="font">性别：{{userinfo.sexStr}}</view>
					<view class="font">学院：{{userinfo.school}}</view>
					<view class="font">专业：{{userinfo.major}}</view>
					<view class="font">年级：{{userinfo.grade}}</view>
					<view class="font">技术栈：{{userinfo.language}}</view>
				</view>
			</view>
		</template>
		<template v-else>
			<view class="animated fast fadeIn">
				<common-list v-for="(item,index) in list" :key="index" :item="item" :index="index" @follow="follow" @doSupport="doSupport"></common-list>
				<divider></divider>
				<load-more :loadmore="loadmore"></load-more>
			</view>
		</template>
		
		
		
		<!-- 弹出层 -->
		<uni-popup ref="popup" type="top">
			<view class="flex align-center justify-center font-md border-bottom py-2" hover-class="bg-light" @click="doBlack">
				<text class="iconfont icon-sousuo mr-2"></text> 
				{{userinfo.isblack ? '移出黑名单' : '加入黑名单'}}
			</view>
			<view v-if="!userinfo.isblack" class="flex align-center justify-center font-md py-2" hover-class="bg-light" @click="openChat">
				<text class="iconfont icon-shanchu mr-2"></text> 聊天
			</view>
		</uni-popup>
		
		
	</view>
</template>

<script>
	const emotionArray = ['保密', '未婚', '已婚'];
	import commonList from '@/components/common/common-list.vue';
	import uniPopup from '@/components/uni-ui/uni-popup/uni-popup.vue';
	import $T from '@/common/time.js';
	import { mapState } from 'vuex'
	import uniNavBar from '@/components/uni-ui/uni-nav-bar/uni-nav-bar.vue';
	export default {
		components: {
			commonList,
			uniPopup,
			uniNavBar
		},
		data() {
			return {
				id:0,
				user_id:0,
				userinfo:{
					userpic:"/static/default.jpg",
					username:"",
					phone:"",
					email:"",
					sexStr:"暂未填写",
					language:"暂未填写",
					school:"暂未填写",
					major:"暂未填写",
					grade:"暂未填写"
				},
				counts:[{
					name:"帖子",
					num:0
				},{
					name:"关注",
					num:0
				},{
					name:"粉丝",
					num:0
				}],
				tabIndex:0,
				tabBars:[{
					name:"主页",
				},{
					name:"帖子",
					list:[],
					// 1.上拉加载更多  2.加载中... 3.没有更多了
					loadmore:"上拉加载更多",
					page:1
				},{
					name:"动态",
					list:[],
					// 1.上拉加载更多  2.加载中... 3.没有更多了
					loadmore:"上拉加载更多",
					page:1
				}],
				sexArray:['保密', '男', '女']
			}
		},
		onNavigationBarButtonTap() {
		},
		computed: {
		},
		filters: {
		},
		onLoad(e) {
			if(!e.user_id){
				return uni.showToast({
					title: '非法参数',
					icon: 'none'
				});
			}
			let id = e.user_id;
			this.$H.post('/userInfo', {
				user_id:id
			}).then(res=>{
				console.log(res.data.obj)
				this.userinfo = res.data.obj;
				this.userinfo.sexStr = this.sexArray[this.userinfo.sex]
			})
		},
		onUnload() {
		},
		methods: {
			openResume() {
				let resumeURL = this.userinfo.resume;
				console.log("resumeURL", resumeURL)
				if (resumeURL === "" || resumeURL === null) {
					uni.showToast({
						title: '该用户没有上传简历！',
						icon: 'none'
					});
				} else {
					uni.navigateTo({
						url: '../resume/resume?url=' + resumeURL
					});
				}
			}
		}
	}
</script>

<style>

</style>
