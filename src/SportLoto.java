public class SportLoto {
	static long mask = 0;

	public static void main(String[] args) {
		// TODO
		/**
		 * Application display out 6 random numbers from 1 to 49 numbers can't repeated
		 * in a sequence of 6 random number7
		 */
		int min = 1;
		int max = 49;

		for(int i = 0; i < 6; i++) {
			System.out.print(generateDigit(min,max) + "; ");
		}

		return;
	}

	static public int generateDigit(int min, int max) {
		int res = 0;
		do {
			res = (int) (min + Math.random()*(max-min-1));
		}while(Bit_Operation.getBitValue(mask, res) == 1);
		
		mask = Bit_Operation.setBitValue(mask, res, true);
		return res;
	}
}
