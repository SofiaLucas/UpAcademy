package io.altar.jseproject.business;

import java.util.Collection;

import io.altar.jseproject.model.Entity;

public interface BusinessServiceInterface<T extends Entity> {

	void create(T entity);

	void remove(T entity); //

	void edit(T entity); //

	Collection<T> getAll();
	
	T getbyId(long id);

	 long [] getAllIds();
	
	boolean isEmpty();
	
	void size();
	
}
