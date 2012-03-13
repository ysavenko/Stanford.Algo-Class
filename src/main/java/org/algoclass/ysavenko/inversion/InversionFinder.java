package org.algoclass.ysavenko.inversion;

public interface InversionFinder<T extends Comparable<T>> {

    long find(T[] array);
}
