package io.altar.jseproject.business;

import java.util.List;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public interface BusinessShelfInterface extends BusinessServiceInterface <Shelf> {
	
	//static final ShelfRepository SDB = ShelfRepository.getInstance();
	
	long[] selectEmptyShelves();
	
	public List<Shelf> removeProductFromShelf(long id);
	
}
