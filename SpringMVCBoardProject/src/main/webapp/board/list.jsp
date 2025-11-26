<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h1 class="text-center">게시판</h1>
		<div class="row">
			<table class="table">
				<tr>
					<td><a href="insert.do" class="btn btn-sm btn-warning">새글</a></td>
				</tr>
			</table>
			<table class="table">
				<tr>
					<th width=10% class="text-center">번호</th>
					<th width=45% class="text-center">제목</th>
					<th width=15% class="text-center">이름</th>
					<th width=20% class="text-center">작성일</th>
					<th width=10% class="text-center">조회수</th>
				</tr>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td widtd=10% class="text-center">${vo.no }</td>
						<td widtd=45%><a href="detail.do?no=${vo.no }">${vo.subject }</a></td>
						<td widtd=15% class="text-center">${vo.name }</td>
						<td widtd=20% class="text-center">${vo.dbday }</td>
						<td widtd=10% class="text-center">${vo.hit }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" class="text-center">
						<a href="list.do?page=${curpage>1 ? curpage-1 : curpage }" class="btn btn-sm btn-info">이전</a>
						${curpage } page / ${totalpage } pages
						<a href="list.do?page=${curpage<totalpage ? curpage + 1 : curpage }" class="btn btn-sm btn-success">다음</a>
					</td>
				</tr>
				
			</table>
		</div>
	</div>
</body>
</html>