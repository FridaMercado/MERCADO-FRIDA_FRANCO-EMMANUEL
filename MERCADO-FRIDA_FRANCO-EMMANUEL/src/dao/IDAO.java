package dao;

import java.util.List;

public interface IDAO<T> {
    T guardar(T t);
    List<T> listarTodo();

}
