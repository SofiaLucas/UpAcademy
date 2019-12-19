package io.altar.jseproject.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;

public interface BusinessProductInterface extends BusinessServiceInterface<Product> {

	static final ProductRepository PDB = ProductRepository.getInstance();
	
	
	
	//void updateRemoveShelfFromProduct
	
	public static void addProductToShelf(Product productToAdd, long selectedId) {
		
		Shelf shelfSelected = SDB.getbyId(selectedId);
		shelfSelected.setProductId(productToAdd.getId());
		productToAdd.addShelfId(shelfSelected.getId());

		shelvesDataBase.edit(shelfSelected);
		PDB.edit(productToAdd);

	}


public static long[] selectEmptyShelves() {

	Collection<Shelf> allShelves = SDB.getAll();
	Iterator<Shelf> iterator = allShelves.iterator();
	List<Long> emptyShelvesIds = new ArrayList<Long>();

	while (iterator.hasNext()) {
		Shelf shelf = (Shelf) iterator.next();
		if (shelf.getProductId() == 0) {
			emptyShelvesIds.add(shelf.getId());
		}
	}

	final long[] emptyShelvesIdsArr = new long[emptyShelvesIds.size()];
	int index = 0;
	for (final Long value : emptyShelvesIds) {
		emptyShelvesIdsArr[index++] = value;
	}
			return emptyShelvesIdsArr;

}
	
	
	
}
