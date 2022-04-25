<template>
	<view>
		<uni-nav-bar leftIcon="back" statusBar :border="false" @click-left="goBack">
			<view class="flex align-center justify-center w-100">
				所有人可见<text class="iconfont icon-shezhi"></text>
			</view>
		</uni-nav-bar>
		
		<!-- 文本域 -->
		<textarea v-model="content" placeholder="说一句话吧" class="uni-textarea px-2"/>
	
	
		<!-- 多图上传 -->
		<upload-image :list="imageList" @change="changeImage"></upload-image>
		
		
		<!-- 底部操作条 -->
		<view class="fixed-bottom bg-white flex align-center" style="height: 85rpx;">
		
			<picker mode="selector" :range="range">
				<view class="iconfont icon-caidan footer-btn animate__animated"
				hover-class="animate__jello"></view>
			</picker>
			
			<view class="iconfont icon-huati footer-btn animate__animated "
			hover-class="animate__jello"></view>
			<view class="iconfont icon-tupian footer-btn animate__animated"
			hover-class="animate__jello"></view>
			
			<view class="bg-main text-white ml-auto flex justify-center align-center rounded mr-2 animate__animated"
			 hover-class="animate__jello" style="width: 140rpx;height: 60rpx;">发送</view>
		</view>
	</view>
</template>

<script>
	
	import uniNavBar from '@/components/uni-ui/uni-nav-bar/uni-nav-bar.vue';
	import uploadImage from "@/components/common/upload-image.vue"
	export default {
		components: {
			uniNavBar,
			uploadImage
		},
		data() {
			
			return {
				content:'',
				imageList:[],
				// 是否已经弹出提示框
				showBack:false
			}
		},
		//监听返回
		onBackPress() {
			if((this.content !== '' || this.imageList.length > 0) && !this.showBack){
				uni.showModal({
					content: '是否要保存为草稿？',
					showCancel: true,
					cancelText: '不保存',
					confirmText: '保存',
					success: res => {
						// 点击确认
						if (res.confirm) {
							this.store()
						} 
						// 手动执行返回 delta返回的级数
						uni.navigateBack({ delta: 1 });
					},
				});
				this.showBack = true
				return true
			}
		},
		onLoad(){
			uni.getStorage({
				key:'add-input',
				success:(res)=>{
					if (res.data) {
						let result = JSON.parse(res.data)
						this.content = result.content
						this.imageList = result.imageList
					}
				}
			})
		},
		methods: {
			
			// 返回上一步
			goBack(){
				uni.navigateBack({ delta: 1 });
			},
			changeImage(e){ //e 是upload-image 组件传过来的照片列表
				this.imageList = e //this.imageList用来发送给后端图片
			},
			//保存草稿
			store(){
				// 保存为本地存储
				let obj = {
					content:this.content,
					imageList:this.imageList
				}
				uni.setStorage({
					key:'add-input',
					data:JSON.stringify(obj)
				})
			},
		}
	}
</script>

<style>
.footer-btn{
	width: 86rpx;
	height: 86rpx;
	display: flex;
	justify-content: center;
	align-content: center;
	font-size: 50rpx;
}
</style>
