<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<form action="/LogIn/LogIn" method="post">
			<label for="userId">아이디</label>
			<input type="text" name="userId" id="userId" placeholder="아이디"	/>
			<label for="userPwd">비밀번호</label>
			<input type="password" name="userPwd" id="userPwd" placeholder="비밀번호"	/>
			<input type="submit" value="로그인"	/>
</form>