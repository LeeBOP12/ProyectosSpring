<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuarios</title>
<%@include file="jspf/head.jspf"%>
</head>
<body>
    <div class="container">
        <%@include file="jspf/header.jspf"%>
    </div>
    <!-- Tabla de usuarios -->
    <div class="container mt-5 d-flex justify-content-center">
        <div class="card w-25">
            <div class="card-body d-flex justify-content-between">
                <h3 class="card-title">USUARIOS</h3>
                <button type="button" class="btn btn-success" data-bs-toggle="modal"
                    data-bs-target="#cadModalNuevo" data-bs-whatever="@mdo">
                    <i class="fa-regular fa-plus"></i>
                </button>
            </div>
            <div class="card-body">
                <table class="table" id="tablita">
                    <thead>
                        <tr>
                            <th scope="col">Usuario</th>
                            <th scope="col">Contraseña</th>
                            <th scope="col" colspan="2">Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- Modal Agregar Usuario -->
    <div class="modal fade" id="cadModalNuevo" tabindex="-1"
        aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Nuevo
                        Usuario</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="mb-3">
                            <label for="usNuevo" class="col-form-label">Nombre de usuario:</label>
                            <input type="text" class="form-control" id="usNuevo">
                        </div>
                        <div class="mb-3">
                            <label for="claveNuevo" class="col-form-label">Contraseña:</label>
                            <input type="password" class="form-control" id="claveNuevo">
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
    <!-- Modal Editar Usuario -->
    <div class="modal fade" id="cadModalEdit" tabindex="-1"
        aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Editar
                        Usuario</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="mb-3">
                            <label for="usEdit" class="col-form-label">Nombre de usuario:</label>
                            <input type="text" class="form-control" id="usEdit">
                        </div>
                        <div class="mb-3">
                            <label for="claveEdit" class="col-form-label">Contraseña:</label>
                            <input type="password" class="form-control" id="claveEdit">
                        </div>
                        <input type="hidden" id="idEdit">
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
    <%@include file="jspf/footer.jspf"%>
    <script type="text/javascript" src="js/usuario.js"></script>
</body>
</html>