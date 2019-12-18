package io.altar.jseproject.repositories;

import java.util.Collection;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.Map;

import io.altar.jseproject.model.Entity;
//import io.altar.jseproject.model.Product;

public abstract class EntityRepository<T extends Entity> {

	Map<Long, T> myMap = new HashMap<Long, T>();
	long currentId = 0;

	private long getNextId() {
		return ++currentId;
	}

	public long create(T entity) {
		long nextId = getNextId();
		entity.setId(nextId);
		myMap.put(entity.getId(), entity);
		return nextId;
	}

	public void remove(T entity) {
		myMap.remove(entity.getId(), entity);
	}

	public boolean isEmpty() {
		return (myMap.size() == 0) ? true : false;
	}

	public Collection<T> getAll() {
		return myMap.values();
	}

	public T getbyId(Long selectedId) {
		return myMap.get(selectedId);
	}

	public Collection<Long> getAllIds() {
		return myMap.keySet();
	}

	public void edit(T entity) {
		myMap.replace(entity.getId(), entity);

	}
	
	
	public long size() {
		return myMap.size();
	}

//	public void printAll() {
//		Iterator<T> TIterator = getAll().iterator();
//
//		while (TIterator.hasNext()) {
//			T t = (T) TIterator.next();
//			System.out.println(t);
//		}
//
//	}

}
