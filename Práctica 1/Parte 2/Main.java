package main;

public class Main {
	static final int N = 100;
	static final int M = 100;

	public static void main(String args[]) {
		Enterititi numR = new Enterititi();
		MyThreadIncremento hilitosIncrementadores[] = new MyThreadIncremento[M];
		MyThreadDecremento hilitosDecrementadores[] = new MyThreadDecremento[M];

		for (int i = 0; i < M; ++i) {
			hilitosIncrementadores[i] = new MyThreadIncremento(numR, N);
			hilitosDecrementadores[i] = new MyThreadDecremento(numR, N);
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
		
		System.out.println("Stop");
		System.out.println(numR.toString());
	}
}
