package main;

public class MyThreadDecremento extends Thread {
	
	private Enterititi numerito;
	private int iteraciones;
	
	public MyThreadDecremento(Enterititi numerito, int iteraciones) {
		this.numerito = numerito;
		this.iteraciones = iteraciones;
	}

	public void run() {
		for (int i = 0; i < iteraciones; ++i)
			numerito.decremento();
	}
}
