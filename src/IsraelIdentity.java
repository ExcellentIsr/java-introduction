public class IsraelIdentity {
	/**
	 * true for right id otherwise false
	 * 
	 * number control sum should be multiple of 10 (sum % 10 == 0) for even indexes
	 * (0, 2, 4, 6, 8) digits as is for odd indexes (1,3,5,7) digit = digit * 2, if
	 * > 9 the sum of inner digits is taken example, 123456782 =>
	 * 1+4(2*2)+3+8(4*2)+5+3(6*2 (1+2))+7+7(8*2 (1+6))+2 = 40 % 10 = 0
	 */
	public static void main(String[] args) {

		int id = generateRandomID();

		System.out.println(id);
		System.out.println(numberСontrol(intToArray(id, lengthOfNumber(id))) + " = " + verify(id));
	}

	static public int generateRandomID() {
		// TODO
		int min = (int) Math.pow(10, 8);
		int max = (int) Math.pow(10, 9);

		int res = min + (int) (Math.random() * (max - min + 1));

		if (!verify(res)) {
			int[] arrayId = intToArray(res, lengthOfNumber(res));
			int sumDigits = numberСontrol(arrayId);

			if (sumDigits % 10 <= arrayId[arrayId.length - 1]) {
				arrayId[arrayId.length - 1] -= sumDigits % 10;
			} else {
				arrayId[arrayId.length - 1] += 10 - sumDigits % 10;
			}
			res = arrayToInt(arrayId);
		}
		return res;
	}

	static public boolean verify(int id) {
		// TODO
		int sumDigits = numberСontrol(intToArray(id, lengthOfNumber(id)));
		return sumDigits % 10 == 0 ? true : false;
	}

	static public int numberСontrol(int[] arrayID) {
		int sumDigits = 0;

		for (int i = 0; i < arrayID.length; i += 2) {
			sumDigits += arrayID[i];
		}
		for (int i = 1; i < arrayID.length; i += 2) {
			sumDigits += (arrayID[i] * 2 % 10 + arrayID[i] * 2 / 10);
		}
		return sumDigits;
	}

	static public int lengthOfNumber(int number) {
		int size = 0;

		do {
			size++;
			number /= 10;
		} while (number != 0);

		return size;
	}

	static public int[] intToArray(int number, int size) {
		int[] res = new int[size];

		for (int i = size - 1; i >= 0; i--) {
			res[i] = number % 10;
			number /= 10;
		}
		return res;
	}

	static public int arrayToInt(int[] array) {
		int res = 0;
		for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
			res += array[i] * Math.pow(10, j);
		}
		return res;
	}
}
