package main;

import java.util.concurrent.Semaphore;

public class MyThreadIncremento extends Thread {

	private Entero numerito;
	private int iteraciones;
	private Semaphore s;
	private int suma;

	public MyThreadIncremento(int suma, Entero numerito, int iteraciones,
			Semaphore s) {
		this.suma = suma;
		this.numerito = numerito;
		this.iteraciones = iteraciones;
		this.s = s;
	}

	public void run() {
		for (int i = 0; i < iteraciones; ++i) {
			try {
				s.acquire();
				numerito.adicion(suma);
				s.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
