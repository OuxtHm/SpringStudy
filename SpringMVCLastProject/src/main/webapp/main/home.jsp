<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {
	margin: 0px auto;
	width: 960px;
}
p {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;	
}
.a-link{
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container" id="food_list">
		<div class="row">
			<div class="col-md-3" v-for="vo in list">
				<div class="thumbnail">
					<a :href="'../food/detail_before.do?fno='+vo.fno">
						<img :src="vo.poster" style="width: 240px; height: 150px">
						<div class="caption">
							<p>{{vo.name}}</p>
						</div>
					</a>
				</div>
			</div>
		</div>
		<div class="row text-center" style="margin-top: 10px">
			<ul class="pagination">
				<li v-if="startPage > 1"><a class="a-link" @click="prev(startPage-1)">&lt;</a></li>
				<li v-for="i in range(startPage, endPage)" :class="i===curpage?'active':''"><a class="a-link" @click="pageChange(i)">{{i}}</a></li>
				<li v-if="endPage < totalpage"><a class="a-link" @click="next(endPage+1)">&gt;</a></li>
			</ul>
		</div>
	</div>
<script type="importmap">
{
	"imports":{
		"vue":"http://unpkg.com/vue@3/dist/vue.esm-browser.js"
	}
}
</script>
<script type="module">
	import {createApp} from "vue"
	import axiosClient from "../js/api.js"
	const app=createApp({
		// Model = 데이터 관리하는 영역
		data(){
			return {
				list:[],
				curpage:1,
				totalpage:0,
				startPage:0,
				endPage:0
			}
		},
		// VM => ViewModel : 데이터 제어 (상태변경)
		mounted(){
			this.dataRecv()
		},
		computed:{
			// 상수화 처리 : 1,000
		},
		methods:{
			// 사용자 정의 메소드 : 이벤트
			async dataRecv(){
				// 서버로부터 데이터 읽기
				const res = await axiosClient.get("food/list_vue.do", {
					params:{
						page:this.curpage
					}
				})
				console.log(res)
				this.list=res.data.list
				this.curpage=res.data.curpage
				this.totalpage=res.data.totalpage
				this.startPage=res.data.startPage
				this.endPage=res.data.endPage
			},
			range(start, end){
				let arr=[]
				let len=end-start
				for(let i=0; i <= len; i++)
				{
					arr[i]=start
					start++;	
				}
				return arr
			},
			prev(page){
				this.curpage=page
				this.dataRecv()	
							
			},
			next(page){
				this.curpage=page
				this.dataRecv()	
			},
			pageChange(page){
				this.curpage=page
				this.dataRecv()	
			}
		} 
	})
	app.mount("#food_list")
</script>
</body>
</html>