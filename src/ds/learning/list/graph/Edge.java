package ds.learning.list.graph;


public class Edge implements Comparable<Edge>{
	String from;
	String to;
	
	int weight;
	
	public Edge() {}
	
	public Edge(String from, String to) {
		this.from = from;
		this.to = to;
		this.weight = 0;
	}
	
	public Edge(String from, String to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		if(this.weight < o.weight)
			return -1;
		else if(this.weight > o.weight)
			return 1;
		else
			return 0;
	}
}
