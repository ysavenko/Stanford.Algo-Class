package org.algoclass.ysavenko.multiplication;

public class MultiplicationKaratsubaImpl extends AbstractMultiplication implements Multiplication {

	public long multiply(long number1, long number2) {

		final int n = Math.max(getLength(number1), getLength(number2));

		if (n == 1) {
			return number1 * number2;
		}

		final int n2 = n / 2;

		final long powerTenN2 = powerTen(n2);

		final long a = number1 / powerTenN2;
		final long b = number1 - a * powerTenN2;
		final long c = number2 / powerTenN2;
		final long d = number2 - c * powerTenN2;

		final long ac = multiply(a, c);
		final long bd = multiply(b, d);
		final long x = multiply(a + b, c + d);
		return powerTenN2 * powerTenN2 * ac + powerTenN2 * (x - ac - bd) + bd;
	}
}
