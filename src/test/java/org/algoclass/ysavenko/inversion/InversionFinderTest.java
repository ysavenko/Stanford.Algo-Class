package org.algoclass.ysavenko.inversion;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.algoclass.ysavenko.ArrayReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class InversionFinderTest {

    private InversionFinder<Integer> inversionFinder;

    public InversionFinderTest(InversionFinder<Integer> inversionFinder) {
	this.inversionFinder = inversionFinder;
    }

    @Parameters
    public static Collection<Object[]> data() {
	final Object[][] data = new Object[][] {
		{ new InversionFinderBruteForceImpl<Integer>() },
		{ new InversionFinderRecursiveImpl<Integer>() } };
	return Arrays.asList(data);
    }

    @Test
    public void testFind_NoInversions() throws Exception {
	inversionFinder.find(new Integer[] { 1, 2, 3, 4, 5 });
    }

    @Test
    public void testFind_OneInversion() throws Exception {
	Assert.assertEquals(1, inversionFinder.find(new Integer[] { 1, 3, 2 }));
    }

    @Test
    public void testFind() throws Exception {
	Assert.assertEquals(5,
		inversionFinder.find(new Integer[] { 1, 7, 4, 6, 2 }));
    }

    @Test
    public void testFind_BigArray() throws Exception {
	Assert.assertEquals(2407905288L,
		inversionFinder.find(ArrayReader.read()));
    }
}
