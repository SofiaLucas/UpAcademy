package io.altar.jseproject.textinterface.states;

import java.util.Arrays;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.EntityRepository;

public class ProductConsult extends State {

	@Override
	public int run() {
		int number = 0;
		long[] allIdsArr = productsDataBase.getAllIds();
		if (allIdsArr.length != 0) {
			do {
				System.out.println("Selecione o id do produto que pretende consultar");

				long selectedId = sc.getValidLong("Ids disponiveis:" + Arrays.toString(allIdsArr), allIdsArr);

				Product productToConsult = productsDataBase.getbyId(selectedId);
				System.out.println(productToConsult);

				System.out.println("Pretende consultar mais algum produto?\n" + "1) Sim\n"
						+ "2) Nao (volta ao menu dos produtos)\n");
				number = sc.getValidInt("", 1, 2);
				System.out.println("Selecione o id do produto que pretende consultar");

			} while (number != 2);

		} else {
			System.out.println("Nao existem produtos");
		}
		return 1;
	}

}
