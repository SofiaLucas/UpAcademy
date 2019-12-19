package io.altar.jseproject.textinterface.states;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.EntityRepository;

public class ProductEdit extends State {

	@Override
	public int run() {

		long[] allIdsArr = productsDataBase.getAllIds();

		if (allIdsArr.length != 0) {

			System.out.println("Selecione o id do produto que pretende editar");
			long selectedId = sc.getValidLong("Ids disponiveis:" + Arrays.toString(allIdsArr), allIdsArr);

			Product productToEdit = productsDataBase.getbyId(selectedId);

			editProductDetails(productToEdit);
			int number = 0;

			do {
				System.out.println("Pretende alterar mais detalhes deste produto?\n" + "1) Sim\n"
						+ "2) Nao (volta ao menu dos produtos)\n");
				number = sc.getValidInt("Seleccione um numero entre ", 1, 2);
				switch (number) {
				case 1:
					editProductDetails(productToEdit);
					break;
				case 2:
					break;
				}
			} while (number != 2);

			productsDataBase.edit(productToEdit);
			System.out.println("O produto foi editado:");
			System.out.println(productToEdit);
		} else {
			System.out.println("Nao existem produtos.\n");
		}

		return 1;
	}

	public void editProductDetails(Product productToEdit) {

		System.out.println("\n Por favor selecione o que pretende editar:\n" + "1) Colocar o produto numa prateleira\n"
				+ "2) Editar o desconto\n" + "3) Editar o Iva\n" + "4) Editar o pvp");

		int number = sc.getValidInt("Select a number between ", 1, 4);
		switch (number) {

		// Fazer: Se o utilizador apenas pressionar <Enter> o valor anterior é mantido
		// na entidade
		case 1:
			long [] emptyShelvesIdsArr = selectEmptyShelves();
			
			// tentar que o utilizador possa escolher varios ids ao mesmo tempo
			
			if (emptyShelvesIdsArr.length == 0) {
				System.out.println("Nao ha prateleiras disponiveis");
				
			} else {
				System.out.println("Selecione o id da prateleira onde pretende inserir o produto");
				long selectedId = sc.getValidLong("Id das prateleiras disponiveis: " + Arrays.toString(emptyShelvesIdsArr),
						emptyShelvesIdsArr);
				
			addProductToShelf(productToEdit, selectedId);
			System.out.println("O produto foi adicionado a prateleira");
			}
			break;
		case 2:
			float currentDiscount = productToEdit.getDiscount();
			System.out.println("Desconto atual:" + currentDiscount);
			int newDiscount = sc.getValidInt("Introduza o desconto", 0, 100);

			if (newDiscount != -1) {
				productToEdit.setDiscount(newDiscount);
			}

			break;
		case 3:
			int currentIva = productToEdit.getIva();
			System.out.println("Iva atual:" + currentIva);
			int[] ivaOptions = { 23, 13, 6 };
			int newIva = sc.getValidInt("Introduza o Iva", ivaOptions);
			productToEdit.setIva(newIva);
			break;
		case 4:
			float currentPvp = productToEdit.getPvp();
			System.out.println("Pvp atual:" + currentPvp);
			float newPvp = sc.getFloat("Introduza o pvp");
			productToEdit.setPvp(newPvp);
			break;
		}
	}

	
	
	public void addProductToShelf(Product productToAdd, long selectedId) {
					
			Shelf shelfSelected = shelvesDataBase.getbyId(selectedId);
			shelfSelected.setProductId(productToAdd.getId());
			productToAdd.addShelfId(shelfSelected.getId());

			shelvesDataBase.edit(shelfSelected);
			productsDataBase.edit(productToAdd);

		}
	

	public long[] selectEmptyShelves() {

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
				return emptyShelvesIdsArr;

	}

}