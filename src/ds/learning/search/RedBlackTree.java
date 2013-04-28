package ds.learning.search;

/**
 * This is Left-Leaning Red-Black Binary Search Tree. (LL RB BST)
 * 
 * @author KUMARDM
 * http://www.cs.princeton.edu/~rs/talks/LLRB/LLRB.pdf
 */
public class RedBlackTree {

	private RedBlackNode rootNode;
	
	public void insert(int number) {
		if(rootNode == null) {
			rootNode = new RedBlackNode(number, true);
		} else {
			rootNode = insert(rootNode, number);
		}
	}
	
	private RedBlackNode insert(RedBlackNode node, int number) {
		if(node == null) {
			return new RedBlackNode(number, true);
		} else if(number < node.data){
			node.left = insert(node.left, number);
		} else if(number > node.data){
			node.right = insert(node.right, number);
		} 

		if( !node.left.isRed() && node.right.isRed())
			rotateLeft(node);
		
		if( node.left.isRed() && node.left.left.isRed())
			rotateRight(node);
		
		if(node.left.isRed() && node.right.isRed()) 
			flipColor(node);
			
		return node;
	}
	
	public RedBlackNode rotateLeft(RedBlackNode node) {
		RedBlackNode right = node.right;
		RedBlackNode temp = right.left;
		right.left = node;
		node.right = temp;
		
		return right;
	}
	
	public RedBlackNode rotateRight(RedBlackNode node) {
		RedBlackNode left = node.left;
		RedBlackNode temp = left.right;
		left.right = node;
		node.left = temp;
		
		return left;
	}
	
	public void flipColor(RedBlackNode node) {
			node.left.red = false;
			node.right.red = false;
			node.red = true;
	}
	
}
