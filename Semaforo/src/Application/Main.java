package Application;

import Facede.Fachada;

// S1 = Sem�foro 1, respons�vel pela rua P1
// S2 = Sem�foro 2, respons�vel pela rua P2
public class Main {
	
	public static void main(String[] args) {
		new Fachada("s1","s2","p1");
	}
	
}
