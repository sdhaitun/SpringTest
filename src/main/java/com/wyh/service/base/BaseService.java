package com.wyh.service.base;

import com.sun.tools.javac.util.List;

import java.io.Serializable;

/**
 * Created by root on 2016/12/27.
 */
public interface BaseService<T, ID extends Serializable> {
    public int save(T obj);

    public int delete(T obj);

    public int update(T obj);

    public T selectById(ID id);

    public List<T> selectAll();

    public int deleteById(ID id);

}
