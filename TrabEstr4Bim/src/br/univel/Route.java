package br.univel;

public class Route {
	private Route origin;
	private City city;
	private Route next;
	private Double totalDistance;

	public Double getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(Double totalDistance) {
		this.totalDistance = totalDistance;
	}

	public Route getOrigin() {
		return origin;
	}

	public void setOrigin(Route origin) {
		this.origin = origin;
	}

	public Route getNext() {
		return next;
	}

	public void setNext(Route next) {
		if (next != null)
			next.setOrigin(this.origin);
		this.next = next;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Route[] getCompleteRoute() {
		Route[] routes = new Route[this.size()];
		Route route = this.origin;
		int count = 0;
		while (route != null) {
			routes[count++] = route;
			route = route.next;
		}
		return routes;
	}

	private int size() {
		int count = 0;
		Route route = this.origin;
		while (route != null) {
			count++;
			route = route.next;
		}
		return count;
	}
}
