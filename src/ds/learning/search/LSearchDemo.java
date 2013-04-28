package ds.learning.search;


// Adv:  Ease of use, simple 
// DisAdv: time consuming
class LSearchDemo
{
   public static void main (String [] args)
   {
      int i, srch = 72;
      int [] x = { 20, 15, 12, 30, -5, 72, 456 };
      for (i = 0; i <= x.length - 1; i++) {
           if (x [i] == srch) {
               System.out.println ("Found " + srch);
               return;
           }
      }
      System.out.println ("Did not find " + srch);
   }
}