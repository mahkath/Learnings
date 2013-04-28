package ds.learning.list;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Graph {

	private Vertex[] vertices = new Vertex[8];
	int numberOfVertices = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge("a", "b");
		graph.addEdge("a", "c");
		graph.addEdge("b", "d");
		graph.addEdge("c", "d");
		graph.addEdge("c", "e");
		graph.addEdge("d", "f");
		graph.addEdge("d", "g");
		graph.addEdge("e", "g");
		graph.addEdge("f", "g");
		
		//graph.depthFirstSearch("e");
		graph.breadthFirstSearch("f");
	}
	
	public void addEdge(String v, String e) {
		Vertex v1 = null;
		Vertex e1 = null;
		
		for(int i=0; i<numberOfVertices; i++) {
			Vertex vertex = vertices[i];
			if(vertex.data.equals(v)) {
				v1 = vertex;
			} else if(vertex.data.equals(e)) {
				e1 = vertex;
			}
		}
		
		if(v1 == null) {
			v1 = new Vertex(v);
			vertices[numberOfVertices] = v1;
			numberOfVertices++;
		}
		
		if(e1 == null) {
			e1 = new Vertex(e);
			vertices[numberOfVertices] = e1;
			numberOfVertices++;
		}
		
		v1.adj.add(e1);
		e1.adj.add(v1);
	}
	
	public void depthFirstSearch(String item) {
		Vertex v = vertices[0];
		boolean found = dfs(v, item);
		
		if(found) {
			System.out.println("Found");
		} else {
			System.out.println("Not Found");
		}
	}
	
	private boolean dfs(Vertex v, String data) {
		v.isVisited = true;
		if(v.data == data) {
			return true;
		} else {
			for(Vertex adj : v.adj) {
				if(!adj.isVisited) {
					boolean found = dfs(adj, data);
					if(found) {
						System.out.println("Path ->" + v.data);
						return found;
					}
				}
			}
			return false;
		}
	}
	
	public void breadthFirstSearch(String item) {
		Vertex v = vertices[0];
		System.out.println(bfs(v, item));
	}
	
	private boolean bfs(Vertex v, String data) {
		java.util.Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(v);
		java.util.Queue<String> path = new LinkedList<String>();
		path.add(v.data);
		
		while(!queue.isEmpty()) {
			Vertex vertex = queue.remove();
			vertex.isVisited = true;
			System.out.println(vertex.data);
			if(vertex.data.equals(data)) {
				return true;
			}
			for(Vertex adj: vertex.adj) {
				if(!adj.isVisited) {
					queue.add(adj);
				}
			}
		}
		return false;
	}

}

class Vertex {
	String data;
	boolean isVisited = false;
	Set<Vertex> adj = new HashSet<Vertex>();
	
	public Vertex() {}
	
	public Vertex(String data) {
		this.data = data;
	}
}
