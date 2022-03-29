<template>
	<view>
		<web-view :src="url">
		</web-view>
	</view>
</template>

<script>
	export default {
		components: {
			
		},
		data() {
			return {
				// pdf.js的viewer.htm所在路径
				// 注意：静态的html文件需要放在根路径下的 hybrid/html 文件夹中
				viewerUrl: '/hybrid/html/web/viewer.html',
				// 要访问的pdf的路径
				fileUrl: 'https://xxgk.xidian.edu.cn/__local/A/A8/80/DE7AFFA35670F1BA7EE37AD5AEC_2723EA0C_45C7E0.pdf',
				// 最终显示在web-view中的路径
				url: ''
			}
		},
		onLoad() {
			/**
			 * 1. 首先判断vuex中是否存在fileUrl，存在则直接显示
			 * 2. 如果不存在则询问是否添加简历，右上角的三个点也可以支持修改简历
			 * 3. 
			 */
			
			
			
			// h5，使用h5访问的时候记得跨域
			// #ifdef H5
			this.url = `${this.viewerUrl}?file=${encodeURIComponent(this.fileUrl)}`;
			// #endif
			
			// 在安卓和ios手机上
			// 判断是手机系统：安卓，使用pdf.js
			// #ifdef APP-PLUS
			if(plus.os.name === 'Android') {
				this.url = `${this.viewerUrl}?file=${encodeURIComponent(this.fileUrl)}`;
			}
			// ios，直接访问pdf所在路径
			else {
				this.url = encodeURIComponent(this.fileUrl);
			}
			// #endif
		},
		onUnload() {
			
		},
		onNavigationBarButtonTap() {
			uni.showModal({
				content: '是否要清除历史记录？',
				success: (res)=>{
					if (res.confirm) {
						uni.removeStorageSync('history')
						this.list = []
					}
				}
			});
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
