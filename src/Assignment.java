import java.util.List;


public class Assignment {

	
	/**
	 * This method return index of source where target is starting.
	 * 
	 * @param source
	 * @param target
	 * @return index
	 */
	public static int indexOfSubList(List<?> source, List<?> target) {
		int INDEX = -1;
		int i = 0, j=0;
		
		//If Source or Target is NULL OR Source or Target length is ZERO then return -1
		if(source == null || target == null || source.size() == 0 || target.size() == 0) {
			return INDEX;
		}
		
		//If Target length > Source length then return -1
		if(target.size() > source.size()) {
			return INDEX;
		}
		
		for(; i< source.size() && j< target.size(); i++) {
			if(source.get(i).equals(target.get(j))) {
				j++;
				if(INDEX == -1) {
					INDEX = i;
				}
			} else {
				j=0;
				INDEX = -1;
			}
		}
		
		//If j is Target length then it means we came out of loop successfull hence return INDEX else -1
		return (j==target.size())? INDEX : -1;
	}

}
