<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initialscale=1">
<title>Buscar Modalidade</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" datadismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir Modalidade</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir esta Modalidade?</div>
				<div class="modal-footer">
					<form action="ManterModalidade.do" method="post">
						<input type="hidden" name="id" id="id_excluir" />
						<button type="submit" class="btn btnprimary" name="acao"
							value="Excluir">Sim</button>
						<button type="button" class="btn btndefault" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<form action="listar_pais.do" method="post">
			<div id="top" class="row">
				<div class="col-md-3">
					<h2>Modalidade</h2>
				</div>
				<div class="col-md-6">
					<div class="input-group h2">
						<input name="data[search]" class="formcontrol" id="search"
							type="text"
							placeholder="Pesquisar Modalidade(deixe
                        vazio para trazer todos)">
						<span class="input-group-btn">
							<button class="btn btn-primary" type="submit" name="acao"
								value="buscar">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
				<div class="col-md-3">
					<a href="CriarPais.jsp" class="btn btnprimary
                   pull-right h2">Nova Modalidade</a>
				</div>
			</div>
			<!-- /#top -->
		</form>
		<hr />
		<c:if test="${not empty lista}">
			<div id="list" class="row">
				<div class="table-responsive col-md-12">
					<table class="table table-striped" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Ouro</th>
								<th>Prata</th>
								<th>Bronze</th>
								<th class="actions">Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="modalidade" items="${lista }">
								<tr>
									<td>${modalidade.nome }</td>
									<td>${modalidade.ouro }</td>
									<td>${modalidade.prata }</td>
									<td>${modalidade.bronze }</td>
									<td class="actions"><a class="btn btn-success
                                        btn-xs"
										href="ManterModalidade.do?acao=Visualizar&id=${modalidade.id}">Visualizar</a>
										<a class="btn btn-warning
                                        btn-xs"
										href="Mantermodalidade.do?acao=Editar&id=${modalidade.id }">Editar</a>
										<button id="btn${modalidade.id
                                        }%>" type="button"
											class="btn btn-danger btn-xs" data-toggle="modal"
											datatarget="#delete-modal" data-cliente="${modalidade.id }">Excluir</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!-- /#list -->
			<div id="bottom" class="row">
				<div class="col-md-12">
					<!-- paginação ainda não foi implementada -->
					<ul class="pagination">
						<li class="disabled"><a>&lt; Anterior</a></li>
						<li class="disabled"><a>1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li class="next"><a href="ListarModalidade.jsp" rel="next">Próximo &gt;</a></li>
					</ul>
					<!-- /.pagination -->
				</div>
			</div>
		</c:if>
		<!-- /#bottom -->
	</div>
	<!-- /#main -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$("#delete-modal").on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget);

			var recipient = button.data('pais');
			$("#nome_excluir").val(recipient);
		});
	</script>
</body>
</html>