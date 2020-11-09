package backend;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import java.util.*;

import backend.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Food f = new Food(30);
		Lock l = new ReentrantLock();
		CelulaAsexuata c = new CelulaAsexuata(f, l);
		Thread t = new Thread(c);

//		CelulaSexuata cell1 = new CelulaSexuata(f, l);
//		CelulaSexuata cell2 = new CelulaSexuata(f, l);
//
//		Service service = new Service();
//
//		service.setCell(cell1);
//		service.setCell(cell2);
//
//		Thread thread1 = new Thread(cell1);
//		Thread thread2 = new Thread(cell2);
//
//		thread1.start();
//		thread2.start();

		t.start();
	}

}
