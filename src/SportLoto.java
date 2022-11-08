public class SportLoto {
	static int countRepeat = 0;
	public static void main(String[] args) {
		//TODO
		/**
		 * Application display out 6 random numbers from 1 to 49 
		 * numbers can't repeated in a sequence of 6 random number7
		 */
		generateTicket();
		
		return;
	}
	
	static public void generateTicket() {
		long row = 0;
		countRepeat = 0;
		System.out.print("Repeat generation history: ");
		for(int i = 0; i < 6; i++) {
			row += generateDigit(row, i) * (long) Math.pow(100, i);
		}
		
		long showMe = row;
		
		System.out.println("\nRepeats on generation stage: " + countRepeat + "\n");
		System.out.print("|  first | second |  third | fourth |  fifth |  sixth |\n|");
		for(int i = 0; i < 6; i++) {
			if(showMe%100 < 10){
				System.out.print("   " + showMe % 100 + "    |");
			}else{
				System.out.print("   " + showMe % 100 + "   |");
			}
			showMe /= 100;
		}
		System.out.println();
		return;
	}
	
	static public int generateDigit(long row, int i) {
		int min = 1;
		int max = 49;
		
		boolean isRepeat = false;
		int newDigit = 0;
		
		do{
			newDigit = (int)(min + Math.random()*(max - min + 1));
			for(int j = 0; j < i; j++) {
				if((row % 100) == newDigit) {
					isRepeat = true;
					countRepeat++;
					System.out.print(newDigit + "! ");
					break;
				}else{
					isRepeat = false;
					row /= 100;
				}
			}
		}while(isRepeat);
		
		return newDigit;
	}
}
