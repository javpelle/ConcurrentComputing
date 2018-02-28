package main;

public class Entero {
	private int num;
	private int numHilos;
	private volatile int last[];
	private volatile int in[];

	public Entero(int numHilos) {
		num = 0;
		last = new int[numHilos];
		in = new int[numHilos];
		for (int i = 0; i < numHilos; ++i) {
			last[i] = -1;
			in [i] = -1;
		}
	}

	public void incremento(int n, int iHilo) {
		for (int j = 0; j < numHilos; ++j) {
			in[iHilo] = j;
			last[j] = iHilo;			
			for (int k = 0; k < numHilos; ++k) {
				if (k != iHilo) {
					while (last[j] == iHilo && in[k] >= in[iHilo]) {
						last = last;
						in = in;
					}
				}
			}
		}
		num += n;
		in[iHilo] = -1;
	}

	public String toString() {
		return Integer.toString(num);
	}
}
