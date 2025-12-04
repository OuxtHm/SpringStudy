<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	Vue
		패턴 : MVVM 기반으로 제작된 프레임 워크
				프레임워크 VS 라이브러리
					|		   |
				   레고        완성품
		Model : 데이터 관리 => data(){}
		View	: mount에 소속된 HTML
					<template>
		ViewModel	: 요청 처리 => Model에 있는 데이터 값 변경
									  | 값 변경 시 마다
									  | View 전송
	
	1. Vue 객체 생성
		Vue.createApp({})
	2. Vue에서 HTML을 제어하는 데이터를 정의
		data()
		{
			return {
				변수 설정
				**정수
				no:0,
				실수
				num:0.0,
				**문자
				str:'', str:""
				**배열 => List
				arr:[],
				**객체 => VO
				vo:{},
				boolen
				isShow:true
			}
		}
		------------------------------Model
		created(){}	: Vue 객체생성 완료시에 자동 호출
			|
		mounted(){} : HTML이 브라우저에서 실행이 된 상태
			|			=> window.onload=function()
			|			=> $(function(){})
			|			*** 시작과 동시에 서버에 데이터 읽기
			|			*** 다른 프레임 워크 연동
			|			** Jquery / React / AngularJS
		updated(){}	: data()안에 있는 데이터 값이 갱신되면 호출
			|
		unmounted(){} : 화면이 변경 된 경우 => Vue 객체 소멸
		
		=> 반응형 시스템
		=> mount => 가상 메모리에 HTML 저장해 둔다
					--------
						| => 비교 다른 점만 변경 (가상돔)
				      실제 메모리 : 브라우저 읽어가는 메모리
		=> 속도가 빠르다 (String, StringBuffer)
								=> 시리얼라이즈
		-------------------------------------------
		컴포넌트 기반
		-----
			UI를 재사용할 수 있게 만든 독립적인 블록
				=> data, props, methods
				=> 기능 별로 나눠서 저장 => 필요시에 재사용
				=> pagecard
	
	
 --%>
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
</style>
</head>
<body>
	<div class="container" id="board_app">
		<div class="row">
			<h1 class="text-center">내용 수정</h1>
			<table class="table">
				<tr>
					<th width=15% class="text-center">이름</th>
					<td width=85%>
						<input type="text" ref="name" size="20" class="input-sm" v-model="name">
					</td>
				</tr>
				<tr>
					<th width=15% class="text-center">제목</th>
					<td width=85%>
						<input type="text" ref="subject" size="45" class="input-sm" v-model="subject">
					</td>
				</tr>
				<tr>
					<th width=15% class="text-center">내용</th>
					<td width=85%>
						<textarea rows="10" cols="45" ref="content" v-model="content"></textarea>
					</td>
				</tr>
				<tr>
					<th width=15% class="text-center">비밀번호</th>
					<td width=85%>
						<input type="password" ref="pwd" size="15" class="input-sm" v-model="pwd">
					</td>
				</tr>
				<tr>
					<td colspan="2" class="text-center">
						<button class="btn-sm btn-primary" type="button" @click="update()">수정</button>
						<button class="btn-sm btn-primary" type="button" onclick="javascript:history.back()">취소</button>
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
				name:'',
				subject:'',
				content:'',
				pwd:'',
				msg:'',
				no:${no}
			}
		},
		mounted(){
			axios.get('http://localhost:8080/web/board/update_vue.do',{
					params:{
						no:this.no
					}
				}).then(res=>{
					this.name=res.data.name
					this.subject=res.data.subject
					this.content=res.data.content
				})
		},
		methods:{
			update(){
				this.dataRecv()
			},
			async dataRecv(){
				if(this.name==="")
				{
					this.$refs.name.focus()
					return
				}
				if(this.subject==="")
				{
					this.$refs.subject.focus()
					return
				}
				if(this.content==="")
				{
					this.$refs.content.focus()
					return
				}
				if(this.pwd==="")
				{
					this.$refs.pwd.focus()
					return
				}
				
				await axios.put('http://localhost:8080/web/board/update_ok_vue.do', {
					name: this.name,
					subject: this.subject,
					content: this.content,
					pwd: this.pwd,
					no:this.no
				}).then(res=>{
					if(res.data.msg==='yes')
					{
						location.href='../board/detail.do?no='+this.no	
					}
					else
					{
						alert("수정에 실패했습니다.")	
						this.pwd=''
						this.$refs.pwd.focus()
					}
				})
			}
		}
	})
	app.mount("#board_app")
</script>
</body>
</html>