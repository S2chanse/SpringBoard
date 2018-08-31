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
<style>
	div{box-sizing: border-box; border: 1px solid black;}
</style>
<script>
function prePage(){
	location.href="/PDS/List";
}
function fsubmit(){
	if($("#memId").val().length==0){
		alert("아이디를 써주세요.");
		$("#memId").focus();
	}else{
		if($("#memPwd").val().length==0){
			alert("비밀번호를 입력해 주세요.");
			$("#memPwd").focus();
		}else{
			if($("#Title").val().length==0){
				alert("제목을 입력하세요.");
				$("#Title").focus();
			}else{
				if($("#Cntx").val().length==0){
					alert("글내용을 입력하세요.");
					$("#Cntx").focus();
				}else{
					var frmSubmit=document.getElementById("frm");
					frmSubmit.submit();
				}
			}	
		}
	}	
}
window.onload=function(){
	$("#selRowCnt").change(function(){
		var link="/PDS/List?menuId=${menuId}&rowcnt="+$("#selRowCnt").val();
		location.href=link;
	});
	var i=1;
	$("#addFile").click(function(){
		var file=$("<input/>").attr({"type":"file"
			,"name":"upFile"+i
			,"id":"orgFile"+i
			,"size":50
			,"class":"upload-hidden"
		});
		var delButton=$("<input/>").attr({"type":"button","class":"btnDel","value":"삭제하기"});
		var divBox=$("<div></div>").attr("class","fileBox").append(file).append(delButton);
		$("#fileUpload").append(divBox);
		i++;
		$(".btnDel").click(function(e){
			console.log($(this).parent(".fileBox").remove());
			console.log(e.target.parentNode);
		});
	});
}
	
</script>

</head>
<body>
		<div style="width:80%; height: 900px; margin:0 auto;">
		<div style="height: 20%;">
			<%@ include  file="../parts/header.jsp"%>
		</div>
		<div style="height: 5%;">
			<%@ include  file="../parts/menus.jsp"%>
		</div>
		<div style="clear:both; width: 100%;height:65%; border:0px;">
			<div style="float:left;width: 22%;height: 99.9%;">
				<%@ include  file="boardMenus.jsp"%>
			</div>
			<div style="float:left;width: 78%;height: 99.9%;">
			<form action="/PDS/Write" method="post" id="frm" enctype="multipart/form-data">
				<input type="hidden" value="<c:out value="${menuId }"/>" name="menuId"/>	
				<input type="hidden" value="<c:out value="${idx}"/>" name="idx"/>	
					<table  class="t01"  style="width:100%;" align="center">
						<tr>  
							<th>아이디</th>
							<td>
							<input type="text" name="memid" id="memId"/>
							<!-- value="${map.memid}" -->
							<input type="hidden" name="pnum"   value="<c:out value="${pnum}"/>"/>
							<input type="hidden" name="bnum"   value="<c:out value="${bnum}"/>"/>
							<input type="hidden" name="rowcnt" value="<c:out value="${rowcnt}"/>"/> 
							</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="mempwd" id="memPwd"/></td>
							<!-- value="${map.mempwd}" -->
						</tr>
						<tr>
							<th>제목</th>
							<td><input type="text" name="title" id="Title"/></td>
						</tr>
						<tr>
							<th style="width:20%;">내용</th>
							<td><textarea name="cntx" cols=50 rows=10 id="Cntx"></textarea></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td id="fileUpload">
								<div class="fileBox">
									<input type="file" name="upFile"  id="orgFile"  size="50" class="upload-hidden"/>
									<input type="button" value="삭제하기" class="btnDel"/>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								 <button type="button" id="addFile">파일추가</button>
								 <input type="button" onclick="prePage()" class="btn btn-primary" value="이전으로"/>
								 <button type="button" onclick="fsubmit()"class="btn btn-success">확인</button>
							</td>
						</tr>
					</table>
				</form>						
			</div>
		</div>
			<div style="height: 10%;">
				<%@ include  file="../parts/bottom.jsp"%>				
			</div>
	</div>
		
</body>
</html>