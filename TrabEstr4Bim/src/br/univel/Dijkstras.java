package br.univel;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Dijkstras {

	private Map<Integer, City> cities;
	private List<Route[]> matchedRoutes;

	public Dijkstras() {
		cities = new LinkedHashMap<Integer, City>();
		matchedRoutes = new LinkedList<>();
	}

	public void insertCity(City city) {
		cities.put(city.getCode(), city);
	}

	public boolean attatchCities(int code1, int code2, Double distance) {
		City city1 = cities.get(code1);
		City city2 = cities.get(code2);
		city1.setRoute(city2, distance);
		city2.setRoute(city1, distance);
		return true;

	}

	public Route[] getShortestPath(Integer code1, Integer code2) {
		City origin = null;
		City destiny = null;
		for (Integer key : cities.keySet()) {
			City current = cities.get(key);
			if (current.getCode() == code1) {
				origin = current;
				continue;
			}
			if (current.getCode() == code2) {
				destiny = current;
				continue;
			}

		}
		List<Route> routes = new LinkedList<>();
		Route currentRoute = new Route();
		currentRoute.setCity(origin);
		currentRoute.setOrigin(currentRoute);
		getRoutes(destiny, currentRoute);
		Route[] shortestPath = null;
		Double minPath = new Double(0);
		for (int i = 0; i < this.matchedRoutes.size(); i++) {
			Route[] route = this.matchedRoutes.get(i);
			if (i == 0) {
				minPath = getDistance(route);
				shortestPath = route;
			}
			Double distance = getDistance(route);
			if (distance.compareTo(minPath) < 0) {
				shortestPath = route;
				minPath = distance;
			}
		}
		return shortestPath;
	}

	public String getStringPath(Route[] route) {
		StringBuilder sb = new StringBuilder();
		if (route != null) {
			for (int i = 0; i < route.length; i++) {
				sb.append(route[i].getCity().getName() + " --> ");
			}
			sb.append(getDistance(route).toString());
		}else{
			sb.append("Nenhuma rota encontrada");
		}
		return sb.toString();
	}

	private Double getDistance(Route[] route) {
		Double distance = new Double(0);
		for (int i = 0; i < route.length - 1; i++) {
			distance = Double.sum(distance, route[i].getCity().getLinks().get(route[i + 1].getCity().getCode()));
		}
		return distance;
	}

	private void getRoutes(City destiny, Route currentRoute) {
		if (currentRoute.getCity().getCode() == destiny.getCode()) {
			this.matchedRoutes.add(currentRoute.getCompleteRoute());
			return;
		}
		for (Integer key : currentRoute.getCity().getLinks().keySet()) {
			City city = cities.get(key);
			if (!isInRoute(city, currentRoute.getOrigin())) {
				Route route = new Route();
				route.setCity(city);
				currentRoute.setNext(route);
				getRoutes(destiny, currentRoute.getNext());
				currentRoute.setNext(null);
			}

		}
	}

	private boolean isInRoute(City city, Route currentRoute) {
		while (currentRoute != null) {
			if (currentRoute.getCity().getCode() == city.getCode())
				return true;
			currentRoute = currentRoute.getNext();
		}
		return false;
	}
}