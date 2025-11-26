<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 600px;
}
</style>
<script type="text/javascript" src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script type="text/javascript" src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		<h3 class="text-center">내용보기</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th width=20% class="text-center danger">번호</th>
					<td width=30% class="text-center">${vo.no }</td>
					<th width=20% class="text-center danger">작성일</th>
					<td width=30% class="text-center">${vo.dbday }</td>
				</tr>
				<tr>
					<th width=20% class="text-center danger">이름</th>
					<td width=30% class="text-center">${vo.name }</td>
					<th width=20% class="text-center danger">조회수</th>
					<td width=30% class="text-center">${vo.hit }</td>
				</tr>
				<tr>
					<th width=20% class="text-center danger">제목</th>
					<td colspan="3">${vo.subject }</td>
				</tr>
				<tr>
					<td colspan="4" valign="top" class="text-left" height=200>
						<pre style="white-space: pre-wrap; background-color:white; border:none">${vo.content }</pre>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="text-right">
						<a href="update.do?no=${vo.no }" class="btn btn-xs btn-warning">수정</a>
						<a href="#" class="btn btn-xs btn-success" @click="btnClick()">{{isOn?'삭제':'취소'}}</a>
						<a href="list.do" class="btn btn-xs btn-info">목록</a>
					</td>
				</tr>
				<tr v-show="bShow">
					<td colspan="4" class="text-right">
						비밀번호:<input type="password" name=pwd size=10 class="input-sm" v-model="pwd" ref="pwdRef">
						<button class="btn-sm btn-danger" type=button v-on:click="deleteBtn">삭제</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<%--
		vuex / pinia
		1. VueJS
			MVVM / 가상돔
		2. 생명주기
		3. 이벤트 => 디렉티브
					-----
					제어문 : 
							v-for
							v-if ~ v-else
							---- v-show
					화면 출력 => <태그>{{변수}}</태그>
							=> v-text="값"
							=> v-html="값"
							=> v-pre="값"
					이벤트 처리
							=> @click
							=> @mouseover
							=> @mouseout
							=> @keydown
							=> @keyup
					양방향 통신
							=> v-model
					*** id 속성이 아닌 ref 속성 사용
	 --%>
	<script>
		let deleteApp=Vue.createApp({
			data(){
				return {
					bShow:false,
					msg:'삭제',
					isOn:true,
					pwd:'',
					no:${param.no}
				}
			},
			methods:{
				btnClick(){
					this.isOn=!this.isOn
					this.bShow=!this.bShow
				},
				deleteBtn(){
					if(this.pwd==='')
					{
						this.$refs.pwdRef.focus();
						return
					}
					// 서버로 데이터 전송
					axios.get('delete.do',{
						params:{
							no:this.no,
							pwd:this.pwd
						}
					}).then(result=>{
						if(result.data==="yes")
						{
							window.location.href="list.do"
						}
						else
						{
							alert("비밀번호가 맞지 않습니다")
							this.pwd=""
							this.$refs.pwdRef.focus()
						}
					})
				}
			}
		}).mount(".container")
	</script>
</body>
</html>