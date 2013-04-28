package ds.learning.list.misc;


public class RepeatedWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String content = "Amar is an awesome Amar Amar guy Varun is asshole Varun Aravind is bullshit both Varun and Aravind are useless fellows";
		String[] tokens = content.split(" ");
		StringBuffer allKeys = new StringBuffer();
		int count = 0;
		for (String token: tokens) {
			int tmpCount = 0;
			for (String tmpToken: tokens) {
				if (token.equals(tmpToken)) {
					tmpCount++;
				}
			}
			
			if (tmpCount >= count) {
				if (!allKeys.toString().contains(token)) {
					allKeys.append(token);	
				}
				count = tmpCount;
			}
		}
		System.out.println(allKeys.toString());
	}
}
