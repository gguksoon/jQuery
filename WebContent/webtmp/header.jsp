<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<style>
.navlogo {
	background: #f5c64d;
}

#imglogo {
	width: 150px;
	height: 25px;
}
</style>
<nav class="navbar navbar-inverse navlogo">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href=""> <img id="imglogo"
				src="../images/Coca-Cola-logo.png">
			</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>회원가입</a></li>
			</ul>
		</div>
	</div>
</nav>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle" id="menu1"
					data-toggle="dropdown">마이페이지 <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
						<li><a href="#">내가쓴글</a></li>
						<li><a href="#">내가쓴댓글</a></li>
						<li><a href="#">장바구니</a></li>
						<li><a href="#">정보수정</a></li>
					</ul>
				</li>

				<li class="dropdown"><a class="dropdown-toggle" id="menu1"
					data-toggle="dropdown">게시판 <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
						<li><a href="#">공지사항</a></li>
						<li><a href="#">QnA</a></li>
						<li><a href="#">자유게시판</a></li>
						<li><a href="#">자료실</a></li>
					</ul>
				</li>

				<li class="dropdown"><a class="dropdown-toggle" id="menu1"
					data-toggle="dropdown">이벤트 <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
						<li><a href="#">진행중인이벤트</a></li>
						<li><a href="#">1+1</a></li>
						<li><a href="#">반짝세일</a></li>
						<li><a href="#">당첨자발표</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>