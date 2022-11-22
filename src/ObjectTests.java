import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ObjectTests {

	@Test
	@Disabled
	void isAnagramTest() {

		String word = "Hello World 123";
		assertTrue(Strings.isAnagram(word, "Hello World 123"));
		assertTrue(Strings.isAnagram(word, "World olelH 231"));
		assertTrue(Strings.isAnagram(word, "2 drlllWooHe1 3"));
	}

	@Test
	@Disabled
	void sortStringNumbersTest() {
		String[] array = { "127", "-40", "40", "1", "-5", "1", "0", "-5", "40", "-128", "-5", "127" };
		assertArrayEquals(new String[] { "-128", "-40", "-5","-5", "-5", "0", "1", "1", "40", "40",  "127", "127" }, 
				Strings.sortStringNumbers(array));
		
		String[] array1 = { "127", "-128" };
		assertArrayEquals(new String[] { "-128",  "127" }, 
				Strings.sortStringNumbers(array1));
		
		String[] array2 = { };
		assertArrayEquals(new String[] { }, 
				Strings.sortStringNumbers(array2));
	}
	
	@Test
	@Disabled
	void javaNameExpTest() {
		assertTrue("java".matches(Strings.javaNameExp()));
		assertTrue("$".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertFalse("1java".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertFalse("$ _".matches(Strings.javaNameExp()));
	}
	
	@Test
	void ipV40ctetTest() {
		assertTrue("0".matches(Strings.ipV40ctet()));
		assertTrue("1".matches(Strings.ipV40ctet()));
		assertTrue("15".matches(Strings.ipV40ctet()));
		assertTrue("199".matches(Strings.ipV40ctet()));
		assertTrue("207".matches(Strings.ipV40ctet()));
		assertTrue("255".matches(Strings.ipV40ctet()));
		assertFalse("375".matches(Strings.ipV40ctet()));
		assertFalse("256".matches(Strings.ipV40ctet()));
		assertFalse("-155".matches(Strings.ipV40ctet()));
	}
	
	@Test
	void ipV4Test() {
		assertTrue("0".matches(Strings.ipV4()));
		assertTrue("255".matches(Strings.ipV4()));
		assertTrue("0.0".matches(Strings.ipV4()));
		assertTrue("0.255".matches(Strings.ipV4()));
		assertTrue("255.0".matches(Strings.ipV4()));
		assertTrue("0.0.0".matches(Strings.ipV4()));
		assertTrue("255.255.255.255".matches(Strings.ipV4()));
		assertTrue("255.0.255".matches(Strings.ipV4()));
		assertTrue("0.0.0.0".matches(Strings.ipV4()));
		assertTrue("15.155.115.51".matches(Strings.ipV4()));
		assertTrue("1.200.5.50".matches(Strings.ipV4()));

		assertFalse(".255.0.255".matches(Strings.ipV4()));
		assertFalse("255.255.255.255.".matches(Strings.	ipV4()));
		assertFalse("0.0..0.0".matches(Strings.ipV4()));
		assertFalse("0.0.0.256".matches(Strings.ipV4()));
		assertFalse("".matches(Strings.ipV4()));
	}
}
