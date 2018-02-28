package main;

public class MyThreadIncremento extends Thread {
	
	private Entero numerito;
	private int iteraciones;
	
	public MyThreadIncremento(Entero numerito, int iteraciones) {
		this.numerito = numerito;
		this.iteraciones = iteraciones;
	}

	public void run() {
		for (int i = 0; i < iteraciones; ++i)
			numerito.incremento();
	}
}
