package io.altar.jseproject.textinterface.states;

import java.util.Arrays;
import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class ProductRemove extends State {

	@Override
	public int run() {
		int number = 0;
		do {
			long[] allIdsArr = productsDataBase.getAllIds();

			if (allIdsArr.length != 0) {

				System.out.println("Selecione o id do produto que pretende remover");
				long idToRemove = sc.getValidLong("Ids disponiveis:" + Arrays.toString(allIdsArr), allIdsArr);

				Product productToRemove = productsDataBase.getbyId(idToRemove);
				productsDataBase.remove(productToRemove);

				if (!productToRemove.getShelvesIds().isEmpty()) {
					List<Shelf> removedShelves = shelvesDataBase.removeProductFromShelf(idToRemove);
					System.out.println("O produto foi removido das seguintes prateleiras: \n " + removedShelves);
				}

				if (productsDataBase.isEmpty() == false) {
					System.out.println("Pretende remover mais algum produto?\n" + "1) Sim\n"
							+ "2) Nao (volta ao menu dos produtos)");
					number = sc.getValidInt("Seleccione um numero entre ", 1, 2);
				} else {
					System.out.println("Nao ha mais produtos para remover");
				}
			} else {
				System.out.println("Nao existem produtos.\n");
			}
		} while (number != 2 && productsDataBase.isEmpty() == false);

		return 1;
	}

}
