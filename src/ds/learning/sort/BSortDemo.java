package ds.learning.sort;

class BSortDemo {
	
   public static void main (String [] args) {
	   int pass;
	   int [] array = { 20, 15, 12, 30, -5, 72, 456 };
	   int tmp;
	   
	   for (pass = 0 ; pass < array.length - 2; pass++) {
		   for (int i=0; i < array.length - pass -2; i++) {
			   if (array[i] > array[i+1]) {
				   tmp = array[i];
				   array[i] = array[i+1];
				   array[i + 1] = tmp;
			   }
		   }
	   }
	   
	   for (int i = 0; i <  array.length; i++) {
	    	  System.out.println (array[i]);
	      }
	   
	   /*
      int i, pass;
      int [] x = { 20, 15, 12, 30, -5, 72, 456 };
      
      for (pass = 0; pass <= x.length - 2; pass++) {
    	  System.out.println("Pass:"+pass);
           for (i = 0; i <= x.length - pass - 2; i++) {
        	   System.out.println("i="+i);
               if (x [i] >  x [i + 1]) {
                   int temp = x [i];
                   x [i] = x [i + 1];
                   x [i + 1] = temp;
               }   
           }
      }
      
      for (i = 0; i <  x.length; i++) {
//    	  System.out.println (x [i]);
      }
          
   */}
   
}