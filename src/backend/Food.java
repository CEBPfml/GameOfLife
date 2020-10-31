package backend;

import java.util.concurrent.atomic.AtomicInteger;

public class Food {
	
	public static AtomicInteger foodUnits; // variable accessed by multiple threads, needs to be protected
	
	public Food(int fUnits) {
		foodUnits = new AtomicInteger(fUnits);
	}

	public static synchronized AtomicInteger getFoodUnits() {
		return foodUnits;
	}

	public static synchronized void setFoodUnits(int fUnits) {
		foodUnits = new AtomicInteger(fUnits);
	}
	

}
