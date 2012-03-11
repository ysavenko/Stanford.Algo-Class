package org.algoclass.ysavenko.sort;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class SorterTest {

    private Sorter<Integer> sorter;

    public SorterTest(Sorter<Integer> sorter) {
	this.sorter = sorter;
    }

    @Parameters
    public static Collection<Object[]> data() {
	final Object[][] data = new Object[][] { { new SorterMergeImpl<Integer>() } };
	return Arrays.asList(data);
    }

    @Test
    public void testSort_Empty() throws Exception {
	final Integer[] array = new Integer[0];
	sorter.sort(array);
	Assert.assertEquals(0, array.length);
    }

    @Test
    public void testSort_OneElement() throws Exception {
	final Integer[] array = new Integer[] { 6 };
	sorter.sort(array);
	Assert.assertArrayEquals(new Integer[] { 6 }, array);
    }

    @Test
    public void testSort_Sorted() throws Exception {
	final Integer[] array = new Integer[] { 1, 2, 3, 4 };
	sorter.sort(array);
	Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, array);
    }

    @Test
    public void testSort_ReversedEven() throws Exception {
	final Integer[] array = new Integer[] { 4, 3, 2, 1 };
	sorter.sort(array);
	Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4 }, array);
    }

    @Test
    public void testSort_ReversedOdd() throws Exception {
	final Integer[] array = new Integer[] { 5, 4, 3, 2, 1 };
	sorter.sort(array);
	Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testSort() throws Exception {
	final Integer[] array = new Integer[] { 5, 1, 3, 2, 4 };
	sorter.sort(array);
	Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, array);
    }
}
