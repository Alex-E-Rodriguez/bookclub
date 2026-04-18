/*
    Walls, C. (2022). Spring in Action (6th ed.).
    Manning Publications Co.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2026
*/

package com.bookclub.service;

import java.util.List;

public interface GenericCrudDao<E, K>
{
    void add(E Entity);
    void update(E Entity);
    boolean remove(E Entity);
    List<E> list(); // Return a list of objects of type E
    E find(K key); // Return an object of type E by type K value.
}


