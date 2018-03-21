package main;

public class Consumidor<T> extends Thread {
	private Almacen<T> almacen;
	
	public Consumidor (Almacen<T> a) {
		this.almacen = a;
	}
	
	public void run() {
		while (true) {
			try {
				System.out.println(almacen.extraer().toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
