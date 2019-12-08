package ETL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GenerarJson {
	
	public static void main (String [] arsg) throws IOException {
		
		System.out.println("************************INICIO***********************");
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        
		FileReader fr = new FileReader("/Users/juanfernandozuluagaramirez/Documents/VisualAnalytics/ProyectoFinal/DatosMuestra/pruebaFiltrado.txt");
		BufferedReader br = new BufferedReader(fr);
		
		fichero = new FileWriter("/Users/juanfernandozuluagaramirez/Documents/VisualAnalytics/ProyectoFinal/DatosMuestra/json.txt");
        pw = new PrintWriter(fichero);
        
    	String  linea;
		linea = br.readLine();
		int cont = 0;
		
		Map<String, Map<String,Integer>> departamentos = new HashMap<String, Map<String,Integer>>();
		
		while(linea != null && cont < 7500000) {
			
			String[] parts = linea.split("-");
			
			if(!departamentos.containsKey(parts[1].toString())){
				departamentos.put(parts[1].toString(), new HashMap<String,Integer>());
			}
			
			if(!departamentos.get(parts[1].toString()).containsKey(parts[2].toString())){
				departamentos.get(parts[1].toString()).put(parts[2].toString(), 1);
			}
			else{
				departamentos.get(parts[1].toString()).put(parts[2].toString(), departamentos.get(parts[1].toString()).get(parts[2].toString())+1);
			}
			
			linea = br.readLine();
			cont++;
		}
		
		String json = "";
		
		json = " {";
		json = json + " \"name\": \"colombia\", \"children\": [";
		pw.println(json);
		
		int conLineas = 0;
		
		int contadortotal = 0;
		
		for (Map.Entry<String, Map<String,Integer>> entry : departamentos.entrySet()) {
		    System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
				
			json = " { \"name\": " +"\""+entry.getKey().toString()+"\""+", \"children\": [ ";
				
			pw.println(json);
				
			Map<String,Integer> municipios = new HashMap<String,Integer>();
			
			municipios = entry.getValue();
				
			for (Entry<String, Integer> entryM : municipios.entrySet()) {
				
				if(conLineas == 0) {
					json = "  { \"name\": " +"\""+entryM.getKey()+"\""+ ", \"size\": "+"\""+entryM.getValue()+"\""+" }";
					pw.println(json);	
					conLineas++;
					contadortotal = contadortotal + entryM.getValue();
				}
				else {
					json = "  ,{ \"name\": " +"\""+entryM.getKey()+"\""+ ", \"size\": "+"\""+entryM.getValue()+"\""+" }";
					pw.println(json);
					contadortotal = contadortotal + entryM.getValue();
				}
			}
			
			conLineas = 0;
			json = " ]},";
			pw.println(json);
			
		}
		
		json = " ]}";
		pw.println(json);
		
		fichero.close();
		
		System.out.println("Total registros procesados: " + cont);
		System.out.println("Sumatoria por municipio: " + contadortotal);
		System.out.println("************************FIN***********************");
	}

}
