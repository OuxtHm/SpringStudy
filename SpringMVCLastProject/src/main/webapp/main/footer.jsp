<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {
  width: 960px;
}
</style>
</head>
<body>
  <div class="container">
   <div class="row" style="margin-top: 20px">
    <h3 class="text-center">최근 방문 맛집</h3>
    <hr>
    <c:forEach var="vo" items="${cList }">
      <div class="col-md-2">
		    <div class="thumbnail">
		      <a href="../food/detail.do?fno=${vo.fno}">
		        <img src="${vo.poster}" style="width:120px;height: 120px">
		        <div class="caption">
		          <p>${vo.name}</p>
		        </div>
		      </a>
		    </div>
		  </div>
    </c:forEach>
   </div>
  </div>
  
</body>
</html>