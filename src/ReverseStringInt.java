
public class ReverseStringInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		reverString("Mahesh");
		System.out.println(reverse("Mahesh"));
		System.out.println(reverseNum(123));
	}
	
	static void reverString(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i=str.length()-1; i>=0; i--) {
			sb.append(str.charAt(i));
		}
		System.out.println(sb.toString());
	}
	
	static String reverse(String str) {
		if(str == null || str.length() == 0)
			return "";
		
		if(str.length() == 1)
			return str;
		
		return reverse(str.substring(1)) + str.charAt(0);
	}
	
	static int reverseNum(int num) {
		int rem = 0;
		int reverse = 0;
		while (num > 0) {
			rem = num % 10;
			reverse = reverse*10 + rem;
			num = num / 10;
		}
		return reverse;
	}

}
