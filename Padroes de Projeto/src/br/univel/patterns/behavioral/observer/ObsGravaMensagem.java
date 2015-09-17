package br.univel.patterns.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

public class ObsGravaMensagem implements Observer {

	public void update(Observable obj, Object arg) {
		
		if (arg instanceof String) {
			String str = (String) arg;
			System.out.println("Gravando: " + str);
		}
		
	}
}