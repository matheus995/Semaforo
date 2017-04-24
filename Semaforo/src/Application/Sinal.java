package Application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Semaforo;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Color;

public class Sinal extends JFrame {

	private JPanel contentPane;
	public JLabel semaforo;
	public JLabel semaforo2;
	public JLabel contador;
	public JLabel contador2;
	private JLabel text_semaforo2;
	private JLabel tempo_s2;
	private Panel panel_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sinal frame = new Sinal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sinal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tempo_s1 = new JLabel("Tempo S1");
		tempo_s1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tempo_s1.setBounds(229, 71, 113, 58);
		contentPane.add(tempo_s1);
		
		
		semaforo = new JLabel("");
		semaforo.setBounds(10, 74, 209, 280);
		ImageIcon imagem = new ImageIcon(Semaforo.class.getResource("/Icones/verde.png"));
		Image img = imagem.getImage().getScaledInstance(semaforo.getWidth(), semaforo.getHeight(), Image.SCALE_SMOOTH);
		semaforo.setIcon(new ImageIcon(img));
		contentPane.add(semaforo);
		
		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(262, 135, 46, 38);
		contentPane.add(panel);
		
		contador = new JLabel("0");
		panel.add(contador);
		contador.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		
		
		JLabel text_semaforo1 = new JLabel("Sem\u00E1foro 1");
		text_semaforo1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		text_semaforo1.setBounds(47, 32, 128, 28);
		contentPane.add(text_semaforo1);
		
		semaforo2 = new JLabel("");
		semaforo2.setBounds(482, 84, 203, 270);
		ImageIcon imagem2 = new ImageIcon(Semaforo.class.getResource("/Icones/verde.png"));
		Image img2 = imagem2.getImage().getScaledInstance(semaforo.getWidth(), semaforo.getHeight(), Image.SCALE_SMOOTH);
		semaforo2.setIcon(new ImageIcon(img2));
		contentPane.add(semaforo2);
		
		text_semaforo2 = new JLabel("Sem\u00E1foro 2");
		text_semaforo2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		text_semaforo2.setBounds(521, 32, 164, 28);
		contentPane.add(text_semaforo2);
		
		tempo_s2 = new JLabel("Tempo S2");
		tempo_s2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tempo_s2.setBounds(704, 84, 121, 32);
		contentPane.add(tempo_s2);
		
		panel_1 = new Panel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(739, 135, 46, 38);
		contentPane.add(panel_1);
		
		contador2 = new JLabel("0");
		contador2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_1.add(contador2);
	}
}
