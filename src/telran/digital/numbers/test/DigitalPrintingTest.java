package telran.digital.numbers.test;

import org.junit.jupiter.api.*;
import static telran.digital.numbers.DigitalNumbersPrinting.*;

public class DigitalPrintingTest {

	@Test
	@Disabled
	void lineTest() {
		System.out.println(line(30, 30));
	}

	@Test
	@Disabled
	void verticalLineTest() {
		// displayStrings(verticalLine(30, 5));
	}

	@Test
	@Disabled
	void twoVerticalLineTest() {
		// displayStrings(twoVerticalLines(30, 10, 5));
	}

	@Test
	// @Disabled
	void displayDigitalNumbersTest() {
		displayDigitalNumbers(1234567890, 3, 9, 7);
	}

}
