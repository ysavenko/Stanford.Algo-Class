package org.algoclass.ysavenko.multiplicity;

public class MultiplicationGradeSchoolImpl extends AbstractMultiplication implements Multiplication {

	public long multiply(long number1, long number2) {
		long result = 0;
		final int[] digits = getDigits(number2);
		for (int shift = 1, i = digits.length - 1; i >= 0; i--, shift *= 10) {
			result += number1 * digits[i] * shift;
		}
		return result;
	}

}
