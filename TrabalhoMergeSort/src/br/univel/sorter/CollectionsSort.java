package br.univel.sorter;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsSort  extends Sort{
	
	public CollectionsSort() {
		this.setName("Collections Sort");
	}
	@Override
	public void sort(ArrayList array) {
		Collections.sort((ArrayList<Integer>)array.clone());
	}
}
