<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang='ko'>
    <head>
        <meta charset='UTF-8'>
    </head>
    <body>
        <div style="width: 100%; height: 100px;">
			<div style="float: right;" class="signMenu">
				<a class="signUp" href="/users/signUp/ToS">sign up</a>
				<a class="signIn" href="#">sign in</a>
				<nav  class="nav" style="margin-top: 10px;">
					<ul>
						<li class="opener">
							<a href="#" class ="signInId">id</a>
							<ul>
								<li><a href="#">내 정보</a></li>
								<li><a href="#">아이디/비밀번호 변경</a></li>
								<li><a href="#">설정</a></li>
								<li><a href="#">로그아웃</a></li>
							</ul>
						</li>
					</ul>
				</nav>
			</div>
		</div>
    </body>
</html>
