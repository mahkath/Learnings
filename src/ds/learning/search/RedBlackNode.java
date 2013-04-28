package ds.learning.search;


public class RedBlackNode {

	RedBlackNode left;
	RedBlackNode right;
	int data;
	boolean red;
	
	RedBlackNode(int newData, boolean red) {
		left = null;
		right = null;
		data = newData;
		this.red = red;
	}
	
	public boolean isRed() {
		return red;
	}

}
