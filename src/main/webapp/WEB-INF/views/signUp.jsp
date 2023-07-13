<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>GAMSO 회원가입</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/css/main.css" type="text/css"/>
		<!-- bootstrap css-->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	</head>
	<body class="no-sidebar is-preload">
		<div id="page-wrapper">

			<!-- Header -->
				<section id="header">
					<a href="/index"><img src="${path}/images/mainLogo.png" style="width: 100px; height: 110px;"></a>
				</section>

			<!-- Main -->
				<section id="main">
					<div class="container">
						<!-- Content -->
						<article class="box post" >
								<h1 style="text-align: center;">회원가입</h1>
								<div class="input-group mb-3">
									<input type="text" id="userId" class="form-control" placeholder="아이디를 입력해주세요" aria-label="Recipient's username" aria-describedby="button-addon2" onmousedown="checkUserIdInput()">
									<button class="btn btn-outline-secondary" type="button" id="button-addon2" onfocus="duplicateCheck()">중복확인</button>
								</div>
								<p id="duplicateMessage"></p>
								<div class="input-group mb-3">
									<input type="text" id="email" class="form-control" placeholder="이메일을 입력해주세요" aria-label="Recipient's username" aria-describedby="button-addon2" onmousedown="checkEmailInput()">
									<button class="btn btn-outline-secondary" type="button" id="button-addon2" onfocus="emailCheck()">인증번호 발송</button>
								</div>
								<p id="emailCheckMessage"></p>

								<div class = "emailCheckNumberDiv" style="display:none;">
									<div class="input-group mb-3">
										<input type="text" id="emailCheckNumber" class="form-control" placeholder="인증번호를 입력해주세요" aria-label="Recipient's username" aria-describedby="button-addon2" onmousedown="checkEmailNumberInput()">
										<button class="btn btn-outline-secondary" type="button" id="button-addon2" onfocus="emailNumberCheck()">인증</button>
									</div>
								</div>
								<p id="emailCheckNumberMessage"></p>
									
								  <div style="text-align: center;">
									  <button type="button" class="btn btn-secondary completeBtn" style="width: 40%;">완료</button>
								  </div>
							</article>
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
			<script>
				let $userId = document.getElementById("userId");
				let $duplicateMessage = document.getElementById("duplicateMessage");
				let duplicateCheckCnt = -1;
				let $email = document.getElementById("email");
				let $emailCheckMessage = document.getElementById("emailCheckMessage");
				let $emailCheckNumber = document.getElementById("emailCheckNumber");
				let $emailCheckNumberMessage = document.getElementById("emailCheckNumberMessage");
				let emailCheckBool= false;
				let emailCheckNumber = "";

				function checkUserIdInput(){
					$duplicateMessage.innerText = "";
				}
				function checkEmailInput(){
					$emailCheckMessage.innerText = "";
				}
				function checkEmailNumberInput(){
					$emailCheckNumberMessage.innerText = "";
				}

				function duplicateCheck(){
					let trUserId = $userId.value.trim()
					if(trUserId !== ""){
						fetch(`/restUsers/\${trUserId}`, {method: "GET"})
							.then(res => res.json())
							.then(data => {
								duplicateCheckCnt = data.checkCnt;
								if(duplicateCheckCnt === 0){
									$duplicateMessage.innerText = "사용 가능한 아이디입니다."
									$duplicateMessage.style.color='green';
								}else{
									$duplicateMessage.innerText = "이미있는 아이디입니다."
									$duplicateMessage.style.color='red';
								}
								
							});
					}else{
						$duplicateMessage.innerText = "아이디를 입력해주세요"
						$duplicateMessage.style.color='red';
						$duplicateMessage.focus()
					}
				}

				function emailCheck(){
					let trEmail = $email.value.trim()
					if(trEmail !== ""){
						document.querySelector(".emailCheckNumberDiv").style.display = "initial"
						fetch('/email/sendEmail',{
							method: "POST",
							headers: {
								"Content-Type": "application/json",
							},
							body: JSON.stringify({
								email: `\${trEmail}`
							})
						}).then(res => res.json())
							.then(data => {
								emailCheckNumber = data.code;
							});
					}else{
						$emailCheckMessage.innerText = "이메일을 입력해주세요"
						$emailCheckMessage.style.color = "red"
						$emailCheckMessage.focus()
					}
				}

				function emailNumberCheck(){
					let trEmailCheckNum = $emailCheckNumber.value.trim()
					if(trEmailCheckNum !== ""){
						if(emailCheckNumber === trEmailCheckNum){
							emailCheckBool = true;
							$emailCheckNumberMessage.innerText = "인증번호되었습니다."
							$emailCheckNumberMessage.style.color = "green"
						}else{
							$emailCheckNumberMessage.innerText = "인증번호가 일치하지 않습니다."
							$emailCheckNumberMessage.style.color = "red"
							$emailCheckNumberMessage.focus()
						}
					}else{
						$emailCheckNumberMessage.innerText = "인증번호를 입력해주세요"
						$emailCheckNumberMessage.style.color = "red"
						$emailCheckNumberMessage.focus()
					}
				}

			</script>
	</body>
</html>