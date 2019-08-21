<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
  
  <script>
  	$(function() {
  		$(".dropdown").on("click", function() {
			var menu = $(".dropdown-toggle", this).text();
			var subMenu = $(".dropdown-menu li", this);
			
			code =  '<div class="list-group">';
			code += '<a href="#" class="list-group-item active disabled">' + menu + '</a>';
			$.each(subMenu, function() {
				code += '<a href="#" class="list-group-item">' + $("a", this).text() + '</a>';
			});
			code += '</div>';
			
			$(".sidenav").html(code);
  		})
  		
  		// 상단 메뉴(드롭다운) 클릭 시 ==> 바인드
  		$(".dropdown-menu li a").on("click", function() {
			proc(this);
  		})
  		
  		// 왼쪽 메뉴(리스트그룹) 클릭 시 ==> 델리게이트
  		$(".sidenav").on("click", ".list-group-item", function() {
  			if(!$(this).attr("class").match("disabled")) {
  				proc(this);
  			}
  		})
  		
  		// 로그인, 회원가입 클릭 시
  		$("#myNavbar a").on("click", function() {
  			proc(this);
  		})
  		
  	})
  	
  	function proc(item) {
  		var subTxt = $(item).text();
  		$(".text-left h1").text(subTxt);
  		
  		if(subTxt == "회원가입") {
  			$(".text-left #result").load("/jqpro/member/member.html");
  		} else if(subTxt == "Login") {
  			$(".text-left #result").load("/jqpro/0812/lprod_prod.html");
  		}
  	}
  </script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="content.jsp"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>