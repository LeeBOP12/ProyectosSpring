$(document).ready(function () {
    listar();
});

// GUARDAR NUEVO POST
$("#save").click(function () {
    let titulo = $("#tituloNuevo").val(); // Captura el título del post
    let descripcion = $("#descripcionNuevo").val(); // Captura la descripción
    let idUsuario = $("#idUsuarioNuevo").val(); // Captura el ID del usuario

    $.post("post", { 
        "titulo": titulo,
        "descripcion": descripcion,
        "idusuario": idUsuario,
        "opc": 3 
    }, function () {
        listar(); // Refresca la tabla después de guardar
    });

    limpiear();
    cerrarNuevo();
});

// ACTUALIZAR POST EXISTENTE
$("#edit").click(function () {
    let id = $("#idEdit").val(); // ID del post a editar
    let titulo = $("#tituloEdit").val(); // Nuevo título
    let descripcion = $("#descripcionEdit").val(); // Nueva descripción
    let idUsuario = $("#idUsuarioEdit").val(); // ID del usuario

    $.post("post", { 
        "id": id,
        "titulo": titulo,
        "descripcion": descripcion,
        "idusuario": idUsuario,
        "opc": 4 
    }, function () {
        listar(); // Refresca la tabla después de actualizar
    });

    cerrarEdit();
});

// CARGAR DATOS PARA EDICIÓN
function editar(id) {
    $.get("post", { "id": id, "opc": 2 }, function (data) {
        var x = JSON.parse(data);
        $("#tituloEdit").val(x.titulo); // Carga el título
        $("#descripcionEdit").val(x.descripcion); // Carga la descripción
        $("#idUsuarioEdit").val(x.idusuario); // Carga el ID del usuario
        $("#idEdit").val(x.idpost); // Carga el ID del post (oculto)
    });
    mostrarEdit();
}

// LISTAR TODOS LOS POSTS
function listar() {
    $.get("post", { "opc": 1 }, function (data) {
        var x = JSON.parse(data);
        $("#tablita tbody tr").remove();
        x.forEach(function (item) {
            $("#tablita tbody").append(
                "<tr>" +
                    "<td>" + item.titulo + "</td>" + // Muestra el título
                    "<td>" + item.descripcion + "</td>" + // Muestra la descripción
                    "<td>" + item.idusuario + "</td>" + // Muestra el ID del usuario
                    "<td>" + // Columna de acciones
                        "<a href='#' onclick='editar(" + item.idpost + ")' class='btn btn-warning'><i class='far fa-edit'></i></a> " + // Botón para editar
                        "<a href='#' onclick='eliminar(" + item.idpost + ")' class='btn btn-danger'><i class='fas fa-trash-alt'></i></a>" + // Botón para eliminar
                    "</td>" +
                "</tr>"
            );
        });
    });
}

// ELIMINAR POST
function eliminar(id) {
    $.get("post", { "id": id, "opc": 5 }, function () {
        listar(); // Refresca la tabla después de eliminar
    });
}

// LIMPIAR CAMPOS DEL MODAL
function limpiear() {
    $("#tituloNuevo").val("");
    $("#descripcionNuevo").val("");
    $("#idUsuarioNuevo").val("");
}

// CERRAR MODAL DE CREACIÓN
function cerrarNuevo() {
    const modalInstance = bootstrap.Modal.getInstance(document.getElementById('cadModalNuevo'));
    if (modalInstance) {
        modalInstance.hide();
    }
}

// CERRAR MODAL DE EDICIÓN
function cerrarEdit() {
    const modalInstance = bootstrap.Modal.getInstance(document.getElementById('cadModalEdit'));
    if (modalInstance) {
        modalInstance.hide();
    }
}

// MOSTRAR MODAL DE EDICIÓN
function mostrarEdit() {
    const modal = new bootstrap.Modal(document.getElementById('cadModalEdit'));
    modal.show();
}