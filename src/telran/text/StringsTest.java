package telran.text;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import static telran.text.Strings.*;

class StringsTest {

	@Test
	void ipV4TestTrue() {
		assertTrue("1.2.3.4".matches(ipV4()));
		assertTrue("199.249.255.209".matches(ipV4()));
		assertTrue("99.99.99.05".matches(ipV4()));
	}

	@Test
	void ipV4TestFalse() {
		assertFalse("*.19.10.10".matches(ipV4()));
		assertFalse("256.19.10.10".matches(ipV4()));
		assertFalse("300.19.10.10".matches(ipV4()));
		assertFalse("255.19.10".matches(ipV4()));
		assertFalse("255.19.10.10.".matches(ipV4()));
		assertFalse("255.19".matches(ipV4()));
	}

	@Test
	void computeExpressionTest() {
		assertEquals(2, computeArithmenticExpression("	2", null, null));
		assertEquals(10.5, computeArithmenticExpression("2 + 2 + 1 * 2 + 0.5", null, null));
		assertEquals(10.5, computeArithmenticExpression("((a + d) + (c * e + b))", new double[] { 2, 0.5, 1, 2, 2 },
				new String[] { "a", "b", "c", "d", "e" }));
		assertEquals(10.5, computeArithmenticExpression("((_$ + 2) + c * 2 + b)", new double[] { 2, 0.5, 1 },
				new String[] { "_$", "b", "c" }));
		assertEquals(10.5, computeArithmenticExpression("abrakadabra1212 + 2 + systemValue1111 * 2 + systemValue5",
						new double[] { 2, 1, 0.5 }, new String[] { "abrakadabra1212", "systemValue1111", "systemValue5" }));
		assertEquals(2.5, computeArithmenticExpression("aabc + 2 % achxcs * 2 + abcsdf",
				new double[] { 2, 0.5, 3 }, new String[] { "aabc", "abcsdf", "achxcs" }));

		assertTrue(Double.isNaN(computeArithmenticExpression("2 # 2 ++ 10", null, null)));
		assertTrue(Double.isNaN(computeArithmenticExpression("2 * 2 _ 10", null, null)));
		assertTrue(Double.isNaN(computeArithmenticExpression("", null, null)));
		assertTrue(Double.isNaN(computeArithmenticExpression("(a + ()2 + c * 2) + d23", new double[] { 2, 1 },
				new String[] { "a", "c" })));
		assertTrue(Double.isNaN(computeArithmenticExpression(")a + 2 + c * 2 + d23(", new double[] { 2, 1 },
				new String[] { "a", "c" })));
		assertTrue(Double.isNaN(computeArithmenticExpression("a + 2 + c * 2 + d23", new double[] { 2, 1, 0.5 },
				new String[] { "a", "c", "dc23" })));
		

	}
}
