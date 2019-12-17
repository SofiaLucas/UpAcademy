package io.altar.jseproject.textinterface.states;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import repositories.EntityRepository;

public class ProductRemove extends State {

	@Override
	public int run() {
		int number = 0;
		do {
			System.out.println("Selecione o id do produto que pretende remover");
			long idToRemove = selectId(productsDataBase);
			Product productToRemove = productsDataBase.getbyId(idToRemove);
			productsDataBase.remove(productToRemove);
			removeProductFromShelf(idToRemove);

			if (productsDataBase.isEmpty() == false) {
				System.out.println(
						"Pretende remover mais algum produto?" + "1) Sim\n" + "2) Nao (volta ao menu dos produtos)\n");
				number = sc.getValidInt("Seleccione um numero entre ", 1, 2);
			} else {
				System.out.println("Nao ha mais produtos para remover");
			}

		} while (number != 2 && productsDataBase.isEmpty() == false);

		
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
	
	
	public void removeProductFromShelf(long id) {
		Collection<Shelf> allShelves = shelvesDataBase.getAll();
		Iterator<Shelf> iterator = allShelves.iterator();
		System.out.println("O produto foi removido das seguintes prateleiras: ");
		while (iterator.hasNext()) {
			Shelf shelf = (Shelf) iterator.next();
			if (shelf.getProductId() == id) {
				shelf.setProductId(0);
				System.out.println(shelf);
			}
		}

	}
}
