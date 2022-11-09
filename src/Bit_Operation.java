/*
* All methods will return -1 in the case of wring nBit value
* right nBit value [0,64)
*/
public class Bit_Operation {

	static private boolean checkNBit(int nBit) {
		// TODO
		return (nBit >= 0 && nBit < 64);
	}

	private static long getMask(int nBit) {
		return 1L << nBit;
	}

	static public int getBitValue(long number, int nBit) {
		// TODO
		int res = -1;

		if (checkNBit(nBit)) {
			long mask = getMask(nBit);

			res = ((number & mask) == 0) ? 0 : 1;
		}
		return res;
	}

	static public long setBitValue(long number, int nBit, boolean value) {
		// TODO
		long res = -1;

		if (checkNBit(nBit)) {
			long mask = getMask(nBit);

			res = (value) ? number | mask : number & ~mask;

		}
		return res;
	}

	static public long negateBitValue(long number, int nBit) {
		// TODO
		long res = -1;

		if (checkNBit(nBit)) {
			long mask = getMask(nBit);
			res = (number ^ mask);
		}
		return res;
	}

	static public int leadingZeros(long number) {
		// TODO
		int res = 0;
		int nBit = 63;

		while (nBit >= 0 && getBitValue(number, nBit) == 0) {
			nBit--;
			res++;
		}

		return res;
	}

	static public int onesInNumber(long number) {
		// TODO
		int res = 0;

		for (int i = 0; i < 63; i++) {
			if (getBitValue(number, i) == 1) {
				res++;
			}
		}

		return res;
	}
}