package org.algoclass.ysavenko.inversion;

import java.util.Arrays;

public class InversionFinderRecursiveImpl<T extends Comparable<T>> implements
	InversionFinder<T> {

    @Override
    public long count(T[] array) {
	return countAndSort(Arrays.copyOf(array, array.length));
    }

    public long countAndSort(T[] array) {
	final int length = array.length;
	if (length <= 1) {
	    return 0;
	}

	final T[] left = Arrays.copyOf(array, length / 2);
	final T[] right = Arrays.copyOfRange(array, length / 2, length);

	long result = countAndSort(left) + countAndSort(right);

	for (int i = 0, j = 0, k = 0; k < length; k++) {
	    final boolean jOutOfBounds = j >= right.length;
	    final boolean iInBounds = i < left.length;
	    if (jOutOfBounds || (iInBounds && left[i].compareTo(right[j]) < 0)) {
		array[k] = left[i++];
	    } else {
		result += left.length - i;
		array[k] = right[j++];
	    }
	}

	return result;
    }

}
