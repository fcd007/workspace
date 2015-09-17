package br.univel.patterns.behavioral.iterator;

interface Iterador<T> {

	boolean hasNext();

	T next();

}