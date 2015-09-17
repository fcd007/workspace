package br.univel.Emuamba.testes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.univel.Emuamba.Produto;

public class readURL {
	public static void main(String[] args) throws IOException {
		String surl = "http://www.master10.com.py/lista-txt";
		URL url = new URL(surl);
		URLConnection connection = url.openConnection();
		InputStream is = connection.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		
		List<Produto> list = new ArrayList<>();
		
		String line = null;
		while((line=br.readLine())!=null){
			if (Pattern.matches("[0-9]+.*", line)) {
				list.add(new Produto(line));
				
			}else{
				System.out.println("ignore "+line);
			}
		}
		list.forEach(System.out::println);
		
	}
}
