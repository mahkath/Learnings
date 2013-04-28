package ds.learning.list.misc;

public class PalindromeString {

	public static void main(String args[]) {
		System.out.println(isPalindrome("AmarramA"));
	}
	
	public static boolean isPalindrome(String word) {
		   int left  = 0;                 // index of leftmost unchecked char
		   int right = word.length() -1;  // index of the rightmost
		   while (left < right) {         // continue until they reach center
		       if (word.charAt(left) != word.charAt(right)) {
		           return false;          // if chars are different, finished
		       }
		       left++;                    // move left index toward the center
		       right--;                   // move right index toward the center
		   }
		   return true;                   // if finished, all chars were same
		}
}
