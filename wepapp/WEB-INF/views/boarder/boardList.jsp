<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link type="text/css" rel="stylesheet" href="/css/common.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>
	div{box-sizing: border-box; border: 1px solid black;}
</style>
<script>
window.onload=function(){
	
	$("#selRowCnt").change(function(){
		var link="/PDS/List?menuId=${menuId}&rowcnt="+$("#selRowCnt").val();
		location.href=link;
	});
}
</script>
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
				<%@ include  file="boardMenus.jsp"%>
			</div>
			<div style="float:left;width: 78%;height: 99.9%;">
			<!-- 여기에 주 내용이 들어갑니다. -->
				<%@ include  file="PdsList.jsp"%>				
			</div>
		</div>
			<div style="height: 10%;">
				<%@ include  file="../parts/bottom.jsp"%>				
			</div>
	</div>
</body>
</html>