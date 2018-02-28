package main;

public class MyThreadDecremento extends Thread {
	
	private Entero numerito;
	private int iteraciones;
	private int iHilo;
	
	public MyThreadDecremento(Entero numerito, int iteraciones, int iHilo) {
		this.numerito = numerito;
		this.iteraciones = iteraciones;
		this.iHilo = iHilo;
	}

	public void run() {
		for (int i = 0; i < iteraciones; ++i)
			numerito.incremento(-1, iHilo);
	}
}
