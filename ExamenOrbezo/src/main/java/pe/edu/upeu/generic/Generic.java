package pe.edu.upeu.generic;

import java.util.List;

public interface Generic<T> {
	int agregar(T t);
	int editar (T t);
	int eliminar (int id);
	T listar (int id);
	List<T> listarT();
}
