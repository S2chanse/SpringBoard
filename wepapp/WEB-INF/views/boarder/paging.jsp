<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta charset="UTF-8">
	<c:choose>
			<c:when test="${rowCntNum>bnum*10}">
				<c:if test="${bnum>1 }">
					<a href="/PDS/List?menuId=${menuId }&pnum=${1}&bnum=${1}&rowcnt=${rowcnt}">◀◀</a>
					<a href="/PDS/List?menuId=${menuId }&pnum=${(bnum-1)*10}&bnum=${bnum-1}&rowcnt=${rowcnt}">◀</a>
				</c:if>
					<c:forEach var="x" begin="${(bnum-1)*10+1 }" end="${bnum*10}" step="1">
						<a href="/PDS/List?menuId=${menuId }&pnum=${x}&bnum=${bnum}&rowcnt=${rowcnt}">[${x}]</a>
				    </c:forEach>
					 <a href="/PDS/List?menuId=${menuId }&pnum=${bnum*10+1}&bnum=${bnum+1}&rowcnt=${rowcnt}">▶</a>   
					 <fmt:formatNumber var="maxBnum" value="${(rowCntNum/10)+(1-((rowCntNum/10)%1))%1}" type="number" />
					 <a href="/PDS/List?menuId=${menuId }&pnum=${rowCntNum}&bnum=${maxBnum}&rowcnt=${rowcnt}">▶▶</a>
			</c:when>
			<c:otherwise>
				<c:if test="${bnum>1 }">
					<a href="/PDS/List?menuId=${menuId }&pnum=${1}&bnum=${1}&rowcnt=${rowcnt}">◀◀</a>
					<a href="/PDS/List?menuId=${menuId }&pnum=${(bnum-1)*10}&bnum=${bnum-1}&rowcnt=${rowcnt}">◀</a>
				</c:if>
		    	<c:forEach var="x" begin="${(bnum-1)*10+1 }" end="${rowCntNum}" step="1">
					<a href="/PDS/List?menuId=${menuId }&pnum=${x}&bnum=${bnum}&rowcnt=${rowcnt}">[${x}]</a>
		    	</c:forEach>    	  		    	   
			</c:otherwise>
		</c:choose>