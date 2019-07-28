package br.com.viavarejo.util;

public class CalcUtils {

	private CalcUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static Double calculateInterest(Double rate, Integer month, Double value) {
		return value * (Math.pow((1 + (rate / 100)), month));
	}
}
