<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
	<!-- 자료실영역 -->
	<table class="t01" align="center">
		<tr>
			<th colspan="5">
				&nabla;<a href="/PDS/WriteForm?menuId=${menuId }">새글쓰기</a>&nbsp;
				&nabla;<a href="/">이전으로</a>
			</th>
		</tr>
		<tr>
			<td colspan="6" align="left">
				<select id="selRowCnt">
					<option value="">게시물 갯수</option>
					<option value="2">테스트</option>
					<option value="5">5개씩 보기</option>
					<option value="10">10개씩 보기</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>파일명</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="PdsVo" items="${pdsList }">
			<tr>
				<c:choose>
					<c:when test="${PdsVo.del_yn=='N' }">
						<c:if test="${PdsVo.lvl>0 }">
						<td></td>
						<td style="padding-left: ${PdsVo.lvl*30}px;">
							<font color="red">ㄴRe:</font>
							 <a href="/PDS/getView?idx=${PdsVo.idx}&menuId=${PdsVo.menuid}&bnum=${bnum}&pnum=${pnum}&rowcnt=${rowcnt}">
									${PdsVo.title }
							 </a>
						</td>
						</c:if>
						<c:if test="${PdsVo.lvl==0 }">
						<td>${PdsVo.fnum }</td>
						<td>
							<a href="/PDS/getView?idx=${PdsVo.idx }&menuId=${PdsVo.menuid}
							&pnum=${pnum}&bnum=${bnum}&rowcnt=${rowcnt}">
								${PdsVo.title }
						    </a>
						</td>
						</c:if>
						<td>${PdsVo.memid }</td>
						<td>${PdsVo.fileName }</td>
						<td>${PdsVo.regdate }</td>
					</c:when>
					<c:otherwise>
						<td colspan="5">삭제된글입니다.</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<%@ include file="paging.jsp" %>
			</td>
		</tr>
	</table>
