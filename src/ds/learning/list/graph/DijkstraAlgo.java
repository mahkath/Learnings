package ds.learning.list.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraAlgo {

	Map<String, Integer> distTo = new HashMap<String, Integer>();
	Edge edgeTo[];
	
	public DijkstraAlgo(DirectedGraph graph, String from) {
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		Vertex v = graph.getVertex(from);
		pq.add(v);
		v.dist = 0;
		
		while(!pq.isEmpty()) {
			Vertex vertex = pq.poll();
			distTo.put(vertex.data, vertex.dist);
			vertex.isVisited = true;
			
			for(Edge edge : vertex.adj) {
				Vertex node = graph.getVertex(edge.to);
				int prevDist = distTo.get(edge.to) != null ? distTo.get(edge.to).intValue() : Integer.MAX_VALUE;
				if(prevDist >  vertex.dist + edge.weight) {
					distTo.put(edge.to, vertex.dist + edge.weight);
				}
				
				if(!node.isVisited) {
					node.dist = vertex.dist + edge.weight;
					pq.add(node);
				}
				System.out.println(vertex.data + "->" + edge.to + " : " + prevDist);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DirectedGraph graph = new DirectedGraph();
		DijkstraAlgo sp = new DijkstraAlgo(graph, "a");
		System.out.println(sp.distTo.get("c"));
	}

}
