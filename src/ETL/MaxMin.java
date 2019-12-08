package ETL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaxMin {
	
	public static void main(String [] args) throws IOException {
		
		System.out.println("************************INICIO***********************");
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        
		FileReader fr = new FileReader("/Users/juanfernandozuluagaramirez/Documents/VisualAnalytics/ProyectoFinal/DatosMuestra/pruebaFiltrado.txt");
		BufferedReader br = new BufferedReader(fr);
		
		fichero = new FileWriter("/Users/juanfernandozuluagaramirez/Documents/VisualAnalytics/ProyectoFinal/DatosMuestra/MaxMin.txt");
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
		
		json = " var freqData=[";
		pw.println(json);
		
		int conLineas = 0;
		
		int contadortotal = 0;
		
		for (Map.Entry<String, Map<String,Integer>> entry : departamentos.entrySet()) {
		    System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
		    
		    Map<String,Integer> municipios = new HashMap<String,Integer>();
			
			municipios = entry.getValue();
			
			int max = 0;
			int min = 0;
			String nomMunMax = "";
			String nomMunMin = "";
			int otros = 0;
			int mid = 0;
				
			for (Entry<String, Integer> entryM : municipios.entrySet()) {
				
				mid++;
				
				if(conLineas == 0) {
						
					max = entryM.getValue();
					nomMunMax = entryM.getKey();
					
					min = entryM.getValue();
					nomMunMin = entryM.getKey();
					
					otros = 0;
					
					conLineas ++;
					
				}else {
					
					if(max < entryM.getValue()) {
						
						otros = otros + max;
						
						max = entryM.getValue();
						nomMunMax = entryM.getKey();	
					}
					else{
						
						if(min > entryM.getValue()) {
							
							otros = otros + min;
							
							min = entryM.getValue();
							nomMunMin = entryM.getKey();
							
						}
						
					}
					
				}
				otros = otros + entryM.getValue();
				
			}
			
			
			mid = otros/mid;
			
			conLineas = 0;
			json = " ,{State:'"+entry.getKey()+"' ,freq:{low:"+min+" mid: "+mid+",high:"+max+"}}" ;
			pw.println(json);
			mid = 0;
				
		}
		
		json = " ];";
		pw.println(json);
		fichero.close();
	}

}
