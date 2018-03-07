package main;

import java.util.concurrent.atomic.AtomicInteger;

public class Entero {
	private volatile int num;
	private volatile int siguiente;
	private AtomicInteger ticket;
	private int numHilos;
	private volatile int turno[];

	public Entero(int numHilos) {
		this.numHilos = numHilos;
		num = 0;
		siguiente = 0;
		ticket = new AtomicInteger();
		turno = new int[this.numHilos];
		for (int i = 0; i < this.numHilos; ++i) {
			turno[i] = -1;
		}
		
	}

	public void incremento(int n, int iHilo) {
		turno[iHilo] = ticket.getAndIncrement();
		while (turno[iHilo] != siguiente);
		num += n;
		++siguiente;
	}

	public String toString() {
		return Integer.toString(num);
	}
}
