package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;



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
		ArrayList<String> cadena = null;
		boolean irten =false;
		int i=0;

		NodeList lista = dokumentua.getElementsByTagName("row");
		
		while (lista.item(i)!=null) {
	
			Node mezua =lista.item(i);
			Element elemento = (Element) mezua;
			
			data = (elemento.getElementsByTagName("data").item(0).getTextContent());
			ordua = (elemento.getElementsByTagName("ordua").item(0).getTextContent());
			nori = (elemento.getElementsByTagName("nori").item(0).getTextContent());
			nork = (elemento.getElementsByTagName("nork").item(0).getTextContent());
			titulua = (elemento.getElementsByTagName("titulua").item(0).getTextContent());
			edukia = (elemento.getElementsByTagName("edukia").item(0).getTextContent());
			
			Oharra oharra= new Oharra(data, ordua, nori, nork, titulua, edukia);
			lista_oharra.add(oharra);
		i++;
		}
		return lista_oharra; 
	}

	public static Oharra ohar_berria(String data, String ordua, String nori, String nork, String titulua,
			String edukia ) {
		Oharra oharra = new Oharra(data, ordua, nori, nork, titulua, edukia);

		return oharra;
	}

	public static void gordeOharrak(ArrayList<Oharra> lista_oharrak) throws TransformerException, ParserConfigurationException{
		
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
 
 
            Document ficheroXML = implementation.createDocument(null, "root", null); //El elemento Raiz del documento es departamentos
            ficheroXML.setXmlVersion("1.0"); //asigno la version del XML
            
            Element raiz = ficheroXML.getDocumentElement();
 
 
            try
            {
                
           
                //Por cada vuelta del bucle leeo un departamento y genero su correspondiente XML
                for (int i=0;i<lista_oharrak.size();i++){
                    Element row = ficheroXML.createElement("row"); //Creo una etiqueta departamento con para cada uno
                    
                    Element data = ficheroXML.createElement("data");
                    Text datatext = ficheroXML.createTextNode(lista_oharrak.get(i).getData()+"\n"); 
                    data.appendChild(datatext); 
                    row.appendChild(data); 
                    
                    Element ordua = ficheroXML.createElement("ordua");
                    Text orduatext = ficheroXML.createTextNode(lista_oharrak.get(i).getOrdua()+"\n"); 
                    ordua.appendChild(orduatext); 
                    row.appendChild(ordua);
                    
                    Element nori = ficheroXML.createElement("nori");
                    Text noritext = ficheroXML.createTextNode(lista_oharrak.get(i).getNori()+"\n"); 
                    nori.appendChild(noritext); 
                    row.appendChild(nori);
                    
                    Element nork = ficheroXML.createElement("nork");
                    Text norktext = ficheroXML.createTextNode(lista_oharrak.get(i).getNork()+"\n"); 
                    nork.appendChild(norktext); 
                    row.appendChild(nork);
                    
                    Element titulua = ficheroXML.createElement("titulua");
                    Text tituluatext = ficheroXML.createTextNode(lista_oharrak.get(i).getTitulua()+"\n"); 
                    titulua.appendChild(tituluatext); 
                    row.appendChild(titulua);
                    
                    Element edukia = ficheroXML.createElement("edukia");
                    Text edukiatext = ficheroXML.createTextNode(lista_oharrak.get(i).getEdukia()+"\n"); 
                    edukia.appendChild(edukiatext); 
                    row.appendChild(edukia);
 
                   raiz.appendChild(row);
                }
               
            }
            catch(Exception e){
                
            }
            ficheroXML.normalizeDocument();
            
            Source source = new DOMSource(ficheroXML);
            Result result = new StreamResult(new File("src/Oharrak2.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        }
		
		
	}

