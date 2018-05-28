<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title> Alterar Modalidade</title>

            <link href="css/bootstrap.min.css" rel="stylesheet">
            <link href="css/style.css" rel="stylesheet">
        </head>

        <body>
                
				<c:import url="Menu.jsp"/>
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Alterar Modalidade ${modalidade.id }</h3>
                    
                    <form action="controller.do" method="post">
                        <!-- area de campos do form -->
                        <input type="hidden" name="id" value="${modalidade.id }" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label for="nome">Nome</label>
                                <input type="text" class="form-control" name="nome" id="nome" maxlength="50" placeholder="nome" value="${modalidade.nome }">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-4">
                                <label for="ouro">Ouro</label>
                                <input type="ouro" class="form-control" name="ouro" id="ouro" maxlength="50" placeholder="obrigatório" value="${modalidade.ouro }">
                            </div>
                             <div class="form-group col-md-4">
                                <label for="prata">Prata</label>
                                <input type="prata" class="form-control" name="prata" id="prata" maxlength="50" placeholder="obrigatório" value="${modalidade.prata }">
                            </div>

                            <div class="form-group col-md-4">
                                <label for="bronze">bronze</label>
                                <input type="bronze" class="form-control" name="bronze" id="bronze"  maxlength="50" placeholder="obrigatório" value="${modalidade.bronze }">
                            </div>
                        </div>
                        <hr />
                        <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary" name="command" value="AlterarCliente">Salvar</button>
                                <a href="ListarModalidade.jsp" class="btn btn-default">Cancelar</a>
                            </div>
                        </div>
                    </form>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>