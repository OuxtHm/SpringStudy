<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script type="text/javascript" src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
}

.row {
	margin: 0px auto;
	width: 800px;
}
p{
	overflow:hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
.link{
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3" v-for="vo in recipe_list">
				<div class="thumbnail">
					<a href="#"> 
						<img :src="vo.poster" style="width: 230px; height: 120px" :title=vo.title>
						<div class="caption">
							<p>{{vo.chef}}</p>
						</div>
					</a>
				</div>
			</div>
		</div>
		<div class="row text-center" style="margin-top: 20px">
			<ul class="pagination">
				
					<li v-if="startpage>1"><a class="link" @click="prev(startpage-1)">&lt;</a></li>
				
					
					<li v-for="i in range(startpage, endpage)" :class="i==curpage?'active':''"><a class="link" @click="pageChange(i)">{{i}}</a></li>
				
					<li v-if="endpage<totalpage"><a class="link" @click="next(endpage+1)">&gt;</a></li>
				
			</ul>
		</div>
	</div>
	<script>
		let listApp=Vue.createApp({
			data(){
				return {
					curpage:1,
					totalpage:0,
					startpage:0,
					endpage:0,
					recipe_list:[]
				}
			},
			mounted(){
				this.dataRecv()
			},
			methods:{
				range(start, end){
					let arr=[];
					let len=end-start
					for(let i=0; i<=len; i++)
					{
						arr[i]=start
						start++
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
				dataRecv(){
					axios.get('list_vue.do', {
						params:{
							page:this.curpage
						}
					}).then(response=>{
						console.log(response.data)
						this.recipe_list=response.data.list
						this.curpage=response.data.curpage
						this.totalpage=response.data.totalpage
						this.startpage=response.data.startpage
						this.endpage=response.data.endpage
					})	
				}
			}
		}).mount('.container')
	</script>
</body>
</html>