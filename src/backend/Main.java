package backend;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Food f = new Food(30);
		Lock l = new ReentrantLock();
		CelulaAsexuata c = new CelulaAsexuata(f, l);
		Thread t = new Thread(c);
		t.start();
	}

}
