package ETL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Evaluation {
	
	public static void main (String [] args) throws IOException {
		System.out.println("************************INICIO***********************");
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        
		//FileReader fr = new FileReader("/Users/juanfernandozuluagaramirez/Documents/VisualAnalytics/ProyectoFinal/DatosMuestra/test.txt");
		FileReader fr = new FileReader("/Volumes/BackUp/Viz/prueba.txt");
		BufferedReader br = new BufferedReader(fr);
		

		String linea;
		linea = br.readLine();
		int cont = 0;
		int noCumple = 0;
		
		Map<String, List<String>> departamentos = new HashMap<String, List<String>>();
		
		while(linea != null && cont < 7500000) {
			
			String[] parts = linea.split("-");
			
			if(parts.length >= 3) {
				if(!departamentos.containsKey(parts[1].toString())){
					departamentos.put(parts[1], new ArrayList<String>());
				}
				
				if(!departamentos.get(parts[1]).contains(parts[2])){
					departamentos.get(parts[1]).add(parts[2]);
				}
			
			System.out.println(cont++);
			
			}
			linea = br.readLine();
		}
		
		System.out.println(cont);
		System.out.println(departamentos.size());
		
		System.out.println(departamentos.get("antioquia").toString());
		
		/**
		for (Map.Entry<String, List<String>> entry : departamentos.entrySet()) {
		    System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue().size());
		}
		**/
		System.out.println("************************FIN***********************");
	}

}
