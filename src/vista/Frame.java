package vista;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	GridBagConstraints config = new GridBagConstraints();

	public Frame() {
		this.setTitle("Rocio Vera");
		this.setSize(new Dimension(300,300));
		this.setResizable(false); // neurketak ez aldatzeko
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}