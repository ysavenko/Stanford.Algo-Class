package org.algoclass.ysavenko.multiplication.number;

public class NumberMultiplicationRecursiveImpl extends AbstractNumberMultiplication
	implements NumberMultiplication {

    public Long multiply(Long number1, Long number2) {

	final int n = Math.max(getLength(number1), getLength(number2));
	final int n2 = n / 2;

	if (n == 1) {
	    return number1 * number2;
	}

	final long powerTenN2 = powerTen(n2);

	final long a = number1 / powerTenN2;
	final long b = number1 - a * powerTenN2;
	final long c = number2 / powerTenN2;
	final long d = number2 - c * powerTenN2;

	return powerTenN2 * powerTenN2 * multiply(a, c) + powerTenN2
		* (multiply(a, d) + multiply(b, c)) + multiply(b, d);
    }

}
