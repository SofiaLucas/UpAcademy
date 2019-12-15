package io.altar.jseproject.textinterface;

import java.util.Arrays;

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
		System.out.println("\n Por favor selecione uma das seguintes opções:\n" + "\t 1) Listar produtos\n"
				+ "\t 2) Listar prateleiras\n" + "\t 3) Sair");

		int number = sc.getValidInt("Select a number between ", 1, 3);

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
		System.out.println("Seleccionou a opção 1) 'Listar produtos'; Estes são os produtos atualmente existentes: \n");
		// Os campos a apresentar são à sua escolha, sendo apenas o campo ID origatório.
		System.out.println(productsDataBase.getAll());

		System.out.println("\n Por favor selecione uma das seguintes opções:\n" + "\t 1) Criar novo produto\n"
				+ "\t 2) Editar um produto existente\n" + "\t 3) Consultar o detalhe de um produto\n"
				+ "\t 4) Remover um produto\n" + "\t 5) Voltar ao ecrã anterior");

		int number = sc.getValidInt("Select a number between ", 1, 5);

		switch (number) {
		case 1:
			System.out.println("1) Criar novo produto:");
			int discount = sc.getValidInt("Introduza o desconto", 0, 100);
			int[] ivaOptions = { 23, 13, 6 };
			int iva = sc.getValidInt("Introduza o Iva", ivaOptions);
			// float pvp = sc.getInt(""); // como é q ele n se chateia com isto??
			float pvp = sc.getFloat("Introduza o pvp");
			Product newProd = new Product(discount, iva, pvp);
			productsDataBase.create(newProd);
			System.out.println("Este foi o produto criado:");
			System.out.println(newProd);
//			System.out.println(productsDataBase.getAllIds());
			System.out.println("\n Voltou ao menu inicial");
			showMainMenu();
			break;
		case 2:
			System.out.println("2) Editar um produto existente:");
			System.out.println("Selecione o id do produto que pretende editar");
			long idSelected = selectId(productsDataBase); // método abaixo

//			System.out.println(Arrays.toString(idArr));
//			System.out.println(productsDataBase.getAllIds());
			Product productToEdit = productsDataBase.getbyId(idSelected);
			productsDataBase.edit(productToEdit); // e agora?
			System.out.println("O produto foi editado");
			System.out.println("\n Voltou ao menu inicial");
			showMainMenu();

			break;
		case 3:
			System.out.println("3) Consultar o detalhe de um produto:");
			System.out.println("Selecione o id do produto que pretende consultar");
			long idToConsult = selectId(productsDataBase);
			Product productToConsult = productsDataBase.getbyId(idToConsult);
			System.out.println(productToConsult);
			System.out.println("\n Voltou ao menu inicial");
			showMainMenu();

			break;
		case 4:
			System.out.println("4) Remover um produto:");
			System.out.println("Selecione o id do produto que pretende remover");
			long idToRemove = selectId(productsDataBase);			
			Product productToRemove = productsDataBase.getbyId(idToRemove);
			productsDataBase.remove(productToRemove);
			System.out.println("O produto foi removido");
			System.out.println("\n Voltou ao menu inicial");
			showMainMenu();
			break;
		case 5:
			showMainMenu();
			break;
		}
	}

	public void showShelvesMenu() {
		System.out.println(
				"Seleccionou a opção 2) 'Listar prateleiras'; Estes são as prateleiras atualmente existentes: \n");
		System.out.println(shelvesDataBase.getAll());
		System.out.println("\n Por favor selecione uma das seguintes opções:\n" + "1) Criar nova prateleira\n"
				+ "2) Editar um prateleira existente\n" + "3) Consultar o detalhe de uma prateleira\n"
				+ "4) Remover uma prateleira\n" + "5) Voltar ao ecrÃ£ anterior");

		int number = sc.getValidInt("Select a number between ", 1, 5);

		switch (number) {
		case 1:
			System.out.println("1) Criar novo prateleira:");

			int shelfCapacity = sc.getInt("Capacidade:");
			float shelfDailyPrice = sc.getFloat("Preço diario:");
			Shelf newShelf = new Shelf(shelfCapacity, shelfDailyPrice);
			shelvesDataBase.create(newShelf);
			System.out.println("Esta foi a prateleira criada: \n");
			System.out.println(newShelf);
			System.out.println("\n Voltou ao menu inicial");
			showMainMenu();
			break;
		case 2:
			System.out.println("2) Editar uma prateleira existente:");

//			Long[] idArr = getIdsArray(shelvesDataBase);
//
//			long selectedId = sc.getValidLong("Selecione o id da prateleira que pretende editar ", idArr[0],
//					idArr[idArr.length - 1]);
//			Shelf shelfToEdit = shelvesDataBase.getbyId(selectedId);
//			shelvesDataBase.edit(shelfToEdit); // e agora?
//			System.out.println("A prateleira foi editada");
//			System.out.println("\n Voltou ao menu inicial");
//			showMainMenu();

			break;
		case 3:
			System.out.println("3) Consultar o detalhe de uma prateleira:");
			break;
		case 4:
			System.out.println("4) Remover uma prateleira:");
			break;
		case 5:
			showMainMenu();
			break;
		}

	}

	public long selectId(EntityRepository dataBase) {
		Object[] objectArray = dataBase.getAllIds().toArray();
		Long[] idArr = new Long[objectArray.length];
		for (int i = 0; i < objectArray.length; i++) {
			idArr[i] = (long) objectArray[i];
		}

		long selectedId = sc.getValidLong("", idArr[0], idArr[idArr.length - 1]);
		return selectedId;

	}

}
