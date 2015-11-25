package br.univel;

public class Main {
	public static void main(String[] args) {
		Dijkstras dijkstras =new Dijkstras();
		dijkstras.insertCity(new City("FOZ", 1));
		dijkstras.insertCity(new City("CASCAVEL", 2));
		dijkstras.insertCity(new City("LARANJEIRAS", 3));
		dijkstras.insertCity(new City("IRATI", 4));
		dijkstras.insertCity(new City("CURITIBA", 5));
		dijkstras.attatchCities(1, 2, new Double(50));
		dijkstras.getShortestPath(1, 3);
	}
}
