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
<script src="/js/WriteForm.js"></script>
<script>
window.onload=function(){
	$("#del").click(function(){
		var pwd=document.getElementById("pwd");
		var pwdCheck=${boardVo.mempwd};
		var result=checkPwd(pwd,pwdCheck);
		if(result){
			location.href="/PDS/Delete?idx=${boardVo.idx}&menuId=${boardVo.menuid }";
		}else{
			pwd.value="";
			pwd.focus();
		}
		
	});
}
</script>
</head>
<body>
	<table class="t01" style="width:60%;" align="center">
		<caption><h1>DeletePage</h1></caption>
		<tr>
			<th colspan="2">비밀번호 확인</th>
		</tr>
		<tr>
			<th>비밀번호:</th>
			<td>
				<input type="password"  id="pwd"/>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				&nabla;<a id="del">삭제</a>&nbsp;
				&nabla;<a href="/PDS/getView?idx=${boardVo.idx}&menuId=${boardVo.menuid }
				&pnum=${pnum}&bnum=${bnum}&rowcnt=${rowcnt}">이전으로</a>&nbsp;
				
			</th>
		</tr>
	</table>
</body>
</html>