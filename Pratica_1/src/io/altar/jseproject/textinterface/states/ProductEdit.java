package io.altar.jseproject.textinterface.states;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import repositories.EntityRepository;

public class ProductEdit extends State {

	@Override
	public int run() {
		System.out.println("Selecione o id do produto que pretende editar");
		long idSelected = selectId(productsDataBase); // metodo abaixo
		Product productToEdit = productsDataBase.getbyId(idSelected);

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
		
		
		return 1;
	}
	
	
	
	
	public void editProductDetails(Product productToEdit) {

		System.out.println("\n Por favor selecione o que pretende editar:\n" + "1) Colocar o produto numa prateleira\n"
				+ "2) Editar o desconto\n" + "3) Editar o Iva\n" + "4) Editar o pvp\n");

		int number = sc.getValidInt("Select a number between ", 1, 4);
		switch (number) {
		case 1:
			addProductToShelf(productToEdit);

			break;
		case 2:
			int newDiscount = sc.getValidInt("Introduza o desconto", 0, 100);
			productToEdit.setDiscount(newDiscount);
			break;
		case 3:
			int[] ivaOptions = { 23, 13, 6 };
			int newIva = sc.getValidInt("Introduza o Iva", ivaOptions);
			productToEdit.setIva(newIva);
			break;
		case 4:
			float newPvp = sc.getFloat("Introduza o pvp");
			productToEdit.setPvp(newPvp);
			break;
		
		}

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
			System.out.println("Nao ha prateleiras disponiveis");
			return -1;
		} else {
			System.out.println("Selecione o id da prateleira onde pretende inserir o produto");
			long selectedId = sc.getValidLong("Id das prateleiras disponiveis: " + Arrays.toString(emptyShelvesIdsArr),
					emptyShelvesIdsArr);
			return selectedId;
		}
	}
	
	
}