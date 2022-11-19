
public class Strings {
	static public boolean isAnagram(String str, String anagram) {

		boolean res = false;
		byte[] helper = new byte[128];

		char[] strArray = str.toCharArray();
		char[] anagramArray = anagram.toCharArray();

		if (anagram.length() != 0 && str.length() == anagram.length()) {
			res = true;

			for (int i = 0; i < strArray.length; i++) {
				helper[(int) strArray[i]]++;
				helper[(int) anagramArray[i]]--;
			}

			for (int i = 0; i < helper.length; i++) {
				if (helper[i] != 0) {
					res = false;
					break;
				}
			}
		}
		return res;
	}

	static public String[] sortStringNumbers(String[] str) {
		String[] res = new String[str.length];
		byte[] helper = new byte[256];

		for (int i = 0; i < str.length; i++) {
			helper[Integer.parseInt(str[i]) + 128]++;
		}

		int index = 0;
		for (int i = 0; i < helper.length; i++) {
			for (int j = 0; j < helper[j]; j++) {
				res[index++] = Integer.toString(i - 128);
			}
		}

		return res;
	}
}
