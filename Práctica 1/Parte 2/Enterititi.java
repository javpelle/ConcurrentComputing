package main;

public class Enterititi {
	private int numerito;
	
	public Enterititi () {
		numerito = 0;
	}
	
	public void incremento() {
		++numerito;
	}
	
	public void decremento() {
		--numerito;
	}
	
	public String toString() {
		return Integer.toString(numerito);
	}
}
