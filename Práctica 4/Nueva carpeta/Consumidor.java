package main;

public class Consumidor<T> extends Thread {
	private Almacen<T> almacen;
	private T vacio;
	
	public Consumidor (Almacen<T> a, T vacio) {
		this.almacen = a;
		this.vacio = vacio;
	}
	
	public void run() {
		while (true) {
			try {
				System.out.println(almacen.extraer(vacio).toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("jaja si no hay productos");
			}
		}
	}
	
}
