<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Posts</title>
<%@include file="jspf/head.jspf"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css ">
</head>
<body>
    <div class="container">
        <%@include file="jspf/header.jspf"%>
    </div>

    <!-- Tabla de Posts -->
    <div class="container mt-5 d-flex justify-content-center">
        <div class="card w-75">
            <div class="card-body d-flex justify-content-between">
                <h3 class="card-title">POSTS</h3>
                <button type="button" class="btn btn-success" data-bs-toggle="modal"
                    data-bs-target="#cadModalNuevo" data-bs-whatever="@mdo">
                    <i class="fa-regular fa-plus"></i>
                </button>
            </div>
            <div class="card-body">
                <table class="table" id="tablita">
                    <thead>
                        <tr>
                            <th scope="col">Título</th>
                            <th scope="col">Descripción</th>
                            <th scope="col">Usuario (ID)</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Modal Agregar Post -->
    <div class="modal fade" id="cadModalNuevo" tabindex="-1"
        aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Nuevo Post</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="mb-3">
                            <label for="tituloNuevo" class="col-form-label">Título:</label>
                            <input type="text" class="form-control" id="tituloNuevo">
                        </div>
                        <div class="mb-3">
                            <label for="descripcionNuevo" class="col-form-label">Descripción:</label>
                            <textarea class="form-control" id="descripcionNuevo"></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="idUsuarioNuevo" class="col-form-label">Usuario (ID):</label>
                            <input type="number" class="form-control" id="idUsuarioNuevo">
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

    <!-- Modal Editar Post -->
    <div class="modal fade" id="cadModalEdit" tabindex="-1"
        aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Editar Post</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <input type="hidden" id="idEdit"> <!-- ID del post -->
                        <div class="mb-3">
                            <label for="tituloEdit" class="col-form-label">Título:</label>
                            <input type="text" class="form-control" id="tituloEdit">
                        </div>
                        <div class="mb-3">
                            <label for="descripcionEdit" class="col-form-label">Descripción:</label>
                            <textarea class="form-control" id="descripcionEdit"></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="idUsuarioEdit" class="col-form-label">Usuario (ID):</label>
                            <input type="number" class="form-control" id="idUsuarioEdit">
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
    <script type="text/javascript" src="js/post.js"></script>
</body>
</html>