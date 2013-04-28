package ds.learning.list;

public class Queue {
	   private int qMaxSize;// max queue size
	   private int frontPointer = 0;  // front pointer
	   private int rearPointer = 0;  // rear pointer
	   private int qSize = 0;  // size of queue
	   private char[] queue;    // actual queue

	   public Queue(int size) {
	      qMaxSize = size;
	      frontPointer = 0;
	      rearPointer = 0;
	      qSize = 0;
	      queue = new char[qMaxSize];
	   }

	   public char delete() {
	      if (!emptyq()) {
	         qSize--;
	         frontPointer = (frontPointer + 1)%qMaxSize;
	         return queue[frontPointer];
	      }
	      else {
	         System.err.println("Underflow");
	         return '?';
	      }
	   }

	   public void insert(char c) {
	      if (!fullq()) {
	         qSize++;
	         rearPointer = (rearPointer + 1)%qMaxSize;
	         queue[rearPointer] = c;
	      }
	      else
	         System.err.println("Overflow\n");
	   }

	   public boolean emptyq() {
	      return qSize == 0;
	   }

	   public boolean fullq() {
	      return qSize == qMaxSize;
	   }
	   
	   public void printq() {
	      System.out.print("Size: " + qSize +
	         ", rp: " + rearPointer + ", fp: " + frontPointer + ", q: ");
	      for (int i = 0; i < qMaxSize; i++)
	         System.out.print("q[" + i + "]=" 
	            + queue[i] + "; ");
	      System.out.println();
	   }
	}