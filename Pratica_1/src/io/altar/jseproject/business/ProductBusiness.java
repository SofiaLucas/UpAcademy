package io.altar.jseproject.business;

import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;

public class ProductBusiness extends EntityBusiness<ProductRepository, Product> implements BusinessProductInterface {

	ShelfBusiness SB = new ShelfBusiness();

	public ProductBusiness() {
		repository = ProductRepository.getInstance();
	}

	@Override
	public void addProductToShelf(Product productToAdd, long selectedId) {
		Shelf shelfSelected = SB.getbyId(selectedId);
		shelfSelected.setProductId(productToAdd.getId());
		productToAdd.addShelfId(shelfSelected.getId());
		SB.edit(shelfSelected);
		repository.edit(productToAdd);
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

		repository.edit(productInShelf);
		return productInShelf;
	}

}
