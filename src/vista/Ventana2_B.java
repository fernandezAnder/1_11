package vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.MenuKontroladorea;
import modelo.Oharra;

public class Ventana2_B extends JFrame {

	private static final long serialVersionUID = 1L;
	//panelan ikusten diren bariableak
	private JTextField noriTxtF, NorkTxtF,tituluaTxtF, edukiaTxtF;
	private JLabel lblNori, lblNork, lblTitulua, lblEdukia;
	private JButton btnGorde, btnUtzi;
	
	public Ventana2_B() {
		//panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png")); 
		getContentPane().setLayout(null);
		this.setBounds(300,300,300,300);
		this.setTitle("OHARREN INPRIMAKIA");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		
		
		//nori
		lblNori = new JLabel("Nori:");
		lblNori.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNori.setBounds(26, 44, 55, 17);
		getContentPane().add(lblNori);
		
		noriTxtF = new JTextField();
		noriTxtF.setColumns(10);
		noriTxtF.setBounds(76, 46, 242, 20);
		getContentPane().add(noriTxtF);
		
		//nork
		NorkTxtF = new JTextField();
		NorkTxtF.setColumns(10);
		NorkTxtF.setBounds(92, 91, 226, 20);
		getContentPane().add(NorkTxtF);
		
		lblNork = new JLabel("Nork:");
		lblNork.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNork.setBounds(26, 89, 60, 17);
		getContentPane().add(lblNork);
		
		//titulua
		lblTitulua = new JLabel("Titulua:");
		lblTitulua.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTitulua.setBounds(26, 139, 82, 17);
		getContentPane().add(lblTitulua);
		
		tituluaTxtF = new JTextField();
		tituluaTxtF.setColumns(10);
		tituluaTxtF.setBounds(113, 139, 205, 20);
		getContentPane().add(tituluaTxtF);
		
		//edukia
		lblEdukia = new JLabel("Edukia:");
		lblEdukia.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEdukia.setBounds(26, 194, 82, 17);
		getContentPane().add(lblEdukia);
		
		edukiaTxtF = new JTextField();
		edukiaTxtF.setColumns(10);
		edukiaTxtF.setBounds(99, 194, 485, 258);
		getContentPane().add(edukiaTxtF);
		
		
		//botoiak
		btnGorde = new JButton("Gorde");
		btnGorde.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				java.util.Date date = new java.util.Date();
				SimpleDateFormat formato_fecha = new SimpleDateFormat("yyy-MM-dd");
				SimpleDateFormat formato_hora = new SimpleDateFormat("kk:mm");
				String data =formato_fecha.format(date);
				String ordua=formato_hora.format(date);
				
				String nori=noriTxtF.getText();
				String nork=NorkTxtF.getText();
				String titulua=tituluaTxtF.getText();
				String edukia=edukiaTxtF.getText();
				
				Oharra ohar = new Oharra(data, ordua, nori, nork, titulua, edukia);
				MenuKontroladorea.oharraGehitu(ohar);
				
			}
		});
		btnGorde.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGorde.setBounds(360, 498, 87, 36);
		getContentPane().add(btnGorde);

		btnUtzi = new JButton("Utzi");
		btnUtzi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				MenuKontroladorea.menua();
			}
		});
		btnUtzi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUtzi.setBounds(500, 498, 67, 36);
		getContentPane().add(btnUtzi);
		
	
		
	}		
}
