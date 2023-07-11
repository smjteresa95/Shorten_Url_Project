<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>당신의 url을 단축해보세요</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/css/main.css" type="text/css"/>
	</head>
	<body class="right-sidebar is-preload">
		<%@ include file="signMenu.jsp"%>
		<div id="page-wrapper">
			<!-- Header -->
				<section id="header">
					<!-- Logo -->
					<a href="/index"><img src="${path}/images/mainLogo.png" style="width: 100px; height: 110px;"></a>
					<!-- <h1><a href="index.jsp">GAMSO</a></h1> -->

					<!-- Nav -->
						<nav class="nav">
							<ul>
								<li><a href="/index">Home</a></li>
								<li class="current"><a href="/url/main">GoShorten</a></li>
							</ul>
						</nav>
				</section>

			<!-- Main -->
				<section id="main">
					<div class="container">
						<div class="row">
							<div class="col-10 col-12-medium">

								<!-- Content -->
									<article class="box post">
										<a href="#" class="image featured"><img src="${path}/images/pic01.jpg" alt="" /></a>
										<header>
											<h2>단축하는 기능자리</h2>
											<p>Lorem ipsum dolor sit amet feugiat</p>
										</header>
									</article>

							</div>
							<div class="col-2 col-12-medium">

								<!-- Sidebar -->
									<section class="box" style="height: 100%;">
										<a href="#" class="image featured"><h1>여기에 광고하세요</h1></a>
									</section>
							</div>
						</div>
					</div>
				</section>

			<!-- Footer -->
				<section id="footer">
					<%@ include file="footer.jsp"%>
				</section>

		</div>

		<!-- Scripts -->
			<script src="${path}/js/jquery.min.js"></script>
			<script src="${path}/js/jquery.dropotron.min.js"></script>
			<script src="${path}/js/browser.min.js"></script>
			<script src="${path}/js/breakpoints.min.js"></script>
			<script src="${path}/js/util.js"></script>
			<script src="${path}/js/main.js"></script>

	</body>
</html>