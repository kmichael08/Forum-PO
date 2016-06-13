package pl.edu.mimuw.forum.data;

import java.util.ArrayList;

public class ListaOperacji {
	
	// Klasa obudowujaca ArrayList
	
	private static ArrayList<Operacja> operations = new ArrayList<Operacja>();
		
	/**
	 * Pozycja na liscie opearacji
	 */
	private static int actualPosition = 0;
	
	public static void add(Operacja op) {
		add(actualPosition, op);
	}
	
	public static void add(int position, Operacja op) {
		operations.add(position, op);
		// przechodzimy do przodu na liscie
		increase();
	}
	
	public static int size() {
		return operations.size();
	}
	
	public static Operacja get(int position) {
		return operations.get(position);
	}

	public static void increase() {
		actualPosition++;
	}
	
	public static void decrease() {
		actualPosition--;
	}
	
	
	public static void undo() {
		Operacja op = get(actualPosition - 1);
				
		op.cofnij();
		
		decrease();
	}
	
	
	public static void redo() {
		Operacja op = get(actualPosition);
				
		op.dokonaj();
		
		increase();
	}
	
	public static int actualPosition() {
		return actualPosition;
	}
	
	public static boolean zmienione = false;
	
}
