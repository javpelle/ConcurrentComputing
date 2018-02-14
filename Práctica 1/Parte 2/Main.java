package main;

public class Main {
	static final int N = 100;
	static final int M = 100;

	public static void main(String args[]) {
		Enterititi numeritoReshulon = new Enterititi();
		MyThreadIncremento hilitosIncrementadores[] = new MyThreadIncremento[M];
		MyThreadDecremento hilitosDecrementadores[] = new MyThreadDecremento[M];

		for (int i = 0; i < M; ++i) {
			hilitosIncrementadores[i] = new MyThreadIncremento(numeritoReshulon, N);
			hilitosDecrementadores[i] = new MyThreadDecremento(numeritoReshulon, N);
			hilitosIncrementadores[i].start();
			hilitosDecrementadores[i].start();
		}

		for (int i = 0; i < M; ++i) {
			try {
				hilitosIncrementadores[i].join();
				hilitosDecrementadores[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("EI MAN, LUS CHOCOPOS BA N AVAU HAHAHAA");
		System.out.println(numeritoReshulon.toString());
	}
}
