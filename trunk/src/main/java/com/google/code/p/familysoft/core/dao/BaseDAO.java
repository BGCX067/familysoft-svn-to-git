package com.google.code.p.familysoft.core.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO <T, ID extends Serializable>{
    public T findById(ID id, boolean lock);

    public List<T> findAll();

    public List<T> findByExample(T exampleInstance, String... excludeProperty);

    T makePersistent(T entity);

    public void makeTransient(T entity);
    
}
