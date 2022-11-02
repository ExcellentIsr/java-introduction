/*
* All methods will return -1 in the case of wring nBit value
* right nBit value [0,64)
*/
public class Bit_Operation {
	
	static private boolean checkNBit(int nBit) {
		//TODO
		return (nBit >= 0 && nBit < 64);
	}
	static public int getBitValue(long number, int nBit) {
		//TODO
		int res = -1;
		
		if(checkNBit(nBit)) {
			long mask = 1 << nBit;

			res = ((number & mask) == 0) ? res = 0 : 1;
		}
		return res;
	}
	static public long setBitValue(long number, int nBit, boolean value) {
		//TODO
		if(checkNBit(nBit)) {
			long mask = 1 << nBit;
			
			number = (value) ? number = number | mask : number & ~mask;
			
			return number;
		}
		return -1;
	}
	static public long negateBitValue(long number, int nBit) {
		//TODO
		if(checkNBit(nBit)) {
			long mask = 1 << nBit;
			return (number ^ mask);
		}
		return -1;
	}
}