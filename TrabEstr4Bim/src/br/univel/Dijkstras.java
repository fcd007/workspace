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
		g.addVertex("FOZ", Arrays.asList(new Vertex("CASCAVEL", 50),new Vertex("CURITIBA", 150)));
		g.addVertex("CASCAVEL", Arrays.asList(new Vertex("IRATI", 100),new Vertex("FOZ", 50)));
		g.addVertex("IRATI", Arrays.asList(new Vertex("CURITIBA", 10),new Vertex("CASCAVEL", 100)));
		g.addVertex("CURITIBA", Arrays.asList(new Vertex("FOZ", 150),new Vertex("IRATI", 10)));
		
		System.out.println(g.getShortestPath("FOZ", "CURITIBA"));
//		for(String distance : g.getResult().keySet()){
//			System.out.println(distance+" -- "+g.getResult().get(distance));
//		}
	}

	
}