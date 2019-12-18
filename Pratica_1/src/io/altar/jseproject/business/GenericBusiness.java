package io.altar.jseproject.business;

import java.util.Collection;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public abstract class GenericBusiness<T extends Entity> implements BusinessServiceInterface<T> {

	ProductRepository productsDataBase = ProductRepository.getInstance();
	ShelfRepository shelvesDataBase = ShelfRepository.getInstance();

	@Override
	public void create(Entity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Entity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(Entity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getbyId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Long> getAllIds() {
		// TODO Auto-generated method stub
		return null;
	}

	public void isEmpty() {
		// TODO Auto-generated method stub

	}

	@Override
	public void size() {
		// TODO Auto-generated method stub

	}

}
