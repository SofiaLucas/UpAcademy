package io.altar.jseproject.textinterface;

import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.textinterface.ScannerUtils.ScannerUtils;
import repositories.EntityRepository;
import repositories.ProductRepository;
import repositories.ShelfRepository;

public class TextInterface {
	ScannerUtils sc = new ScannerUtils();
	ProductRepository pdb = pdb.getInstance();
	ShelfRepository sdb = sdb.getInstance();
	
	public void showMainMenu() {

		System.out.println("Por favor selecione uma das seguintes opções:\n" + "1) Listar produtos\n"
				+ "2) Listar prateleiras\n" + "3) Sair");

		int number = sc.getValidInt("Select a number between ", 1, 3);

		switch (number) {
		case 1:
			System.out.println("1) Listar produtos:");
			showProductsMenu();
			break;
		case 2:
			System.out.println("2) Listar prateleiras:");
			break;
		case 3:
			System.out.println("3) Sair");
			System.exit(0);
		}
	}

	public void showProductsMenu() {
		
			
		pdb.getAll();
		
		System.out.println("Por favor selecione uma das seguintes opções:\n" + "1) Criar novo produto\n"
				+ "2) Editar um produto existente\n" + "3) Consultar o detalhe de um produto\n"
				+ "4) Remover um produto\n" + "5) Voltar ao ecrã anterior");

		int number = sc.getValidInt("Select a number between ", 1, 5);

		switch (number) {
		case 1:
			System.out.println("1) Criar novo produto:");
			System.out.println("Introduza o desconto");
			
			int discount = sc.getInt("");
			
			
			System.out.println("Introduza o Iva");
			//Product iva = sc.getValidInt("", ivnna);
			System.out.println("Introduza o pvp");
			
			//Product newProd = new Product(discount, iva, pvp);
//			EntityRepository <Product> newProduct = new EntityRepository<Product> ();
//			newProduct.create(newProduct);
			
			break;
		case 2:
			System.out.println("2) Editar um produto existente:");
			break;
		case 3:
			System.out.println("3) Consultar o detalhe de um produto:");
			break;
		case 4:
			System.out.println("4) Remover um produto:");
			break;
		case 5:
			showMainMenu();
			break;
		}

	}
	
	public void showShelvesMenu() {
		
		System.out.println("Por favor selecione uma das seguintes opções:\n" + "1) Criar nova prateleira\n"
				+ "2) Editar um prateleira existente\n" + "3) Consultar o detalhe de uma prateleira\n"
				+ "4) Remover uma prateleira\n" + "5) Voltar ao ecrã anterior");

		int number = sc.getValidInt("Select a number between ", 1, 5);

		switch (number) {
		case 1:
			System.out.println("1) Criar novo prateleira:");
						
			break;
		case 2:
			System.out.println("2) Editar uma prateleira existente:");
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

}
