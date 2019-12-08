package ETL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer;

public class Extraction {
		
	public static void main(String [] args) throws IOException {
		
		System.out.println("************************INICIO***********************");
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        
		//FileReader fr = new FileReader("/Users/juanfernandozuluagaramirez/Documents/VisualAnalytics/ProyectoFinal/DatosMuestra/test.txt");
		FileReader fr = new FileReader("/Volumes/BackUp/Viz/dwc_co_2019T3.txt");
		BufferedReader br = new BufferedReader(fr);
		
		fichero = new FileWriter("/Users/juanfernandozuluagaramirez/Documents/VisualAnalytics/ProyectoFinal/DatosMuestra/prueba.txt");
        pw = new PrintWriter(fichero);
        
    	String linea;
		linea = br.readLine();
		int cont = 0;
		
		while(linea != null && cont < 7500000) {
			
			String[] parts = linea.split("\"");
			
			String departamento = Normalizer.normalize(parts[49].toString(), Normalizer.Form.NFD);
			departamento = departamento.replaceAll("[^\\p{ASCII}]", "");
			
			String municipio = Normalizer.normalize(parts[51].toString(), Normalizer.Form.NFD);
			municipio = municipio.replaceAll("[^\\p{ASCII}]", "");
			
			if(filtrar(departamento)){
				if(municipio.toString().equals("")) {
					municipio = "Indeterminado";
				}
				pw.println(parts[47] + "-" + departamento.toLowerCase() + "-" + municipio.toLowerCase());
				System.out.println(cont++);
			}
			
			linea = br.readLine();
			
		}
		
		System.out.println("Numero de registros: " + cont);
		
		System.out.println("************************FIN***********************");
        
	}
	
	public static boolean filtrar(String municipio){
		if(municipio.equals("Choco")||
		   municipio.equals("Cauca")||
		   municipio.equals("Antioquia")||
		   municipio.equals("Risaralda")||
		   municipio.equals("Atlantico")||
		   municipio.equals("Vichada")||
		   municipio.equals("Caldas")||
		   municipio.equals("Santander")||
		   municipio.equals("Bolivar")||
		   municipio.equals("Cundinamarca")||
		   municipio.equals("Guaviare")||
		   municipio.equals("Caqueta")||
		   municipio.equals("Narino")||
		   municipio.equals("Boyaca")||
		   municipio.equals("Putumayo")||
		   municipio.equals("Valle del Cauca")||
		   municipio.equals("Meta")||
		   municipio.equals("Arauca")||
		   municipio.equals("Huila")||
		   municipio.equals("Guainia")||
		   municipio.equals("Amazonas")||
		   municipio.equals("Quindio")||
		   municipio.equals("Norte de Santander")||
		   municipio.equals("Cesar")||
		   municipio.equals("Magdalena")||
		   municipio.equals("La Guajira")||
		   municipio.equals("Vaupes")||
		   municipio.equals("Casanare")||
		   municipio.equals("Sucre")||
		   municipio.equals("Cordoba")||
		   municipio.equals("Bogota, D.C.")||
		   municipio.equals("San Andres y Providencia")||
		   municipio.equals("Tolima")
				) {
			return true;
		}
		else {
			return false;
		}
	}

}
