<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<%@include file="base-head.jsp"%>
<title>CRUD Manager - Inserir CEO</title>
</head>
<body>
	<%@include file="nav-menu.jsp"%>

	<div id="container" class="container-fluid">
		<h3 class="page-header">${action eq "insert" ? "Adicionar" : "Editar"}
			CEO</h3>

		<form action="${pageContext.request.contextPath}/ceo/${action}"
			method="POST">

			<input type="hidden" name="ceo_id" value="${ceoToEdit.getId()}">

			<div class="row">
				<div class="form-group col-md-4">
					<label for="content">Nome</label> <input type="text"
						class="form-control" id="ceo_name" name="ceo_name"
						autofocus="autofocus" placeholder="Nome do CEO" required
						oninvalid="this.setCustomValidity('Por favor, informe o Nome do CEO.')"
						oninput="setCustomValidity('')" value="${ceoToEdit.getName()}">
				</div>

				<div class="form-group col-md-4">
					<label for="gender">Sexo</label> <select id="ceo_gender"
						class="form-control selectpicker" name="ceo_gender" required
						oninvalid="this.setCustomValidity('Por favor, informe o sexo')"
						oninput="setCustomValidity('')">
						<option value="" disabled ${notemptyceo ? "" : "selected"}>Selecione
							o sexo</option>
						<option value="F" ${ceoToEdit.getGender() == 'F' ? "selected" : ""}>Feminino</option>
						<option value="M" ${ceoToEdit.getGender() == 'M' ? "selected" : ""}>Masculino</option>
					</select>
				</div>

				<div class="form-group col-md-4">
					<label for="content">Email</label> <input type="email"
						class="form-control" id="ceo_email" name="ceo_email"
						autofocus="autofocus" placeholder="Email do CEO" required
						oninvalid="this.setCustomValidity('Por favor, informe o Email do CEO')"
						oninput="setCustomValidity('')" value="${ceoToEdit.getEmail()}">
				</div>

				<div class="form-group col-md-4">
					<label for="content">Telefone</label> <input type="text"
						class="form-control" id="ceo_fone" name="ceo_fone"
						autofocus="autofocus" placeholder="Telefone do CEO" required
						oninvalid="this.setCustomValidity('Por favor, informe o Telefone do CEO')"
						oninput="setCustomValidity('')" value="${ceoToEdit.getFone()}">
				</div>

				<div class="form-group col-md-6">
					<label for="seller_company">Empresa</label> <select
						id="ceo_company" class="form-control selectpicker"
						name="ceo_company" required
						oninvalid="this.setCustomValidity('Por favor, informe a Empresa.')"
						oninput="setCustomValidity('')">
						<option value=""disabled ${notemptyceoToEdit ? "" : "selected"}>Selecione
							uma empresa</option>
						<c:forEach var="company" items="${companies}">
							<option value="${company.getId()}"
								${ceoToEdit.getCompany().getId() eq company.getId() ? "selected" : ""}>
								${company.getName()}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<hr />

			<div id="actions" class="row pull-right">
				<div class="col-md-12">
					<a href="${pageContext.request.contextPath}/sellers"
						class="btn btn-default">Cancelar</a>
					<button type="submit" class="btn btn-primary">${action eq "insert" ? "Criar" : "Editar"}
						Vendedor</button>
				</div>
			</div>

		</form>
	</div>
</body>
</html>