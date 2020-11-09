package backend;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import java.util.*;

import backend.*;

public class Main {

	private ArrayList<CelulaSexuata> cells = new ArrayList<CelulaSexuata>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Food f = new Food(30);
		Lock l = new ReentrantLock();
		CelulaAsexuata c = new CelulaAsexuata(f, l);
		Thread t = new Thread(c);

		createListOfSexuateCells(f, l);

		t.start();
	}

	private void createListOfSexuateCells(Food f, Lock l) {

		CelulaSexuata cell1 = new CelulaSexuata(f, l);
		CelulaSexuata cell2 = new CelulaSexuata(f, l);

		this.cells.add(cell1);
		this.cells.add(cell2);
	}

	private void verifyIfCellReadyInList(CelulaSexuata cell, Food f, Lock l) {

		for(CelulaSexuata celula : this.cells) {
			if(celula.getNewState() == cell.getNewState()) {
				this.cells.add(new CelulaSexuata(f, l));
			}
		}
	}
}
