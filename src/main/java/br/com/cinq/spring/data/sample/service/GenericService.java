package br.com.cinq.spring.data.sample.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericService<T, ID extends Serializable> {

    Optional<List<T>> list(Integer page, Integer size, T entity);

    Optional<T> create(T entity);

    Optional<T> findById(ID id);

    Optional<T> update(ID id, T entity);

    void deleteById(ID id);

}