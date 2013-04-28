package ds.learning.list.misc;

public class PolindromeLongest {
	public static void main(String args[]) {
		String testData = "HYTBCABADEFGHABCDEDCBAGHTFYW12345678987654321ZWETYGDE";
		System.out.println(GetPalindromeString(testData));
	}

	// Explanation: http://stevekrenzel.com/articles/longest-palnidrome
	public static String GetPalindromeString(String theInputString) {
		int j = 0;
		int k = 0;
		String aPalindrome = "";
		String aLongestPalindrome = "";
		for (int i = 1; i < theInputString.length(); i++) {
			k = i + 1;
			j = i - 1;
			while (j >= 0 && k < theInputString.length()) {
				if (theInputString.charAt(j) != theInputString.charAt(k)) {
					break;
				} else {
					aPalindrome = theInputString.substring(j, k+1);
					j--;
					k++;
				}
				
				if (aPalindrome.length() > aLongestPalindrome.length()) {
					aLongestPalindrome = aPalindrome;
				}
			}
		}
		return aLongestPalindrome;
	}

}
