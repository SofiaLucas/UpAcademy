package io.altar.jseproject.textinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.textinterface.ScannerUtils.ScannerUtils;
import repositories.EntityRepository;
import repositories.ProductRepository;
import repositories.ShelfRepository;

public class TextInterface {
	ScannerUtils sc = new ScannerUtils();
	ProductRepository productsDataBase = ProductRepository.getInstance();
	ShelfRepository shelvesDataBase = ShelfRepository.getInstance();

	public void showMainMenu() {
//		System.out.println("\n Por favor selecione uma das seguintes opcoes:\n" + "\t 1) Listar produtos\n"
//				+ "\t 2) Listar prateleiras\n" + "\t 3) Sair");

		int number = sc.getValidInt("Seleccione uma opcao ", 1, 3);

		switch (number) {
		case 1:
			showProductsMenu();
			break;
		case 2:
			showShelvesMenu();
			break;
		case 3:
			System.out.println("Saiu do menu principal");
			System.exit(0);
		}
	}

	public void showProductsMenu() {
		System.out.println("Seleccionou a opcao 1) 'Listar produtos'; Estes sao os produtos atualmente existentes: \n");
		// Os campos a apresentar s�o � sua escolha, sendo apenas o campo ID origat�rio.
		System.out.println(productsDataBase.getAll());

//		System.out.println("\n Por favor selecione uma das seguintes opcoes:\n" + "\t 1) Criar novo produto\n"
//				+ "\t 2) Editar um produto existente\n" + "\t 3) Consultar o detalhe de um produto\n"
//				+ "\t 4) Remover um produto\n" + "\t 5) Voltar ao ecra anterior (Menu inicial)");

		int number = sc.getValidInt("Seleccione uma opcao ", 1, 5);

		switch (number) {
		case 1:
			System.out.println("1) Criar novo produto:");
			createProduct();
			break;
		case 2:
			System.out.println("2) Editar um produto existente:");
			editProduct();
			break;
		case 3:
			System.out.println("3) Consultar o detalhe de um produto:");
			consultProduct();
			break;
		case 4:
			System.out.println("4) Remover um produto:");
			removeProduct();
			break;
		case 5:
			showMainMenu();
			break;
		}
	}

	public void showShelvesMenu() {
		System.out.println(
				"Seleccionou a opcao 2) 'Listar prateleiras'; Estes sao as prateleiras atualmente existentes: \n");
		System.out.println(shelvesDataBase.getAll());
//		System.out.println("\n Por favor selecione uma das seguintes opcoes:\n" + "1) Criar nova prateleira\n"
//				+ "2) Editar um prateleira existente\n" + "3) Consultar o detalhe de uma prateleira\n"
//				+ "4) Remover uma prateleira\n" + "5) Voltar ao ecrã anterior");

		int number = sc.getValidInt("Seleccione uma opcao ", 1, 5);

		switch (number) {
		case 1:
			System.out.println("1) Criar novo prateleira:");
			createShelf();

			break;
		case 2:
			System.out.println("2) Editar uma prateleira existente:");
			editShelf();

			break;
		case 3:
			System.out.println("3) Consultar o detalhe de uma prateleira:");
			consultShelf();
			break;
		case 4:
			System.out.println("4) Remover uma prateleira:");
			removeShelf();
			break;
		case 5:
			showMainMenu();
			break;
		}
	}

	// ********************
	// PRODUCTS
	// ********************

	public void createProduct() {
		int number = 0;
		do {
			int discount = sc.getValidInt("Introduza o desconto ", 0, 100);
			int[] ivaOptions = { 23, 13, 6 };
			int iva = sc.getValidInt("Introduza o Iva ", ivaOptions);
			float pvp = sc.getFloat("Introduza o pvp ");
			Product newProd = new Product(discount, iva, pvp);
			productsDataBase.create(newProd);
			System.out.println("Este foi o produto criado:");
			System.out.println(newProd);

			System.out
					.println("Pretende criar mais algum produto?\n" + "1) Sim\n" + "2) Nao (volta ao menu inicial)\n");
			number = sc.getValidInt("", 1, 2);
		} while (number != 2);

		System.out.println("\n Voltou ao menu inicial");
		showMainMenu();
	}

