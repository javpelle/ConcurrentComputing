package main;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.List;

public class Almacen<T> {
	private int tam;
	private List<T> cola;

	public Almacen () {
		tam = 1;
		cola = new ArrayList<T>();
	}
}
