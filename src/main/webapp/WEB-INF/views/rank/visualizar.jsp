<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>Visualizar RANK</title>
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
					<div class="col-sm-12 whos-behind">
						<h3>Ranking Atual dos Restaurantes</h3>
					</div>
				</div>
				<c:if test="${ errorMessage == null }">
					<div class="row">
						<div class="col-sm-12 whos-behind">
							<p>Votos do usuário ${rankByUsuario.usuario.nome}</p>
						</div>
					</div>
					<c:forEach items="${ rankByUsuario.listaRank }" var="rank">
						<div class="col-sm-3 whos-behind-box-1">
							<div class="whos-behind-photo">
								<h5>${rank.quantidadeVotos} Voto(s)</h5>
								<img src="${pageContext.request.contextPath}/assets/images/${rank.restaurante.imagem}" alt="" style="-webkit-border-radius: initial;">
								<div class="features-box-1-icon"></div>
								<p>${rank.restaurante.nome}</p>
							</div>
						</div>
					</c:forEach>
					<div class="row">
						<div class="col-sm-12 whos-behind">
							<p>RANK GLOBAL</p>
						</div>
					</div>
					<c:forEach items="${ rankGlobal }" var="rank">
						<div class="col-sm-3 whos-behind-box-1">
							<div class="whos-behind-photo">
								<h5>${rank.quantidadeVotos} Voto(s)</h5>
								<img src="${pageContext.request.contextPath}/assets/images/${rank.restaurante.imagem}" alt="" style="-webkit-border-radius: initial;">
								<div class="features-box-1-icon"></div>
								<p>${rank.restaurante.nome}</p>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<div class="col-sm-12 col-md-12 col-lg-12">
					<p>${ errorMessage } </p>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-12">
					<div class="top-button">
		            	<a class="button-1" href="${pageContext.request.contextPath}/votacao/restaurante" style="background: #6d9bb5;">
		            		Votar Novamente
		            	</a>
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
