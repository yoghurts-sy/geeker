<template>

	<!--
 	图标演示
	<text class="iconfont icon-smile" style="font-size: 100rpx;color: red;"></text>

	动画使用方式一：点击效果
	<view style="display: flex;justify-content: center;padding: 50rpx;">
			<view class="animate__animated" hover-class="animate__rubberBand"
			style="border: 1rpx solid #333333;padding: 20rpx;">
				点击效果
			</view>
		</view>
	动画使用方式二：v-if
	动画使用方式三：列表渲染 
	-->

	<view>

		<block v-for="(item, index) in list" :key="index">
			<!-- 列表组件 -->
			<common-list :item="item" :index="index" @follow="follow"></common-list>
			<!-- 全局分割线 -->
			<divider></divider>
		</block>
	</view>
</template>

<script>
	import commonList from '@/components/common/common-list.vue'
	
	export default {
		components:{
			commonList
		},
		data() {
			return {
				list: [
							{
							username: "昵称",
							userpic: "/static/default.jpg",
							newstime: "2021-11-7",
							isFollow: false,
							title: "我是标题",
							titlepic: "/static/demo/datapic/11.jpg",
							support: {
								type: "support",
								support_count: 1,
								unsupport_count: 2
							},
							comment_count: 2,
							share_count: 2
						},{
							username: "昵称",
							userpic: "/static/default.jpg",
							newstime: "2021-11-7",
							isFollow: false,
							title: "我是标题",
							titlepic: "",
							support: {
								type: "support",
								support_count: 1,
								unsupport_count: 2
							},
							comment_count: 2,
							share_count: 2
						},
					]

			}
		},
		onLoad() {

		},
		methods: {
			follow(index){
				this.list[index].isFollow = true
				uni.showToast({	title:"关注成功"	 })
			}

		}
	}
</script>

<style>

</style>
