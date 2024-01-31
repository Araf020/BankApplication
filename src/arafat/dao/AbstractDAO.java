package src.arafat.dao;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<T> implements IGenericDao<T>{

    // Data Source
    protected final List<T> storage = new ArrayList<>();

    public AbstractDAO() {}

   

    
}
