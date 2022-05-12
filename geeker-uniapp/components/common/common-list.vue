<template>
	<view class="p-2">
		<!-- 头像昵称 | 关注按钮 -->
		<view class="flex align-center justify-between">
			<!-- 头像昵称 -->
			<view class="flex align-center">
				<!-- 头像 -->
				<image class="rounded-circle mr-2" :src="item.userpic" @click="openSpace"
					style="width: 65rpx;height: 65rpx;" lazy-load>
				</image>
				<!-- 昵称 发布时间 -->
				<view>
					<view class="font" style="line-height: 1.5;">
						{{item.username}}
					</view>
					<text class="font-sm text-light-muted" style="line-height: 1.5;">
						{{formatDate(item.newstime*1000)}}
					</text>
				</view>
			</view>
			
			


			<!-- 类型标识 -->
			
			<!-- <view class="flex align-center justify-center bg-primary rounded text-white ml-5" 
			style="width: 80rpx; height: 50rpx;"
			v-if="item.type">招聘</view>
			<view class="flex align-center justify-center bg-info rounded text-white ml-5" 
			style="width: 80rpx; height: 50rpx;" v-else>求职</view> -->
			
			<!-- 关注按钮 -->
			<!-- <view class="flex align-center justify-center rounded bg-main text-white  animate__animated faster"
				style="width: 90rpx;height: 50rpx;" v-if="!item.isFollow"
				hover-class="animate__jello" @click="follow">
				关注
			</view> -->
		</view>
		
		<view class="flex flex-wrap">
			<view class="border rounded font mx-2 my-1 px-2"
			v-for="(item,index) in list" :key="index"
			hover-class="bg-light">{{item}}</view>
		</view>

		<!-- 标题 -->
		<view class="font-md my-1" @click="openDetail">{{item.title}}</view>
		<!-- 图片 -->
		<image v-if="item.titlepic" :src="item.titlepic" @click="openDetail"
			style="height: 350rpx; width: 100%;border-bottom: 5rpx;">
		</image>
		
		
		
		<!-- 图标按钮 -->
		<view class="flex align-center">
			<!-- 顶|踩 -->
			<view class="flex-1 flex align-center justify-center animate__animated faster"
				hover-class="animate__jello" @click="doSupport('support')">
				
				<text class="iconfont icon-dianzan2 mr-2"></text>
				<text>{{item.support_count > 0 ? item.support_count : '喜欢'}}</text>
			</view>
			<!-- dislike 暂不需要 -->
			<!-- <view class="flex-1 flex align-center justify-center animate__animated faster"
				hover-class="animate__jello" @click="doSupport('unsupport')"
				:class="item.support.type === 'unsupport' ? 'text-main' : ''">
				<text class="iconfont icon-cai mr-2"></text>
				<text>{{item.support.unsupport_count > 0 ? item.support.unsupport_count : '不喜欢'}}</text>
			</view> -->
			<!-- 评论 -->
			<view class="flex-1 flex align-center justify-center animate__animated faster"
				hover-class="animate__jello" @click="doComment">
				<text class="iconfont icon-pinglun2 mr-2"></text>
				<text>{{item.comment_count > 0 ? item.comment_count : '评论'}}</text>
			</view>
			<!-- 分享 -->
			<!-- <view class="flex-1 flex align-center justify-center animate__animated faster"
				hover-class="animate__jello" @click="doShare">
				<text class="iconfont icon-fenxiang mr-2"></text>
				<text>{{item.share_count > 0 ? item.share_count : '转发'}}</text>
			</view> -->
		</view>
	</view>
</template>

<script>
	export default {
		props: {
			item: Object,
			index: Number,
			isDetail:{
				type: Boolean,
				default: false
			}
		},
		data() {
			return {
				list:["Java", "Python", 'go']
			}
		},
		methods: {
			// 打开个人空间
			openSpace() {
				console.log("打开个人空间")
			},
			// 关注
			follow() {
				this.$emit("follow", this.index)
			},
			// 进入详情页
			openDetail() {
				if(this.isDetail) return;
				console.log("进入详情页")
				uni.navigateTo({
					url: '../../pages/detail/detail?detail='+ JSON.stringify(this.item),
				});
			},
			// 顶踩操作
			doSupport(type) {
				this.$emit("doSupport", {
					type,
					index: this.index
				})
			},
			// 评论
			doComment() {
				console.log("评论")
			},
			// 分享
			doShare() {
				console.log("分享")
			},
			formatDate(date) {
			  var date = new Date(date);
			  var YY = date.getFullYear() + '-';
			  var MM = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
			  var DD = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate());
			  var hh = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
			  var mm = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
			  var ss = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
			  return YY + MM + DD +" "+hh + mm + ss;
			}
		}
	}
</script>

<style>

</style>
