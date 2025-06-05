package pe.edu.upeu.generic;

import java.util.List;

public interface Generic<T> {
	boolean agregar (T t);
	boolean editar (T t);
	boolean eliminar (int id);
	T listar (int id);
	List<T> listarT ();
}
