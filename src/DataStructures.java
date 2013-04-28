import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class DataStructures {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		setDatastructure();
	}
	
	public static void setDatastructure() {
		//Set<String> hs = new LinkedHashSet<String>();
		//Set<String> hs = new HashSet<String>();
		Set<String> hs = new TreeSet<String>();
		hs.add("b");
		hs.add("a");
		hs.add("a");
		hs.add("b");
		hs.add(null);
		hs.add("c");
		
		//for(String str : hs) {
			//System.out.println(str);
		//}
		
		Iterator<String> it = hs.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void listDatastructure() {
		//List<String> lst = new ArrayList<String>();
		List<String> lst = new LinkedList<String>();
		lst.add("b");
		lst.add("a");
		lst.add("a");
		lst.add("b");
		lst.add(null);
		lst.add("c");
		
		for(String str : lst) {
			System.out.println(str);
		}
		
		
	}

}
