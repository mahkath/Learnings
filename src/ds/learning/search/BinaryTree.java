package ds.learning.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// An Awesome link for BST implementation and Utility operations on BST 
//http://cslibrary.stanford.edu/110/BinaryTrees.html#java
public class BinaryTree {
	// Root node pointer. Will be null for an empty tree.
	private Node root;

	/*
	 * --Node-- The binary tree is built using this nested node class. Each node
	 * stores one data element, and has left and right sub-tree pointer which
	 * may be null. The node is a "dumb" nested class -- we just use it for
	 * storage; it does not have any methods.
	 */
	private static class Node {
		Node left;
		Node right;
		int data;

		Node(int newData) {
			left = null;
			right = null;
			data = newData;
		}
	}

	/**
	 * Creates an empty binary tree -- a null root pointer.
	 */
	public void BinaryTree() {
		root = null;
	}

	/**
	 * Returns true if the given target is in the binary tree. Uses a recursive
	 * helper.
	 */
	public boolean lookup(int data) {
		return (lookup(root, data));
	}

	/**
	 * Recursive lookup -- given a node, recur down searching for the given
	 * data.
	 */
	private boolean lookup(Node node, int data) {
		if (node == null) {
			return (false);
		}

		if (data == node.data) {
			return (true);
		} else if (data < node.data) {
			return (lookup(node.left, data));
		} else {
			return (lookup(node.right, data));
		}
	}

	/**
	 * Inserts the given data into the binary tree. Uses a recursive helper.
	 */
	public void insert(int data) {
		root = insert(root, data);
	}

	/**
	 * Recursive insert -- given a node pointer, recur down and insert the given
	 * data into the tree. Returns the new node pointer (the standard way to
	 * communicate a changed pointer back to the caller).
	 */
	private Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}

		return (node); // in any case, return the new pointer to the caller
	}

	/*******************************************************/
	// The following is the list of many utility methods that can be executed on
	// BST
	/*******************************************************/
	// size() Solution (Java)
	/**
	 * Returns the number of nodes in the tree. Uses a recursive helper that
	 * recurs down the tree and counts the nodes.
	 */
	public int size() {
		return (size(root));
	}

	private int size(Node node) {
		if (node == null)
			return (0);
		else {
			return (size(node.left) + 1 + size(node.right));
		}
	}

	/*******************************************************/

	/**
	 * Returns the max root-to-leaf depth of the tree. Uses a recursive helper
	 * that recurs down to find the max depth.
	 */
	public int maxDepth() {
		return (maxDepth(root));
	}

	private int maxDepth(Node node) {
		if (node == null) {
			return (0);
		} else {
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			// use the larger + 1
			return (Math.max(lDepth, rDepth) + 1);
		}
	}

	/*******************************************************/

	/**
	 * Returns the min value in a non-empty binary search tree. Uses a helper
	 * method that iterates to the left to find the min value.
	 */
	public int minValue() {
		return (minValue(root));
	}

	/**
	 * Finds the min value in a non-empty binary search tree.
	 */
	private int minValue(Node node) {
		Node current = node;
		while (current.left != null) {
			current = current.left;
		}

		return (current.data);
	}

	/*******************************************************/

	/**
	 * Prints the node values in the "inorder" order. Uses a recursive helper to
	 * do the traversal.
	 */
	public void printTreeInorder() {
		printTreeInorder(root);
		System.out.println();
	}

	private void printTreeInorder(Node node) {
		if (node == null)
			return;

		// left, node itself, right
		printTreeInorder(node.left);
		System.out.print(node.data + "  ");
		printTreeInorder(node.right);
	}

	/*******************************************************/

	/**
	 * Prints the node values in the "postorder" order. Uses a recursive helper
	 * to do the traversal.
	 */
	public void printPostorder() {
		printPostorder(root);
		System.out.println();
	}

	public void printPostorder(Node node) {
		if (node == null)
			return;

		// first recur on both subtrees
		printPostorder(node.left);
		printPostorder(node.right);

		// then deal with the node
		System.out.print(node.data + "  ");
	}

	/*******************************************************/

	// 7. hasPathSum() Solution (Java)
	/**
	 * Given a tree and a sum, returns true if there is a path from the root
	 * down to a leaf, such that adding up all the values along the path equals
	 * the given sum. Strategy: subtract the node value from the sum when
	 * recurring down, and check to see if the sum is 0 when you run out of
	 * tree.
	 */
	public boolean hasPathSum(int sum) {
		return (hasPathSum(root, sum));
	}

	boolean hasPathSum(Node node, int sum) {
		// return true if we run out of tree and sum==0
		if (node == null) {
			return (sum == 0);
		} else {
			// otherwise check both subtrees
			int subSum = sum - node.data;
			return (hasPathSum(node.left, subSum) || hasPathSum(node.right,
					subSum));
		}
	}

	/*******************************************************/
	// isBST()
	/**
	 * Tests if a tree meets the conditions to be a binary search tree (BST).
	 * Uses the efficient recursive helper.
	 */
	public boolean isBST2() {
		return (isBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	/**
	 * Efficient BST helper -- Given a node, and min and max values, recurs down
	 * the tree to verify that it is a BST, and that all its nodes are within
	 * the min..max range. Works in O(n) time -- visits each node only once.
	 */
	private boolean isBST2(Node node, int min, int max) {
		if (node == null) {
			return (true);
		} else {
			// left should be in range min...node.data
			boolean leftOk = isBST2(node.left, min, node.data);

			// if the left is not ok, bail out
			if (!leftOk)
				return (false);

			// right should be in range node.data+1..max
			boolean rightOk = isBST2(node.right, node.data + 1, max);

			return (rightOk);
		}
	}

	/*******************************************************/

	//
	void bfsQueue() {
		Queue<Node> queue = new java.util.LinkedList<Node>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print("-" + node.data);
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
	}

	
	void bfsList() {
		List<Node> queue = new java.util.ArrayList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.remove(0);
			System.out.print("-" + node.data);
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}
	
	
	/*public void dfs() {
		// DFS uses Stack data structure
		Stack stack = new Stack();
		stack.push(this.root);
		while (!stack.isEmpty()) {
			Node node = (Node) stack.peek();
			if (node.left != null)
				stack.push(node.left);
			if (node.right != null)
				stack.push(node.right);
			
		}
		
		Iterator<Node> it = stack.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
	}*/

	public void allPathsTraversal(Node node, List<List<Node>> list) {
		Stack<Node> stack = new Stack<Node>();
	    stack.push(node);
	    if (!isLeaf(node)) {
	            allPathsTraversal(node.left, list);
	            allPathsTraversal(node.right, list);
	    }
	    if (isLeaf(node)) {
	        List<Node> path = new ArrayList<Node>();
	        for (Node aNode : stack) {
	            path.add(aNode);
	        }
	        list.add(path);
	    }
	    Node ret = stack.pop();
	    if (ret != null) {
	    	System.out.print("-"+ret.data);
	    }
	}
	
	private boolean isLeaf(Node node) {
	    return size(node) == 0;
	}
	
	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();

		bt.insert(5);
		bt.insert(4);
		bt.insert(2);
		bt.insert(3);
		bt.insert(7);
		bt.insert(6);
		bt.insert(8);

		System.out.println(bt.root.data);
		bt.bfsQueue();
		System.out.println();
		bt.bfsList();
//		List<List<Node>> list = new ArrayList<List<Node>>();
//		bt.allPathsTraversal(bt.root, list);
		// System.out.println(bt.lookup(5));
		// System.out.println(bt.isBST2());
	}

}
