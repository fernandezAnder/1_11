package vista;

import java.awt.*;
import javax.swing.*;

import controlador.MenuKontroladorea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana2_A extends JFrame {
	private static final long serialVersionUID = 1L;
	//panelan ikusten diren bariableak
	JTextArea textArea = new JTextArea();
	
	JButton btnIrten = new JButton("Irten");
	
	public Ventana2_A() {
		//panelaren propietateak
		
		getContentPane().setLayout(null);
		
		
		btnIrten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				MenuKontroladorea.menua();
			}
		});
		btnIrten.setBounds(400, 494, 89, 30);
		getContentPane().add(btnIrten);
		textArea.setDragEnabled(true);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);

		textArea.setBounds(74, 31, 415, 445);
		JScrollPane scroll	= new JScrollPane(textArea);
		scroll.setBounds(10, 11, 479, 470);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scroll);
		
		this.setBounds(300,300,300,300);
		this.setTitle("OHARREN INPRIMAKIA");
		this.setResizable(false); 
		this.setSize(new Dimension(571, 564));
		for(int i=0;i<MenuKontroladorea.lista_oharrak.size();i++) {
			textArea.append("data:"+MenuKontroladorea.lista_oharrak.get(i).getData()+"\n");
			textArea.append("ordua:"+MenuKontroladorea.lista_oharrak.get(i).getOrdua()+"\n");
			textArea.append("nori:"+MenuKontroladorea.lista_oharrak.get(i).getNori()+"\n");
			textArea.append("nork:"+MenuKontroladorea.lista_oharrak.get(i).getNork()+"\n");
			textArea.append("titulua:"+MenuKontroladorea.lista_oharrak.get(i).getTitulua()+"\n");
			textArea.append("edukia:"+MenuKontroladorea.lista_oharrak.get(i).getEdukia()+"\n");
			textArea.append("*****************"+"\n");
			
		}
		
		
//		textArea.setText(MenuKontroladorea.lista_oharrak.toString());
//		
	}		
}
