<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

.row {
	margin: 0px auto;
	width: 960px;
}

p {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<form method="post" action="find.do">
				<select name="column" class="input-sm">
					<option value="title" ${column=="title" ? "selected":"" }>제목</option>
					<option value="chef" ${column=="chef" ? "selected":"" }>쉐프명</option>
				</select>
				<input type="text" name="fd" class="input-sm" size="20" value="${fd!=null?fd:'' }">
				<button class="btn-sm btn-primary">검색</button>
			</form>
		</div>
		<div class="row" style="margin-top: 10px">
			<c:forEach var="vo" items="${list }">
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="#"> 
							<img src="${vo.poster }" style="width: 230px; height: 120px" title="${vo.title }">
							<div class="caption">
								<p>${vo.chef }</p>
							</div>
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="row text-center" style="margin-top: 20px">
			<ul class="pagination">
				<c:if test="${startpage>1 }">
					<li><a href="find.do?page=${startpage-1}&fd=${fd}&column=${column}">&lt;</a></li>
				</c:if>
				<c:forEach var="i" begin="${startpage }" end="${endpage }">
					<li ${i==curpage?"class=active":"" }><a href="find.do?page=${i }&fd=${fd}&column=${column}">${i }</a></li>
				</c:forEach>
				<c:if test="${endpage <totalpage }">
					<li><a href="find.do?page=${endpage+1 }&fd=${fd}&column=${column}">&gt;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>