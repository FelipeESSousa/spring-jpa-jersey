package br.com.cinq.spring.data.sample.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<T, ID extends Serializable> {

	T save(T entity);
	
	T merge(T entity);

	List<T> save(Iterable<T> entities);

	T findOne(ID id);

	T findReference(ID id);

	List<T> findAll();

	List<T> findAll(Integer page, Integer size, T param);

	void delete(ID id);
	
    Long count();

}
