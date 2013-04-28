package com.pac;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HouseBuilding {
	
	public static void main(String args[]) {
		HouseBuilding hb = new HouseBuilding();
		String[] input = {"5781252",
				 "2471255",
				 "0000291",
				 "1212489"};
		System.out.println(hb.getMinimum(input));
	}
	public int getMinimum(String[] area) {
		Map<String, Integer> repeatedNum = new HashMap<String, Integer>();
		int average = 0;
		int totalDiff = 0;
		int max = 0;
		
		for(String str : area) {
			for(int i=0; i<str.length(); i++) {
				Integer val = repeatedNum.get(new String(""+str.charAt(i)));
				if(val == null) {
					val = 0;
				} 
				val++;
				repeatedNum.put(new String("" + str.charAt(i)), val);
			}
		}
		Set<String> keys = repeatedNum.keySet();
		for(String s : keys) {
			if(repeatedNum.get(s) > max) {
				max = repeatedNum.get(s);
				average = Integer.parseInt(s);
			}
		}
		
		System.out.println("Max=" + max + " Average=" + average);
		
		for(String str : area) {
			for(int i=0; i<str.length(); i++) {
				int num = Integer.parseInt(""+str.charAt(i));
				if(average > num) {
					totalDiff += average - num -1;
				} if(average < num)  {
					totalDiff += num  -average -1;
				} else {
					continue;
				}
			}
		}
		return totalDiff;
	}
}