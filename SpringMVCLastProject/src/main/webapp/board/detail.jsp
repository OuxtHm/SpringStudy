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
	width: 800px;
}
h3 {
	text-align: center;
}
.a-link{
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="container" id="detail_app">
		<h3 class="text-center">내용보기</h3>
		<div class="row">
			<table class="table">
				<tbody>
					<tr>
						<th width=20% class="text-center danger">번호</th>
						<td width=30% class="tet-center">{{vo.no}}</td>
						<th width=20% class="text-center danger">작성일</th>
						<td width=30% class="tet-center">{{vo.dbday}}</td>
					</tr>
					<tr>
						<th width=20% class="text-center">이름</th>
						<td width=30% class="tet-center">{{vo.name}}</td>
						<th width=20% class="text-center">조회수</th>
						<td width=30% class="tet-center">{{vo.hit}}</td>
					</tr>
					<tr>
						<th width=20% class="text-center">제목</th>
						<td colspan="3" class="tet-center">{{vo.subject}}</td>
					</tr>
					<tr>
						<td colspan="4" class="text-left" valign="top" height="250">
							<pre style="border:none; background-color: white; white-space: pre-wrap">{{vo.content}}</pre>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="text-right">
							<a :href="'../board/update.do?no='+vo.no" class="btn btn-xs btn-success">수정</a>
							<a href="#" class="btn btn-xs btn-info a-link" @click="del()">{{msg}}</a>
							<a href="../board/list.do" class="btn btn-xs btn-warning">목록</a>
						</td>
					</tr>
					<tr v-show="isShow">
						<td colspan="4" class="text-right">
						비밀번호:<input type="password" ref="pwd" size="10" class="input-sm" v-model="pwd">
							   <button class="btn-sm btn-success" @click="boardDelete()">삭제</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
<script>
	let detailApp=Vue.createApp({
		data(){
			return {
				vo:{},
				no:${no},
				isShow:false,
				pwd:'',
				msg:'삭제'
			}
		},
		mounted(){
			axios.get("http://localhost:8080/web/board/detail_vue.do",{
				params:{
					no:this.no
				}
			}).then(response=>{
				console.log(response.data)
				this.vo=response.data
			})
		},
		methods:{
			del(){
				this.isShow=!this.isShow
				if(this.isShow)
				{
					this.msg='취소'
				}
				else
				{
					this.msg='삭제'	
				}
			},
			boardDelete(){
				if(this.pwd==="")
				{
					this.$refs.pwd.focus()
					return
				}
				axios.delete("http://localhost:8080/web/board/delete_vue.do",{
					params:{
						no:this.no,
						pwd:this.pwd
					}
				}).then(response=>{
					if(response.data.msg=='yes')
					{
						location.href='../board/list.do'		
					}
					else
					{
						alert("비밀번호가 일치하지 않습니다.")
						this.pwd=''
						this.$refs.pwd.focus()
					}
				})
			}
		}
	}).mount("#detail_app")
</script>
</body>
</html>