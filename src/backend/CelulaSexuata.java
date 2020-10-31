package backend;

import java.util.concurrent.locks.Lock;

public class CelulaSexuata extends Celula implements Runnable{
	
	// primeste din afara un array list in care pune celulele nou create
	public CelulaSexuata(Food f, Lock l) {
		super(f, l);
	}

	public void reproduce() {
		
	}
	
	public void run() {
		
	}
}
