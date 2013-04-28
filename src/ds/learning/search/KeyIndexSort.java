package ds.learning.search;

public class KeyIndexSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		KeyIndexSort rs = new KeyIndexSort();
		
		//char input[] = {'a','z','e','b','a','c','k','b','e','d','d','a','f','z'};
		//rs.sort(input);
		
		String input[] = {"cab","abe","def","abc","bca","caa"};
		rs.lsdSort(input, 3);
	}
	
	public void sort(char input[]) {
		int counters[] = new int[26+1];
		char aux[] = new char[input.length];
		int index = 0;
		
		for(int i=0; i<input.length; i++) {
			counters[input[i]+1-'a']++;
		}
		
		for(int i=0; i<counters.length-1; i++) {
			counters[i+1] += counters[i];
			System.out.println(counters[i]);
		}
		
		for(int i=0; i<input.length; i++) {
			index = counters[input[i]-'a'];
			aux[index] = input[i];
			counters[input[i]-'a']++;
		}
		
		System.out.println(input);
		System.out.println(aux);
	}
	
	public void lsdSort(String input[], int stringSize) {
		
		
		int index = 0;
		
		for(int charLoc=stringSize-1; charLoc>=0; charLoc--) {
			int counters[] = new int[26+1];
			String aux[] = new String[input.length];
			
			System.out.println("--------------------------");
		
			for(int i=0; i<input.length; i++) {
				counters[input[i].charAt(charLoc)+1-'a']++;
			}
			
			for(int i=0; i<counters.length-1; i++) {
				counters[i+1] += counters[i];
				//System.out.println(counters[i]);
			}
			
			for(int i=0; i<input.length; i++) {
				index = counters[input[i].charAt(charLoc)-'a'];
				aux[index] = input[i];
				counters[input[i].charAt(charLoc)-'a']++;
			}
		
			for(String str : aux) {
				System.out.println(str);
			}
			
			input = aux;
		}
		
		
		//System.out.println(aux);
	}

}
