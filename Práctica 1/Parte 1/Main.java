package main;

public class Main {
	static final int N = 10;
	static final long T = 2000;

	public static void main (String args[]) {
		MyThread hilitos[] = new MyThread[N]; 
		
		for (int i = 0; i < N; ++i) {
			hilitos[i] = new MyThread(i, T);
			hilitos[i].start();
		}
		
		for (MyThread thread : hilitos) {
			  try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("EI MAN, LUS CHOCOPOS BA N AVAU HAHAHAA");
	}
}
