package backend;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import java.util.*;

import backend.*;

public class Service {

    private CelulaSexuata[] cells = new CelulaSexuata[20];

    public static CelulaSexuata[] add_element(int n, CelulaSexuata myarray[], CelulaSexuata ele) {

        int i;

        CelulaSexuata newArray[] = new CelulaSexuata[n + 1];
        // copy original array into new array
        for (i = 0; i < n; i++)
        newArray[i] = myarray[i];

        // add element to the new array
        newArray[n] = ele;

        return newArray;
    }

    public void setCell(CelulaSexuata cell) {
        this.cells = add_element(this.cells.length, this.cells, cell);
    }

    public CelulaSexuata[] getCells() {
        return this.cells;
    }
}
