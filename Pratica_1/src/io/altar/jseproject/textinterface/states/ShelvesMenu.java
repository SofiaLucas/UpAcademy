package io.altar.jseproject.textinterface.states;

public class ShelvesMenu extends State{

	

	@Override
	public int run() {
		System.out.println(
				"Menu das prateleiras.\n"+"Estes sao as prateleiras atualmente existentes: \n");
		System.out.println(shelvesDataBase.getAll());
		
		System.out.println("\n Por favor selecione uma das seguintes opcoes:\n" + "\t 1) Criar nova prateleira\n"
				+ "\t 2) Editar um prateleira existente\n" + "\t 3) Consultar o detalhe de uma prateleira\n"
				+ "\t 4) Remover uma prateleira\n" + "\t 5) Voltar ao ecrã anterior");

		
		return sc.getValidInt("Seleccione uma opcao ", 1, 5);
	}
}
