package br.univel.Emuamba;

import java.math.BigDecimal;

public class Produto {
	String name;
	int code;
	BigDecimal price;
	
	public Produto(){
		
	}
	
	public Produto(String line){
		String code = line.substring(0, 12).replaceAll("\\.", "");
		String name = line.substring(12);
		name = name.substring(0, name.indexOf("...")).replaceAll("\\.", "");
		String price = line.substring(line.lastIndexOf("...")+5);
		
		this.code = Integer.parseInt(code);
		this.name = name;
		this.price = new BigDecimal(price.replaceAll(",", "").replace(',', '.'));
	}
	
	public Produto(String name, String code, String price) {
		this();
		this.code = Integer.parseInt(code);
		this.name = name;
		this.price = new BigDecimal(price.replace(',', '.'));
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{\"code\": "+code + ", \"name\": \""+name+"\", \"price\": "+price+"}";
	}

	
}
