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
	window.onload=function(){
		$(".updateATag").click(function(e){
			e.preventDefault();
			//alert($(this).attr("href"));
			var menuId=$(this).attr("href");
			$(this).parents("td").append($("#updateForm").css("display","block"));
			$("#inMenuName").focus();
			$("#cancel").click(function(){
				$("#updateForm").css("display","none");
			});
			$("#update").click(function(){
				var menuName=$("#inMenuName").val();
				var link="/MENU/UpdMenu?menuId="+menuId+"&menuName="+menuName;
				location.href=link;
			});
		});
		$(".cngSeqATag").click(function(e){
			e.preventDefault();
			//alert($(this).attr("href"));
			var menuId=$(this).attr("href");
			$(this).parents("td").append($("#seqCngForm").css("display","block"));
			$("#regret").click(function(){
				$("#seqCngForm").css("display","none");
			});
			$("#chnage").click(function(){
				var link="/MENU/ChangeSeq?menuId="+menuId+"&menuSeq="+$("#selSeq").val();
				location.href=link;
			});
		});
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
				<table  class="t01" align="center">
					<tr>
						<th>순서</th>
						<th>메뉴이름</th>
						<th>설정</th>
					</tr>
					<c:forEach var="menuVo" items="${menuList }" >
					<tr>
						<td>		
							${menuVo.menuIdx }
						</td>		
						<td>
							${menuVo.menuName }
						</td>
						<td>
							<a href="/MENU/DelMenu?menuId=${menuVo.menuId }">메뉴삭제하기</a>
							<%!/*<a href="/MENU/UpMenu?menuId=${menuVo.menuId }">수정</a>*/%>
							<a class="updateATag" href="${menuVo.menuId }">메뉴수정하기</a>
							<a class="cngSeqATag" href="${menuVo.menuId }">순서변경하기</a>
						</td>
					</tr>	
					</c:forEach>
				</table>		
			</div>
		</div>
			<div style="height: 10%;">
				<%@ include  file="../parts/bottom.jsp"%>				
			</div>
	</div>
	<div style="display: none; position: absolute;width:60%;left:60%;
	background-color: white;" id="updateForm">
		<div style="text-align:center;margin:0 auto;">
				<div style="margin:0 auto; ">
					<div style="text-align:center;height:30px;width:15%;float:left; ">
						메뉴이름
					</div>
					<div style="text-align:center; height:30px;;width:20%;float:left; ">
						<input type="text" id="inMenuName" 
						style="width:95%;height: 75%;"/>
					</div>
					<div style="text-align:center; height:30px;;width:15%;float:left;">
						<input type="button" value="수정" id="update"/>
						<input type="button" value="취소" id="cancel"/>
					</div>
			</div>
		</div>
	</div>
	<div style="display: none; position: absolute;width:90%;left:70%;
	background-color: white;" id="seqCngForm">
		<div style="text-align:center;margin:0 auto;">
				<div style="margin:0 auto; ">
					<div style="text-align:center; height:30px;;width:20%;float:left; ">
						<select id="selSeq">
								<option>순서를 선택하세요.</option>
							<c:forEach var="x"  begin="1" end="${menuLen }" step="1">
								<option value="${x}">${x}</option>
							</c:forEach>
						</select>
					</div>
					<div style="text-align:center; height:30px;;width:15%;float:left;">
						<input type="button" value="수정" id="chnage"/>
						<input type="button" value="취소" id="regret"/>
					</div>
			</div>
		</div>
	</div>
</body>
</html>