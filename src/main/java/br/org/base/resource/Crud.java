package br.org.base.resource;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 10/31/13
 * Time: 2:59 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Crud<T> {



    public T create(T object);

    public T read(String id);

    public List readAll();

    public void update();

    public void delete(String id);


}
