package ds.learning.list.graph;

import java.util.LinkedList;

public class DirectedGraph {

	Vertex[] vertices = new Vertex[8];
	int numberOfVertices = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph();
		graph.addEdge("a", "b", 1);
		graph.addEdge("a", "c", 8);
		graph.addEdge("b", "d", 1);
		graph.addEdge("c", "d", 2);
		graph.addEdge("e", "c", 2);
		graph.addEdge("d", "f", 8);
		graph.addEdge("d", "g", 1);
		graph.addEdge("g", "e", 2);
		graph.addEdge("g", "f", 4);
		
		graph.depthFirstSearch("c");
		//graph.breadthFirstSearch("f");
	}
	
	public DirectedGraph() {
		addEdge("a", "b", 1);
		addEdge("a", "c", 8);
		addEdge("b", "d", 1);
		addEdge("c", "d", 2);
		addEdge("e", "c", 2);
		addEdge("d", "f", 8);
		addEdge("d", "g", 1);
		addEdge("g", "e", 2);
		addEdge("g", "f", 4);
	}
	
	public void addEdge(String from, String to, int weight) {
		Vertex v1 = null;
		Vertex e1 = null;
		
		for(int i=0; i<numberOfVertices; i++) {
			Vertex vertex = vertices[i];
			if(vertex.data.equals(from)) {
				v1 = vertex;
			} else if(vertex.data.equals(to)) {
				e1 = vertex;
			}
		}
		
		if(v1 == null) {
			v1 = new Vertex(from);
			vertices[numberOfVertices] = v1;
			numberOfVertices++;
		}
		
		if(e1 == null) {
			e1 = new Vertex(to);
			vertices[numberOfVertices] = e1;
			numberOfVertices++;
		}
		
		Edge edge = new Edge(from, to, weight);
		v1.adj.add(edge);
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
			for(Edge edge : v.adj) {
				Vertex to = getVertex(edge.to);
				if(!to.isVisited) {
					boolean found = dfs(to, data);
					if(found) {
						System.out.println("Path ->" + v.data);
						return found;
					}
				}
			}
			return false;
		}
	}
	
	public Vertex getVertex(String v) {
		for(int i=0; i<numberOfVertices; i++) {
			Vertex vertex = vertices[i];
			if(vertex.data.equals(v)) {
				return vertex;
			} 
		}
		
		return null;
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
			for(Edge edge: vertex.adj) {
				Vertex to = getVertex(edge.to);
				if(!to.isVisited) {
					queue.add(to);
				}
			}
		}
		return false;
	}

	
	
}


