package pt.upacademy.desafios.desafio3;

import java.util.Arrays;

public class Desafio {

	public static int points(String[] strings) {

		System.out.println(Arrays.toString(strings));
		int result = 0;

		for (int i = 0; i < strings.length; i++) {

			
			if(strings[i].charAt(0)==strings[i].charAt(2)) {
				result +=1;				
			}
			else if (strings[i].charAt(0)>strings[i].charAt(2)) {
				result += 3;
			}
			
						
			
//			int[] matches = Arrays.stream(strings[i].split(":")).mapToInt(Integer::parseInt).toArray();
//			// System.out.println(Arrays.toString(matches));
///			
//			
//			
//			for (int j = 0; j < matches.length; j++) {
//				if (matches(0) == matches(1)) {
//					result += 1;
//				}
//				else if (matches(0) > matches(1)) {
//					result += 3;
//				}
//				
//			}

		}

		return result;

	}

}
