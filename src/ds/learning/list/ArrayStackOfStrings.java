package ds.learning.list;

import java.util.Iterator;


// http://introcs.cs.princeton.edu/java/43stack/
// Array implementation
public class ArrayStackOfStrings implements Iterable<String> {
	
    private String[] a;  // holds the items
    private int N;       // number of items in stack

    public ArrayStackOfStrings(int max) {  a = new String[max];       }
    
    public boolean isEmpty()            {  return (N == 0);           }
    
    public void push(String item)       {  a[N++] = item;             }
    
    public String pop()                 {  return a[--N];             }
    
    public Iterator<String> iterator()  { return new ArrayIterator(); }
    
    public int size() {
    	return N;
    }


    public class ArrayIterator implements Iterator<String> {
        private int i = N-1;

        public boolean hasNext() { return i >= 0; }
        public String next()     { return a[i--]; }
        public void remove()      { throw new UnsupportedOperationException(); }
    }


    public static void main(String[] args) {
//        int max = Integer.parseInt(args[0]);
        int max = 10;
        // Create new Stack 
        ArrayStackOfStrings stack = new ArrayStackOfStrings(max);

        System.out.println("Enter a string to add to the stack \n");
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("STOP")) {
            	if (stack.size() >= max) {
            		System.out.println("Stack Overflow - Cannot add more elements");
            		continue;
            	} else {
            		stack.push(item);
            	}
            } else if (stack.isEmpty()) {
            	System.out.println("STACK IS FULL"); 
            } else {
            	System.out.println(stack.pop() + " ");
            }
        }
        System.out.println();

        // print what's left on the stack
        System.out.print("Left on stack: ");
        for (String s : stack) {
        	System.out.println(s + " ");
        }
        System.out.println();
    } 
} 