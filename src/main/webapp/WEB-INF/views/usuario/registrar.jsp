<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>Registrar</title>
	</head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fonts/OleoScript">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/fonts/OpenSans">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheet/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheet/font-awesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheet/form-elements.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheet/buttons.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheet/ultm.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheet/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/stylesheet/media-queries.css">
	<body style="background-color: #3d3d3d">
		<div class="subscribe-container">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 subscribe">
						<h3>Cadastro</h3>
						<p>Faça seu cadastro preenchendo os campos abaixo</p>
						<form class="form-inline" role="form" action="salvar" method="post">
							<div class="row">
								<div class="form-group">
									<input type="email" name="email" placeholder="Email" class="subscribe-email" id="subscribe-email" required> 
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<input type="text" name="nome" placeholder="Nome" class="subscribe-email" id="subscribe-name" required>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<button type="submit" class="btn">Enviar</button>
								</div>
							</div>
						</form>
						<div class="success-message" style="display: none;"></div>
						<div class="error-message" style="display: none;"></div>
					</div>
				</div>
			</div>
		</div>
		<footer>
			<div class="container"></div>
		</footer>
		<script src="${pageContext.request.contextPath}/assets/javascript/jquery-1.11.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/javascript/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/javascript/jquery.backstretch.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/javascript/retina-1.1.0.min.js"></script>
	</body>
</html>
