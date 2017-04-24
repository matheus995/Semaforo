package Facede;

import java.sql.SQLException;

import Application.Sinal;
import Control.Sistema;

public class Fachada {
	
	public Fachada(String nomeSinal,String nomeSinal2, String nomeRua) {
		Sinal sinal = new Sinal();
		sinal.setVisible(true);
		try {
			new Sistema(sinal, nomeSinal,nomeSinal2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
