package backend;

import java.util.concurrent.locks.Lock;

public class CelulaSexuata extends Celula implements Runnable {

	private boolean isReady;
	private Service service = new Service();
	private Food f;
	private Lock l;

	// primeste din afara un array list in care pune celulele nou create
	public CelulaSexuata(Food f, Lock l) {

		super(f);
		this.isReady = false;
		this.f = f;
		this.l = l;
	}

	public void reproduce() {
		System.out.println("Create a new cell.");
		this.isReady = true;

		for(int index = 0; index <= service.getCells().length; index++) {
			if(service.getCells()[index].getNewState() == service.getCells()[index+1].getNewState()) {
				CelulaSexuata celll = new CelulaSexuata(f, l);

				service.setCell(celll);

				Thread thread = new Thread(celll);
				thread.start();
			}
		}

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
				//super.getLock().lock();
				System.out.println("PQPQPQ");
				super.eat(); // the cell is full now
				//super.getLock();
				System.out.println("No of meals: " + super.getNumberOfMeals());

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
