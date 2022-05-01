<template>
	<view>
		<view class="box">
			<lsj-upload
			ref="lsjUpload"
			width="100px"
			height="80rpx"
			childId="upload"
			:size="10"
			:option="option"
			v-model="percent"
			@input="onInput"
			@callback="onCallback">
			    <view class="btn"> + </view>
			</lsj-upload>
		</view>
		
	</view>
</template>

<script>
	/*  */
	export default {
	    data() {
	        return {
	            option: {},
	            tabIndex: 0,
	            percent: '',
	            list:[]
	        }
	    },
	    onReady() {
	        // 初始化参数并创建上传DOM
			let baseUrl = 'http://localhost:8585/love/api';
	        this.option = {
	            // #ifdef APP-PLUS
	            cuWebview: this.$mp.page.$getAppWebview(), // app必传 
	            // #endif
	            url: baseUrl + '/uploadFile', //替换为你的接口地址
	            name: 'file', // 附件key
	            size: 10, // 附件上传大小上限(M)，默认10M
	            debug: true,
	            //根据你接口需求自定义请求头
	            //根据你接口需求自定义body参数
	            formData: {
	                /* 'orderId': 1000 */
	            }
	        };
	    },
	    methods: {
	        add() {
	            this.list.push('DOM重排测试');
	        },
	        open() {
	            
	        },
	        onTab(tabIndex) {
	            this.tabIndex = tabIndex;
	
	            if (tabIndex == 0 ) {
	                this.$nextTick(()=>{
	                    this.$refs.lsjUpload.show();
	                })
	            }
	            else {
	                this.$refs.lsjUpload.hide();
	            }
	
	        },
	        onInput(e) {
	            console.log('上传进度',e);
	        },
	        onCallback(e) {
	            console.log('上传结果', e);
				let res = e;
				if (res !== undefined) {
					res = JSON.parse(res.responseText)
					console.log(res.obj)
				}
	        }
	    }
	}
</script>

<style>
	.btn {
		height: 180rpx;
		widt: 200rpx;
		
		background-color: #FFFFFF;
		color: #D9D9D9;
		border-radius: 10rpx;
		border: #D9D9D9 solid 4px;
		display: flex;
		align-items: center;
		justify-content: center;
		font-size: 58rpx;
		font-weight: bold;
		margin-top: 340rpx;
	}
	.box {
		height: 100%;
		width: 100%;
		text-align: center;
	}
</style>
