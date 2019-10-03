package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;



public class OharrakKudeatu {

	//BAariable Globala


	public static ArrayList<Oharra> irakurriOharrak() throws IOException {


		//BARIABLEAK
		ArrayList<Oharra> lista_oharra=new ArrayList<>();
		
		FileReader fitxeroa = new FileReader("src/Oharrak.csv");
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
			String linea = br.readLine();
			while ((linea = br.readLine()) != null) {


				cadena= linea.split(",");
			
				data=cadena[0].replace("\"","");
				ordua=cadena[1].replace("\"","");;
				nori=cadena[2].replace("\"","");;
				nork=cadena[3].replace("\"","");;
				titulua=cadena[4].replace("\"","");;
				edukia=cadena[5].replace("\"","");;
				oharra_bete=true;	

				Oharra oharra= new Oharra(data, ordua, nori, nork, titulua, edukia);
				lista_oharra.add(oharra);
				oharra_bete=false;
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
