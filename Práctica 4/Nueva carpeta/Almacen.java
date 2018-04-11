package main;

import java.util.ArrayList;

public class Almacen<T> {
	private int tam;
	private ArrayList<T> buff;
	
	private int front;
	private int rear;
	
	private int contador;

	public Almacen (int tam) {
		this.tam = tam;
		front = 0;
		rear = 0;
		contador = 0;
		
		buff = new ArrayList<T>(tam);
		
		
	}
	
	public synchronized void almacenar(T producto) throws InterruptedException {
		while (contador == tam) {
			return;
		}
		buff.add(rear, producto);
		rear = (rear + 1) % tam;
		System.out.println("HAY " + Integer.toString(contador) + "PRDOUCTOS AJAJAJAJA");
		++contador;
		//despertar();		
	}
	
	public synchronized T extraer(T vacio) throws InterruptedException {
		while (contador == 0) {
			return null;
		}
		T t = buff.get(front);
		buff.set(front, vacio);
		front = (front + 1) % tam;
		--contador;
		//despertar();
		return t;
	}
	
	public synchronized void despertar() {
		notifyAll();
	}

}
