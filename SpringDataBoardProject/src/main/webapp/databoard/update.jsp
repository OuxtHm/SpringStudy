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
		<h3 class="text-center">수정하기</h3>
		<div class="row">
			<form method="post" action="update_ok.do">
				<table class="table">
					<tr>
						<td width=15%>이름</td>
						<td width=85%>
							<input type="text" name=name size=20 class=input-sm required value="${vo.name }">
							<input type="hidden" name=no value="${vo.no }">
						</td>
					</tr>
					<tr>
						<td width=15%>제목</td>
						<td width=85% >
							<input type="text" name=subject size=60 class=input-sm required value="${vo.subject }">
						</td>
					</tr>
					<tr>
						<td width=15%>내용</td>
						<td width=85%>
							<textarea rows="10" cols="60" name=content required>${vo.content }</textarea>
						</td>
					</tr>
					<tr>
						<td width=15%>비밀번호</td>
						<td width=85%>
							<input type="password" name=pwd size=10 class=input-sm required>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<button type="submit" class="btn-sm btn-success">수정</button>
							<button type="button" class="btn-sm btn-success" onclick="javascript:history.back()">취소</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<script>
		const app=Vue.createApp({
			data(){
				return {
					files:[]
				}
			},
			methods:{
				addFile(){
					this.files.push({})
				},
				removeFile(){
					if(this.files.length > 0)
					{
						this.files.pop()
					}
				}
			}
		}).mount(".container")
	</script>
</body>
</html>