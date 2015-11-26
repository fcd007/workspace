package br.univel;

import java.util.LinkedHashMap;
import java.util.Map;

public class City {
	private String name;
	private Integer code;
	private Map<Integer, Double> links;
	
	public City(String name, Integer code) {	
		links = new LinkedHashMap<Integer, Double>();
		this.name=name;
		this.code=code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Integer, Double> getLinks() {
		return links;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	} 
	
	public void setRoute(City city, Double distance){
		links.put(city.getCode(), distance);
	}
	
}
