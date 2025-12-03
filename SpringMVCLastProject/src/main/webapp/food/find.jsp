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
<script src="../js/pagecard.js"></script>
</head>
<body>
	<div class="container" id="food_list">
	<div class="row">
		<input type="text" size=30 class="input-sm" v-model="address">
		<button class="btn-sm btn-danger" type="button" @click="find()">검색</button>
	</div>
		<div class="row" style="margin-top: 10px">
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
			<pagecard></pagecard>
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
				endPage:0,
				address:'마포'
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
				const res = await axiosClient.get("food/find_vue.do", {
					params:{
						page:this.curpage,
						address:this.address
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
			},
			find(){
				this.curpage=1
				this.dataRecv()
			}
		},
		components:{
			'pagecard':pagecard	
		}
	})
	app.mount("#food_list")
</script>
</body>
</html>