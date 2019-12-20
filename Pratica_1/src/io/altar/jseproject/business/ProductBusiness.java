package io.altar.jseproject.business;

import java.util.Collection;
import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class ProductBusiness implements BusinessProductInterface {

	ShelfBusiness SB = new ShelfBusiness();

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

	@Override
	public void addProductToShelf(Product productToAdd, long selectedId) {
		Shelf shelfSelected = SB.getbyId(selectedId);
		shelfSelected.setProductId(productToAdd.getId());
		productToAdd.addShelfId(shelfSelected.getId());
		SB.edit(shelfSelected);
		PDB.edit(productToAdd);
	}

	
	@Override
	public Product updateshelvesIdsInProduct(Product productInShelf, long productIdInShelf) {
		List<Long> shelvesIdsInProduct = productInShelf.getShelvesIds();

		for (int i = 0; i < shelvesIdsInProduct.size(); i++) {
			if (shelvesIdsInProduct.get(i) == productIdInShelf) {
				productInShelf.removeShelfId(shelvesIdsInProduct.get(i));
				break;
				}
		}

		PDB.edit(productInShelf);
		return productInShelf;
	}

		

}
