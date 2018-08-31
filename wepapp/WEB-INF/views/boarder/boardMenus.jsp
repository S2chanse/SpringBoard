<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<table  class="t01" align="center">
		<tr>
			<th colspan="${menuLen }" id="menuHead">
				메뉴리스트
				<button type="button" id="menuBtn"class="btn btn-default btn-sm">
          			+
       			</button>
			</th>
		</tr>
		<c:forEach var="menuVo" items="${menuList }" >
		<tr>
			<td style="width: ${100/menuLen}%">
				<a href="/MENU/SELECT?menuId=${menuVo.menuId }">${menuVo.menuName }</a>
			</td>
		</tr>	
		</c:forEach>
	</table>
<script>

	$("#menuBtn").click(function(){
		if(!$('#menuBox').length){
		var menuBox=$("<div></div>").attr("id","menuBox");
		var addMenu=$("<a></a>").attr("href","/MENU/ADD").html("메뉴추가");
		var modiFyMenu=$("<a></a>").attr("href","/MENU/MODIFY").html("메뉴설정");
		menuBox.append(addMenu);
		menuBox.append($("</br>"));
		menuBox.append(modiFyMenu);
		$("#menuHead").append(menuBox);
		}else{
			$("#menuHead").find("#menuBox").remove();
		}			
});

</script>