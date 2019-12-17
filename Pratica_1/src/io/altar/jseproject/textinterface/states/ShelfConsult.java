package io.altar.jseproject.textinterface.states;

import java.util.Arrays;

import io.altar.jseproject.model.Shelf;
import repositories.EntityRepository;

public class ShelfConsult extends State {

	@Override
	public int run() {
		int number = 0;
		do {
			System.out.println("Selecione o id da prateleira que pretende consultar");
			long idToConsult = selectId(shelvesDataBase);
			Shelf shelfToConsult = shelvesDataBase.getbyId(idToConsult);
			System.out.println(shelfToConsult);
			System.out.println(
					"Pretende consultar mais alguma prateleira?" + "1) Sim\n" + "2) Nao (volta ao menu das prateleiras)\n");
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
