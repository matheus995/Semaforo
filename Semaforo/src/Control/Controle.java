
package Control;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Application.Sinal;
import DAO.DAOsemaforo;

public class Controle {

	int vel = 5; // velocidade em segundos
	int vel2 = 5;
	int luz = 0; // controla qual semaforo acender 

	//public Controle(String s, Sinal sinal) {
		//semaforo(s, sinal);
	//}
	public Controle(String s,String s2, Sinal teste){
		semaforo2(s,s2,teste);
	}
	/*public void semaforo(String s, Sinal sinal) {
		try {
			Sistema.checkAll();
		} catch (SQLException erro) {
			erro.printStackTrace();
		}
		Icon icone;
		switch(luz) {
		case 0:
			
			luz = 1;
			vel = getTempoVerde(s);
			cronometro(vel);
			icone = new ImageIcon(getClass().getResource("/Icones/verde.png"));
			sinal.jLabel1.setIcon(icone);
			break;
		case 1:
			luz = 2;
			vel = getTempoAmarelo(s);
			cronometro(vel);
			icone = new ImageIcon(getClass().getResource("/Icones/amarelo.png"));
			sinal.jLabel1.setIcon(icone);
			break;
		case 2:
			luz = 0;
			vel = getTempoVermelho(s);
			cronometro(vel);
			icone = new ImageIcon(getClass().getResource("/Icones/vermelho.png"));
			sinal.jLabel1.setIcon(icone);
			break;
		}
		try {
			Thread.sleep(vel*1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		semaforo(s, sinal);
	}*/
	public void semaforo2(String s,String s2, Sinal sinal) {
		try {
			Sistema.checkAll();
		} catch (SQLException erro) {
			erro.printStackTrace();
		}
		Icon icone;
		Icon icone2;
		switch(luz) {
		case 0:
			luz = 1;
			vel = getTempoVerde(s);
			vel2 = getTempoVermelho(s2);
			icone = new ImageIcon(getClass().getResource("/Icones/verde.png"));
			icone2 = new ImageIcon(getClass().getResource("/Icones/vermelho.png"));
			sinal.semaforo.setIcon(icone);
			sinal.semaforo2.setIcon(icone2);
			cronometro(vel,vel2+2,sinal);
			break;
		case 1:
			luz = 2;
			vel = getTempoAmarelo(s);
			vel2 = getTempoAmarelo(s2);
			icone = new ImageIcon(getClass().getResource("/Icones/amarelo.png"));
			icone2 = new ImageIcon(getClass().getResource("/Icones/amarelo.png"));
			sinal.semaforo.setIcon(icone);
			//teste.semaforo2.setIcon(icone2);
			cronometro(vel,vel2,sinal);
			break;
		case 2:
			luz = 0;
			vel = getTempoVermelho(s);
			vel2 = getTempoVerde(s2);
			icone = new ImageIcon(getClass().getResource("/Icones/vermelho.png"));
			icone2 = new ImageIcon(getClass().getResource("/Icones/verde.png"));
			sinal.semaforo.setIcon(icone);
			sinal.semaforo2.setIcon(icone2);
			cronometro(vel+2,vel2,sinal);
			break;
			
		/*case 3:
			luz=0;
			vel = getTempoVermelho(s);
			vel2 = getTempoAmarelo(s2);
			icone = new ImageIcon(getClass().getResource("/Icones/vermelho.png"));
			icone2 = new ImageIcon(getClass().getResource("/Icones/amarelo.png"));
			//teste.semaforo.setIcon(icone);
			teste.semaforo2.setIcon(icone2);
			cronometro(2,vel2,teste);
			break;*/
		
		}
		try {
			Thread.sleep(vel*1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		semaforo2(s,s2, sinal);
	}
	
	public static void cronometro(int tempo,int tempo2, Sinal teste) {
		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {
			int segundos = tempo;
			int segundos2 = tempo2;
			public void run() {
				if (segundos == 1)
					timer.cancel();
				String s = Integer.toString(segundos);
				String s2 = Integer.toString(segundos2);
				teste.contador.setText(s);
				teste.contador2.setText(s2);
				System.out.println(segundos);
				segundos--;
				segundos2 --;
			}
		};
		timer.schedule(tarea, 0, 1000);
	}
	
	public static int getTempoVerde(String s) {
		DAOsemaforo dao = new DAOsemaforo();
		try {
			Semaforo semaforo = dao.pegarTempos(s);
			return semaforo.getTempoverde();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 30;
	}

	public static int getTempoAmarelo(String s) {
		DAOsemaforo dao = new DAOsemaforo();
		try {
			Semaforo semaforo = dao.pegarTempos(s);
			return semaforo.getTempoamarelo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 2;
	}

	public static int getTempoVermelho(String s) {
		DAOsemaforo dao = new DAOsemaforo();
		try {
			Semaforo semaforo = dao.pegarTempos(s);
			return semaforo.getTempovermelho();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 30;
	}

}
