package org.algoclass.ysavenko.multiplication.number;

public class AbstractNumberMultiplication {

    protected int[] getDigits(long number) {
	final long i = number / 10;
	if (i == 0) {
	    return new int[] { (int) number };
	}
	final int[] digits = getDigits(i);
	int[] result = new int[digits.length + 1];
	System.arraycopy(digits, 0, result, 0, digits.length);
	result[result.length - 1] = (int) (number - i * 10);
	return result;
    }

    protected long powerTen(int n) {
	return n == 0 ? 1 : 10 * powerTen(n - 1);
    }

    protected int getLength(long number) {
	return getDigits(number).length;
    }

    protected boolean isOdd(long number) {
	return number % 2 == 0;
    }

}