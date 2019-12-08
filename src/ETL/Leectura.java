package ETL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;

public class Leectura {
	
	
	public static void main(String[] args) throws IOException{
		
		System.out.println("************************INICIO***********************");
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        
		FileReader fr = new FileReader("/Users/juanfernandozuluagaramirez/Documents/VisualAnalytics/ProyectoFinal/DatosMuestra/prueba.txt");
		BufferedReader br = new BufferedReader(fr);
		
		fichero = new FileWriter("/Users/juanfernandozuluagaramirez/Documents/VisualAnalytics/ProyectoFinal/DatosMuestra/pruebaFiltrado.txt");
        pw = new PrintWriter(fichero);
        
    	String linea;
		linea = br.readLine();
		int cont = 0;
		int errores = 0;
		
		while(linea != null && cont < 7500000) {
			String[] parts = linea.split("-");
			
			if(parts.length < 3){
				errores++;
				System.out.println(linea);
			}
			else {
				pw.println(parts[0] + "-" + parts[1] + "-" + parts[2]);
				//cont++;
			}
			
			linea = br.readLine();
			cont++;
			
		}
		
		System.out.println("ERRORES IDENTIFICADOS" + errores);
		System.out.println(cont);
		
		System.out.println("************************FIN***********************");
		
	} 

}
