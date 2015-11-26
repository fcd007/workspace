package br.univel;

public class Main {
	public static void main(String[] args) {
		Dijkstras dijkstras =new Dijkstras();
		dijkstras.insertCity(new City("FOZ", 1));
		dijkstras.insertCity(new City("CASCAVEL", 2));
		dijkstras.insertCity(new City("LARANJEIRAS", 3));
		dijkstras.insertCity(new City("IRATI", 4));
		dijkstras.insertCity(new City("CURITIBA", 5));
		dijkstras.insertCity(new City("ESPIGAO AZUL", 6));
		dijkstras.attatchCities(1, 2, new Double(50));
		dijkstras.attatchCities(1, 6, new Double(80));
		dijkstras.attatchCities(6, 5, new Double(10));
		dijkstras.attatchCities(2, 4, new Double(100));
		dijkstras.attatchCities(4, 5, new Double(10));
		dijkstras.attatchCities(1, 5, new Double(150));
		System.out.println(dijkstras.getStringPath(dijkstras.getShortestPath(1, 5)));
	}
}
