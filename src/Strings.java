
public class Strings {

	static public boolean isAnagram(String str, String anagram) {

		boolean res = false;
		byte[] helper = new byte[126];

		char[] strArray = str.toCharArray();
		char[] anagramArray = anagram.toCharArray();

		if (str.length() == anagram.length()) {
			res = true;

			for (int i = 0; i < strArray.length; i++) {
				helper[(int) strArray[i]]++;
				helper[(int) anagramArray[i]]--;
			}
			int index = 0;
			while (index < helper.length && res) {
				if (helper[index] != 0) {
					res = false;
				} else {
					index++;
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
			for (int j = helper[i]; j > 0; j--) {
				res[index++] = Integer.toString(i - 128);
			}
		}

		return res;
	}

	static public String javaNameExp() {
		return "[a-zA-Z$][\\w$]*|_[\\w$]+";
	}

	static public String ipV40ctet() {
		return "[1-9]?[0-9]|1\\d\\d|2[0-4]\\d|25[0-5]";
	}

	static public String ipV4() {
		return "((" + ipV40ctet() + ")\\.){3}(" + ipV40ctet() + ")$";
	}
}
