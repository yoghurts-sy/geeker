<template>
	<view>
		
		<!-- 图标演示 -->
		<!-- <text class="iconfont icon-smile" style="font-size: 100rpx;color: red;"></text> -->
		
		<!-- 动画使用方式一：点击效果 -->
		<view style="display: flex;justify-content: center;padding: 50rpx;">
			<view class="animate__animated" hover-class="animate__rubberBand"
			style="border: 1rpx solid #333333;padding: 20rpx;">
				点击效果
			</view>
		</view>
		<!-- 动画使用方式二：v-if -->
		<!-- 动画使用方式三：列表渲染 -->
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		onLoad() {

		},
		methods: {

		}
	}
</script>

<style>
	
</style>
