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
<body>
	<div class="container">
		<div class="row">
			<input type="text" size=30 class="input-xm" v-model="msg">
		</div>
		<div class="row" style="margin-top: 10px">
			<span>{{msg}}</span>
		</div>
	</div>
	<script>
		// 데이터가 변경이 되면 자동으로 HTML으로 보내준다
		let a=Vue.createApp({
			data(){
				return {
					msg:''
				}
			}
		}).mount('.container')
	</script>
</body>
</html>