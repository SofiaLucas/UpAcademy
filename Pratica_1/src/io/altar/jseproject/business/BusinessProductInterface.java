package io.altar.jseproject.business;

import io.altar.jseproject.model.Product;

import io.altar.jseproject.repositories.ProductRepository;

public interface BusinessProductInterface extends BusinessServiceInterface<Product> {

//	static final ProductRepository PDB = ProductRepository.getInstance();

	void addProductToShelf(Product productToAdd, long selectedId);

	Product updateshelvesIdsInProduct(Product productInShelf, long productIdInShelf);
}
