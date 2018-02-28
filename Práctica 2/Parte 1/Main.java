package main;

public class Main {
	static final int N = 10000;

	public static void main(String args[]) {
		Entero num = new Entero();
		MyThreadIncremento hiloInc = new MyThreadIncremento(num, N);
		MyThreadDecremento hiloDec = new MyThreadDecremento(num, N);
		hiloInc.start();
		hiloDec.start();
		try {
				hiloInc.join();
				hiloDec.join();
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		
		System.out.println(num.toString());
	}
}
