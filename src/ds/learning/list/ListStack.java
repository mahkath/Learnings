package ds.learning.list;

/**
 * List-based implementation of the stack.
 * @author Mark Allen Weiss
 */
public class ListStack implements Stack {
	
	private ListNode topOfStack;
	
    /**
     * Construct the stack.
     */
    public ListStack( ) {
        topOfStack = null;
    }
    
    /**
     * Test if the stack is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( ) {
        return topOfStack == null;
    }
    
    /**
     * Make the stack logically empty.
     */
    public void makeEmpty( ) {
        topOfStack = null;
    }
    
    /**
     * Insert a new item into the stack.
     * @param x the item to insert.
     */
    public void push( Object x ) {
        topOfStack = new ListNode( x, topOfStack );
    }
    
    /**
     * Remove the most recently inserted item from the stack.
     * @throws UnderflowException if the stack is empty.
     */
    public void pop( ) {
        if( isEmpty( ) )
            throw new UnderflowException( "ListStack pop" );
        topOfStack = topOfStack.next;
    }
    
    /**
     * Get the most recently inserted item in the stack.
     * Does not alter the stack.
     * @return the most recently inserted item in the stack.
     * @throws UnderflowException if the stack is empty.
     */
    public Object top( ) {
        if( isEmpty( ) )
            throw new UnderflowException( "ListStack top" );
        return topOfStack.element;
    }
    /**
     * Return and remove the most recently inserted item
     * from the stack.
     * @return the most recently inserted item in the stack.
     * @throws UnderflowException if the stack is empty.
     */
    public Object topAndPop( ) {
        if( isEmpty( ) )
            throw new UnderflowException( "ListStack topAndPop" );
        
        Object topItem = topOfStack.element;
        topOfStack = topOfStack.next;
        return topItem;
    }
    
}

/**
 * Exception class for access in empty containers
 * such as stacks, queues, and priority queues.
 * @author Mark Allen Weiss
 */
class UnderflowException extends RuntimeException {
    /**
     * Construct this exception object.
     * @param message the error message.
     */
    public UnderflowException( String message ) {
        super( message );
    }
}

// Stack interface
//
// ******************PUBLIC OPERATIONS*********************
// void push( x )         --> Insert x
// void pop( )            --> Remove most recently inserted item
// Object top( )          --> Return most recently inserted item
// Object topAndPop( )    --> Return and remove most recent item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// top, pop, or topAndPop on empty stack
/**
 * Protocol for stacks.
 * @author Mark Allen Weiss
 */
 interface Stack {
    /**
     * Insert a new item into the stack.
     * @param x the item to insert.
     */
    void    push( Object x );
    
    /**
     * Remove the most recently inserted item from the stack.
     * @exception UnderflowException if the stack is empty.
     */
    void    pop( );
    
    /**
     * Get the most recently inserted item in the stack.
     * Does not alter the stack.
     * @return the most recently inserted item in the stack.
     * @exception UnderflowException if the stack is empty.
     */
    Object  top( );
    
    
    /**
     * Return and remove the most recently inserted item
     * from the stack.
     * @return the most recently inserted item in the stack.
     * @exception UnderflowException if the stack is empty.
     */
    Object  topAndPop( );
    
    /**
     * Test if the stack is logically empty.
     * @return true if empty, false otherwise.
     */
    boolean isEmpty( );
    
    /**
     * Make the stack logically empty.
     */
    void    makeEmpty( );
}

// Basic node stored in a linked list
// Note that this class is not accessible outside
// of package weiss.nonstandard
class ListNode {
	  
    public Object   element;
    
    public ListNode next;
    
    // Constructors
    public ListNode( Object theElement ) {
        this( theElement, null );
    }
    
    public ListNode( Object theElement, ListNode n ) {
        element = theElement;
        next    = n;
    }
  
}