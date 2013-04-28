package ds.learning.list.misc;

public class Add2BinaryNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Add2BinaryNumbers obj = new Add2BinaryNumbers();
		System.out.println(obj.addTwoBinaryNumbers("1111", "0111"));
	}
	
	public String addTwoBinaryNumbers(String one, String two) {
		int i=one.length()-1, j=two.length()-1;
		int carry = 0;
		int sum = 0;
		String result = "";
		while(i>=0 && j>=0) {
			int oneDigit = convertToInt(one.charAt(i));
			int twoDigit = convertToInt(two.charAt(j));
			sum = (oneDigit + twoDigit + carry)%2;
			carry = (oneDigit + twoDigit + carry)/2;
			result = sum + result;
			i--;
			j--;
		}
		
		if( i>0) {
			for(;i>=0;i--) {
				int oneDigit = convertToInt(one.charAt(i));
				sum = (oneDigit + carry)%2;
				carry = (oneDigit + carry)/2;
				result = sum + result;
			}
		} else if(j>0){
			for(;j>=0;j--) {
				int twoDigit = convertToInt(two.charAt(j));
				sum = (twoDigit + carry)%2;
				carry = (twoDigit + carry)/2;
				result = sum + result;
			}
		} else {
			result = carry + result;
		}
		
		return result;
	}

	private int convertToInt(char ch) {
		int num = (ch == '0') ? 0 :  1;
		return num;
	}
}
