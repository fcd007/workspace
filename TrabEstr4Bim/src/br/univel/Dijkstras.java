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