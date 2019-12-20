package io.altar.jseproject.textinterface.states;


import java.util.Arrays;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;


public class ShelfRemove extends State {

	@Override
	public int run() {
		int number = 0;
		do {
			long[] allIdsArr = shelvesDataBase.getAllIds();
			
			if (allIdsArr.length != 0) {
			System.out.println("Selecione o id da prateleira que pretende remover");
			long idToRemove = sc.getValidLong("Ids disponiveis:" + Arrays.toString(allIdsArr), allIdsArr);
			Shelf shelfToRemove = shelvesDataBase.getbyId(idToRemove);
			shelvesDataBase.remove(shelfToRemove);

			/////// verifica se ha um produto na shelf removida:
			long productIdInShelf = shelfToRemove.getProductId();
			Product productInShelf = productsDataBase.getbyId(productIdInShelf);
			if (productIdInShelf != 0) {		
				Product updatedProduct = productsDataBase.updateshelvesIdsInProduct(productInShelf, productIdInShelf); 
				System.out.println("O seguinte produto foi removido da prateleira:\n" + updatedProduct);										
			}
				
			long[] emptyShelvesIdsArr = shelvesDataBase.selectEmptyShelves();
			if (emptyShelvesIdsArr.length == 0) {
				System.out.println("Nao ha prateleiras vazias");
			} else {
				System.out.println(
						"\n Existem prateleiras disponiveis. Pretende adicionar o produto a uma nova prateleira?\n"
								+ "1) Sim\n" + "2) Nao");
				int number2 = sc.getValidInt("Seleccione uma opcao ", 1, 2);

				switch (number2) {
				case 1:
					long emptyShelfIdSelected = sc.getValidLong("Ids disponiveis:" + Arrays.toString(emptyShelvesIdsArr), emptyShelvesIdsArr);
					productsDataBase.addProductToShelf(productInShelf, emptyShelfIdSelected);
					break;
				}
				}
			/////////////////////// 

			if (shelvesDataBase.isEmpty() == false) {
				System.out.println("Pretende remover mais alguma prateleira?\n" + "1) Sim\n"
						+ "2) Nao (volta ao menu das prateleiras)\n");
				number = sc.getValidInt("Seleccione um numero entre ", 1, 2);
			} else {
				System.out.println("Nao ha mais prateleiras para remover");
			}
			}
			else {System.out.println("Nao existem prateleiras.");}
		} while (number != 2 && shelvesDataBase.isEmpty() == false);
		
		
		return 1;
	}


}
