package br.univel;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Graph {
	
	private final Map<String, List<Vertex>> vertices;
	
	public Graph() {
		this.vertices = new LinkedHashMap<String, List<Vertex>>(); 
	}
	
	public void addVertex(String character, List<Vertex> vertex) {
		this.vertices.put(character, vertex);
	}
	
	public List<String> getShortestPath(String start, String finish) {
		Map<String, Integer> distances = new LinkedHashMap<String, Integer>();
		PriorityQueue<Vertex> nodes = new PriorityQueue<Vertex>();
		Map<String, Vertex> previous = new LinkedHashMap<String, Vertex>();
		List<String> path = new LinkedList<String>();
		
		for(String vertex : vertices.keySet()) {
			if (vertex.equals(start)) {
				distances.put(vertex, 0);
				nodes.add(new Vertex(vertex+"", 0));
			} else {
				distances.put(vertex, Integer.MAX_VALUE);
				nodes.add(new Vertex(vertex+"", Integer.MAX_VALUE));
			}
			previous.put(vertex, null);
		}
		
		while (!nodes.isEmpty()) {
			Vertex smallest = nodes.poll();
			if (smallest.getId().equals(finish)) {
				path = new LinkedList<String>();
				while (previous.get(smallest.getId()) != null) {
					path.add(smallest.getId());
					smallest = previous.get(smallest.getId());
				}
				return path;
			}

			if (distances.get(smallest.getId()) == Integer.MAX_VALUE) {
				break;
			}
						
			for (Vertex neighbor : vertices.get(smallest.getId())) {
				Integer alt = distances.get(smallest.getId()) + neighbor.getDistance();
				if (alt < distances.get(neighbor.getId())) {
					distances.put(neighbor.getId(), alt);
					previous.put(neighbor.getId(), smallest);
					
					forloop:
					for(Vertex n : nodes) {
						if (n.getId() == neighbor.getId()) {
							n.setDistance(alt);
							break forloop;
						}
					}
				}
			}
		}
		
		return new ArrayList<String>(distances.keySet());
	}
	
}