package controlador;



import java.util.ArrayList;

import modelo.Oharra;
import modelo.OharrakKudeatu;
import vista.*;

public class MenuKontroladorea {
	public static ArrayList<Oharra> lista_oharrak;
	
	public static void menua() {
		Ventana1 Leiho1 = new Ventana1();
		Leiho1.setVisible(true);
	}

	public static void oharrenInprimakia() {
		Ventana2_B Leiho2 = new Ventana2_B();
		Leiho2.setVisible(true);
	}

	public static void inprimatu() {
		Ventana2_A Leiho3 = new Ventana2_A();
		
		Leiho3.setVisible(true);
	}


	public static void arrayabete(ArrayList<Oharra> oharrak) {

			lista_oharrak = oharrak;
		
	}
	public static void oharraGehitu(Oharra ohar) {
		lista_oharrak.add(ohar);
			System.out.println(lista_oharrak.get(lista_oharrak.size()-1));
		
	}
	public static void oharrakIdatzi() {
		OharrakKudeatu.gordeOharrak(lista_oharrak);
	}
}
