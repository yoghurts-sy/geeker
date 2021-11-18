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
			<common-list :item="item" :index="index" @follow="follow" @doSupport="doSupport"></common-list>
			<!-- 全局分割线 -->
			<divider></divider>
		</block>

		<!-- 顶部选项卡 -->
		<scroll-view scroll-x :scroll-into-view="scrollInto" class="scroll-row" style="height: 100rpx;">
			<view v-for="(item,index) in tabBars" :key="index" class="scroll-row-item px-3 py-2 font-md"
				:id="'tab'+index" :class="tabIndex === index ? 'text-main font-lg font-weight-bold' : ''"
				@click="changeTab(index)">{{item.name}}</view>
		</scroll-view>

		<swiper :duration="150" :current="tabIndex" @change="onChangeTab" :style="'height:'+scrollHeight+'px;'">
			<swiper-item v-for="(item,index) in newsList" :key="index">
				<!-- scroll-view 是展示信息的位置 -->
				<scroll-view scroll-y="true" :style="'height:'+scrollHeight+'px;'" @scrolltolower="loadmore(index)">
					<!-- 列表不空 -->
					<template v-if="item.list.length">
						<!-- 遍历list -->
						<block v-for="(item2, index2) in item.list" :key="index2">
							<!-- 列表组件 -->
							<common-list :item="item2" :index="index2" @follow="follow" @doSupport="doSupport">
							</common-list>
							<!-- 全局分割线 -->
							<divider></divider>
						</block>
						<!-- 上拉加载 -->
						<load-more :loadmore="item.loadmore"></load-more>
					</template>
					<!-- 列表空 -->
					<template v-else>
						<Nothing></Nothing>
					</template>
					
				</scroll-view>
			</swiper-item>
		</swiper>

	</view>
</template>

<script>
	// 演示列表
	const demo = [{
								username: "昵称",
								userpic: "/static/default.jpg",
								newstime: "2021-11-7",
								isFollow: false,
								title: "我是标题",
								titlepic: "/static/demo/datapic/11.jpg",
								support: {
									type: "support",
									support_count: 0,
									unsupport_count: 2
								},
								comment_count: 2,
								share_count: 2
							}, {
								username: "昵称",
								userpic: "",
								newstime: "2021-11-7",
								isFollow: false,
								title: "我是标题",
								titlepic: "",
								support: {
									type: "unsupport",
									support_count: 1,
									unsupport_count: 2
								},
								comment_count: 2,
								share_count: 2
							},
							{
								username: "昵称",
								userpic: "",
								newstime: "2021-11-7",
								isFollow: false,
								title: "我是标题",
								titlepic: "",
								support: {
									type: "",
									support_count: 1,
									unsupport_count: 2
								},
								comment_count: 2,
								share_count: 2
							},
						]
	import commonList from '@/components/common/common-list.vue'
	
	import loadMore from '@/components/common/loadmore.vue'
	export default {
		components: {
			commonList,
			loadMore
		},
		data() {
			return {
				scrollHeight: 0,
				tabIndex: 0,
				tabBars: [{
						name: "关注"
					},
					{
						name: "推荐"
					},
					{
						name: "体育"
					},
					{
						name: "英语"
					},
					{
						name: "随笔"
					},
					{
						name: "随便"
					},
					{
						name: "随便"
					},
					{
						name: "随便"
					},
					{
						name: "随便"
					},
					{
						name: "随便"
					},
				],
				scrollInto: "",
				newsList: [ //每个tab对应newsList里的一个对象  tab内的内容存在list数组中
				],

			}
		},
		// 监听点击导航栏搜索框
		onNavigationBarSearchInputClicked() {
			uni.navigateTo({
				url: '../search/search'
			});
		},
		onLoad() {
			uni.getSystemInfo({
				success: res => {
					console.log(res)
					this.scrollHeight = res.windowHeight - uni.upx2px(100)
				}
			})
			// 根据选项生成列表
			this.getData()

		},
		methods: {
			loadmore(index){
				let item = this.newsList[index]
				//判断是否可加载
				if(item.loadmore !== "上拉加载更多") return;
				
				item.loadmore = '加载中...';
				setTimeout(()=>{
					// 加载数据
					item.list = [...item.list, ...item.list]
					
					item.loadmore = '上拉加载更多'
				}, 2000)
			},
			getData() {
				var arr = []
				for (let i = 0; i < this.tabBars.length; i++) {
					// 生成列表模板
					let item = {
						// 1.上拉加载更多  2.加载中... 3.没有更多了
						loadmore: "上拉加载更多",
						list: []
					}
					if(i < 2) item.list = demo
					arr.push(item)
				}
				this.newsList = arr
			},
			follow(index) {
				this.list[index].isFollow = true
				uni.showToast({
					title: "关注成功"
				})
			},
			doSupport(data) {
				this.newsList[this.tabIndex].list[data.index].support.type = data.type;
			},
			// 监听滑动
			onChangeTab(res) {
				this.changeTab(res.detail.current)
			},
			// 切换
			changeTab(index) {
				if (this.tabIndex === index) {
					return;
				}
				this.tabIndex = index
				// 滚动到指定元素
				this.scrollInto = 'tab' + index
			}

		}
	}
</script>

<style>

</style>
