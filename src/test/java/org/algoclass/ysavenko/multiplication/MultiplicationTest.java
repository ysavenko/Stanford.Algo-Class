package org.algoclass.ysavenko.multiplication;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.algoclass.ysavenko.multiplication.Multiplication;
import org.algoclass.ysavenko.multiplication.MultiplicationGradeSchoolImpl;
import org.algoclass.ysavenko.multiplication.MultiplicationKaratsubaImpl;
import org.algoclass.ysavenko.multiplication.MultiplicationRecursiveImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class MultiplicationTest {

	private Multiplication multiplication;

	public MultiplicationTest(Multiplication multiplication) {
		this.multiplication = multiplication;
	}

	@Parameters
	public static Collection<Object[]> data() {
		final Object[][] data = new Object[][] { { new MultiplicationGradeSchoolImpl() },
		    { new MultiplicationRecursiveImpl() }, { new MultiplicationKaratsubaImpl() } };
		return Arrays.asList(data);
	}

	@Test
	public void testMultiply_ByZero() throws Exception {
		Assert.assertEquals(0L, multiplication.multiply(0L, 1L));
		Assert.assertEquals(0l, multiplication.multiply(1L, 0L));
	}

	@Test
	public void testMultiply() throws Exception {
		Assert.assertEquals(20L, multiplication.multiply(4L, 5L));
		Assert.assertEquals(2352L, multiplication.multiply(42L, 56L));
		Assert.assertEquals(240264L, multiplication.multiply(423L, 568L));
		Assert.assertEquals(24066056L, multiplication.multiply(4234L, 5684L));
		Assert.assertEquals(2407116024L, multiplication.multiply(42346L, 56844L));
		Assert.assertEquals(2406917447159115L, multiplication.multiply(42343367L, 56842845L));
	}

	@Test
	public void testMultiply_Symetry() throws Exception {
		Assert.assertEquals(2406917447159115L, multiplication.multiply(42343367L, 56842845L));
		Assert.assertEquals(2406917447159115L, multiplication.multiply(56842845L, 42343367L));
	}

}
