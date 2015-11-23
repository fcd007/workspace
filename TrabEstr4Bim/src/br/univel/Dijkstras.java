package br.univel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstras {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex("Cascavel", Arrays.asList(new Vertex("Medianeira", 7), new Vertex("Toledo", 8), new Vertex("Curitiba", 1)));
		g.addVertex("Medianeira", Arrays.asList(new Vertex("Cascavel", 7), new Vertex("Ceu Azul", 2)));
		g.addVertex("Toledo", Arrays.asList(new Vertex("Cascavel", 8), new Vertex("Ceu Azul", 6), new Vertex("Cafelandia", 4)));
		g.addVertex("Santa Tereza", Arrays.asList(new Vertex("Ceu Azul", 8)));
		g.addVertex("Ramilandia", Arrays.asList(new Vertex("Curitiba", 1)));
		g.addVertex("Ceu Azul", Arrays.asList(new Vertex("Medianeira", 2), new Vertex("Toledo", 6), new Vertex("Santa Tereza", 8), new Vertex("Cafelandia", 9), new Vertex("Curitiba", 3)));
		g.addVertex("Cafelandia", Arrays.asList(new Vertex("Toledo", 4), new Vertex("Ceu Azul", 9)));
		g.addVertex("Curitiba", Arrays.asList(new Vertex("Ramilandia", 1), new Vertex("Ceu Azul", 3),new Vertex("Cascavel", 1)));
		System.out.println(g.getShortestPath("Cascavel", "Curitiba"));
		for(String distance : g.getResult().keySet()){
			System.out.println(distance+" -- "+g.getResult().get(distance));
		}
	}
	
}

class Vertex implements Comparable<Vertex> {
	
	private String id;
	private Integer distance;
	
	public Vertex(String id, Integer distance) {
		super();
		this.id = id;
		this.distance = distance;
	}

	public String getId() {
		return id;
	}

	public Integer getDistance() {
		return distance;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Vertex other = (Vertex) obj;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertex [id=" + id + ", distance=" + distance + "]";
	}

	@Override
	public int compareTo(Vertex o) {
		return this.distance < o.distance ? -1 : this.distance == o.distance ? 0 : 1;  
	}
	
}

class Graph {
	
	private final Map<String, List<Vertex>> vertices;
	private Map<String, Integer> result= new LinkedHashMap<>();
	
	
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
				nodes.add(new Vertex(vertex, 0));
			} else {
				distances.put(vertex, Integer.MAX_VALUE);
				nodes.add(new Vertex(vertex, Integer.MAX_VALUE));
			}
			previous.put(vertex, null);
		}
		
		while (!nodes.isEmpty()) {
			Vertex smallest = nodes.poll();
			if (smallest.getId() == finish) {
				path = new LinkedList<String>();
				while (previous.get(smallest.getId()) != null) {
					path.add(smallest.getId()+" -- "+smallest.getDistance());
					smallest = previous.get(smallest.getId());
				}
//				result;
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

	public Map<String, Integer> getResult() {
		return result;
	}

	public void setResult(Map<String, Integer> result) {
		this.result = result;
	}
	
}