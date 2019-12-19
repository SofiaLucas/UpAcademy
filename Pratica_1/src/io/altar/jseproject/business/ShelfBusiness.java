package io.altar.jseproject.business;

import java.util.Collection;

//import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Shelf;

public class ShelfBusiness implements BusinessShelfInterface {

	@Override
	public void create(Shelf entity) {
		SDB.create(entity);
	}

	@Override
	public void remove(Shelf entity) {
		SDB.remove(entity);
	}

	@Override
	public void edit(Shelf entity) {
		SDB.edit(entity);

	}

	@Override
	public Collection<Shelf> getAll() {
		return SDB.getAll();

	}

	@Override
	public Shelf getbyId(long id) {
		return SDB.getbyId(id);
		
	}

	@Override
	public long[] getAllIds() {
		return SDB.getAllIds();
	
	}

	@Override
	public boolean isEmpty() {
		return SDB.isEmpty();

	}

	@Override
	public void size() {
		SDB.size();

	}

}
