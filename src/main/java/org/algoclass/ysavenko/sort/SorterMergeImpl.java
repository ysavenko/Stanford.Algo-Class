package org.algoclass.ysavenko.sort;

import java.util.Arrays;

public class SorterMergeImpl<T extends Comparable<T>> implements Sorter<T> {

    public void sort(T[] array) {
	final int length = array.length;
	if (length <= 1) {
	    return;
	}

	final T[] left = Arrays.copyOf(array, length / 2);
	final T[] right = Arrays.copyOfRange(array, length / 2, length);

	sort(left);
	sort(right);

	for (int i = 0, j = 0, k = 0; k < length; k++) {
	    final boolean jOutOfBounds = j >= right.length;
	    final boolean iInBounds = i < left.length;
	    if (jOutOfBounds || (iInBounds && left[i].compareTo(right[j]) < 0)) {
		array[k] = left[i++];
	    } else {
		array[k] = right[j++];
	    }
	}
    }

}
