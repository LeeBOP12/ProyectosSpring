<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AUTORES</title>
<%@include file="jspf/head.jspf"%>
</head>
<div class="container">
	<%@include file="jspf/header.jspf"%>
</div>
<!-- Tabla de Posts -->
<div class="container mt-5 d-flex justify-content-center">
	<div class="card w-75">
		<div class="card-body d-flex justify-content-between">
			<h3 class="card-title">AUTORES</h3>
			<button type="button" class="btn btn-success" data-bs-toggle="modal"
				data-bs-target="#cadModalNuevo" data-bs-whatever="@mdo">
				<i class="fa-regular fa-plus"></i>
			</button>
		</div>
		<div class="card-body">
			<table class="table" id="tablita">
				<thead>
					<tr>
						<th scope="col">Nombres</th>
						<th scope="col">Apellidos</th>
						<th scope="col">Pais</th>
						<th scope="col">Estado</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</div>

<!-- Modal Agregar Autor -->
<div class="modal fade" id="cadModalNuevo" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel">Nuevo
					Autor</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form>
					<div class="mb-3">
						<label for="tituloNuevo" class="col-form-label">Nombres:</label> <input
							type="text" class="form-control" id="nombresNuevo">
					</div>
					<div class="mb-3">
						<label for="descripcionNuevo" class="col-form-label">Apellidos:</label>
						<input type="text" class="form-control" id="apellidosNuevo">
					</div>
					<div class="mb-3">
						<label for="idUsuarioNuevo" class="col-form-label">Pais:</label>
						<input type="text" class="form-control" id="paisNuevo">
					</div>
					<div class="mb-3">
						<label for="idUsuarioNuevo" class="col-form-label">Estado:</label>
						<input type="text" class="form-control" id="estadoNuevo">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Cerrar</button>
				<button type="button" class="btn btn-primary" id="save">Guardar</button>
			</div>
		</div>
	</div>
</div>

<!-- Modal Editar Autor -->
<div class="modal fade" id="cadModalEdit" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h1 class="modal-title fs-5" id="exampleModalLabel">Editar
					Autor</h1>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form>
					<input type="hidden" id="idEdit">
					<div class="mb-3">
						<label for="tituloEdit" class="col-form-label">Nombres:</label> <input
							type="text" class="form-control" id="nombresEdit">
					</div>
					<div class="mb-3">
						<label for="descripcionNuevo" class="col-form-label">Apellidos:</label>
						<input type="text" class="form-control" id="apellidosEdit">
					</div>
					<div class="mb-3">  
						<label for="idUsuarioNuevo" class="col-form-label">Pais:</label>
						<input type="text" class="form-control" id="paisEdit">
					</div>
					<div class="mb-3">  
						<label for="idUsuarioNuevo" class="col-form-label">Estado:</label>
						<input type="text" class="form-control" id="estadoEdit">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Cerrar</button>
				<button type="button" class="btn btn-primary" id="edit">Actualizar</button>
			</div>
		</div>
	</div>
</div>

<!-- Incluir footer y script -->
<%@include file="jspf/footer.jspf"%>
<script type="text/javascript" src="js/autor.js"></script>
<body>
</body>
</html>