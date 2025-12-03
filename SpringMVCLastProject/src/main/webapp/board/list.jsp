<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row{
	margin: 0px auto;
	width: 800px;
}
h3 {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container" id="board_app">
		<h3>VueJS를 이용한 게시판</h3>
		<div class="row">
		<table class="table">
			<tr>
				<td>
					<a href="../board/insert.do" class="btn btn-sm btn-success">새글</a>
				</td>
			</tr>
		</table>
			<table class="table">
				<tr class="success">
					<th width=10% class="text-center">번호</th>
					<th width=45% class="text-center">제목</th>
					<th width=15% class="text-center">이름</th>
					<th width=20% class="text-center">작성일</th>
					<th width=10% class="text-center">조회수</th>
				</tr>
				<tr v-for="vo in list">
					<td widtd=10% class="text-center">{{vo.no}}</td>
					<td widtd=45%><a href="'../board/detail.do?no='+vo.no">{{vo.subject}}</a></td>
					<td widtd=15% class="text-center">{{vo.name}}</td>
					<td widtd=20% class="text-center">{{vo.dbday}}</td>
					<td widtd=10% class="text-center">{{vo.hit}}</td>
				</tr>
				<tr>
					<td colspan="5" class="text-center">
						<a href="#" class="btn btn-sm btn-danger">이전</a>
						{{curpage}} page / {{totalpage}} pages
						<a href="#" class="btn btn-sm btn-danger">다음</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
<script type="importmap">
{
	"imports":{
		"vue":"https://unpkg.com/vue@3/dist/vue.esm-browser.js"
	}
}
</script>
<script type="module">
	import {createApp} from "vue"
	const app=createApp({
		data(){
			return {
				list:[],
				curpage:1,
				totalpage:0
			}
		},
		mounted(){
			this.dataRecv()
		},
		methods:{
			async dataRecv(){
				await axios.get("http://localhost:8080/web/board/list_vue.do",{
				params:{
						page:this.curpage
					}
				}).then(response=>{
					console.log(response.data)
					this.list=response.data.list
					this.curpage=response.data.curpage
					this.totalpage=response.data.totalpage
				})
			}
		}
	})
	app.mount("#board_app")
</script>
</body>
</html>