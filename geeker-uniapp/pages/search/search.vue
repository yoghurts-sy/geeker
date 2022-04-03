<template>
	<view>
		<template v-if="searchList.length === 0">
			<!-- 搜索历史 -->
			<view class="py-2 font-md px-2">搜索历史</view>
			<view class="flex flex-wrap">
				<view class="border rounded font mx-2 my-1 px-2" 
				v-for="(item,index) in list" :key="index"
				hover-class="bg-light"
				@click="clickSearchHistory(item)">{{item}}</view>
			</view>
		</template>
		<template v-else>
			<!-- 数据列表 -->
			<block v-for="(item,index) in searchList" :key="index">
				<common-list :item="item" :index="index"></common-list>
			</block>
		</template>
	</view>
</template>

<script>
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
	
	import commonList from '@/components/common/common-list.vue';
	export default {
		components:{
			commonList
		},
		data() {
			return {
				list:["what's wrong", `"hello world"`, 'do you'],
				searchList:[],
			}
		},
		// 监听导航输入
		onNavigationBarSearchInputChanged(e){
			this.searchText = e.text
		},
		// 监听点击导航搜索按钮
		onNavigationBarButtonTap(e) {
			if (e.index === 0) {
				this.searchEvent()
			}
		},
		methods: {
			// 点击搜索历史
			clickSearchHistory(text){
				this.searchText = text
				this.searchEvent()
			},
			// 搜索事件
			searchEvent(){
				// 收起键盘
				uni.hideKeyboard()
				
				// 请求搜索
				uni.showLoading({
					title: '加载中',
					mask: false
				});
				
				setTimeout(()=>{
					this.$axios.get("/scpost?keyword="+"你好"+"&pageNum="+0).then(res=>{
						console.log(res);
					})
					this.searchList = demo;
					uni.hideLoading()
				}, 2000);
			},
		}
	}
</script>

<style>

</style>
