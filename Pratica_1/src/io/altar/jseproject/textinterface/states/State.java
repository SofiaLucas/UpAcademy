package io.altar.jseproject.textinterface.states;


//import io.altar.jseproject.business.ProductBusiness;
//import io.altar.jseproject.business.ShelfBusiness;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.textinterface.ScannerUtils.ScannerUtils;

public abstract class State {
	
	public static final ScannerUtils sc = new ScannerUtils();
//	ProductBusiness productBusiness = new ProductBusiness();
//	ShelfBusiness shelfBusiness = new ShelfBusiness();
	
	
	ProductRepository productsDataBase = ProductRepository.getInstance();
	ShelfRepository shelvesDataBase = ShelfRepository.getInstance();

	public abstract int run();

	
	
	
}
