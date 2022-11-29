package telran.digital.numbers;

import java.util.Arrays;

public class DigitalNumbersPrinting {

	private static final String SYMBOL = "*";

	public static void displayDigitalNumbers(int number, int offset, int wight, int height) {
		// TODO
		String[] res = new String[height];
		Arrays.fill(res, "");

		while (number != 0) {
			switch (number % 10) {
			case 0:
				sumString(res, zero(offset, wight, height));
				break;
			case 1:
				sumString(res, one(offset, wight, height));
				break;
			case 2:
				sumString(res, two(offset, wight, height));
				break;
			case 3:
				sumString(res, three(offset, wight, height));
				break;
			case 4:
				sumString(res, four(offset, wight, height));
				break;
			case 5:
				sumString(res, five(offset, wight, height));
				break;
			case 6:
				sumString(res, six(offset, wight, height));
				break;
			case 7:
				sumString(res, seven(offset, wight, height));
				break;
			case 8:
				sumString(res, eight(offset, wight, height));
				break;
			case 9:
				sumString(res, nine(offset, wight, height));
				break;
			}
			number /= 10;
		}

		displayStrings(res);
	}

	private static void sumString(String[] res, String[] currentNumber) {
		for (int i = 0; i < currentNumber.length; i++) {
			res[i] = currentNumber[i] + res[i];
		}
	}

	private static void displayStrings(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}

	public static String line(int offset, int lenght) {
		return " ".repeat(offset) + SYMBOL.repeat(lenght);
	}

	public static String[] rightVerticalLine(int offset, int height) {
		String[] res = new String[height];

		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL;
		}
		return res;
	}

	public static String[] leftVerticalLine(int offset, int width, int height) {
		String[] res = new String[height];

		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 1);
		}
		return res;
	}

	public static String[] twoVerticalLines(int offset, int width, int height) {
		String[] res = new String[height];

		for (int i = 0; i < res.length; i++) {
			res[i] = " ".repeat(offset) + SYMBOL + " ".repeat(width - 2) + SYMBOL;
		}
		return res;
	}

	private static int halfOfDigit(int digit) {
		return digit % 2 == 0 ? (digit - 1) / 2 : (digit) / 2;
	}

	public static String[] zero(int offset, int width, int height) {
		String[] res = new String[height];

		res[0] = line(offset, width);
		String[] lines = twoVerticalLines(offset, width, height - 2);
		System.arraycopy(lines, 0, res, 1, lines.length);
		res[height - 1] = line(offset, width);
		return res;
	}

	public static String[] one(int offset, int width, int height) {
		return rightVerticalLine(offset + width - 1, height);
	}

	public static String[] two(int offset, int width, int height) {
		String[] res = new String[height];
		res[0] = line(offset, width);

		String[] line = rightVerticalLine(offset + width - 1, halfOfDigit(height));
		System.arraycopy(line, 0, res, 1, line.length);

		res[halfOfDigit(height)] = line(offset, width);

		line = leftVerticalLine(offset, width, halfOfDigit(height));
		System.arraycopy(line, 0, res, halfOfDigit(height) + 1, line.length);

		res[height - 1] = line(offset, width);

		return res;
	}

	public static String[] three(int offset, int width, int height) {
		String[] res = new String[height];

		res[0] = line(offset, width);

		String[] line = rightVerticalLine(offset + width - 1, height);
		System.arraycopy(line, 0, res, 1, line.length - 2);

		res[halfOfDigit(height)] = line(offset, width);
		res[height - 1] = line(offset, width);

		return res;
	}

	public static String[] four(int offset, int width, int height) {
		String[] res = new String[height];

		String[] lines = twoVerticalLines(offset, width, halfOfDigit(height));
		System.arraycopy(lines, 0, res, 0, lines.length);

		res[halfOfDigit(height)] = line(offset, width);

		String[] line = rightVerticalLine(offset + width - 1, halfOfDigit(height % 2 == 0 ? height + 1 : height));
		System.arraycopy(line, 0, res, halfOfDigit(height) + 1, line.length);

		return res;
	}

	public static String[] five(int offset, int width, int height) {
		String[] res = new String[height];

		res[0] = line(offset, width);

		String[] line = leftVerticalLine(offset, width, halfOfDigit(height));
		System.arraycopy(line, 0, res, 1, line.length);

		res[halfOfDigit(height)] = line(offset, width);

		line = rightVerticalLine(offset + width - 1, halfOfDigit(height));
		System.arraycopy(line, 0, res, halfOfDigit(height) + 1, line.length);

		res[height - 1] = line(offset, width);

		return res;
	}

	public static String[] six(int offset, int width, int height) {
		String[] res = new String[height];

		res[0] = line(offset, width);

		String[] line = leftVerticalLine(offset, width, halfOfDigit(height));
		System.arraycopy(line, 0, res, 1, line.length);

		res[halfOfDigit(height)] = line(offset, width);

		String[] lines = twoVerticalLines(offset, width, halfOfDigit(height));
		System.arraycopy(lines, 0, res, halfOfDigit(height) + 1, lines.length);

		res[height - 1] = line(offset, width);

		return res;
	}

	public static String[] seven(int offset, int width, int height) {
		String[] res = new String[height];

		res[0] = line(offset, width);

		String[] line = rightVerticalLine(offset + width - 1, height);
		System.arraycopy(line, 0, res, 1, line.length - 1);

		return res;
	}

	public static String[] eight(int offset, int width, int height) {
		String[] res = new String[height];

		res[0] = line(offset, width);

		String[] lines = twoVerticalLines(offset, width, halfOfDigit(height));
		System.arraycopy(lines, 0, res, 1, lines.length);

		res[halfOfDigit(height)] = line(offset, width);

		lines = twoVerticalLines(offset, width, halfOfDigit(height));
		System.arraycopy(lines, 0, res, halfOfDigit(height) + 1, lines.length);

		res[height - 1] = line(offset, width);

		return res;
	}

	public static String[] nine(int offset, int width, int height) {
		String[] res = new String[height];

		res[0] = line(offset, width);

		String[] lines = twoVerticalLines(offset, width, halfOfDigit(height));
		System.arraycopy(lines, 0, res, 1, lines.length);

		res[halfOfDigit(height)] = line(offset, width);

		String[] line = rightVerticalLine(offset + width - 1, halfOfDigit(height));
		System.arraycopy(line, 0, res, halfOfDigit(height) + 1, line.length);

		res[height - 1] = line(offset, width);

		return res;
	}
}
