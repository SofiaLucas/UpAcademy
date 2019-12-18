package io.altar.jseproject.textinterface.states;

import java.util.Arrays;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.EntityRepository;

public class ShelfEdit extends State {

	@Override
	public int run() {
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
	
	public void editShelfDetails(Shelf shelfToEdit) {

		System.out.println("\n Por favor selecione o que pretende editar:\n" + "1) Capacidade\n" + "2) Preco diario\n"
				+ "3) Voltar ao menu das prateleiras\n");

		int number = sc.getValidInt("Select a number between ", 1, 3);
		switch (number) {
		case 1:
			int currentCapacity = shelfToEdit.getCapacity();
			System.out.println("Capacidade atual:" + currentCapacity);
			int newCapacity = sc.getInt("Introduza a nova capacidade");
			shelfToEdit.setCapacity(newCapacity);
			break;
		case 2:
			float currentPrice = shelfToEdit.getDailyPrice();
			System.out.println("Preco atual:" + currentPrice);
			float newPrice = sc.getFloat("Introduza o novo preco diario");
			shelfToEdit.setDailyPrice(newPrice);
			break;
		case 3:
			
			break;

		}
}
	
}
