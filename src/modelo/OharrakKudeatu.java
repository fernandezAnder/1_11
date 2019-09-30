package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;



public class OharrakKudeatu {

	//BAariable Globala


	public static ArrayList<Oharra> irakurriOharrak() throws FileNotFoundException {


		//BARIABLEAK
		ArrayList<Oharra> lista_oharra=new ArrayList<>();
		FileReader fitxeroa = new FileReader("src/Oharrak.txt");
		BufferedReader br = new BufferedReader(fitxeroa);
		int kont = 1;

		//OHARRAREN BARIABLEAK
		String data="";
		String ordua="";
		String nori="";
		String nork="";
		String titulua="";
		String edukia="";
		boolean oharra_bete=false;
		String[] cadena;
		try {
			String linea;
			while ((linea = br.readLine()) != null) {
				// lerro zuriak ez irakurtzeko
				if (!linea.equals("")) {
					//while(!linea.isEmpty()) {
					cadena= linea.split(":");
					if (cadena[0].equals("data")) {
						data=cadena[1];
					}else if(cadena[0].equals("ordua")) {
						ordua=cadena[1]+":"+cadena[2];
					}else if(cadena[0].equals("nori")) {
						nori=cadena[1];
					}else if(cadena[0].equals("nork")) {
						nork=cadena[1];
					}else if(cadena[0].equals("titulua")) {
						titulua=cadena[1];
					}else if(cadena[0].equals("edukia")) {
						edukia=cadena[1];
						oharra_bete=true;
					}
					//}

					//System.out.println(kont + " " + linea);
					kont++;
				} else {
					//System.out.println(linea);
				}
				if (oharra_bete) {
					Oharra oharra= new Oharra(data, ordua, nori, nork, titulua, edukia);
					System.out.println(oharra);
					lista_oharra.add(oharra);
					oharra_bete=false;
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return lista_oharra; 
	}

	public static Oharra ohar_berria(String data, String ordua, String nori, String nork, String titulua,
			String edukia ) {
		Oharra oharra = new Oharra(data, ordua, nori, nork, titulua, edukia);

		return oharra;
	}

	public static void gordeOharrak(ArrayList<Oharra> lista_oharrak){
		try {
			FileWriter idatzi = new FileWriter("src/Oharrak.txt");
			BufferedWriter bw= new BufferedWriter(idatzi);
			for(int i=0;i<lista_oharrak.size();i++) {
				
//				idatzi.append("Data: "+lista_oharrak.get(i).getData());
//				idatzi.append("Ordua: "+lista_oharrak.get(i).getOrdua());
//				idatzi.append("Nori: "+lista_oharrak.get(i).getNori());
//				idatzi.append("Nork: "+lista_oharrak.get(i).getNork());
//				idatzi.append("Titulua: "+lista_oharrak.get(i).getTitulua());
//				idatzi.append("Edukia: "+lista_oharrak.get(i).getEdukia());
//				idatzi.append("");
				
				bw.write("data:"+lista_oharrak.get(i).getData());
				bw.flush();
				bw.newLine();
				bw.write("ordua:"+lista_oharrak.get(i).getOrdua());
				bw.flush();
				bw.newLine();
				bw.write("nori:"+lista_oharrak.get(i).getNori());
				bw.flush();
				bw.newLine();
				bw.write("nork:"+lista_oharrak.get(i).getNork());
				bw.flush();
				bw.newLine();
				bw.write("titulua:"+lista_oharrak.get(i).getTitulua());
				bw.flush();
				bw.newLine();
				bw.write("edukia:"+lista_oharrak.get(i).getEdukia());
				bw.flush();
				bw.newLine();
				bw.write("*****************");
				bw.flush();
				bw.newLine();
				
			}
			idatzi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
