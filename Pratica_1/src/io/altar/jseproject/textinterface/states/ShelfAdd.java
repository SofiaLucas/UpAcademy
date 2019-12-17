package io.altar.jseproject.textinterface.states;

import io.altar.jseproject.model.Shelf;

public class ShelfAdd extends State {

	@Override
	public int run() {
		int number = 0;
		do {
			int shelfCapacity = sc.getInt("Capacidade:");
			float shelfDailyPrice = sc.getFloat("Preco diario:");
			Shelf newShelf = new Shelf(shelfCapacity, shelfDailyPrice);
			shelvesDataBase.create(newShelf);
			System.out.println("Esta foi a prateleira criada: \n");
			System.out.println(newShelf);
			System.out.println(
					"Pretende criar mais alguma prateleira ?\n" + "1) Sim\n" + "2) Nao (volta ao menu das prateleiras)\n");
			number = sc.getValidInt("", 1, 2);
		} while (number != 2);

		
		return 1;
	}

}
