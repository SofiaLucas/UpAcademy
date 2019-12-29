package io.altar.jseproject.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class ShelfBusiness extends EntityBusiness<ShelfRepository, Shelf> implements BusinessShelfInterface {

	public ShelfBusiness() {
		repository = ShelfRepository.getInstance();
	}

	@Override
	public long[] selectEmptyShelves() {
		Collection<Shelf> allShelves = repository.getAll();
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

	@Override
	public List<Shelf> removeProductFromShelf(long id) {
		Collection<Shelf> allShelves = repository.getAll();
		Iterator<Shelf> iterator = allShelves.iterator();
		List<Shelf> removedShelves = new ArrayList<Shelf>();
		
		while (iterator.hasNext()) {
			Shelf shelf = (Shelf) iterator.next();
			if (shelf.getProductId() == id) {
				shelf.setProductId(0);
				removedShelves.add(shelf);
			}
		}
		return removedShelves;
	}
}
