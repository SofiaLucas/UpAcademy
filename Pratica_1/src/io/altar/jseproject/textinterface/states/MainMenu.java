package io.altar.jseproject.textinterface.states;

public class MainMenu extends State {

	@Override
	public int run() {
		System.out.println("\n Por favor selecione uma das seguintes opcoes:\n" + "\t 1) Listar produtos\n"
				+ "\t 2) Listar prateleiras\n" + "\t 3) Sair");

		return sc.getValidInt("Seleccione uma opcao ", 1, 3);
		
	}

}
