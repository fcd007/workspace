package br.univel.patterns.behavioral.observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

public class LeitorDeComandos extends Observable {

	public void iniciar() {

		try {
			final InputStreamReader isr = new InputStreamReader(System.in);
			final BufferedReader br = new BufferedReader(isr);
			while (true) {
				String response = br.readLine();
				setChanged();
				notifyObservers(response);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}