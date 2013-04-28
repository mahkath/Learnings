package ds.learning.list.graph;

import java.util.HashSet;
import java.util.Set;

public class Vertex  implements Comparable<Vertex> {
	String data;
	boolean isVisited = false;
	
	int dist = Integer.MAX_VALUE;
	
	Set<Edge> adj = new HashSet<Edge>();
	
	public Vertex() {}
	
	public Vertex(String data) {
		this.data = data;
	}
	
	public void addEdge(Edge e) {
		adj.add(e);
	}
	
	@Override
	public int compareTo(Vertex o) {
		if(this.dist < o.dist)
			return -1;
		else if(this.dist > o.dist)
			return 1;
		else
			return 0;
	}
}