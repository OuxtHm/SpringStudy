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
</head>
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">개인 정보</h3>
			<form method="post" action="input_ok.do">
				<table class="table">
					<tr>
						<td width=15%>이름</td>
						<td width=85%><input type=text name=name size=20 class="input-sm"></td>
					</tr>
					<tr>
						<td width=15%>성별</td>
						<td width=85%>
							<input type=radio name=sex value="남자" checked>남자 
							<input type=radio name=sex value="남자">여자 
						</td>
					</tr>
					<tr>
						<td width=15%>주소</td>
						<td width=85%><input type=text name=address size=50 class="input-sm"></td>
					</tr>
					<tr>
						<td width=15%>소개</td>
						<td width=85%>
							<textarea rows="5" cols="50" name=content size=20 class="input-sm"></textarea>
						</td>
					</tr>
					<td colspan="2" class="text-center">
						<button class="btn-sm btn-primary">전송</button>
					</td>
				</table>
			</form>
		</div>
	</div>
</body>
</html>