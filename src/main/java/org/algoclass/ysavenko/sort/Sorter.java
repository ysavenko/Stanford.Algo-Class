package org.algoclass.ysavenko.sort;

public interface Sorter<T extends Comparable<T>> {
    void sort(T[] array);
}
