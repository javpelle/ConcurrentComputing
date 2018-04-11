package main;

public class Entero {
	private int numerito;
	
	public Entero () {
		numerito = 0;
	}
	
	public synchronized void adicion (int i) {
		numerito += i;
	}
	
	public String toString() {
		return Integer.toString(numerito);
	}
}
