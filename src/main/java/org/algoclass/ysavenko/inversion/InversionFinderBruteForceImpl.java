package org.algoclass.ysavenko.inversion;

public class InversionFinderBruteForceImpl<T extends Comparable<T>> implements
	InversionFinder<T> {

    @Override
    public long find(T[] array) {
	long result = 0;
	for (int i = 0; i < array.length - 1; i++) {
	    for (int j = i + 1; j < array.length; j++) {
		if (array[i].compareTo(array[j]) > 0) {
		    result++;
		}
	    }
	}
	return result;
    }

}
