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
		<h3 class="text-center">등록하기</h3>
		<div class="row">
			<form method="post" action="insert_ok.do" enctype="multipart/form-data">
				<table class="table">
					<tr>
						<td width=15%>이름</td>
						<td width=85%>
							<input type="text" name=name size=20 class=input-sm required>
						</td>
					</tr>
					<tr>
						<td width=15%>제목</td>
						<td width=85% >
							<input type="text" name=subject size=60 class=input-sm required>
						</td>
					</tr>
					<tr>
						<td width=15%>내용</td>
						<td width=85%>
							<textarea rows="10" cols="60" name=content required></textarea>
						</td>
					</tr>
					<tr>
						<td width=15%>첨부파일</td>
						<td width=85%>
							<table class="table">
								<tr>
									<td colspan="2" class="text-right">
										<button class="btn-xs btn-info" type=button @click="addFile()">Add</button>
										<button class="btn-xs btn-danger" type=button @click="removeFile()">Remove</button>
									</td>
								</tr>
							</table>
							<table class="table">
								<tr v-for="(file, index) in files">
									<td width=20% class="text-center">File {{index+1}}</td>
									<td width=80%>
										<input type="file" :name="'files['+index+']'">
										<%--
											Spring => List에 값을 채우는 경우
											name=file[0] file[1]
										 --%>
									</td>
								</tr>
							</table>
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
							<button type="submit" class="btn-sm btn-success">등록</button>
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