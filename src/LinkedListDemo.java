
public class LinkedListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListDemo d=new LinkedListDemo();
		
		LinkedList list = d.new LinkedList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		
		list.list();
		System.out.println("-----------");
		//System.out.println( list.get(3));
		//System.out.println("-----------");
		
//		System.out.println(list.remove());
//		System.out.println("-----------");
//		list.list();
//		System.out.println("-----------");
//		System.out.println( list.get(3));
		list.reverse();
		
		list.add("z");
		list.list();
	}

	class Node {
		private String data;
		private Node next = null;
		
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	class LinkedList {
		Node head = null;
		Node tail = null;
		int size = 0;
		
		public void add(String data) {
			Node node = new Node();
			node.setData(data);
			
			if(head == null) {
				head = node;
				tail = node;
			} else {
				tail.setNext(node);
				tail = node;
			}
			size++;
		}
		
		public String get(int index) {
			if(head == null || index < 0 || index >= size) {
				return null;
			}
			
			Node node = head;
			for(int count=0; count != index && node!= null; count++) {
				node = node.getNext();
			}
			return node.getData();
		}
		
		public void list() {
			Node node = head;
			for(int i=0; i<size && node != null; i++) {
				System.out.println(node.getData());
				node = node.getNext();
			}
		}
		
		public String remove() {
			if(head == null) {
				return null;
			}
			
			String data = head.getData();
			head = head.getNext();
			size--;
			return data;
		}
		
		public void reverse() {
			Node revHead = null;
			Node temp = null;
			Node node = head;
			while(node != null) {
				temp = node.getNext();
				node.setNext(revHead);
				revHead = node;
				node = temp;
			}
			tail = head;
			head = revHead;
		}
	}
}

