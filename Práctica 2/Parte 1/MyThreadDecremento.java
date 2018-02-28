package main;

public class MyThreadDecremento extends Thread {
	
	private Entero numerito;
	private int iteraciones;
	
	public MyThreadDecremento(Entero numerito, int iteraciones) {
		this.numerito = numerito;
		this.iteraciones = iteraciones;
	}

	public void run() {
		for (int i = 0; i < iteraciones; ++i)
			numerito.decremento();
	}
}
