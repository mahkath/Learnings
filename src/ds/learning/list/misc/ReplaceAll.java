package ds.learning.list.misc;

public class ReplaceAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str = "Great Man Makka with good HuManity with Different Man in soMany Countries";
		System.out.println(replaceAll(str, "Man", "Woman"));
	}

	
	static String  replaceAll(String str, String with, String replace) {
		char array[] = str.toCharArray();
		char find[] = with.toCharArray();
		StringBuffer buffer = new StringBuffer();
		int count = 0;
		for (int i=0;i<array.length;i++) {
			boolean found = false;
			if (array[i] == find[0]) {
				int k = 0;
				for (int j = i; j < array.length && k < find.length; j++, k++) {
					if (array[j] == find[k]) {
						count = k;
						found = true;
					} else {
						found = false;
						break;
					}
				}
				if (found) {
					buffer.append(replace);
					i = i + find.length -1 ;
				} else {
					for (int m = 0; m <= count; m++) {
						buffer.append(find[m]);
						i = i + m;
					}
				}
				
			} else {
				buffer.append(array[i]);
			}
		}
		return buffer.toString();
	}
}
