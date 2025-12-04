<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row{
	margin: 0px auto;
	width: 500px;
}
h3{
	text-align: center;
}
.a-link{
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container" id="join_app">
		<div class="row">
			<h3>회원가입</h3>
			<table class="table">
				<tbody>
					<tr>
						<th width=20% class="text-center">ID</th>
						<td width=80%>
							<input type="text" ref="userid" size=20 class="input-sm" v-model="userid">
						</td>
					</tr>
					<tr>
						<th width=20% class="text-center">Password</th>
						<td width=80%>
							<input type="password" ref="userpwd" size=20 class="input-sm" v-model="userpwd">
						</td>
					</tr>
					<tr>
						<th width=20% class="text-center">이름</th>
						<td width=80%>
							<input type="text" ref="username" size=20 class="input-sm" v-model="username">
						</td>
					</tr>	
					<tr>
						<th width=20% class="text-center">성별</th>
						<td width=80%>
							<input type="radio" value="남자" checked v-model="sex">남자
							<input type="radio" value="여자" v-model="sex">여자
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<button class="btn-sm btn-danger" @click="memberJoin()">회원가입</button>
							<button class="btn-sm btn-danger" onclick="javascript:history.back()">취소</button>
						</td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
<script>
	let joinApp=Vue.createApp({
		data(){
			return {
				userid:'',
				userpwd:'',
				username:'',
				sex:''
			}
		},
		methods:{
			memberJoin(){
				if(this.userid==="")
				{
					this.$refs.userid.focus()
					return 
				}
				if(this.userpwd==="")
				{
					this.$refs.userpwd.focus()
					return 
				}
				if(this.username==="")
				{
					this.$refs.username.focus()
					return 
				}
				
				axios.post('http://localhost:8080/web/member/join_vue_ok.do', {
					userid:this.userid,
					userpwd:this.userpwd,
					username:this.username,
					sex:this.sex
				}).then(response=>{
					if(response.data.msg==='yes')
					{
						location.href="../main/main.do"
					}	
					else
					{
						alert("회원가입에 실패하셨습니다.")
					}
				})
			}
		}
	}).mount("#join_app")
</script>
</body>
</html>