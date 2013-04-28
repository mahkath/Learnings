package ds.learning.list.misc;

class ReverseInt {
	  public static void main(String[] args) {
		  System.out.println(reverseAnInteger(102));
	  }
	  
	  public static int reverseAnInteger(int testInteger) {
	       int rev = 0;
	       while (testInteger / 10 != 0) {
	         rev = (rev * 10) + testInteger % 10;
	         System.out.println("Rev:"+rev);
	         testInteger = testInteger / 10;
	         System.out.println("testInteger:"+testInteger);
	       }
	       rev = (rev * 10) + testInteger;
	       return rev;
	   }
}