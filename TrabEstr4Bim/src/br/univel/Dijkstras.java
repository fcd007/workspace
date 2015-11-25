package br.univel;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Dijkstras {
	
	private Map<Integer, City> cities;
	
	public Dijkstras() {
		cities = new LinkedHashMap<Integer, City>();
	}
	
	public void insertCity(City city){
		cities.put(city.getCode(),city);
	}
	
	public boolean attatchCities(int code1, int code2, Double distance){
		City city1  = cities.get(code1);
		City city2 = cities.get(code2);
		city1.setRoute(city2, distance);
		city2.setRoute(city1, distance);
		return true;
		
	}
	
	public List<City> getShortestPath(Integer code1, Integer code2){
		City city1=null;
		for (Integer key : cities.keySet()) {
			city1= cities.get(key);
			if(city1.getCode() == code1){
				break;
			}
		}
		System.out.println(getDistance(city1, code2, city1.getCode()));
//		getDistance(city1, code2);
		return null;
	}


	private boolean getDistance(City current, Integer destiny, Integer origin) {
		if(current.getCode() == destiny){
			return true;
		}
		if(!current.getAttachments().isEmpty() && origin != current.getCode()){
			for(Integer key : current.getAttachments().keySet()){
				City city = cities.get(key);
				
				if(getDistance(city, destiny, origin))
					return true;
			}
		}
			
		return false;
	}

//	class Node {
//		private City city;
//		List<Node> attachments;
//	}
}