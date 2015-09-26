package br.univel.sorter;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsSort  extends Sort{
	
	public CollectionsSort() {
		this.setName("Collections Sort");
	}
	@Override
	public void sort(ArrayList<Integer> array) {
		Collections.sort((ArrayList)array.clone());
	}
}
