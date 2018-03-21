package main;

public class Producto {
	
	private int a;
	
	public Producto(int a) {
		this.a = a;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	public String toString() {
		return Integer.toString(a);
	}

}
