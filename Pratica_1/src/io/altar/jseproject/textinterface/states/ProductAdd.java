package io.altar.jseproject.textinterface.states;

import io.altar.jseproject.model.Product;

public class ProductAdd extends State{

	@Override
	public int run() {
		
		System.out.println("Adicionar produto");
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
					.println("Pretende criar mais algum produto?\n" + "1) Sim\n" + "2) Nao (volta ao menu dos produtos)\n");
			number = sc.getValidInt("", 1, 2);
		} while (number != 2);

		
		return 1;
	}

}
