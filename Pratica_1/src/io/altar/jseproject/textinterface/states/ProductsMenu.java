package io.altar.jseproject.textinterface.states;



public class ProductsMenu extends State{
	
	
	@Override
	public int run() {
				
		System.out.println("Menu dos produtos.\n"+ "Estes sao os produtos atualmente existentes: \n");
		// Os campos a apresentar s�o � sua escolha, sendo apenas o campo ID origat�rio.
		System.out.println(productsDataBase.getAll());
		
		System.out.println("\n Por favor selecione uma das seguintes opcoes:\n" + "\t 1) Criar novo produto\n"
				+ "\t 2) Editar um produto existente\n" + "\t 3) Consultar o detalhe de um produto\n"
				+ "\t 4) Remover um produto\n" + "\t 5) Voltar ao ecra anterior (Menu inicial)");
		return sc.getValidInt("Seleccione uma opcao ", 1, 5);
		
	}

}
