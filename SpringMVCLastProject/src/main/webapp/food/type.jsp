<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/pagecard.js"></script>
<style type="text/css">
.row{
	margin: 0px auto;
	width: 100%;
}
p {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;	
}
a.link{
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container-fluid" id="type_app">
		<div class="row">
			<div class="text-center">
				<button class="btn-lg btn-danger" type="button" @click="select('한식')">한식</button>
				<button class="btn-lg btn-primary" type="button" @click="select('중식')">중식</button>
				<button class="btn-lg btn-info" type="button" @click="select('양식')">양식</button>
				<button class="btn-lg btn-warning" type="button" @click="select('일식')">일식</button>
				<button class="btn-lg btn-success" type="button" @click="select('분식')">분식</button>
			</div>
		</div>
		<!-- <div class="row" style="margin-top: 20px"> -->
			<div class="col-sm-7" style="margin-top:20px">
				<div class="col-md-3" v-for="vo in list">
					<div class="thumbnail">
						<a class="a-link" @click="detailData(vo.fno)">
							<img :src="vo.poster" style="width: 240px; height: 150px">
							<div class="caption">
								<p>{{vo.name}}</p>
							</div>
						</a>
					</div>
				</div>
				<div class="text-center" style="margin-top: 10px">
					<pagecard></pagecard>
				</div>
			</div>
			<div class="col-sm-4" v-show="isShow">
				<fooddetail v-bind:detail="detail"></fooddetail>
			</div>
		<!-- </div> -->
	</div>
<script>
	const fooddetail={
			props:['detail'],
			template:
				`
				<table class="table">
				<tbody>
				<tr>
					<td width="30%" class="text-center" rowspan="9">
						<img :src="detail.poster" style="width:250px;height:350px">
					</td>
					<td colspan="2">
						<h3><span id="name">{{detail.name}}&nbsp;</span><span style="color:orange">{{detail.score}}</span></h3>
					</td>
				</tr>
				<tr>
					<td width="15%" style="color:gray">주소</td>
					<td width="55%">{{detail.address}}</td>
				</tr>
				<tr>
					<td width="15%" style="color:gray">전화</td>
					<td width="55%">{{detail.phone}}</td>
				</tr>
				<tr>
					<td width="15%" style="color:gray">음식 종류</td>
					<td width="55%">{{detail.type}}</td>
				</tr>
				<tr>
					<td width="15%" style="color:gray">가격대</td>
					<td width="55%">{{detail.price}}</td>
				</tr>
				<tr>
					<td width="15%" style="color:gray">주차</td>
					<td width="55%">{{detail.parking}}</td>
				</tr>
				<tr>
					<td width="15%" style="color:gray">영업시간</td>
					<td width="55%">{{detail.time}}</td>
				</tr>
				<tr>
					<td width="15%" style="color:gray">테마</td>
					<td width="55%">{{detail.theme}}</td>
				</tr>
			</tbody>
			</table>
			<table class="table">
				<tbody>
				<tr>
					<td>{{detail.context}}</td>
				</tr>
				</tbody>
			</table>
				`
	}
	let typeApp=Vue.createApp({
		data(){
			return {
				// 변수 선언(멤버변수)
				list:[],
				curpage:1,
				totalpage:0,
				startPage:0,
				endPage:0,
				detail:{},
				isShow:false,
				type:'한식'
			}
		},
		mounted(){
			// Callback함수 => 자동호출
			this.dataRecv()
		},
		methods:{
			detailData(fno){
				this.isShow = true
				axios.get('../food/detail_vue.do', {
					params:{
						fno:fno
					}
				}).then(res=>{
					this.detail=res.data
				}).catch(error=>{
					console.log(error.response)
				})
			},
			// 사용자 정의 함수 => 자동 호출 x
			dataRecv(){
				
				axios.get('http://localhost:8080/web/food/type_vue.do', {
					params:{
						page:this.curpage,
						type:this.type
					}
				}).then(response=>{
					console.log(response.data)
					this.list=response.data.list
					this.curpage=response.data.curpage
					this.totalpage=response.data.totalpage
					this.startPage=response.data.startPage
					this.endPage=response.data.endPage
				})
				
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
			select(type){
				this.type=type
				this.curpage=1
				this.dataRecv()
			}
		},
		components:{
			'pagecard':pagecard,
			'fooddetail':fooddetail
			
		}
	}).mount("#type_app")
</script>
</body>
</html>