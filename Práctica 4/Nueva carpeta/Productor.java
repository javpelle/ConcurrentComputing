package main;

public class Productor<T> extends Thread {
	private Almacen<T> almacen;
	private T[] list;

	public Productor(Almacen<T> a, T[] list) {
		this.almacen = a;
		this.list = list;
	}

	public void run() {
		while (true) {
			try {
				almacen.almacenar(list[(int) (Math.random() * list.length)]);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
