package org.algoclass.ysavenko.multiplication.number;

public class NumberMultiplicationGradeSchoolImpl extends
	AbstractNumberMultiplication implements NumberMultiplication {

    @Override
    public Long multiply(Long number1, Long number2) {
	long result = 0;
	final int[] digits = getDigits(number2);
	for (int shift = 1, i = digits.length - 1; i >= 0; i--, shift *= 10) {
	    result += number1 * digits[i] * shift;
	}
	return result;
    }

}
