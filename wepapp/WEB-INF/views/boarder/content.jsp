<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<table class="t01" style="width:100%;" align="center">
		<tr>
			<th colspan="4">상세내용</th>
		</tr>
			<th>글쓴이</th><td>${PdsVo.memid }</td>
			<th>등록일</th><td>${PdsVo.regdate}</td>
		</tr>
		<tr>
			<th colsapn="1">제목</th><td colspan="3">${PdsVo.title}</td>
		</tr>
		<tr>
			<th colsapn="1" style="height: 30%;">내용</th><td colspan="3">${PdsVo.cntx}</td>
		</tr>
		<tr>
			<th colsapn="1">첨부파일</th>
			<td colspan="3" style="height: 20%;">
				<div style="width: auto;height: 110px;
				overflow: auto;">
					<c:forEach var="fileVo" items="${FilesList }">				
						<p>
							<a href="/download/external/${fileVo.sfileName }">
							${fileVo.fileName }</a>
						</p>
					</c:forEach>
				</div>
			</td>
		</tr>
	<tr>
			<th colspan="4">
				&nabla;<a href="/PDS/List?menuId=${PdsVo.menuid }
				&pnum=${pnum}&bnum=${bnum}&rowcnt=${rowcnt}">이전으로</a>
				&nbsp;&nabla;
				<a href="/PDS/WriteForm?idx=${PdsVo.idx}&menuId=${PdsVo.menuid }
				&pnum=${pnum}&bnum=${bnum}&rowcnt=${rowcnt}">답글쓰기</a>
				&nbsp;&nabla;
				<a href="/PDS/WriteForm?menuId=${PdsVo.menuid }
				&pnum=${pnum}&bnum=${bnum}&rowcnt=${rowcnt}">새글쓰기</a>&nbsp;
				&nabla;<a href="/PDS/UpdateForm?idx=${PdsVo.idx}&menuId=${PdsVo.menuid }
				&pnum=${pnum}&bnum=${bnum}&rowcnt=${rowcnt}">수정하기</a>&nbsp;
				&nabla;<a href="/PDS/DeleteForm?idx=${PdsVo.idx}&menuId=${PdsVo.menuid }
				&pnum=${pnum}&bnum=${bnum}&rowcnt=${rowcnt}">삭제하기</a>&nbsp;
			</th>
		</tr>
	</table>