package backend;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import backend.*;

public class Main {

//	private ArrayList<CelulaSexuata> cells = new ArrayList<CelulaSexuata>();

	public static void main(String[] args) {
		ConfigLoader configLoader = new ConfigLoader();
		int food_units = Integer.parseInt(configLoader.getProperty("food_units"));
		Food f = new Food(food_units);

		CelulaAsexuata c = new CelulaAsexuata(f);
		Thread t = new Thread(c);
		t.start();
//		CelulaAsexuata c = new CelulaAsexuata(f, l);
//		Thread t = new Thread(c);

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

	}

}
