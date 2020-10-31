package backend;

import java.util.concurrent.locks.Lock;

public class CelulaAsexuata extends Celula implements Runnable{
	
	public CelulaAsexuata(Food f, Lock l) {
		super(f, l);
	}

	public void reproduce() {
		System.out.println("Creating a new cell.");
		CelulaAsexuata newCell = new CelulaAsexuata(super.getFood(), super.getLock());
		super.setNumberOfMeals(0);
		Thread t = new Thread(newCell);
		t.start();
	}
	
	public void run() {
		long start = System.currentTimeMillis();
		
		// at this moment the cell is hungry
		while(System.currentTimeMillis() - start < super.getStarvationTime()) {
			int currentFood = super.getFoodUnits();
			System.out.println("Food units: " + currentFood);
			System.out.println(Thread.currentThread().getName());
			System.out.println();
			if(currentFood > 0) // if there is food, the cell eats
			{
				//super.getLock().lock();
				super.eat(); // the cell is full now
				//super.getLock();
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
