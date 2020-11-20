package com.ITHS.Webshop.controllers;

import java.util.List;

public interface  BaseController<T> {

    public List<T> list();
    public T get(int id);
    public T create(final T obj);
    public T update(int id, T obj);


}
