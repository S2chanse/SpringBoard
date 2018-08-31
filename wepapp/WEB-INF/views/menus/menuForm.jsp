<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link type="text/css" rel="stylesheet" href="/css/common.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	function submit(){
		var fmt=document.getElementsByTagName("form")[0];
		var inputTagName=document.getElementsByName("MenuName")[0];
		if(inputTagName.value==''){
			alert("메뉴이름을 입력해주세요");
			inputTagName.focus();
		}else{
			alert("메뉴가 추가되었습니다.");
			fmt.submit();
		}
	}
</script>
</head>
<body>
<style>
	div{box-sizing: border-box; border: 1px solid black;}
</style>
<body>
	<div style="width:80%; height: 900px; margin:0 auto;">
		<div style="height: 15%;">
			<%@ include  file="../parts/header.jsp"%>
		</div>
		<div style="height: 5%;">
			<%@ include  file="../parts/menus.jsp"%>
		</div>
		<div style="height: 5%;">
			
		</div>
		<div style="clear:both; width: 100%;height:65%; border:0px;">
			<div style="float:left;width: 22%;height: 99.9%;">
				<%@ include file="../boarder/boardMenus.jsp" %>
			</div>
			<div style="float:left;width: 78%;height: 99.9%;">
				<form action="/MENU/INMENU" method="post">
					<div style="text-align:center;width:100%; margin:0 auto; ">
						<div style="width:100%;border:1px solid black;">
							메뉴추가하기
						</div>
						<div style="margin:0 auto; ">
							<div style="text-align:center;height:30px;width:30%;float:left; border: 1px solid black;">
								메뉴이름
							</div>
							<div style="text-align:center; height:30px;;width:70%;float:left; border: 1px solid black;">
								<input type="text" name="MenuName" 
								style="width:95%;height: 75%;" />
						</div>
						</div>
						<a onclick="submit()">메뉴추가</a> <a href="/Board/List?menuId=MENU01">목록으로</a>	
					</div>
				</form>			
			</div>
		</div>
			<div style="height: 10%;">
				<%@ include  file="../parts/bottom.jsp"%>				
			</div>
	</div>
	
</body>
</html>