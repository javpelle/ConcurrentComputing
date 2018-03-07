package main;

public class Entero {
	private volatile int num;
	private int numHilos;
	private volatile int turno[];

	public Entero(int numHilos) {
		this.numHilos = numHilos;
		num = 0;
		turno = new int[numHilos];
	}

	public void incremento(int n, int iHilo) {
		turno[iHilo] = 1;
		for (int i = 0; i < numHilos; ++i) {
			turno = turno;
			if (turno[i] > turno[iHilo]) turno[iHilo] = turno[i] + 1;
		}
		for (int j = 0; j < numHilos; ++j) {
			if (j != iHilo) {
				while (turno[j] != 0 && mayor(iHilo, j));
			}
		}
		num += n;
		turno[iHilo] = 0;
	}

	private boolean mayor(int iHilo, int j) {
		return turno[iHilo] > turno [j] || (turno[iHilo] == turno[j] && iHilo > j);
	}

	public String toString() {
		return Integer.toString(num);
	}
}
