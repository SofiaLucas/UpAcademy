package io.altar.jseproject.business;

import java.util.Collection;
import io.altar.jseproject.model.Product;

public class ProductBusiness implements BusinessProductInterface {

	// public static final // shelf service

	@Override
	public void create(Product entity) {
		PDB.create(entity);
	}

	@Override
	public void remove(Product entity) {
		PDB.remove(entity);

	}

	@Override
	public void edit(Product entity) {
		PDB.edit(entity);

	}

	@Override
	public Collection<Product> getAll() {
		return PDB.getAll();

	}

	@Override
	public Product getbyId(long id) {
		return PDB.getbyId(id);

	}

	@Override
	public long[] getAllIds() {
		return PDB.getAllIds();
	}

	@Override
	public boolean isEmpty() {
		return PDB.isEmpty();

	}

	@Override
	public void size() {
		PDB.size();

	}

}
