package backend;

import java.util.Random;
import java.util.concurrent.locks.Lock;

public abstract class Celula {
	private int timeFull = 5000;
	private int timeStarve = 10000;
	private int numberOfMeals;
	private Food food = null;
	private Lock lock = null;
	private Random rand;

	public Celula(Food f, Lock l) {
		this.food = f;
		this.lock = l;
		this.rand = new Random();
		this.numberOfMeals = 0;
	}

	public abstract void reproduce();

	public void eat() {
		System.out.println("Eating...");
		//lock.lock();
		this.food.decrementUnits();
		numberOfMeals++;
		/*int fUnits = this.food.getFoodUnits();
		System.out.println("Food remaining after I ate: " + fUnits);*/
		//lock.unlock();
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public int getFullTime() {
		return this.timeFull;
	}

	public int getStarvationTime() {
		return this.timeStarve;
	}

	public void die() {
		System.out.println("I'm dying!");
		int randNumberOfFood = rand.nextInt(5);
		//lock.lock();
		int fUnits = food.getFoodUnits();
		food.setFoodUnits(fUnits + randNumberOfFood);
		//lock.unlock();
		fUnits = this.food.getFoodUnits();
		System.out.println("Food after I died: " + fUnits);
	}

	public int getFoodUnits() {
		return this.food.getFoodUnits();
	}

	public Food getFood() {
		return this.food;
	}

	public Lock getLock() {
		return this.lock;
	}

	public int getNumberOfMeals() {
		return this.numberOfMeals;
	}

	public void setNumberOfMeals(int value)
	{
		this.numberOfMeals = value;
	}

	public void incrementMeals() {
		this.numberOfMeals++;
	}
}
