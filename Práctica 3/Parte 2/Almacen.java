package main;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Almacen<T> {
	private int tam;
	private ArrayList<T> buff;
	private Semaphore empty;
	private Semaphore full;
	private Semaphore mutexD;
	private Semaphore mutexF;
	
	private int front;
	private int rear;

	public Almacen (int tam) {
		this.tam = tam;
		empty = new Semaphore(tam);
		full = new Semaphore(0);
		mutexD = new Semaphore(1);
		mutexF = new Semaphore(1);
		front = 0;
		rear = 0;
		
		buff = new ArrayList<T>(tam);
		
		
	}
	
	public void almacenar(T producto) throws InterruptedException {
		empty.acquire();
		mutexD.acquire();
		buff.add(rear, producto);
		rear = (rear + 1) % tam;
		mutexD.release();
		full.release();	
	}
	
	public T extraer() throws InterruptedException {
		full.acquire();
		mutexF.acquire();
		T t = buff.get(front);
		front = (front + 1) % tam;
		mutexF.release();
		empty.release();
		return t;
	}

}
