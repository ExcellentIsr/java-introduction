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
	@Disabled
	void addNumberTest() {
		int expectedNumber = 21;
		int array[] = { 1, 2, 3, 4, 5 };
		int array1[] = { 1, 2, 3, 4, 5, 21 };
		assertArrayEquals(array1, MyArrays.addNumber(array, expectedNumber));
	}

	@Test
	@Disabled
	void removeNumberTest() {
		int index = 2;
		int array[] = { 1, 2, 3, 4, 5 };
		int array1[] = { 1, 2, 4, 5 };
		assertArrayEquals(array1, MyArrays.removeNumber(array, index));
	}

	@Test
	@Disabled
	void insertSortedTest() {
		int index = 5;
		int array[] = { 1, 10, 12, 13, 22, 24, 27 };
		int array1[] = { 1, 2 };
		int array2[] = { 8, 9, 11 };
		int array3[] = { 14 };
		int array4[] = { 2, 8, 8, 8, 10 };
		int array5[] = { 10, 11 };
		assertArrayEquals(new int[] { 1, 5, 10, 12, 13, 22, 24, 27 }, MyArrays.insertSorted(array, index));
		assertArrayEquals(new int[] { 1, 2, 5 }, MyArrays.insertSorted(array1, index));
		assertArrayEquals(new int[] { 5, 8, 9, 11 }, MyArrays.insertSorted(array2, index));
		assertArrayEquals(new int[] { 5, 14 }, MyArrays.insertSorted(array3, index));
		assertArrayEquals(new int[] { 2, 5, 8, 8, 8, 10 }, MyArrays.insertSorted(array4, index));
		assertArrayEquals(new int[] { 5, 10, 11 }, MyArrays.insertSorted(array5, index));
	}

	@Test
	void bubbleSortTest() {
		int array[] = { 27, 17, 2, -2, 0, 1, 5, 12 };
		int array1[] = { 2, 1 };
		int array2[] = { 2, 2, 1, 1 };
		int array3[] = { 1 };
		int array4[] = { 10, 10, 10, 0, 5 };
		int array5[] = {};
		assertArrayEquals(new int[] { -2, 0, 1, 2, 5, 12, 17, 27 }, MyArrays.bubbleSort(array));
		assertArrayEquals(new int[] { 1, 2 }, MyArrays.bubbleSort(array1));
		assertArrayEquals(new int[] { 1, 1, 2, 2 }, MyArrays.bubbleSort(array2));
		assertArrayEquals(new int[] { 1 }, MyArrays.bubbleSort(array3));
		assertArrayEquals(new int[] { 0, 5, 10, 10, 10 }, MyArrays.bubbleSort(array4));
		assertArrayEquals(new int[] {}, MyArrays.bubbleSort(array5));
	}

	@Test
	@Disabled
	void isOneSwapForSortedTest() {
		int ar1[] = { 10, 2, 3, 4, 1 };
		int ar2[] = { 1, 2, 4, 3, 5, 10 };
		int ar3[] = { 1, 2, 3, 10, 5, 4 };
		int ar4[] = { 1, 5, 3, 4, 2, 10 };
		int ar5[] = { 1, 2, 3, 4, 10, 5 };
		int ar6[] = { 2, 1, -3, 4, 5, 10 };
		int ar7[] = { 3, 2, 1, 4, 5, 6 };
		assertTrue(MyArrays.isOneSwapForSorted(ar1));
		assertTrue(MyArrays.isOneSwapForSorted(ar2));
		assertTrue(MyArrays.isOneSwapForSorted(ar3));
		assertTrue(MyArrays.isOneSwapForSorted(ar4));
		assertTrue(MyArrays.isOneSwapForSorted(ar5));
		assertTrue(MyArrays.isOneSwapForSorted(ar6));
		assertTrue(MyArrays.isOneSwapForSorted(ar7));
	}

	@Test
	void binarySearchTest() {
		int index = 8;
		int array[] = { 1, 10, 12, 13, 22, 24, 27 };
		int array1[] = { 14 };
		int array2[] = { 1, 2 };
		int array3[] = { 8, 9, 11 };
		int array4[] = { 2, 8, 8, 8, 10 };
		int array5[] = { 2, 5, 8 };
		assertEquals(-2, MyArrays.binarySearch(array, index));
		assertEquals(-1, MyArrays.binarySearch(array1, index));
		assertEquals(-3, MyArrays.binarySearch(array2, index));
		assertEquals(0, MyArrays.binarySearch(array3, index));
		assertEquals(1, MyArrays.binarySearch(array4, index));
		assertEquals(2, MyArrays.binarySearch(array5, index));
	}

	@Test
	@Disabled
	void IsraelIdentityTest() {
		assertTrue(IsraelIdentity.verify(346853476));
	}

}