package io.altar.jseproject.textinterface.ScannerUtils;

import java.util.Scanner;

public class ScannerUtils {
	private Scanner sc = new Scanner(System.in);
	private Scanner lineSc;

	public String getValue() {
		return sc.nextLine();
//		System.out.println(msg);
//		String result = sc.nextLine();
//		return result;
	}

	public boolean isInt(String value) {
		lineSc = new Scanner(value);
		return lineSc.hasNextInt();
	}

	public int toInt(String value) {
		lineSc = new Scanner(value);
		return lineSc.nextInt();
	}

	public int getInt(String msg) { // variavel com o mesmo nome, mas é outra variavel
		boolean valid = false;
		int result = 0;
		do {
			System.out.println(msg);
			String value = getValue();
			if (isInt(value)) {
				valid = true;
				result = toInt(value);
			}
		} while (!valid);
		return result;

//		while (true) {
//
//			String value = getValue(msg);
//			Scanner sc2 = new Scanner(value);
//			if (sc2.hasNextInt()) {
//				return sc2.nextInt();
//
//			} else {
//				sc2.nextLine();
//			}
//			sc2.close();
//		}
	}

	public int getValidInt(String msg, int[] iva) {
		while (true) {
			int value = getInt(msg);

			boolean check = false;
			for (int i = 0; i < iva.length; i++) {
				if (value == iva[i]) {
					check = true;
					return value;
				}
			}
			if (check == false) {
				System.out.println("Select a valid option");
			}
		}
	}

	public int getValidInt(String msg, int min, int max) {
//		int value = getInt(msg);
//		if (value < min || value > max) {
//			String myMsg = msg + min + " e " + max;
//			
//		}
//		else {
//			return value;
//		}
//		
		int value;
		do {
			String myMsg = msg + min + " and " + max;
			value = getInt(myMsg);
		} while (value < min || value > max);
		return value;
	}

}

