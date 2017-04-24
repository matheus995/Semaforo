package Application;

import Facede.Fachada;

// S1 = Semáforo 1, responsável pela rua P1
// S2 = Semáforo 2, responsável pela rua P2
public class Main {
	
	public static void main(String[] args) {
		new Fachada("s1","s2","p1");
	}
	
}
