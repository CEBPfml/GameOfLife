package backend;

import java.util.concurrent.locks.Lock;

public class CelulaSexuata extends Celula implements Runnable {

	private boolean isReady;

	// primeste din afara un array list in care pune celulele nou create
	public CelulaSexuata(Food f, Lock l) {

		super(f);
		this.isReady = false;
	}

	public void reproduce() {
		System.out.println("Create a new cell.");
		this.isReady = true;

//		CelulaSexuata newCell = new CelulaSexuata(super.getFood(), super.getLock());
//		super.setNumberOfMeals(0);
//		Thread t = new Thread(newCell);
//		t.start();
	}

	public void setNewState(boolean isReady) {
		this.isReady = isReady;
	}

	public boolean getNewState() {
		return this.isReady;
	}

	public void run() {
		long start = System.currentTimeMillis();

		// at this moment the cell is hungry
		while(System.currentTimeMillis() - start < super.getStarvationTime()) {
			if(super.eat()) // if there is food, the cell eats
			{
				super.incrementMeals();
				if(super.getNumberOfMeals() == 10)
				{
					this.reproduce();
				}
				if(super.getNumberOfMeals() == 9)
				{
					this.reproduce();
				}
				long lastTimeAte = System.currentTimeMillis();
				// do nothing while the cell is full
				while(System.currentTimeMillis() - lastTimeAte > super.getFullTime()) {

				}
				start = System.currentTimeMillis(); // now the cell is hungry, reset the timer
			}

		}
		super.die(); // if there was no chance for the cell to eat while it was starving, the cell dies
	}
}
