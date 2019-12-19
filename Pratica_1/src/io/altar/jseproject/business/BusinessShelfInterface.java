package io.altar.jseproject.business;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public interface BusinessShelfInterface extends BusinessServiceInterface <Shelf> {
	
	static final ShelfRepository SDB = ShelfRepository.getInstance();
	
	
}
