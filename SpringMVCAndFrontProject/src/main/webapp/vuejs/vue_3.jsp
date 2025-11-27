<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%--
	디렉티브
	v- => 태그 안에서 사용
	1) 제어문
		조거문
			단일 조건문
				v-if="조건"
			선택 조건문
				v-if="조건"
				v-else
			다중 조건문
				v-if
				v-else-if="조건"
				v-else-if="조건"
				v-else-if="조건"
				...
		반복문
			v-for
			-------------------------------- v-for와 v-if는 동시에 사용할 수 없다
 --%>
<body>
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<th class="text-center">사번</th>
					<th class="text-center">이름</th>
					<th class="text-center">입사일</th>
					<th class="text-center">직위</th>
					<th class="text-center">급여</th>
				</tr>
				<tr v-for="vo in sawon">
					<td class="text-center")>{{vo.sabun}}</td>
					<td class="text-center">{{vo.name}}</td>
					<td class="text-center">{{vo.day}}</td>
					<td class="text-center">{{vo.job}}</td>
					<td class="text-center">{{vo.sal}}</td>
				</tr>
			</table>
		</div>
	</div>
	<script>
		let a=Vue.createApp({
			data(){
				return {
					sawon:[
						{sabun: 1, name: '홍길동1', day:'2025-11-27', job: '사원', sal:'3000'},
						{sabun: 2, name: '홍길동2', day:'2025-11-27', job: '사원', sal:'3000'},
						{sabun: 3, name: '홍길동3', day:'2025-11-27', job: '사원', sal:'3000'},
						{sabun: 4, name: '홍길동4', day:'2025-11-27', job: '사원', sal:'3000'},
						{sabun: 5, name: '홍길동5', day:'2025-11-27', job: '사원', sal:'3000'}
					]
				}
			}
		}).mount('.container')
	</script>
</body>
</html>