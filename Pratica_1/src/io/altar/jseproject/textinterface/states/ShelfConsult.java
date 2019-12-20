package io.altar.jseproject.textinterface.states;

import java.util.Arrays;

import io.altar.jseproject.model.Shelf;

public class ShelfConsult extends State {

	@Override
	public int run() {
		int number = 0;
		long[] allIdsArr = shelvesDataBase.getAllIds();
		if (allIdsArr.length != 0) {

			do {
				System.out.println("Selecione o id da prateleira que pretende consultar");

				long idToConsult = sc.getValidLong("Ids disponiveis:" + Arrays.toString(allIdsArr), allIdsArr);

				Shelf shelfToConsult = shelvesDataBase.getbyId(idToConsult);
				System.out.println(shelfToConsult);
				System.out.println("Pretende consultar mais alguma prateleira?\n" + "1) Sim\n"
						+ "2) Nao (volta ao menu das prateleiras)");
				number = sc.getValidInt("", 1, 2);

			} while (number != 2);
		} else {
			System.out.println("Nao existem prateleiras.\n");
		}

		return 1;
	}

}
