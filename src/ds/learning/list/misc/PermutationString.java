package ds.learning.list.misc;

import java.util.ArrayList;
import java.util.List;

public class PermutationString {

	static int cnt = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PermutationString ps = new PermutationString();
		List<StringBuffer> permutations = ps.getPerms("ABCDE");
		for(StringBuffer sb : permutations) {
			System.out.println(sb);
		}
		
		System.out.println(cnt);
	}
	
	public List<StringBuffer> getPerms(String strToPerm) {
		List<StringBuffer> listToBeReturned = new ArrayList<StringBuffer>();
		
		if(strToPerm == null || strToPerm.length() == 1) {
			StringBuffer sb = new StringBuffer(strToPerm);
			//cnt++;
			listToBeReturned.add(sb);
			return listToBeReturned;
		}
		
		
		char firstChar = strToPerm.charAt(0);
		String restOfString = strToPerm.substring(1);
		
		List<StringBuffer> permsList = getPerms(restOfString);
		
		
		for(int j=0; j<permsList.size(); j++) {
			for(int i=0; i<restOfString.length()+1; i++) {
				StringBuffer perm = new StringBuffer(permsList.get(j));
				perm.insert(i,firstChar);
				listToBeReturned.add(perm);
				cnt++;
			}
		}
		return listToBeReturned;
	}

}
