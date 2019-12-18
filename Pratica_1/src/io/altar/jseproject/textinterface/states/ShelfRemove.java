package io.altar.jseproject.textinterface.states;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.EntityRepository;

public class ShelfRemove extends State {

	@Override
	public int run() {
		int number = 0;
		do {
			System.out.println("Selecione o id da prateleira que pretende remover");
			long idToRemove = selectId(shelvesDataBase); // id da shelf
			Shelf shelfToRemove = shelvesDataBase.getbyId(idToRemove);
			shelvesDataBase.remove(shelfToRemove);
			
					
			

			///////verifica se ha um produto na shelf removida:
			if (shelfToRemove.getProductId() != 0) {
				long productIdInShelf = shelfToRemove.getProductId();		
				Product productInShelf = productsDataBase.getbyId(productIdInShelf);
				
				System.out.println("O seguinte produto foi removido da prateleira:\n" + productInShelf);	
				
				//remover o id da shelf nos produtos (shelvesIds):
					
				List<Long> shelvesIdsInProduct = productInShelf.getShelvesIds();
				
				for (int i = 0; i < shelvesIdsInProduct.size(); i++) {
					
					if(shelvesIdsInProduct.get(i)==productIdInShelf) {
						shelvesIdsInProduct.remove(i);
						break;
									
					}
					}
				
				productsDataBase.edit(productInShelf);
				
				
				///////////////
				
				
				
				

				if (!shelvesDataBase.isEmpty()&&selectEmptyShelvesIds()!=-1) {

					System.out.println(
							"\n Existem prateleiras disponiveis. Pretende adicionar o produto a uma nova prateleira?\n"
									+ "1) Sim\n" + "2) Nao");
					int number2 = sc.getValidInt("Seleccione uma opcao ", 1, 2);

					switch (number2) {
					case 1:
						addProductToShelf(productInShelf);
						break;
					}
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

		} while (number != 2 && shelvesDataBase.isEmpty() == false);

		return 1;
	}

	public long selectId(EntityRepository dataBase) {
		Object[] objectArray = dataBase.getAllIds().toArray();
		long[] idArr = new long[objectArray.length];
		for (int i = 0; i < objectArray.length; i++) {
			idArr[i] = (long) objectArray[i];
		}

		long selectedId = sc.getValidLong("Ids disponiveis:" + Arrays.toString(idArr), idArr);
		return selectedId;

	}

	public void addProductToShelf(Product productToAdd) {
		long shelfIdSelected = selectEmptyShelvesIds();

		// tentar que o utilizador possa escolher varios ids ao mesmo tempo
		if (shelfIdSelected != -1) {
			Shelf shelfSelected = shelvesDataBase.getbyId(shelfIdSelected);
			shelfSelected.setProductId(productToAdd.getId());
			productToAdd.addShelfId(shelfSelected.getId());

			shelvesDataBase.edit(shelfSelected);
			productsDataBase.edit(productToAdd);

		}
	}

	public long selectEmptyShelvesIds() {

		Collection<Shelf> allShelves = shelvesDataBase.getAll();
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

		if (emptyShelvesIdsArr.length == 0) {
			System.out.println("Nao ha prateleiras vazias");
			return -1;
		} else {
			System.out.println("Selecione o id da prateleira onde pretende inserir o produto");
			long selectedId = sc.getValidLong("Id das prateleiras disponiveis: " + Arrays.toString(emptyShelvesIdsArr),
					emptyShelvesIdsArr);
			return selectedId;
		}
	}

}
