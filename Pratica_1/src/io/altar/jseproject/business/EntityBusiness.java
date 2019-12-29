package io.altar.jseproject.business;

import java.util.Collection;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.repositories.EntityRepository;

public class EntityBusiness<R extends EntityRepository<E>, E extends Entity> implements BusinessServiceInterface<E> {

	protected R repository;

	@Override
	public void create(E entity) {
		repository.create(entity);

	}

	@Override
	public void remove(E entity) {
		repository.remove(entity);

	}

	@Override
	public void edit(E entity) {
		repository.edit(entity);

	}

	@Override
	public Collection<E> getAll() {
		return repository.getAll();

	}

	@Override
	public E getbyId(long id) {
		return repository.getbyId(id);
	}

	@Override
	public long[] getAllIds() {
		return repository.getAllIds();
	}

	@Override
	public boolean isEmpty() {
		return repository.isEmpty();
	}

	@Override
	public void size() {
		repository.size();

	}

}
