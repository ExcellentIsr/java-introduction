import java.util.Arrays;

public class MyArrays {

	static public int[] addNumber(int[] array, int number) {
		int[] res = Arrays.copyOf(array, array.length + 1);
		res[array.length] = number;

		return res;
	}

	static public int[] removeNumber(int[] array, int index) {
		index++;

		int[] res = new int[array.length - 1];
		if (index > 0 && index <= array.length) {
			System.arraycopy(array, 0, res, 0, index - 1);
			System.arraycopy(array, index, res, index - 1, array.length - index);
		}

		return res;
	}

	static public int[] insertSorted(int[] arraySorted, int number) {
		// use the methods binarySearch of the standard class Arrays
		// use standard class System, method ArrayCopy
		// new array with inserted number at an index for keeping array sorted
		int[] res = new int[arraySorted.length + 1];
		int index = 0;

		index = binarySearch(arraySorted, number);
		index = index < 0 ? -(index + 1) : index;

		System.arraycopy(arraySorted, 0, res, 0, index);
		res[index] = number;
		System.arraycopy(arraySorted, index, res, index + 1, arraySorted.length - index);

		return res;
	}

	static public int binarySearch(int[] arraySorted, int number) {
		// TODO
		int low = 0;
		int high = arraySorted.length - 1;

		while (low <= high) {
			int midInd = (low + high) / 2;
			int midValue = arraySorted[midInd];
			if (midValue < number) {
				low = midInd + 1;
			} else if (midValue > number) {
				high = midInd - 1;
			} else {
				if (midInd != 0) {
					if (arraySorted[midInd - 1] == number) {
						high = midInd - 1;
					} else {
						return midInd;
					}
				} else {
					return midInd;
				}
			}
		}
		return -(low + 1);
	}

	static boolean SORTED;

	static public int[] bubbleSort(int[] array) {
		if (array.length > 1) {
			for (int i = 0; i < array.length; i++) {
				SORTED = true;
				for (int j = 0; j < array.length - 1; j++) {
					moveGreaterRight(array, j);
				}
				if (SORTED)
					break;
			}
		}
		return array;
	}

	static private void moveGreaterRight(int[] array, int indexToSwap) {
		if (array[indexToSwap] > array[indexToSwap + 1]) {
			int value = array[indexToSwap];
			array[indexToSwap] = array[indexToSwap + 1];
			array[indexToSwap + 1] = value;

			SORTED = false;
		}
	}

	static public int[][] transp(int[][] matrix) {
		// TODO
		int[][] res = new int[matrix[0].length][matrix.length];

		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				res[i][j] = matrix[j][i];
			}
		}
		return res;
	}

	static public boolean isSum2(short[] array, short sum) {
		// TODO return true if array contains two numbers, sum of which equals a given
		boolean res = false;
		boolean[] isNumbers = new boolean[sum+1];
		
		for (int i = 0; i < array.length; i++) {
			if(i != 0 && array[i] <= sum && isNumbers[sum - array[i]]) {
				res = true;
			}
			
			if(array[i] <= sum) {
				isNumbers[array[i]] = true;
			}
		}
		
		return res;
	}
}
