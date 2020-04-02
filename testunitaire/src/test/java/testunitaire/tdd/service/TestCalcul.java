package testunitaire.tdd.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCalcul {

	@Test
	public void testerCalcul() {
		int a = 8, b = 5;
		Calcul c = new Calcul();
		int res = c.diviser(a, b);
		assertEquals(res, 1);

	}

	@Test(expected = ArithmeticException.class)
	public void testerCalcul2() {
		int a = 8, b = 0;
		Calcul c = new Calcul();
		int res = c.diviser(a, b);
		assertEquals(res, 1);

	}

}
