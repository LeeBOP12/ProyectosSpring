$(document).ready(function() {
	listar();
});
function listar() {
	$.get("autores", { "opc": 1 }, function(data) {
		var x = JSON.parse(data);
		$("#tablita tbody tr").remove();
		x.forEach(function(item) {
			$("#tablita tbody").append(
				"<tr>" +
				"<td>" + item.nombres + "</td>" +
			    "<td>" + item.apellidos + "</td>" +
				"<td>" + item.pais + "</td>" +
				"<td>" + item.estado + "</td>" +
				"<td><a href='#' onclick='editar(" + item.idautores + ")' class='btn btn-warning'><i class='far fa-edit'></i></a></td>" +
				"<td><a href='#' onclick='eliminar(" + item.idautores + ")' class='btn btn-danger'><i class='fas fa-trash-alt'></i></a></td>" +
				"</tr>"
			);
		});
	});
}

$("#save").click(function () {
    let nombres = $("#nombresNuevo").val();
    let apellidos = $("#apellidosNuevo").val();
	let pais = $("#paisNuevo").val();
	let estado = $("#estadoNuevo").val();

    $.post("autores", { 
        "nombres": nombres,
        "apellidos": apellidos,
		"pais": pais,
		"estado": estado,
        "opc": 3 
    }, function () {
        listar(); 
    });

    limpiear();
    cerrarNuevo();
});

function limpiear() {
    $("#nombresNuevo").val("");
    $("#apellidosNuevo").val(""); 
	$("#paisNuevo").val("");
	$("#estadoNuevo").val("");
}

function cerrarNuevo() {
    const modalInstance = bootstrap.Modal.getInstance(document.getElementById('cadModalNuevo'));
    if (modalInstance) {
        modalInstance.hide(); 
        modalInstance._element.focus(); 
    }
}

function eliminar(id) {
    $.get("autores", { "id": id, "opc": 5 }, function () {
        listar(); 
    });
}


// ACTUALIZAR USUARIO
$("#edit").click(function () {
    let id = $("#idEdit").val();
    let nombres = $("#nombresNuevo").val();
    let apellidos = $("#apellidosNuevo").val();
	let pais = $("#paisNuevo").val();
	let estado = $("#estadoNuevo").val();

    $.post("autores", { 
        "id": id,
        "nombres": nombres,
        "apellidos": apellidos,
		"pais": pais,
		"estado": estado,
        "opc": 4 
    }, function () {
        listar(); // Refresca la tabla después de actualizar
    });

    cerrarEdit();
});

// CARGAR DATOS PARA EDICIÓN
function editar(id) {
    $.get("autores", { "id": id, "opc": 2 }, function (data) {
        var x = JSON.parse(data); 
        $("#nombresEdit").val(x.nombres); 
        $("#apellidosEdit").val(x.apellidos); 
        $("#paisEdit").val(x.pais); 
		$("#estadoEdit").val(x.estado);
		$("#idEdit").val(x.idautores.toUppercase);
    });
    mostrarEdit(); // Muestra el modal de edición
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
