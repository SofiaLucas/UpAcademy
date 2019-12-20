package io.altar.jseproject.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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

	@Override
	public long[] selectEmptyShelves() {
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

	@Override
	public List<Shelf> removeProductFromShelf(long id) {
		Collection<Shelf> allShelves = SDB.getAll();
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
