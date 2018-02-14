package main;

public class MyThread extends Thread {
	private long timeMili;
	private int id;

	public MyThread(int id, long timeMili) {
		this.timeMili = timeMili;
		this.id = id;
	}

	public void run() {
		System.out.println(id);
		try {
			sleep(timeMili);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(id);
	}
}
