package io.altar.jseproject.textinterface.states;

import io.altar.jseproject.textinterface.ScannerUtils.ScannerUtils;
import repositories.ProductRepository;
import repositories.ShelfRepository;

public abstract class State {
	
	public static final ScannerUtils sc = new ScannerUtils();
	ProductRepository productsDataBase = ProductRepository.getInstance();
	ShelfRepository shelvesDataBase = ShelfRepository.getInstance();
	
	public abstract int run();

}
