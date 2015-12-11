<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>Votação</title>
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
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon.png">
	<body style="background-color: #3d3d3d">
		<div class="subscribe-container">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 whos-behind">
						<h3>Qual é o melhor?</h3>
						<p>Clique na imagem para votar</p>
					</div>
				</div>
				<form action="votar" method="post">
					<input type="hidden" name="restauranteSelecionadoId" id="restauranteSelecionadoId"/>
					<div class="row">
						<div class="col-sm-6 whos-behind-box-1">
							<div class="whos-behind-photo restaurante" data-restaurante-id="${opcaoVotacaoSelecionada.opcao1.id}" style="height: auto;">
								<img src="${pageContext.request.contextPath}/assets/images/${opcaoVotacaoSelecionada.opcao1.imagem}" alt="" style="-webkit-border-radius: initial;">
								<div class="features-box-1-icon"></div>
								<p>${opcaoVotacaoSelecionada.opcao1.nome}</p>
							</div>
						</div>
						<div class="col-sm-6 whos-behind-box-1">
							<div class="whos-behind-photo restaurante" data-restaurante-id="${opcaoVotacaoSelecionada.opcao2.id}" style="height: auto;">
								<img src="${pageContext.request.contextPath}/assets/images/${opcaoVotacaoSelecionada.opcao2.imagem}" alt="" style="-webkit-border-radius: initial;">
								<div class="features-box-1-icon"></div>
								<p>${opcaoVotacaoSelecionada.opcao2.nome}</p>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<footer>
			<div class="container"></div>
		</footer>
		<script src="${pageContext.request.contextPath}/assets/javascript/jquery-1.11.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/javascript/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/javascript/jquery.backstretch.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/javascript/retina-1.1.0.min.js"></script>
		<script>
			$(document).ready(function(){
				$('.restaurante').click(function(){
					var $this = $(this);
					var restauranteId = $this.attr('data-restaurante-id');
					$('#restauranteSelecionadoId').val(restauranteId);
					$('form').submit();
				});
			});
		</script>
	</body>
</html>
