package vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

import controlador.MenuKontroladorea;
import modelo.OharrakKudeatu;

import javax.swing.JButton;
import java.awt.Font;

public class Ventana1 extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton btnKargatuOharrak, btnGehituOharra, btnGordeOharrak, btnInprimatu,btnIrten;

	// panelan ikusten diren bariableak
	public Ventana1() {
		// panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);

		this.setBounds(300, 300, 300, 300);
		this.setTitle("OHARREN KUDEAKETA");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));

		btnKargatuOharrak = new JButton("Kargatu Oharrak");
		btnKargatuOharrak.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnKargatuOharrak.addActionListener(new ActionListener() {
		
		// Lehenengo Botoia. OHARRAK KARGATU
			@Override
			public void actionPerformed(ActionEvent e) {
			
					try {
						
						MenuKontroladorea.arrayabete(OharrakKudeatu.irakurriOharrak());
					} catch (IOException e1) {
				
						e1.printStackTrace();
					}
				
			}
		});
		btnKargatuOharrak.setBounds(180, 102, 245, 33);
		getContentPane().add(btnKargatuOharrak);
		
		//Bigarren Botoia
		
		btnGehituOharra = new JButton("Gehitu Oharra");
		btnGehituOharra.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGehituOharra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MenuKontroladorea.oharrenInprimakia();
				dispose();
			}
		});
		btnGehituOharra.setBounds(180, 163, 245, 33);
		getContentPane().add(btnGehituOharra);
		
		//Hirugarren botoia
		
		btnGordeOharrak = new JButton("Gorde Oharrak");
		btnGordeOharrak.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				MenuKontroladorea.oharrakIdatzi();
			}
		});
		btnGordeOharrak.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnGordeOharrak.setBounds(180, 220, 245, 33);
		getContentPane().add(btnGordeOharrak);

		//Laugarren botoia
		
		btnInprimatu = new JButton("Inprimatu");
		btnInprimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuKontroladorea.inprimatu();
			}
		});
		btnInprimatu.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnInprimatu.setBounds(180, 276, 245, 33);
		getContentPane().add(btnInprimatu);

		//Azken botoia
		
		btnIrten = new JButton("Irten");
		btnIrten.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnIrten.setBounds(180, 334, 245, 33);
		getContentPane().add(btnIrten);
		
	}
}
