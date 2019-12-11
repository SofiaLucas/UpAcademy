package pt.upacademy.desafios.desafio1;

public class Desafio {
	private int numCicles;
	private int big3Count;
	private int big5Count;

	public Desafio(int i) {
		this.numCicles = i;

	}

	public void run() {
		big3Count = 0;
		big5Count = 0;
		for (int i = 1; i <= numCicles; i++) {

			if (i % 3 == 0) {
				big3Count += 1;
			} if (i % 5 == 0) {
				big5Count += 1;
			}
		}
	}

	public int getBig3Count() {
		return big3Count;
	}

	public int getBig5Count() {

		return big5Count;
	}

}
