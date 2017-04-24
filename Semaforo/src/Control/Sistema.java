package Control;

import java.sql.SQLException;

import Application.Sinal;
import DAO.DAOsemaforo;

public class Sistema {
	
	

	public Sistema(Sinal sinal, String nomeSinal,String nomeSinal2) throws SQLException {
		new Controle(nomeSinal,nomeSinal2, sinal);
	}
	
	public static void checkAll() throws SQLException {
		check("s1", "p1", "s2", "p2"); // Cruzamento 1
	}
	
	public static void check(String nomeSinal1, String nomeRua1, String nomeSinal2, String nomeRua2) throws SQLException {
		DAOsemaforo dao = new DAOsemaforo();
		Semaforo semaforo1 = dao.pegarTempos(nomeSinal1); // Semáforo da rua primária
		Semaforo semaforo2 = dao.pegarTempos(nomeSinal2); // Semáforo da rua secundária
		int rua1 = dao.quantidadeCarros(nomeRua1); // Rua primária (Prioritária)
		int rua2 = dao.quantidadeCarros(nomeRua2); // Rua secundária
		int limite = 10; // limite de carros na rua 
		int minimo = 5; // mínimo de carros na rua
		
		if (rua1 >= minimo && rua2 <= minimo) {
			int tempo = (rua1 - rua2) * 3;
			if (tempo > 15) {tempo = 15;}
			semaforo1.setTempoverde(30 + tempo); semaforo1.setTempovermelho(30 - tempo);
			semaforo2.setTempoverde(30 - tempo); semaforo2.setTempovermelho(30 + tempo);
		} else if (rua2 >= minimo && rua1 <= minimo) {
			int tempo = (rua2 - rua1) * 3;
			if (tempo > 15) {tempo = 15;}
			semaforo1.setTempoverde(30 - tempo); semaforo1.setTempovermelho(30 + tempo);
			semaforo2.setTempoverde(30 + tempo); semaforo2.setTempovermelho(30 - tempo);
		} else if (rua1 > limite && rua2 <= limite) {
			int tempo = (rua1 - rua2) * 2;
			if (tempo > 15) {tempo = 15;}
			semaforo1.setTempoverde(30 + tempo); semaforo1.setTempovermelho(30 - tempo);
			semaforo2.setTempoverde(30 - tempo); semaforo2.setTempovermelho(30 + tempo);
		} else if (rua2 > limite && rua1 <= limite) {
			int tempo = (rua2 - rua1) * 2;
			if (tempo > 15) {tempo = 15;}
			semaforo1.setTempoverde(30 - tempo); semaforo1.setTempovermelho(30 + tempo);
			semaforo2.setTempoverde(30 + tempo); semaforo2.setTempovermelho(30 - tempo);
		} else if (rua1 > limite && rua2 > limite && rua1 > rua2) {
			int tempo = (rua1 - rua2);
			if (tempo > 15) {tempo = 15;}
			semaforo1.setTempoverde(30 + tempo); semaforo1.setTempovermelho(30 - tempo);
			semaforo2.setTempoverde(30 - tempo); semaforo2.setTempovermelho(30 + tempo);
		} else if (rua2 > limite && rua1 > limite && (rua2 - rua1) > minimo) {
			int tempo = ((rua2 - rua1) / 2);
			if (tempo > 15) {tempo = 15;}
			semaforo1.setTempoverde(30 - tempo); semaforo1.setTempovermelho(30 + tempo);
			semaforo2.setTempoverde(30 + tempo); semaforo2.setTempovermelho(30 - tempo);
		} else {
			semaforo1.setTempoverde(30); semaforo1.setTempovermelho(30);
			semaforo2.setTempoverde(30); semaforo2.setTempovermelho(30);
		}
		
		dao.atualiza(nomeSinal1, semaforo1);
		dao.atualiza(nomeSinal2, semaforo2);
	}
	
}
