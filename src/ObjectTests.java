import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ObjectTests {

	@Test
	void isAnagramTest() {

		String word = "yellow";
		assertTrue(Strings.isAnagram(word, "loweyl"));
		assertTrue(Strings.isAnagram(word, "elolyw"));
		assertTrue(Strings.isAnagram(word, "wolley"));
		assertTrue(Strings.isAnagram(word, "loleyw"));
		assertFalse(Strings.isAnagram(word, ""));
		assertFalse(Strings.isAnagram(word, "yellob"));
		assertFalse(Strings.isAnagram(word, "yello"));
		assertFalse(Strings.isAnagram(word, "yelllo"));
	}

	@Test
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
}
