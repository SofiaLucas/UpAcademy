package io.altar.jseproject.textinterface.ScannerUtils;

import java.util.Scanner;

public class ScannerUtils {
	private Scanner sc = new Scanner(System.in);
	private Scanner lineSc;

	public String getValue() {
		return sc.nextLine();
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
				System.out.println("Select a valid option (23,13,6)");
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

	//***********************************
	//				 FLOATS!!
	// **********************************
	public boolean isFloat(String value) {
		lineSc = new Scanner(value);
		return lineSc.hasNextFloat();
	}
	
	public float toFloat(String value) {
		lineSc = new Scanner(value);
		return lineSc.nextFloat();
	}
	
	public float getFloat(String msg) { // variavel com o mesmo nome, mas é outra variavel
		boolean valid = false;
		float result = 0;
		do {
			System.out.println(msg);
			String value = getValue();
			if (isFloat(value)) {
				valid = true;
				result = toFloat(value);
			}
		} while (!valid);
		return result;
	}
	
		
	
	//***********************************
	//				 LONGS!!
	// **********************************
	
	
	public boolean isLong(String value) {
		lineSc = new Scanner(value);
		return lineSc.hasNextLong();
	}

	public long toLong(String value) {
		lineSc = new Scanner(value);
		return lineSc.nextLong();
	}
		
		public long getLong(String msg) { // variavel com o mesmo nome, mas é outra variavel
			boolean valid = false;
			long result = 0;
			do {
				System.out.println(msg);
				String value = getValue();
				if (isLong(value)) {
					valid = true;
					result = toLong(value);
				}
			} while (!valid);
			return result;
	}
		
		public long getValidLong(String msg, long min, long max) {
			long value;
			do {
				String myMsg = msg + "(" + min + " - " + max + ")";
				value = getLong(myMsg);
			} while (value < min || value > max);
			return value;
		}
}

