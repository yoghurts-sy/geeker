<template>
	<view>
		<!-- 帖子信息 -->
		<common-list :item="info" :support_type="support_type" isDetail></common-list>
		
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
				comments:[],
				focus:false,
				reply_id:0,
				support_type:false
			}
		},
		onLoad(e){
			console.log("e:");
			console.log(e);
			if(e.detail){
				this.__init(JSON.parse(e.detail))
				this.info = JSON.parse(e.detail)
				console.log(this.info)
				this.getComments()
			}
			var uid = this.$store.state.user.id;
			var pid = this.info.id
			var url = "/getsup?uid="+uid+"&pid="+pid;
			this.$axios.get(url).then(res=>{
				console.log(res);
				if(res.data.obj===1) {
					this.support_type = true
				}
			})
			
		},
		methods: {
			getComments(){
				var url = '/comments?post_id=' + this.info.id
				this.$axios.get(url).then(res=>{
					this.comments = res.data;
					this.info.comment_count = this.comments.length
				})
			},
			
			__init(data){ 
				// 修改标题
				uni.setNavigationBarTitle({
					title:data.title
				})
			},
			// 提交评论
			submit(data){
				if(data === ''){
					return uni.showToast({
						title: '评论不能为空',
						icon: 'none'
					});
				}
				uni.showLoading({
					title: '评论中...',
					mask: false
				});
				var uid = this.$store.state.user.id;
				var pid = this.info.id
				this.$H.post('/addcomments',{
					user_id:uid,
					fid:0,
					fnum:0,
					data:data,
					post_id:pid,
				}).then(res=>{
					uni.hideLoading()
					this.getComments()
				}).catch(err=>{
					uni.hideLoading()
				})
			},
		},
		// 过滤器
		filters:{
			formatTime(value){
				return $T.gettime(value)
			}
		},
		// 输入框失去焦点
		blur(){
			this.reply_id = 0
			this.focus = false
		}
	}
</script>

<style>

</style>
