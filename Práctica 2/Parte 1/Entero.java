package main;

public class Entero {
	private int num;
	private volatile boolean turno; 
	
	public Entero () {
		num = 0;
		turno = true;
	}
	
	public void incremento() {
		while(turno);
		++num;
		turno = true;
	}
	
	public void decremento() {
		while(!turno);
		--num;
		turno = false;
	}
	
	public String toString() {
		return Integer.toString(num);
	}
}
