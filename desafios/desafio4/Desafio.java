package pt.upacademy.desafios.desafio4;

import java.util.Arrays;

public class Desafio {

	public static int[] ints(String string) {
		
		String [] newString = string.split(" ");
		
		
		System.out.println(Arrays.toString(newString));
		
	
		
		//criar um arraylist e adicionar os qsao numericos
		for (int i = 0; i < newString.length; i++) {

			
			System.out.println(newString[i]);
		
			if (newString[i].matches("^[0-9]*$")){
					
				
				
			}
					
				
				
				
					//Character.isDigit(newString[i]);
					 
				
			}
			
			
			
		
		
		
		return null;
	}

}
