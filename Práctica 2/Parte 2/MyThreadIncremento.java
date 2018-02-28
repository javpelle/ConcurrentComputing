package main;

public class MyThreadIncremento extends Thread {
	
	private Entero numerito;
	private int iteraciones;
	private int iHilo;
	
	public MyThreadIncremento(Entero numerito, int iteraciones, int iHilo) {
		this.numerito = numerito;
		this.iteraciones = iteraciones;
		this.iHilo = iHilo;
	}

	public void run() {
		for (int i = 0; i < iteraciones; ++i)
			numerito.incremento(1, iHilo);
	}
}
