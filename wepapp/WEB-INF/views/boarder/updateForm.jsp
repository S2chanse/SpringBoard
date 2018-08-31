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
function prePage(){
	location.href="/PDS/getView?idx=${PdsVo.idx }&menuId=${PdsVo.menuid}&pnum=${pnum}&bnum=${bnum}&rowcnt=${rowcnt}";
}
function checkPwd(){
	var pwd=document.getElementById("pwd");
	var pwdCheck=${PdsVo.mempwd};
	if(pwd.value==pwdCheck){
		var fmt=document.getElementById("formTag");
		fmt.submit();
	}else{
		alert("비밀번호가 맞지 않습니다.");
		pwd.value="";
		pwd.focus();
	}
}
window.onload=function(){
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
	$(".delFile").click(function(e){
		e.preventDefault();
		var idx=${PdsVo.idx};
		var menuId=${PdsVo.menuid};
		var fileNum=$(this).attr("href");
		var fileName=$(this).siblings("#fileName").val();
		$.ajax({
	        url : "PDS/DelOnlyFile",
	        type: "get",
	        data : { "idx" :idx
					,"menuId":menuId
					,"fileNum":fileNum
					,"fileName":fileName
	        },
	        success : function(responseData){
	            var data = JSON.parse(responseData);
	            if(data){
	            	$(this).parent("p").remove();      
	            }else{alert("111");}
	        }
	    });
	});
	$("#selRowCnt").change(function(){
		var link="/PDS/List?menuId=${menuId}&rowcnt="+$("#selRowCnt").val();
		location.href=link;
	});
}
</script>
<style>
	div{box-sizing: border-box; border: 1px solid black;}
</style>
</head>

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
					<form action="/PDS/Update" method="post" id="formTag" enctype="multipart/form-data">
						<input type="hidden" value="${PdsVo.menuid }" name="menuId"/>	
						<input type="hidden" value="${PdsVo.idx}" name="idx"/>	
						<table class="t01" style="width:100%;" align="center">
								<tr>
									<th>
										아이디	
										<input type="hidden" name="pnum"value="${pnum}"/>
										<input type="hidden" name="bnum"value="${bnum}"/>
										<input type="hidden" name="rowcnt"value="${rowcnt}"/>
										</th> 
									<td>
										<input type="text" name="memid" value="${PdsVo.memid }" readonly="readonly"/>
									</td>
								</tr>
								<tr>
									<th>비밀번호</th>
									<td><input type="password" name="mempwd" id="pwd"/></td>
								</tr>
								<tr>
									<th>제목</th>
									<td><input type="text" name="title" value="${PdsVo.title }"/></td>
								</tr>
								<tr>
									<th style="width:20%;">내용</th>
									<td><textarea name="cntx" cols=50 rows=10>
									${PdsVo.cntx }
									</textarea></td>
								</tr>
								<tr>
									<th colsapn="1">첨부파일</th>
									<td style="height: 50px;"  id="fileUpload">
										<div style="width: auto;height: 110px;
										overflow: auto;">
											<c:forEach var="fileVo" items="${FilesList }">				
												<p>
													${fileVo.fileName }
													<a  href="${fileVo.fileNum }"class="delFile">x</a>
													<input type="hidden" vale="${fileVo.sfileName }" id="fileName">
												</p>
											</c:forEach>
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										 <button type="button" id="addFile">파일추가</button>
										<input type="button" onclick="prePage()" value="이전으로"/>
										 <button type="button" onclick="checkPwd()"class="btn btn-success">확인</button>
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

	
		<tr>
							
								
</body>
</html>