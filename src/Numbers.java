public class Numbers {
	static public int getNDigits(long number) {
		int res = 0;
		
		do {
			number /= 10;
			res++;
		}while(number != 0);
		
		return res;
	}
	
	static public boolean happyNumber(long number) {
		//TODO 
		return (getSumDigits(number % 1000) == getSumDigits((long) number / 1000)) ? true : false;
	}
	
	static public int getSumDigits(long number) {
		int res = 0;
		
		while(number != 0){
			res += number % 10;
			number /= 10;
		};
		return res;
	}
}
