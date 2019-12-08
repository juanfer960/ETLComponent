package ETL;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Escritura {
	
	public static void main (String [] args) {
		
		String a = "San Pedro de Uraba";
		if(a.contains("San Pedro de uraba") ){
			System.out.print("Lo contiene");
		}else{
			System.out.print("No lo contiene");
		}
	}

}
