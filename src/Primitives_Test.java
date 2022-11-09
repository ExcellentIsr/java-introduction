import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Primitives_Test {

	@Test
	@Disabled
	void happyNumberTest() {

		long number = 185491;
		assertEquals(true, Numbers.happyNumber(number));

		number = 231555;
		assertEquals(false, Numbers.happyNumber(number));

		number = 200002;
		assertEquals(true, Numbers.happyNumber(number));
	}

	@Test
	@Disabled
	void getBitValueTest() {
		long number = 0x3ab7f5; // 11_1010_1011_1011_0111_1111_0101

		assertEquals(0, Bit_Operation.getBitValue(number, 1));
		assertEquals(1, Bit_Operation.getBitValue(number, 2));
		assertEquals(1, Bit_Operation.getBitValue(number, 5));
		assertEquals(0, Bit_Operation.getBitValue(number, 11));
		assertEquals(-1, Bit_Operation.getBitValue(number, 100));
		assertEquals(-1, Bit_Operation.getBitValue(number, -2));

		number = -1;
		assertEquals(1, Bit_Operation.getBitValue(number, 63));

		number = Bit_Operation.negateBitValue(number, 63);
		assertEquals(0, Bit_Operation.getBitValue(number, 63));
	}

	@Test
	@Disabled
	void setBitValueTest() {
		long number = 0x3ab7f5; // 11_1010_1011_1011_0111_1111_0101

		assertEquals(0x3ab7d5, Bit_Operation.setBitValue(number, 5, false));
		assertEquals(0x3ab7f5, Bit_Operation.setBitValue(number, 5, true));
	}

	@Test
	@Disabled
	void negateBitValueTest() {
		long number = 0x3ab7f5; // 11_1010_1011_1011_0111_1111_0101

		assertEquals(0x3ab7d5, Bit_Operation.negateBitValue(number, 5));
		assertEquals(0x3ab7f4, Bit_Operation.negateBitValue(number, 0));
	}

	@Test
	@Disabled
	void getDigitsTest() {
		int expected[] = { 1, 2, 3, 4 };

		assertArrayEquals(expected, Numbers.getDigits(1234));
	}

	@Test
	@Disabled
	void getNumberFromDigitsTest() {
		int expectedNumber = 1234;
		int array[] = { 1, 2, 3, 4 };
		assertEquals(expectedNumber, Numbers.getNumberFromDigits(array));
	}

	@Test
	void addNumberTest() {
		int expectedNumber = 21;
		int array[] = { 1, 2, 3, 4, 5 };
		int array1[] = { 1, 2, 3, 4, 5, 21 };
		assertArrayEquals(array1, MyArrays.addNumber(array, expectedNumber));
	}

	@Test
	void removeNumberTest() {
		int index = 2;
		int array[] = { 1, 2, 3, 4, 5 };
		int array1[] = { 1, 2, 4, 5 };
		assertArrayEquals(array1, MyArrays.removeNumber(array, index));
	}

	@Test
	void insertSortedTest() {
		int index = 8;
		int array[] = { 1, 2, 4, 9, 9, 10 };
		int array1[] = { 1, 2 };
		int array2[] = { 8, 9, 11 };
		int array3[] = { 14 };
		int array4[] = { 2, 8, 8, 8, 10 };
		int array5[] = { 10, 11 };
		assertArrayEquals(new int[] { 1, 2, 4, 8, 9, 9, 10 }, MyArrays.insertSorted(array, index));
		assertArrayEquals(new int[] { 1, 2, 8 }, MyArrays.insertSorted(array1, index));
		assertArrayEquals(new int[] { 8, 8, 9, 11 }, MyArrays.insertSorted(array2, index));
		assertArrayEquals(new int[] { 8, 14 }, MyArrays.insertSorted(array3, index));
		assertArrayEquals(new int[] { 2, 8, 8, 8, 8, 10 }, MyArrays.insertSorted(array4, index));
		assertArrayEquals(new int[] { 8, 10, 11 }, MyArrays.insertSorted(array5, index));
	}

	@Test
	void IsraelIdentityTest() {
		assertTrue(IsraelIdentity.verify(346853476));
	}

}