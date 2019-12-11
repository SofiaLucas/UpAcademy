package pt.upacademy.desafios.desafio2;

import java.util.Arrays;
//import java.util.regex.Matcher;

public class Desafio {

	public static String order(String string) {

		String[] array = string.split(" ");

		System.out.println(Arrays.toString(array));

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < 9; i++) {

			for (String word : array) {

				if (word.contains(Integer.toString(i)) == true) {

					result.append(" " + word);

					break;
				}
			}

		}
		String finalResult = result.toString().trim();
		

		return finalResult;
	}

}
