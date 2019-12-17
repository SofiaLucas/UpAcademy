package io.altar.jseproject.textinterface.states;

import java.util.Arrays;

import io.altar.jseproject.model.Product;
import repositories.EntityRepository;

public class ProductConsult extends State {

	@Override
	public int run() {
		int number = 0;
		do {
			System.out.println("Selecione o id do produto que pretende consultar");
			long idToConsult = selectId(productsDataBase);
			Product productToConsult = productsDataBase.getbyId(idToConsult);
			System.out.println(productToConsult);

			System.out.println(
					"Pretende consultar mais algum produto?" + "1) Sim\n" + "2) Nao (volta ao menu dos produtos)\n");
			number = sc.getValidInt("", 1, 2);
		} while (number != 2);

		
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
}
