import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Primitives_Test {
	
	@Test
	void happyNumberTest() {
		
		long number = 185491;
		assertEquals(true, Numbers.happyNumber(number));
		
		number = 231555;
		assertEquals(false, Numbers.happyNumber(number));

		number = 200002;
		assertEquals(true, Numbers.happyNumber(number));
	}
	
	@Test
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
	void setBitValueTest() {
		long number = 0x3ab7f5; // 11_1010_1011_1011_0111_1111_0101
		
		assertEquals(0x3ab7d5, Bit_Operation.setBitValue(number, 5, false));
		assertEquals(0x3ab7f5, Bit_Operation.setBitValue(number, 5, true));
	}
	
	@Test
	void negateBitValueTest() {
		long number = 0x3ab7f5; // 11_1010_1011_1011_0111_1111_0101
		
		assertEquals(0x3ab7d5, Bit_Operation.negateBitValue(number, 5));
		assertEquals(0x3ab7f4, Bit_Operation.negateBitValue(number, 0));
	}
}