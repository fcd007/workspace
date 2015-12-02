package br.univel;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		Dijkstras dijkstras =new Dijkstras();
//		dijkstras.insertCity(new City("FOZ", 1));
//		dijkstras.insertCity(new City("CASCAVEL", 2));
//		dijkstras.insertCity(new City("LARANJEIRAS", 3));
//		dijkstras.insertCity(new City("IRATI", 4));
//		dijkstras.insertCity(new City("CURITIBA", 5));
//		dijkstras.insertCity(new City("ESPIGAO AZUL", 6));
//		dijkstras.attatchCities(1, 2, new Double(50));
//		dijkstras.attatchCities(1, 6, new Double(80));
//		dijkstras.attatchCities(6, 5, new Double(10));
//		dijkstras.attatchCities(2, 4, new Double(100));
//		dijkstras.attatchCities(4, 5, new Double(10));
//		dijkstras.attatchCities(1, 5, new Double(150));
//		System.out.println(dijkstras.getStringPath(dijkstras.getShortestPath(1, 5)));
		
		int cont=0;
		while(true){
			StringBuilder sb = new StringBuilder();
			sb.append("1 - Inserir Cidade\n");
			sb.append("2 - Conectar Cidades\n");
			sb.append("3 - Calcular caminho mais curto");
			Integer result = Integer.parseInt(JOptionPane.showInputDialog(null, sb.toString()));
			switch (result) {
			case 1:{
				String name = JOptionPane.showInputDialog(null, "Insira o nome da cidade");
				dijkstras.insertCity(new City(name, ++cont));
				JOptionPane.showMessageDialog(null, cont + " - "+name);
				break;
			}
			case 2:{
				Integer c1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira Codigo da primeira cidade"));
				Integer c2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira Codigo da segunda cidade"));
				Double distance = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira a distancia"));
				dijkstras.attatchCities(c1, c2, distance);
				break;
			}
			case 3:{
				Integer c1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira Codigo da primeira cidade"));
				Integer c2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira Codigo da segunda cidade"));
				JOptionPane.showMessageDialog(null, dijkstras.getStringPath(dijkstras.getShortestPath(c1, c2)));
				break;
			}
			default:
				break;
			}
		}
	}
	
	
}
