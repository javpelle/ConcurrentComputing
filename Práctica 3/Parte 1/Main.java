package main;

import java.util.concurrent.Semaphore;

public class Main {
	static final int N = 100;
	static final int M = 100;

	public static void main(String args[]) {
		Entero numeritoReshulon = new Entero();
		MyThreadIncremento hilitosIncrementadores[] = new MyThreadIncremento[M];
		MyThreadIncremento hilitosDecrementadores[] = new MyThreadIncremento[M];
		Semaphore s = new Semaphore(1);

		for (int i = 0; i < M; ++i) {
			hilitosIncrementadores[i] = new MyThreadIncremento(1,
					numeritoReshulon, N, s);
			hilitosDecrementadores[i] = new MyThreadIncremento(-1,
					numeritoReshulon, N, s);
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
		System.out.println(numeritoReshulon.toString());
	}
}
