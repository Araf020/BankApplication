package src.arafat.dao;

import java.util.Map;

public interface IGenericDao<T> {
    
    T insert(Long id, T t);
    T update(Long id, T t);
    void delete(Long id);
    T get(Long id);
    Map<Long, T> getAll();
}
