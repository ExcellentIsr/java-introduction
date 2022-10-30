/*
* All methods will return -1 in the case of wring nBit value
* right nBit value [0,64)
*/
public class Bit_Operation {
	
	static private boolean checkNBit(int nBit) {
		//TODO Auto-generated method stub
		return (nBit >= 0 && nBit < 64);
	}
	/**
	 * @param number any
	 * @param nBit - bit number
	 * @return value of bit with number nBit
	 */
	static public int getBitValue(long number, int nBit) {
		//TODO
		
		int res = -1;
		
		if(checkNBit(nBit)) {
			long mask = 1 << nBit; // all bits are 0 except bit with number nBit
			
			if ((number & mask) == 0) {
				res = 0;
			}else {
				res = 1;
			}
		}
		return res;
	}
	/**
	 * @param number any
	 * @param nBit - bit number
	 * @param value - boolean
	 * @return new number in which value of nBit'h bit will have 
	 */
	static public long setBitValue(long number, int nBit, boolean value) {
		//TODO
		
		if(checkNBit(nBit)) {
			long mask = 1 << nBit;
			
			if(value) {
				number |= mask;
			}else{
				number &= ~mask;
			}
			
			return number;
		}
		return -1;
	}
	/**
	 * @param number any
	 * @param nBit - bit number
	 * @return new number in which nBit'h will be reverted (old value - 1, new value - 0)
	 */
	static public long negateBitValue(long number, int nBit) {
		//TODO
		if(checkNBit(nBit)) {
			long mask = 1 << nBit;
			return number ^ mask;
		}
		
		return -1;
	}
}
