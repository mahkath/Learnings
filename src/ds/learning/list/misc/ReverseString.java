package ds.learning.list.misc;

public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abcdefgh";
		int length = str.length();
		
		StringBuffer reverse = new StringBuffer(length);
		int index = (length - 1);
		while ( index >= 0) {
			reverse.append(str.charAt(index));
			index--;
		}
		System.out.println(reverse);
		
		System.out.println(reverse(str));
	}
	

	// String Reverse without using StringBuffer	
	public static String reverse(String str) {
		char[] ch = str.toCharArray();
		int j = ch.length -1 ;
		for (int i=0; i < ch.length/2; i++) {
			char tmp = ch[i];
			ch[i] = ch[j];
			ch[j] = tmp;
			j--;
		}
		return new String(ch);
	}
	
}
