package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.sql.rowset.spi.XmlReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLReaderFactory;



public class OharrakKudeatu {

	//BAariable Globala


	public static ArrayList<Oharra> irakurriOharrak() throws ParserConfigurationException, SAXException, IOException {


		//BARIABLEAK
		ArrayList<Oharra> lista_oharra=new ArrayList<>();

		
		File fitxeroa = new File("src/Oharrak.xml");
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		Document dokumentua;
		DocumentBuilder docubuilder = factoria.newDocumentBuilder();
		dokumentua = docubuilder.parse(fitxeroa);
		dokumentua.getDocumentElement().normalize();
		
		//OHARRAREN BARIABLEAK
		String data="";
		String ordua="";
		String nori="";
		String nork="";
		String titulua="";
		String edukia="";
		String[] cadena;
		boolean irten =false;
		int i=0;
		NodeList lista = dokumentua.getElementsByTagName("row");
		
		while (lista.item(i)!=null) {
			//Node mezua =lista.item(i).toString();
			//System.out.println(mezua.toString());
			

		//	Oharra oharra= new Oharra(data, ordua, nori, nork, titulua, edukia);
		//	lista_oharra.add(oharra);
		i++;
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
