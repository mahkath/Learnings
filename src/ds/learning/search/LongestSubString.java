package ds.learning.search;

import java.util.Arrays;

public class LongestSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestSubString lss = new LongestSubString();
		String input = "I Love India, I'm Indian. Every one Love India, ";
		lss.longestSubString(input);
	}

	public void longestSubString(String input) {
		String suffixString[] = new String[input.length()];
		
		for(int i=input.length()-1; i>=0; i--) {
			suffixString[i] = input.substring(i);
		}
		
		Arrays.sort(suffixString);
		
		String subString = "";
		for(int i=0; i<suffixString.length-1; i++) {
			String temp = commonSubString(suffixString[i],suffixString[i+1]);
			if(temp.length() > subString.length()) {
				subString = temp;
			}
		}
		
		System.out.println("*"+subString+"*");
	}
	
	public String commonSubString(String first, String second) {
		int min = Math.min(first.length(), second.length());
		
		int commonIndex = 0;
		for(int i=0; i<min; i++) {
			
			if(first.charAt(i)!=second.charAt(i)) {
				break;
			} else {
				commonIndex ++;
			}
		}
		
		if(commonIndex == -1)
			return "";
		else
			return first.substring(0, commonIndex);
	}
}
