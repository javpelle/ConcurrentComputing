package main;

public class Main {
	static final int N = 1;
	static final int M = 10000;

	public static void main(String args[]) {
		Entero num = new Entero(2*M);
		MyThreadIncremento hilosInc[] = new MyThreadIncremento[M];
		MyThreadDecremento hilosDec[] = new MyThreadDecremento[M];

		for (int i = 0; i < M; ++i) {
			hilosInc[i] = new MyThreadIncremento(num, N, 2*i);
			hilosDec[i] = new MyThreadDecremento(num, N, 2*i + 1);
			hilosInc[i].start();
			hilosDec[i].start();
		}

		for (int i = 0; i < M; ++i) {
			try {
				hilosInc[i].join();
				hilosDec[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(num.toString());
	}
}