	public void editProduct() {

		System.out.println("Selecione o id do produto que pretende editar");
		long idSelected = selectId(productsDataBase); // metodo abaixo
		Product productToEdit = productsDataBase.getbyId(idSelected);

		editProductDetails(productToEdit);
		int number = 0;
		do {
			System.out.println("Pretende alterar mais detalhes deste produto?\n" + "1) Sim\n"
					+ "2) Nao (volta ao menu inicial)\n");
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
		System.out.println("\n Voltou ao menu inicial");
		showMainMenu();
	}

	public void editProductDetails(Product productToEdit) {

		System.out.println("\n Por favor selecione o que pretende editar:\n" + "1) Colocar o produto numa prateleira\n"
				+ "2) Editar o desconto\n" + "3) Editar o Iva\n" + "4) Editar o pvp\n"
				+ "5) Voltar ao menu dos produtos\n");

		int number = sc.getValidInt("Select a number between ", 1, 5);
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
		case 5:
			showProductsMenu();
			break;
		}

	}

	public void consultProduct() {
		int number = 0;
		do {
			System.out.println("Selecione o id do produto que pretende consultar");
			long idToConsult = selectId(productsDataBase);
			Product productToConsult = productsDataBase.getbyId(idToConsult);
			System.out.println(productToConsult);

			System.out.println(
					"Pretende consultar mais algum produto?" + "1) Sim\n" + "2) Nao (volta ao menu inicial)\n");
			number = sc.getValidInt("", 1, 2);
		} while (number != 2);

		System.out.println("\n Voltou ao menu inicial");
		showMainMenu();
	}

	public void removeProduct() {

		int number = 0;
		do {
			System.out.println("Selecione o id do produto que pretende remover");
			long idToRemove = selectId(productsDataBase);
			Product productToRemove = productsDataBase.getbyId(idToRemove);
			productsDataBase.remove(productToRemove);
			removeProductFromShelf(idToRemove);

			if (productsDataBase.isEmpty() == false) {
				System.out.println(
						"Pretende remover mais algum produto?" + "1) Sim\n" + "2) Nao (volta ao menu inicial)\n");
				number = sc.getValidInt("Seleccione um numero entre ", 1, 2);
			} else {
				System.out.println("Nao ha mais produtos para remover");
			}

		} while (number != 2 && productsDataBase.isEmpty() == false);

		System.out.println("\n Voltou ao menu inicial");
		showMainMenu();
	}

	// *********

