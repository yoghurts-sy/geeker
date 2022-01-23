<template>
	<view>
		<!-- <view class="box animate__animated" hover-stay-time="800" hover-class="box-hover animate__rubberBand">
			<text>text组件</text>
			<view>1</view>
			<view>2</view>
			<view>3</view>
			<view>4</view>
		</view> -->
		
		<view class="flex flex-row bg-danger" >
			
			<view class="flex-1 bg-primary text-center" >1</view>
			<view class="flex-1 bg-primary text-center" >2</view>
			<view class="flex-1 bg-primary text-center" >3</view>
			<view class="flex-1 bg-primary text-center" >4</view>
			<view class="flex-1 bg-primary text-center" >5</view>
			<view class="flex-1 bg-primary text-center" >6</view>

		</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style>
	.my-box{
		width: 750rpx;
		height: 600rpx;
		border: #000000 1rpx solid;
	}
	
	
	.box{
		width: 610upx;
		height: 600upx;
		display: flex;
		/* flex-direction: column; */
		/* flex-wrap: wrap-reverse; */
		justify-content: center;/*左右方向调整*/
		align-items: center;/*上下方向调整 stretch 子元素中没声明height时拉伸*/
	}
	
	.box-item{
		color: white;
		height: 200upx;
		width: 200upx;
		font-size: 30upx;
		font-weight: bold;	
		text-align: center;
		border: 1upx solid black;
	}
	
	.box>view:nth-of-type(even){
		background: blue;
		flex: 1;
	}
	
	.box>view:nth-of-type(odd){
		background: green;
		flex: 2; /*按比例划分*/
	}
	
	.box>view:first-of-type{
		flex-shrink: 0;/*0为不压缩*/
	}
	
	.box-hover{
		background: red;
	}

/* 	.box view{
		font-size: 40upx;
	}
	
	.box>:nth-child(2n-1){
		background: white;
	}
	.box>:nth-child(2n){
		background: red;
	} */
	
</style>
