<template>
	<view>
		<!-- 时间 -->
		<view v-if="shortTime"
		class="py-2 flex align-center justify-center font-sm text-light-muted">
			{{shortTime}}
		</view>
		<!-- 消息气泡 -->
		<view class="flex align-start px-2 my-2"
		:style="isSelf ? 'flex-direction: row-reverse;' : ''">
			<image :src="item.avatar ? item.avatar : '/static/default.jpg'"
			style="width: 100rpx;height: 100rpx;"
			class="rounded-circle bg-secondary" @click="openDetail"></image>
			<view class="bg-light p-2 rounded mx-2"
			style="max-width: 400rpx;">
				{{item.data}}
			</view>
		</view>
	</view>
</template>

<script>
	import $T from '@/common/time.js';
	export default {
		props:{
			item:Object,
			index:Number,
			pretime:[Number,String]
		},
		onLoad() {
		}
		,
		computed: {
			// 是否是登录用户本人
			isSelf() {
				let myId = this.$store.state.user.id
				return myId === this.item.user_id
			},
			// 转化时间
			shortTime(){
				return $T.getChatTime(this.item.create_time, this.pretime)
			}
		},
		methods:{
			openDetail() {
				console.log("openDetail");
				let id = this.$store.state.ToUser.user_id;
				uni.navigateTo({
					url: '../user-space/user-space?user_id=' + id
				});
			}
		}
	}
</script>

<style>
</style>
