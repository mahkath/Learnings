package ds.learning.search;

class BSearchDemo {
	
	/*public static void main (String [] args) {
      int [] array = { -5, 12, 15, 20, 30, 72, 456 };
      
      int loIndex = 0;
      int hiIndex = array.length - 1;
      int midIndex, srch = 72;
      
      while (loIndex <= hiIndex) {
         midIndex = (loIndex + hiIndex) / 2;
         if (srch > array [midIndex])
             loIndex = midIndex + 1;
         else
         if (srch < array [midIndex])
             hiIndex = midIndex - 1;
         else
             break;
      }
      if (loIndex > hiIndex)
          System.out.println (srch + " not found");
      else
          System.out.println (srch + " found");
   }*/
   
	public static void main (String [] args) {
		int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		int lower = 0;
		int higher = array.length -1;
		int midIndex = -1;
		int searchKey = 6;
		
		while (higher >= lower) {
			midIndex = (lower + higher)/2;
			if (array[midIndex] < searchKey) {
				lower = midIndex + 1;
			} else if (array[midIndex] > searchKey) {
				higher = midIndex - 1; 
			} else {
				break;
			}
		}
		
		if (lower > higher) {
			System.out.println("Not found");
		} else {
			System.out.println("found:"+ array[midIndex]);
		}
		
	}
   
}