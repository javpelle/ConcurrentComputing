package main;

import java.util.ArrayList;

public class Main {
	
	private static final int N_PRODUCTOS = 5;
	private static final int N_CONSUMIDORES = 25;
	private static final int N_PRODUCTORES = 30;

	public static void main(String args[]) {
		
		Almacen<Producto> a = new Almacen<Producto>(N_PRODUCTOS);
		ArrayList<Productor<Producto>> prod  = new ArrayList<Productor<Producto>>();
		ArrayList<Consumidor<Producto>> cons  = new ArrayList<Consumidor<Producto>>();
		
		Producto vacio = new Producto(-1);
		
		for (int i = 0; i < N_CONSUMIDORES; ++i) {
			cons.add(new Consumidor<Producto>(a, vacio));
			cons.get(i).start();
			
		}
		
		Producto lista [] = {new Producto(1), new Producto(2), new Producto(3)}; 
		
		for (int i = 0; i < N_PRODUCTORES; ++i) {
			prod.add(new Productor<Producto>(a, lista));
			prod.get(i).start();
		}
		
		for (int i = 0; i < N_CONSUMIDORES; ++i) {
			try {
				cons.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < N_PRODUCTORES; ++i) {
			try {
				prod.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


	}
}
