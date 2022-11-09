import java.util.Arrays;

public class MyArrays {

	static public int[] addNumber(int[] array, int number) {
		// TODO
		// use standard class Arrays, method copy
		int[] res = Arrays.copyOf(array, array.length + 1);
		res[array.length] = number;

		return res;
	}

	static public int[] removeNumber(int[] array, int index) {
		// TODO
		// use standard class System, method ArrayCopy
		index++;

		int[] res = new int[array.length - 1];
		if (index > 0 && index <= array.length) {
			System.arraycopy(array, 0, res, 0, index - 1);
			System.arraycopy(array, index, res, index - 1, array.length - index);
		}

		return res;
	}

	static public int[] insertSorted(int[] arraySorted, int number) {
		// TODO
		// use the methods binarySearch of the standard class Arrays
		// use standard class System, method ArrayCopy
		// new array with inserted number at an index for keeping array sorted
		int[] res = new int[arraySorted.length + 1];
		int step = number;
		int index = 0;
		boolean find = false;

		if (arraySorted[0] >= number) {
			System.arraycopy(arraySorted, 0, res, 1, arraySorted.length);
			res[0] = number;

		} else if (arraySorted[arraySorted.length - 1] <= number) {
			System.arraycopy(arraySorted, 0, res, 0, arraySorted.length);
			res[res.length - 1] = number;

		} else {
			do {
				index = Arrays.binarySearch(arraySorted, step);
				find = index >= 0 ? true : false;
				if (step == 0) {
					find = true;
				} else {
					step--;
				}
			} while (!find || step < 0);
			System.arraycopy(arraySorted, 0, res, 0, index + 1);
			res[index + 1] = number;
			System.arraycopy(arraySorted, index + 1, res, index + 2, arraySorted.length - index - 1);
		}
		return res;
	}
}
