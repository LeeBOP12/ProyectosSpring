$(document).ready(function() {
	listar();
});

// LLENAR TODA LA TABLA DE LA VISTA
function listar() {
	$.get("usuario", { "opc": 1 }, function(data) {
		var x = JSON.parse(data);
		$("#tablita tbody tr").remove();
		x.forEach(function(item) {
			let claveOculta = item.clave.replace(/./g, 'X');
			$("#tablita tbody").append(
				"<tr>" +
				"<td>" + item.username + "</td>" +
				"<td>" + claveOculta + "</td>" +
				"<td><a href='#' onclick='editar(" + item.idusuario + ")' class='btn btn-warning'><i class='far fa-edit'></i></a></td>" +
				"<td><a href='#' onclick='eliminar(" + item.idusuario + ")' class='btn btn-danger'><i class='fas fa-trash-alt'></i></a></td>" +
				"</tr>"
			);
		});
	});
}
// GUARDAR NUEVO USUARIO
$("#save").click(function () {
    let username = $("#usNuevo").val();
    let clave = $("#claveNuevo").val();

    $.post("usuario", { 
        "nombre": username,
        "clave": clave,
        "opc": 3 
    }, function () {
        listar(); // Refresca la tabla después de guardar
    });

    limpiear();
    cerrarNuevo();
});

// ACTUALIZAR USUARIO
$("#edit").click(function () {
    let id = $("#idEdit").val();
    let username = $("#usEdit").val();
    let clave = $("#claveEdit").val();

    $.post("usuario", { 
        "id": id,
        "nombre": username,
        "clave": clave,
        "opc": 4 
    }, function () {
        listar(); // Refresca la tabla después de actualizar
    });

    cerrarEdit();
});

// CARGAR DATOS PARA EDICIÓN
function editar(id) {
    $.get("usuario", { "id": id, "opc": 2 }, function (data) {
        var x = JSON.parse(data); // Convierte la respuesta JSON a objeto JS
        $("#usEdit").val(x.username); // Carga el nombre de usuario
        $("#claveEdit").val(x.clave); // Carga la contraseña
        $("#idEdit").val(x.idusuario); // Carga el ID (oculto)
    });
    mostrarEdit(); // Muestra el modal de edición
}

// ELIMINAR USUARIO
function eliminar(id) {
    $.get("usuario", { "id": id, "opc": 5 }, function () {
        listar(); // Refresca la tabla después de eliminar
    });
}

// LIMPIAR CAMPOS DEL MODAL
function limpiear() {
    $("#usNuevo").val(""); // Limpia el campo de nombre de usuario
    $("#claveNuevo").val(""); // Limpia el campo de contraseña
}

//Cerrar Crear
function cerrarNuevo() {
    const modalInstance = bootstrap.Modal.getInstance(document.getElementById('cadModalNuevo'));
    if (modalInstance) {
        modalInstance.hide(); // Cierra el modal.
        modalInstance._element.focus(); // Elimina el foco del último elemento enfocado.
    }
}

// Cerrar modal de edición
function cerrarEdit() {
    const modalInstance = bootstrap.Modal.getInstance(document.getElementById('cadModalEdit'));
    if (modalInstance) {
        modalInstance.hide(); // Cierra el modal.
        modalInstance._element.focus(); // Elimina el foco del último elemento enfocado.
    }
}
// MOSTRAR MODAL DE EDICIÓN
function mostrarEdit() {
    const modal = new bootstrap.Modal(document.getElementById('cadModalEdit'));
    modal.show();
}