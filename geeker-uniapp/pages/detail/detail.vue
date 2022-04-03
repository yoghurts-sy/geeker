<template>
	<view>
		<!-- 帖子信息 -->
		<common-list :item="info" isDetail></common-list>
		
		<divider></divider>
		<view class="p-2 font-md font-weight-bold">
			评论 {{comments.length}}
		</view>
		<view class="px-2">
			
			<view class="uni-comment-list"
			v-for="(item, index) in comments" :key="index">
					<view class="uni-comment-face"><image :src="item.userpic"></image></view>
					<view class="uni-comment-body">
						<view class="uni-comment-top">
							<text>{{item.username}}</text>
						</view>
						<view class="uni-comment-content">{{item.data}}</view>
						<view class="uni-comment-date">
							<view>{{item.create_time | formatTime }}</view>
							<!-- <view class="uni-comment-replay-btn">5回复</view> -->
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
	import $T from "@/common/time.js";
	export default {
		components:{
			commonList,
			bottomInput
		},
		data() {
			return {
				info:{},
				comments:[]
			}
		},
		onLoad(e){
			if(e.detail){
				this.__init(JSON.parse(e.detail))
				this.info = JSON.parse(e.detail)
				console.log(this.info)
				var url = '/comments?post_id=' + this.info.id
				this.$axios.get(url).then(res=>{
					this.comments = res.data;
				})
			}
		},
		methods: {
			__init(data){ 
				// 修改标题
				uni.setNavigationBarTitle({
					title:data.title
				})
			}
		},
		// 过滤器
		filters:{
			formatTime(value){
				return $T.gettime(value)
			}
		},
	}
</script>

<style>

</style>
