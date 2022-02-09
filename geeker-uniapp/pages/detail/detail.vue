<template>
	<view>
		<!-- 帖子信息 -->
		<common-list :item="info" isDetail></common-list>
		
		<divider></divider>
		<view class="p-2 font-md font-weight-bold">
			最新评论 3
		</view>
		<view class="px-2">
			
			<view class="uni-comment-list">
					<view class="uni-comment-face"><image src="https://tangzhe123-com.oss-cn-shenzhen.aliyuncs.com/Appstatic/qsbk/demo/userpic/4.jpg"></image></view>
					<view class="uni-comment-body">
						<view class="uni-comment-top">
							<text>小猫咪</text>
						</view>
						<view class="uni-comment-content">前排支持</view>
						<view class="uni-comment-date">
							<view>2天前</view><view class="uni-comment-replay-btn">5回复</view>
						</view>
					</view>
			</view>
			
		</view>
		
		<view style="height: 100rpx;"></view>
		<bottom-input :focus="focus" @blur="blur" @submit="submit"></bottom-input>
	</view>
</template>

<script>
	
	import commonList from '@/components/common/common-list.vue';
	import bottomInput from '@/components/common/bottom-input.vue';
	export default {
		components:{
			commonList,
			bottomInput
		},
		data() {
			return {
				info:{}
			}
		},
		onLoad(e){
			if(e.detail){
				this.__init(JSON.parse(e.detail))
				this.info = JSON.parse(e.detail)
			}
		},
		methods: {
			__init(data){ 
				// 修改标题
				uni.setNavigationBarTitle({
					title:data.title
				})
			}
		}
	}
</script>

<style>

</style>
