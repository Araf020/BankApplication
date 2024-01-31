package src.arafat.dao;

import java.util.List;

public interface IGenericDao<T> {
    
    T add( T t);
    T delete(Long id, T t);
    T getById(String id, T t);
    void delete(Long id);
    boolean delete(String id);
   
    List<T> getAll();
}
