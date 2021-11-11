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
						{{item.newstime}}
					</text>
				</view>
			</view>

			<!-- 关注按钮 -->
			<view class="flex align-center justify-center rounded bg-main text-white  animate__animated faster"
				style="width: 90rpx;height: 50rpx;" v-if="!item.isFollow"
				hover-class="animate__jello" @click="follow">
				关注
			</view>
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
				hover-class="animate__jello text-main" @click="doSupport('support')">
				<text class="iconfont icon-dianzan2 mr-2"></text>
				<text>{{item.support.support_count}}</text>
			</view>
			<view class="flex-1 flex align-center justify-center animate__animated faster"
				hover-class="animate__jello text-main" @click="doSupport('unsupport')">
				<text class="iconfont icon-cai mr-2"></text>
				<text>{{item.support.unsupport_count}}</text>
			</view>
			<!-- 评论 -->
			<view class="flex-1 flex align-center justify-center animate__animated faster"
				hover-class="animate__jello text-main" @click="doComment">
				<text class="iconfont icon-pinglun2 mr-2"></text>
				<text>{{item.comment_count}}</text>
			</view>
			<!-- 分享 -->
			<view class="flex-1 flex align-center justify-center animate__animated faster"
				hover-class="animate__jello text-main" @click="doShare">
				<text class="iconfont icon-fenxiang mr-2"></text>
				<text>{{item.share_count}}</text>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		props: {
			item: Object,
			index: Number
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
				console.log("进入详情页")
			},
			// 顶踩操作
			doSupport(type) {
				type === 'support' ? console.log("顶") : console.log("踩");
			},
			// 评论
			doComment() {
				console.log("评论")
			},
			// 分享
			doShare() {
				console.log("分享")
			}
		}
	}
</script>

<style>

</style>
