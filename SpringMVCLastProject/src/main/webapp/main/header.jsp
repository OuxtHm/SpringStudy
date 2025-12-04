<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SpringMVC</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="../main/main.do">Home</a></li>
      <li><a href="../member/join.do">회원가입</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">맛집
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="../food/find.do">맛집 검색</a></li>
          <li><a href="../food/type.do">음식별 검색</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">상품
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="../goods/list.do">전체 상품</a></li>
          <li><a href="#">베스트 상품</a></li>
          <li><a href="#">특가 상품</a></li>
          <li><a href="#">신상품</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">레시피
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="../recipe/list.do">레시피</a></li>
          <li><a href="#">셰프</a></li>
          <li><a href="#">레시피 검색</a></li>
        </ul>
      </li>
      <li><a href="../board/list.do">커뮤니티</a></li>
      <li><a href="#">실시간 채팅</a></li>
    </ul>
  </div>
</nav>
<div class="container">
	<div class="row text-right">
		ID:<input type="text" ref="id" size=15 class="input-sm">
		&nbsp;
		PW:<input type="password" ref="pwd" size=15 class="input-sm">
		&nbsp;
		<button class="btn btn-sm btn-primary">로그인</button>
		자동 로그인:<input type="checkbox" id="remember-me">
	</div>
</div>
<div style="height: 10px"></div>
</body>
</html>