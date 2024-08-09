<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<%@include file="base-head.jsp"%>
<title>CRUD Manager - Inserir Departamentos</title>
</head>
<body>
	<%@include file="nav-menu.jsp"%>

	<div id="container" class="container-fluid">
		<h3 class="page-header">${action eq "insert" ? "Adicionar" : "Editar"}
			Departamento</h3>

		<form action="${pageContext.request.contextPath}/departaments/${action}"
			method="POST">

			<input type="hidden" name="departaments_id" value="${departamentsToEdit.getId()}">

			<div class="row">
				<div class="form-group col-md-4">
					<label for="name">Nome</label> <input type="text"
						class="form-control" id="departament_name" name="departament_name"
						autofocus="autofocus" placeholder="Nome do Departamento" required
						oninvalid="this.setCustomValidity('Por favor, informe o Nome do Departamento.')"
						oninput="setCustomValidity('')" value="${departamentsToEdit.getName()}">
				</div>
				
				<div class="form-group col-md-4">
					<label for="description">Descrição</label> <input type="text"
						class="form-control" id="departament_description" name="departament_description"
						autofocus="autofocus" placeholder="Descrição do Departamento" required
						oninvalid="this.setCustomValidity('Por favor, informe a descrição.')"
						oninput="setCustomValidity('')" value="${departamentsToEdit.getDescription()}">
				</div>

				<div class="form-group col-md-4">
					<label for="employeeCount">Quantidade de Empregados</label> <input type="text"
						class="form-control" id="departament_employeeCount" name="departament_employeeCount"
						autofocus="autofocus" placeholder="Quantidade de Empregados" required
						oninvalid="this.setCustomValidity('Por favor, informe a quantidade de Empregados')"
						oninput="setCustomValidity('')" value="${departamentsToEdit.getEmployeeCount()}">
				</div>

				<div class="form-group col-md-4">
					<label for="departament_phone">Telefone</label> <input type="text"
						class="form-control" id="departament_phone" name="departament_phone"
						autofocus="autofocus" placeholder="Ramal do Departamento" required
						oninvalid="this.setCustomValidity('Por favor, informe o Ramal do Departamento')"
						oninput="setCustomValidity('')" value="${departamentsToEdit.getPhone()}">
				</div>

				<div class="form-group col-md-6">
					<label for="departament_department_head">Chefe de Departamento</label> <select
						id="departament_department_head" class="form-control selectpicker"
						name="departament_department_head" required
						oninvalid="this.setCustomValidity('Por favor, informe o chefe de Departamento.')"
						oninput="setCustomValidity('')">
						<option value=""disabled ${notemptydepartamentsToEdit ? "" : "selected"}>Selecione
							um Chefe de Departamento</option>
						<c:forEach var="user" items="${users}">
							<option value="${user.getId()}"
								${departamentsToEdit.getDepartmentHead().getId() eq user.getId() ? "selected" : ""}>
								${user.getName()}</option>
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
						Departamento</button>
				</div>
			</div>

		</form>
	</div>
</body>
</html>