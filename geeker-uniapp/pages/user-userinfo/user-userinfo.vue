<template>
	<view>
		<uni-list-item title="头像" @click="changeUserpic">
			<view class="flex align-center" slot="right">
				<image :src="user.avatar ? user.avatar : '/static/default.jpg'"
				style="width: 100rpx;height: 100rpx;"
				class="rounded-circle"></image>
				<text class="iconfont icon-bianji1 ml-2"></text>
			</view>
		</uni-list-item>
		<uni-list-item title="呢称">
			<view class="flex align-center" slot="right">
				<input class="uni-input text-right" v-model="username" />
				<text class="iconfont icon-bianji1 ml-2"></text>
			</view>
		</uni-list-item>
		<uni-list-item title="性别" @click="changeSex">
			<view class="flex align-center" slot="right">
				<text>{{sexText}}</text>
				<text class="iconfont icon-bianji1 ml-2"></text>
			</view>
		</uni-list-item>
		<uni-list-item title="技术栈" @click="changeEmotion">
			<view class="flex align-center" slot="right">
				<text>{{emotionText}}</text>
				<text class="iconfont icon-bianji1 ml-2"></text>
			</view>
		</uni-list-item>
		<uni-list-item title="年级">
			<view class="flex align-center" slot="right">
				<input class="uni-input text-right" v-model="grade" />
				<text class="iconfont icon-bianji1 ml-2"></text>
			</view>
		</uni-list-item>
		<uni-list-item title="学院">
			<view class="flex align-center" slot="right">
				<input class="uni-input text-right" v-model="school" />
				<text class="iconfont icon-bianji1 ml-2"></text>
			</view>
		</uni-list-item>
		<uni-list-item title="专业">
			<view class="flex align-center" slot="right">
				<input class="uni-input text-right" v-model="major" />
				<text class="iconfont icon-bianji1 ml-2"></text>
			</view>
		</uni-list-item>
		
		<view class="py-2 px-3">
			<button class="bg-main text-white" style="border-radius: 50rpx;border: 0;" type="primary" @click="submit">完成</button>
		</view>
		
		
		<mpvue-city-picker :themeColor="themeColor" ref="mpvueCityPicker" :pickerValueDefault="cityPickerValueDefault" @onConfirm="onConfirm"></mpvue-city-picker>
		
	</view>
</template>

<script>
	const sexArray = ['保密', '男', '女']
	const emotionArray = ['Java', 'Python', 'Go', 'C++', '算法', '前端', '后端']
	import uniListItem from '@/components/uni-ui/uni-list-item/uni-list-item.vue';
	
	import mpvueCityPicker from '@/components/uni-ui/mpvue-citypicker/mpvueCityPicker.vue';
	
	import { mapState } from 'vuex'
	
	export default {
		components: {
			uniListItem,
			mpvueCityPicker
		},
		data() {
			return {
				themeColor: '#007AFF',
				cityPickerValueDefault: [0, 0, 1],
				pickerText: '',
				
				grade : "年级",
				sex : 0,
				emotion : 0,
				job : "保密",
				school : "学院",
				major : "专业",
				username:"昵称"
			}
		},
		// 监听返回
		onBackPress() {
		  if (this.$refs.mpvueCityPicker.showPicker) {
		  	this.$refs.mpvueCityPicker.pickerCancel();
		    return true;
		  }
		},
		// 监听页面卸载
		onUnload() {
			if (this.$refs.mpvueCityPicker.showPicker) {
				this.$refs.mpvueCityPicker.pickerCancel()
			}
		},
		onLoad() {
			let userinfo = this.$store.state.user.userInfo
			console.log(userinfo);
			if(userinfo){
				this.sex =  userinfo.sex
				this.emotion = emotionArray.indexOf(userinfo.language)
				this.grade  = userinfo.grade
				this.school  = userinfo.school
				this.major  = userinfo.major
			}
			this.username = this.user.username
		},
		computed: {
			...mapState({
				user:state=>state.user
			}),
			sexText() {
				return sexArray[this.sex]
			},
			emotionText(){
				return emotionArray[this.emotion]
			}
		},
		methods: {
			showCityPicker(){
				this.$refs.mpvueCityPicker.show()
			},
			// 三级联动提交事件
			onConfirm(e) {
				this.pickerText = e.label
			},
			// 修改生日
			onDateChange(e){
				this.birthday = e.detail.value
			},
			// 修改头像
			changeUserpic(){
				let id = this.$store.state.user.id;
				uni.chooseImage({
					count:1,
					sizeType:["compressed"],
					sourceType:["album","camera"],
					success: (res) => {
						this.$H.upload('/uploadFile',{
							filePath: res.tempFilePaths[0],
							name : 'file',
							token : true
						}).then(result=>{
							//console.log(result.obj);
							let url = result.obj;
							let rL = '/updateUserpic?user_id='+id+'&url='+url;
							this.$H.get(rL).then(res=>{
								//console.log(res);
								this.$store.commit('editUserInfo',{
									key:"avatar",
									value:res.data.obj
								})
								uni.showToast({
									title: '修改头像成功',
									icon: 'none'
								});
								
							})
						}).catch(err=>{
							console.log(err);
						})
					}
				})
			},
			// 修改性别
			changeSex(){
				uni.showActionSheet({
				    itemList: sexArray,
				    success:(res)=>{
				        this.sex = res.tapIndex
				    }
				});
			},
			// 修改技术栈
			changeEmotion(){
				uni.showActionSheet({
				    itemList: emotionArray,
				    success:(res)=>{
				        this.emotion = res.tapIndex
				    }
				});
			},
			// 提交
			submit(){
				
				let obj = {
					sex:this.sex,
					grade:this.grade,
					language:emotionArray[this.emotion],
					school:this.school,
					major:this.major,
					user_id:this.$store.state.user.id,
					username:this.username
				}
				console.log(obj);
				this.$H.post('/updateUserInfo', obj, {
					token:true
				}).then(res=>{
					
					this.$store.commit('editUserUserInfo', obj)
					uni.showToast({
						title: '修改资料成功',
						icon: 'none'
					});
					uni.navigateBack({
						delta: 1
					});
					uni.$emit('update', {msg:'页面更新'})
				})
			}
		}
	}
</script>

<style>

</style>
