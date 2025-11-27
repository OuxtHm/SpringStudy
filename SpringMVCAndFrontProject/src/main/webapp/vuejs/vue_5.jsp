<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		MVVM => model view viewModel
		----------------------------
		사용자(변경 요청) => 이벤트(버튼 클릭, 콤보박스 선택...)
			| HTML 태그
		  사용자 요청에 따라 변경
		  	| ViewModel => 함수처리
		  	  ---------
		  	  | data()에 저장된 데이터 값 변경
		  	 Model
		  	  | 변경된 데이터를 HTML로 전송
		  	 View : HTML
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
}

.row {
	margin: 0px auto;
	width: 800px;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="text-center">조건문(v-if, v-else, v-else-if)</h1>
		<div class="row">
			<button type="button" class="btn-sm btn-danger" @click="select(1)">한식</button>
			<button type="button" class="btn-sm btn-success" @click="select(2)">양식</button>
			<button type="button" class="btn-sm btn-info" @click="select(3)">중식</button>
			<button type="button" class="btn-sm btn-primary" @click="select(4)">일식</button>
			<button type="button" class="btn-sm btn-warning" @click="select(5)">기타</button>
		</div>
		<div class="row text-center" style="margin-top:20px">
			<div v-if="type===0">
				선택한 음식이 없습니다.
			</div>
			<div v-else-if="type===1">
				한식을 선택하셨습니다.
			</div>
			<div v-else-if="type===2">
				양식을 선택하셨습니다.
			</div>
			<div v-else-if="type===3">
				중식을 선택하셨습니다.
			</div>
			<div v-else-if="type===4">
				일식을 선택하셨습니다.
			</div>
			<div v-else-if="type===5">
				기타를 선택하셨습니다.
			</div>
		</div>
		<div class="row text-center" style="margin-top: 20px">
			<button class="btn-lg btn-danger" @click="log()">로그인</button>
			<button class="btn-lg btn-primary" @click="logout()">로그아웃</button>
			<div v-if="login===true">
				<h3>로그인 되었습니다.</h3>		
			</div>
			<div v-else>
				<h3>로그아웃 되었습니다.</h3>
			</div>
		</div>
		<div class="row text-center" style="margin-top: 20px">
			Start:<input type="text" class="input-sm" v-model="start"><br>
			End:<input type="text" class="input-sm" v-model="end"><br>
			<button type="button" class="btn-sm btn-warning">실행</button>
			<ul class="pagination">
				<li v-for="i in range(start, end)"><a href="#">{{i}}</a></li>
			</ul>
		</div>
	</div>
	<script>
		let a=Vue.createApp({
			data(){
				return {
					type:0,
					login:false,
					start:0,
					end:0
				}
			},
			methods:{
				select(no){
					this.type=no
				},
				log(){
					this.login=true
				},
				logout(){
					this.login=false
				},
				range(s, e)
				{
					// 3 5 => 2
					let arr=[];
					let len=e-s;
					for(let i=0; i<len; i++)
					{
						arr[i]=s;
						s++
					}
					return arr;
				}
			}
		}).mount(".container")
	</script>
</body>
</html>