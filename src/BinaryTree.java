
public class BinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>();
		tree.add(5);
		tree.add(3);
		tree.add(6);
		tree.add(1);
		tree.add(9);
		tree.add(10);
		tree.add(2);
		
		tree.list();
		
		if(tree.search(11) != null) {
			System.out.println("Yey!! Got It");
		} else {
			System.out.println("Not found data");
		}
	}

}

class Node<T> {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
	private T data;
	private Node<T> left = null;
	private Node<T> right = null;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getLeft() {
		return left;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	public Node<T> getRight() {
		return right;
	}
	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	
}
class Tree<T extends Comparable<T>> {
	private Node<T> head = null;
	public void add(T o) {
		head = add(o, head);
	}
	
	private Node<T> add(T o, Node<T> node) {
		if(node == null) {
			node = new Node<T>();
			node.setData(o);
			return node;
		} else if(o.compareTo(node.getData()) < 0) {
			 node.setLeft(add(o, node.getLeft()));
		} else if(o.compareTo(node.getData()) > 0) {
			node.setRight(add(o, node.getRight()));
		}
		return node;
	}
	
	public void list() {
		if(head == null) {
			System.out.println("Empty Tree");
			return;
		} else {
			inOrder(head);
		}
	}
	
	private void inOrder(Node<T> node) {
		if(node != null) {
			inOrder(node.getLeft());
			System.out.println(node.getData());
			inOrder(node.getRight());
		} else {
			return;
		}
	}
	
	public T search(T o) {
		if(o == null) {
			System.out.println("Search Item is NULL");
			return null;
		} else if(head == null) {
			System.out.println("Data is Empty in Tree");
			return null;
		} else {
			return inOrderSearch(head, o);
		}
	}
	
	private T inOrderSearch(Node<T> node, T o) {
		if(node == null) {
			System.out.println("Not Found");
			return null;
		}
		
		if(o.compareTo(node.getData()) < 0) {
			return inOrderSearch(node.getLeft(), o);
		}  else if(o.compareTo(node.getData()) > 0) {
			return inOrderSearch(node.getRight(), o);
		} else {
			System.out.println("Found");
			return node.getData();
		}
	}
}