	public long selectId(EntityRepository dataBase) {
		Object[] objectArray = dataBase.getAllIds().toArray();
		long[] idArr = new long[objectArray.length];
		for (int i = 0; i < objectArray.length; i++) {
			idArr[i] = (long) objectArray[i];
		}

		long selectedId = sc.getValidLong("Ids disponiveis:" + Arrays.toString(idArr), idArr);
		return selectedId;

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

	// *******************+
	// Shelf
	// *******************

	public void createShelf() {
		int number = 0;
		do {
			int shelfCapacity = sc.getInt("Capacidade:");
			float shelfDailyPrice = sc.getFloat("Preco diario:");
			Shelf newShelf = new Shelf(shelfCapacity, shelfDailyPrice);
			shelvesDataBase.create(newShelf);
			System.out.println("Esta foi a prateleira criada: \n");
			System.out.println(newShelf);
			System.out.println(
					"Pretende criar mais alguma prateleira ?\n" + "1) Sim\n" + "2) Nao (volta ao menu inicial)\n");
			number = sc.getValidInt("", 1, 2);
		} while (number != 2);

		System.out.println("\n Voltou ao menu inicial");
		showMainMenu();
	}

	public void editShelf() {

		System.out.println("Selecione o id da prateleira que pretende editar");
		long idSelected = selectId(shelvesDataBase);
		Shelf shelfToEdit = shelvesDataBase.getbyId(idSelected);

		editShelfDetails(shelfToEdit);
		int number = 0;
		do {
			System.out.println("Pretende alterar mais detalhes desta prateleira?\n" + "1) Sim\n"
					+ "2) Nao (volta ao menu inicial)\n");
			number = sc.getValidInt("Seleccione um numero entre ", 1, 2);
			switch (number) {
			case 1:
				editShelfDetails(shelfToEdit);
				break;
			case 2:
				break;
			}
		} while (number != 2);

		shelvesDataBase.edit(shelfToEdit);

		System.out.println("A prateleira foi editada:");
		System.out.println(shelfToEdit);
		System.out.println("\n Voltou ao menu inicial");
		showMainMenu();

	}

	public void editShelfDetails(Shelf shelfToEdit) {

		System.out.println("\n Por favor selecione o que pretende editar:\n" + "1) Capacidade\n" + "2) Preco diario\n"
				+ "3) Voltar ao menu das prateleiras\n");

		int number = sc.getValidInt("Select a number between ", 1, 3);
		switch (number) {
		case 1:
			int newCapacity = sc.getInt("Introduza a nova capacidade");
			shelfToEdit.setCapacity(newCapacity);
			break;
		case 2:
			float newPrice = sc.getFloat("Introduza o novo preco diario");
			shelfToEdit.setDailyPrice(newPrice);
			break;
		case 3:
			showShelvesMenu();
			break;

		}

	}

	public void consultShelf() {
		int number = 0;
		do {
			System.out.println("Selecione o id da prateleira que pretende consultar");
			long idToConsult = selectId(shelvesDataBase);
			Shelf shelfToConsult = shelvesDataBase.getbyId(idToConsult);
			System.out.println(shelfToConsult);
			System.out.println(
					"Pretende consultar mais alguma prateleira?" + "1) Sim\n" + "2) Nao (volta ao menu inicial)\n");
			number = sc.getValidInt("", 1, 2);
		} while (number != 2);

		System.out.println("\n Voltou ao menu inicial");
		showMainMenu();
	}

	public void removeShelf() {

		int number = 0;
		do {
			System.out.println("Selecione o id da prateleira que pretende remover");
			long idToRemove = selectId(shelvesDataBase);
			Shelf shelfToRemove = shelvesDataBase.getbyId(idToRemove);
			shelvesDataBase.remove(shelfToRemove);
			//// fazer alguma coisa relativamente aos produtos;

			/////////////////////////////
			if (shelfToRemove.getProductId() != 0) {
				System.out.println(
						"O seguinte produto foi removido da prateleira; pretende adiciona-lo a uma nova prateleira?\n"
								+ "1) Sim\n" + "2) Nao\n");
				int number2 = sc.getValidInt("Seleccione uma opcao ", 1, 2);
				long productIdInShelf = shelfToRemove.getProductId();
				Product productInShelf = productsDataBase.getbyId(productIdInShelf);
				System.out.println(productInShelf);

				switch (number2) {
				case 1:
					addProductToShelf(productInShelf);
					break;

				}

			}
			///////////////////////

			if (shelvesDataBase.isEmpty() == false) {
				System.out.println(
						"Pretende remover mais alguma prateleira?" + "1) Sim\n" + "2) Nao (volta ao menu inicial)\n");
				number = sc.getValidInt("Seleccione um numero entre ", 1, 2);
			} else {
				System.out.println("Nao ha mais prateleiras para remover");
			}

		} while (number != 2 && shelvesDataBase.isEmpty() == false);

		System.out.println("\n Voltou ao menu inicial");
		showMainMenu();
	}
}
