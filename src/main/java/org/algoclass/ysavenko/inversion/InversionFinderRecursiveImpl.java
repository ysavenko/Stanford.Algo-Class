package org.algoclass.ysavenko.inversion;

import java.util.Arrays;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class InversionFinderRecursiveImpl<T extends Comparable<T>> implements
	InversionFinder<T> {

    @Override
    public long find(T[] array) {
	final int length = array.length;
	if (length <= 1) {
	    return 0;
	}

	return find(Arrays.copyOf(array, length / 2))
		+ find(Arrays.copyOfRange(array, length / 2, length))
		+ findMixed(array);
    }

    private long findMixed(T[] array) {
	throw new NotImplementedException();
    }

}
