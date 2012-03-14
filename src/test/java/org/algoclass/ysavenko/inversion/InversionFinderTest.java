package org.algoclass.ysavenko.inversion;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.algoclass.ysavenko.ArrayReader;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class InversionFinderTest {

    private InversionFinder<Integer> inversionFinder;

    private static Integer[] bigArray;

    public InversionFinderTest(InversionFinder<Integer> inversionFinder) {
	this.inversionFinder = inversionFinder;
    }

    @BeforeClass
    public static void setUp() throws Exception {
	bigArray = ArrayReader.read();
    }

    @Parameters
    public static Collection<Object[]> data() {
	final Object[][] data = new Object[][] {
		{ new InversionFinderBruteForceImpl<Integer>() },
		{ new InversionFinderRecursiveImpl<Integer>() } };
	return Arrays.asList(data);
    }

    @Test
    public void testFind_NoInversions() {
	inversionFinder.count(new Integer[] { 1, 2, 3, 4, 5 });
    }

    @Test
    public void testFind_OneInversion() {
	Assert.assertEquals(1, inversionFinder.count(new Integer[] { 1, 3, 2 }));
    }

    @Test
    public void testFind_Reverted() {
	final Integer[] array = new Integer[] { 6, 5, 4, 3, 2, 1 };
	Assert.assertEquals(array.length * (array.length - 1) / 2,
		inversionFinder.count(array));
    }

    @Test
    public void testFind_OddLengthArray() {
	Assert.assertEquals(5,
		inversionFinder.count(new Integer[] { 1, 7, 4, 6, 2 }));
    }

    @Test
    public void testFind_EvenLengthArray() {
	Assert.assertEquals(8,
		inversionFinder.count(new Integer[] { 1, 7, 4, 3, 6, 2 }));
    }

    @Test
    public void testFind_BigArray() {
	Assert.assertEquals(2407905288L, inversionFinder.count(bigArray));
    }
}
