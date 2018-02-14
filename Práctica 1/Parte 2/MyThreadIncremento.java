package main;

public class MyThreadIncremento extends Thread {
	
	private Enterititi numerito;
	private int iteraciones;
	
	public MyThreadIncremento(Enterititi numerito, int iteraciones) {
		this.numerito = numerito;
		this.iteraciones = iteraciones;
	}

	public void run() {
		for (int i = 0; i < iteraciones; ++i)
			numerito.incremento();
	}
}
