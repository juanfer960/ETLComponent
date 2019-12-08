package ETL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Extraction_2 {
	
	public static void main(String [] args) throws IOException {
		
		System.out.println("************************INICIO***********************");
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        
		//FileReader fr = new FileReader("/Users/juanfernandozuluagaramirez/Documents/VisualAnalytics/ProyectoFinal/DatosMuestra/test.txt");
		FileReader fr = new FileReader("/Volumes/BackUp/Viz/prueba.txt");
		BufferedReader br = new BufferedReader(fr);
		
		fichero = new FileWriter("/Users/juanfernandozuluagaramirez/Documents/VisualAnalytics/ProyectoFinal/DatosMuestra/prueba.txt");
        pw = new PrintWriter(fichero);
        
    	String linea;
		linea = br.readLine();
		int cont = 0;
		
		Map<String, List<String>> departamentos = new HashMap<String, List<String>>();
		
		while(linea != null && cont < 7500000) {
			
			String[] parts = linea.split("-");
			
			if(parts.length >= 3){
				
				if(!departamentos.containsKey(parts[1].toString())){
					departamentos.put(parts[1], new ArrayList<String>());
				}
				
				String municipio  = filtrar(parts[2].toString().toLowerCase(),departamentos.get(parts[1]));
				
			
				if(!departamentos.get(parts[1]).contains(municipio)) {
					
					if(!departamentos.get(parts[1]).contains(filtrarValoresErrados(municipio).toLowerCase())) {
						departamentos.get(parts[1]).add(filtrarValoresErrados(municipio).toLowerCase());
						/**pw.println(parts[0] + "-" + parts[1] + "-" + filtrarValoresErrados(municipio).toLowerCase());
						if("choco".equals(parts[1].toString())) {
							System.out.println(parts[0] +"-"+parts[1]+"-"+parts[2]);
						}
						**/
					}
						
				}
				pw.println(parts[0] + "-" + parts[1] + "-" + filtrarValoresErrados(municipio).toLowerCase());
				System.out.println(cont++);
				
			}
			
			linea = br.readLine();
			
		}
		
		System.out.println(cont);
		
		
		for (Map.Entry<String, List<String>> entry : departamentos.entrySet()) {
		    System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue().size());
		}
		System.out.println("************************FIN***********************");
		
	}
	
	public static String filtrar(String municipio, List municipios) {
		
		Iterator itr = municipios.iterator();
		
		while(itr.hasNext()) {
			String municipoEnLista = itr.next().toString();
			if(municipoEnLista.contains(municipio) || municipio.contains(municipoEnLista)) {
				return municipoEnLista;
			}
		}
		return municipio;
	}
	
	public static String filtrarValoresErrados(String municipio) {
		
		if("el yopal".equals(municipio)) return "yopal";
		if("bogota".equals(municipio)) return "bogota, d.c.";
		if("puerto lpez".equals(municipio)) return "puerto lopez";
		if("san martn".equals(municipio)) return "san martin";
		if("macarena".equals(municipio)) return "la macarena";
		if("fuentedeoro".equals(municipio)) return "fuente de oro";
		if("pto. gaitan".equals(municipio)) return "puerto gaitan";
		if("uribe".equals(municipio)) return "la uribe";
		if("macarena".equals(municipio)) return "la macarena";
		if("san carlos de guaro".equals(municipio)) return "san carlos de guaroa";
		if("san luis cubarral".equals(municipio)) return "san luis de cubarral";
		if("san jose del fragua".equals(municipio)) return "san jose de fragua";
		if("florencia y belen de los andaquies".equals(municipio)) return "belen de los andaquies";
		if("doncello".equals(municipio)) return "el doncello";
		if("milan".equals(municipio)) return "puerto milan";
		if("san sebastin de mariquita".equals(municipio)) return "san sebastian de mariquita";
		if("guamo".equals(municipio)) return "el guamo";
		if("fresno".equals(municipio)) return "el fresno";
		if("espinal".equals(municipio)) return "el espinal";
		if("ibagu".equals(municipio)) return "ibague";
		if("carmen de apical".equals(municipio)) return "carmen de apicala";
		if("calarc".equals(municipio)) return "calarca";
		if("purificacion".equals(municipio)) return "purificacin";
		if("saldaa".equals(municipio)) return "saldana";
		if("saldaa".equals(municipio)) return "saldana";
		if("faln".equals(municipio)) return "falan";
		if("tambo".equals(municipio)) return "el tambo";
		if("vega".equals(municipio)) return "la vega";
		if("villarrica".equals(municipio)) return "villa rica";
		if("purac".equals(municipio)) return "purace";
		if("totor".equals(municipio)) return "totoro";
		if("popayn".equals(municipio)) return "popayan";
		if("popay??n".equals(municipio)) return "popayan";
		if("santader de quilichao".equals(municipio)) return "santander de quilichao";
		if("inz".equals(municipio)) return "inza";
		if("piendam".equals(municipio)) return "piendamo";
		if("bolvar".equals(municipio)) return "bolivar";
		if("puerto carreo".equals(municipio)) return "puerto carreno";
		if("sanata rita".equals(municipio)) return "santa rita";
		if("puero carreno".equals(municipio)) return "puerto carreno";
		if("pto. carreno".equals(municipio)) return "puerto carreno";
		if("san andres sotavento".equals(municipio)) return "san andres de sotavento";
		if("buenavista".equals(municipio)) return "buena vista";
		if("cartagena".equals(municipio)) return "cartagena de indias";
		if("cartagena d.t".equals(municipio)) return "cartagena de indias";
		if("san juan de nepomoceno".equals(municipio)) return "san juan de nepomuceno";
		if("san juan nepomuseno".equals(municipio)) return "san juan de nepomuceno";
		if("carmen de bolivar".equals(municipio)) return "el carmen de bolivar";
		if("calima darien".equals(municipio)) return "calima el darien";
		if("cali".equals(municipio)) return "santiago de cali";
		if("dovio".equals(municipio)) return "el dovio";
		if("victoria".equals(municipio)) return "la victoria";
		if("alcal".equals(municipio)) return "alcala";
		if("tulu".equals(municipio)) return "tulua";
		if("riofrio".equals(municipio)) return "rio frio";
		if("carmen del darien".equals(municipio)) return "el carmen del darien";
		if("municipio de quibdo".equals(municipio)) return "quibdo";
		if("bahia solano (mutis)".equals(municipio)) return "bahia solano";
		if("el litoral del san juan".equals(municipio)) return "el litoral de san juan";
		if("litoral del san juan".equals(municipio)) return "el litoral de san juan";
		if("barranco mina".equals(municipio)) return "barranco minas";
		if("corregimiento pacoa".equals(municipio)) return "pacoa";
		if("toluviejo".equals(municipio)) return "tolu viejo";
		if("san antonio de palmito".equals(municipio)) return "san antonio de los palmitos";
		if("san juan betulia".equals(municipio)) return "san juan de betulia";
		if("palmito".equals(municipio)) return "los palmitos";
		if("hatonuevo".equals(municipio)) return "hato nuevo";
		if("santamaria".equals(municipio)) return "santa maria";
		if("paz de rio\\n".equals(municipio)) return "paz del rio";
		if("paz de rio".equals(municipio)) return "paz del rio";
		if("boyaca".equals(municipio)) return "guacamayas";
		if("santana".equals(municipio)) return "santa ana";
		if("sierra nevada de santa marta".equals(municipio)) return "santa marta";
		if("em el cerro entre gaira y santa marta".equals(municipio)) return "santa marta";
		if("sta. marta".equals(municipio)) return "santa marta";
		if("santamarta".equals(municipio)) return "santa marta";
		if("cerro san antonio".equals(municipio)) return "cerro de san antonio";
		if("puebloviejo".equals(municipio)) return "pueblo viejo";
		if("sitionuevo".equals(municipio)) return "sitio nuevo";
		if("fundacin".equals(municipio)) return "fundacion";
		if("magdalena".equals(municipio)) return "santa marta";
		if("san jose del guaviare.".equals(municipio)) return "san jose del guaviare";
		if("san jos del guaviare".equals(municipio)) return "san jose del guaviare";
		if("santacruz".equals(municipio)) return "santa cruz";
		if("alban (san jose)".equals(municipio)) return "san jose";
		if("mun. leticia".equals(municipio)) return "leticia";
		if("miriti ".equals(municipio)) return "miriti";
		if("mun. puerto nario".equals(municipio)) return "puerto nario";
		if("mun. la pedrera".equals(municipio)) return "la pedrera";
		if("victoria".equals(municipio)) return "la victoria";
		if("dorada".equals(municipio)) return "la dorada";
		if("saman".equals(municipio)) return "samana";
		if("chinchin".equals(municipio)) return "chinchina";
		if("san jos".equals(municipio)) return "san jose";
		if("aranzaz".equals(municipio)) return "aranzazu";
		if("villamaria".equals(municipio)) return "villa maria";
		if("mistrat".equals(municipio)) return "mistrato";
		if("mil".equals(municipio)) return "mistrato";
		if("cucuta".equals(municipio)) return "san jose de cucuta";
		if("el zulia".equals(municipio)) return "zulia";
		if("ccuta".equals(municipio)) return "san jose de cucuta";
		if("brego".equals(municipio)) return "abrego";
		if("tib".equals(municipio)) return "tibu";
		if("chitag".equals(municipio)) return "chitaga";
		if("buenavista".equals(municipio)) return "buena vista";
		if("sangil".equals(municipio)) return "san gil";
		if("san vicente de chucur".equals(municipio)) return "san vicente de chucuri";
		if("san vicente del chucuri".equals(municipio)) return "san vicente de chucuri";
		if("mesa de lo santos".equals(municipio)) return "mesa de los santos";
		if("landazuri mun.".equals(municipio)) return "landazuri";
		if("puerto  wilches".equals(municipio)) return "puerto wilches";
		if("carmen del chucuri".equals(municipio)) return "el carmen de chucuri";
		if("piedecuesta".equals(municipio)) return "pie de cuesta";
		if("charal".equals(municipio)) return "charala";
		if("concepcin".equals(municipio)) return "concepcion";
		if("landazuri mun.".equals(municipio)) return "landazuri";
		if("san josz de miranda".equals(municipio)) return "san jose de miranda";
		if("arauca".equals(municipio)) return "indeterminado";
		if("pto rondon".equals(municipio)) return "puerto rondon";
		if("pto. rondon".equals(municipio)) return "puerto rondon";
		if("mun. arauca".equals(municipio)) return "indeterminado";
		if("l a plata".equals(municipio)) return "la plata";
		if("agrado".equals(municipio)) return "el agrado";
		if("pital".equals(municipio)) return "el pital";
		if("garzn".equals(municipio)) return "garzon";
		if("campoalegre".equals(municipio)) return "campo alegre";
		if("villavieja".equals(municipio)) return "villa vieja";
		if("timan".equals(municipio)) return "timana";
		if("valle de sibundoy".equals(municipio)) return "sibundoy";
		if("villagarzn".equals(municipio)) return "villagarzon";
		if("puerto ass".equals(municipio)) return "puerto asis";
		if("puerto leguzamo".equals(municipio)) return "puerto leguizamo";
		if("villa garzn".equals(municipio)) return "villa garzon";
		if("manaure balcon del cesar".equals(municipio)) return "manaure";
		if("curuman".equals(municipio)) return "curumani";
		if("curuman".equals(municipio)) return "san martin";
		if("bogota, d.c.".equals(municipio)) return "bogota d.c.";
		if("bogota".equals(municipio)) return "bogota d.c.";
		if("bogot".equals(municipio)) return "bogota d.c.";
		if("bogot d.c.".equals(municipio)) return "bogota d.c.";
		if("macizo de bogot".equals(municipio)) return "bogota d.c.";
		if("bogot, d.c.".equals(municipio)) return "bogota d.c.";
		if("bogot d.c".equals(municipio)) return "bogota d.c.";
		if("la vega y san francisco".equals(municipio)) return "la vega";
		if("ubala b".equals(municipio)) return "ubala";
		if("penon".equals(municipio)) return "el penon";
		if("san juan de rioseco".equals(municipio)) return "san juan de rio seco";
		if("villapinzon".equals(municipio)) return "villa pinzon";
		if("zipaquir".equals(municipio)) return "zipaquira";
		if("fusagasug".equals(municipio)) return "fusagasuga";
		if("sibat".equals(municipio)) return "sibate";
		if("gachet".equals(municipio)) return "gacheta";
		if("guataqu".equals(municipio)) return "guataqui";
		if("chaguan".equals(municipio)) return "chaguani";
		if("bojac".equals(municipio)) return "bojaca";
		if("supat".equals(municipio)) return "supata";
		if("sesquil".equals(municipio)) return "sesquile";
		if("yacop".equals(municipio)) return "yacopi";
		if("alb??n".equals(municipio)) return "alban";
		if("albn".equals(municipio)) return "alban";
		if("cajic".equals(municipio)) return "cajica";
		if("sop".equals(municipio)) return "sopo";
		if("facatativ".equals(municipio)) return "facatativa";
		if("chocont".equals(municipio)) return "choconta";
		if("caparrap".equals(municipio)) return "caparrapi";
		if("gachancip".equals(municipio)) return "gachancipa";
		if("gachancip".equals(municipio)) return "gachancipa";
		if("frontino municipio".equals(municipio)) return "frontino";
		if("mun. frontino".equals(municipio)) return "frontino";
		if("mun frontino".equals(municipio)) return "frontino";
		if("mun. turbo".equals(municipio)) return "turbo";
		if("mun. san carlos".equals(municipio)) return "san carlos";
		if("carmen de viboral".equals(municipio)) return "el carmen de viboral";
		if("mun. amalfi".equals(municipio)) return "amalfi";
		if("mun. san rafael".equals(municipio)) return "san rafael";
		if("mun. betania".equals(municipio)) return "betania";
		if("jardin".equals(municipio)) return "el jardin";
		if("jardn".equals(municipio)) return "el jardin";
		if("mun. jardn".equals(municipio)) return "el jardin";
		if("santafe de antioquia".equals(municipio)) return "santa fe de antioquia";
		if("santaf de antioquia".equals(municipio)) return "santa fe de antioquia";
		if("mun. santa f de antioquia".equals(municipio)) return "santa fe de antioquia";
		if("antioquia".equals(municipio)) return "santa fe de antioquia";
		if("mun. bello".equals(municipio)) return "bello";
		if("mun. caldas".equals(municipio)) return "caldas";
		if("mun. heliconia".equals(municipio)) return "heliconia";
		if("mun. yarumal".equals(municipio)) return "yarumal";
		if("urrao municipio".equals(municipio)) return "urrao";
		if("mun. urrao".equals(municipio)) return "urrao";
		if("mun urrao".equals(municipio)) return "urrao";
		if("mun. salgar".equals(municipio)) return "salgar";
		if("mun. sabanalarga".equals(municipio)) return "sabanalarga";
		if("mun. liborina".equals(municipio)) return "liborina";
		if("mun. ituango".equals(municipio)) return "ituango";
		if("mun. caucasia".equals(municipio)) return "caucasia";
		if("mun. guarne".equals(municipio)) return "guarne";
		if("san  luis".equals(municipio)) return "san luis";
		if("mun. san luis".equals(municipio)) return "san luis";
		if("mun. san francisco".equals(municipio)) return "san francisco";
		if("penol".equals(municipio)) return "el penol";
		if("mun. santa rosa de osos".equals(municipio)) return "santa rosa de osos";
		if("mun. dabeiba".equals(municipio)) return "dabeiba";
		if("mun. remedios".equals(municipio)) return "remedios";
		if("mun. envigado".equals(municipio)) return "envigado";
		if("mun. andes".equals(municipio)) return "andes";
		if("mun. rionegro".equals(municipio)) return "rionegro";
		if("mun. la ceja".equals(municipio)) return "la ceja";
		if("mun. gmez plata".equals(municipio)) return "la ceja";
		if("gmez plata".equals(municipio)) return "gomez plata";
		if("mun. argelia".equals(municipio)) return "argelia";
		if("mun. belmira".equals(municipio)) return "belmira";
		if("mun. caramanta".equals(municipio)) return "caramanta";
		if("mun. caramanta".equals(municipio)) return "caramanta";
		if("retiro".equals(municipio)) return "el retiro";
		if("mun. fredonia".equals(municipio)) return "fredonia";
		if("mun. carepa".equals(municipio)) return "carepa";
		if("bagre".equals(municipio)) return "el bagre";
		if("mun. el bagre".equals(municipio)) return "el bagre";
		if("mun. san vicente".equals(municipio)) return "san vicente";
		if("mun. valdivia".equals(municipio)) return "valdivia";
		if("donmatias".equals(municipio)) return "don matias";
		if("mun. campamento".equals(municipio)) return "campamento";
		if("mun. hispania".equals(municipio)) return "hispania";
		if("mun. montebello".equals(municipio)) return "montebello";
		if("mun. arboletes".equals(municipio)) return "arboletes";
		if("ro claro".equals(municipio)) return "rio claro";
		if("medelln".equals(municipio)) return "medellin";
		if("medellan".equals(municipio)) return "medellin";
		if("mun. medelln".equals(municipio)) return "medellin";
		if("medell??n".equals(municipio)) return "medellin";
		if("medell??n".equals(municipio)) return "medellin";
		if("san jos de la montaa".equals(municipio)) return "san jose de la montana";
		if("mun. san jos de la montaa".equals(municipio)) return "san jose de la montana";
		if("anor".equals(municipio)) return "anori";
		if("mun. anor".equals(municipio)) return "anori";
		if("la unin".equals(municipio)) return "la union";
		if("la unian".equals(municipio)) return "la union";
		if("unin".equals(municipio)) return "la union";
		if("mun. la unin".equals(municipio)) return "la union";
		if("sonsn".equals(municipio)) return "sonson";
		if("mun. sonsn".equals(municipio)) return "sonson";
		if("sopetrn".equals(municipio)) return "sopetran";
		if("valparaso".equals(municipio)) return "valparaiso";
		if("ciudad bolvar".equals(municipio)) return "ciudad bolivar";
		if("mun. bolvar".equals(municipio)) return "ciudad bolivar";
		if("san jernimo".equals(municipio)) return "san jeronimo";
		if("jeric".equals(municipio)) return "jerico";
		if("mun. jeric".equals(municipio)) return "jerico";
		if("amag".equals(municipio)) return "amaga";
		if("san andrs de cuerqua".equals(municipio)) return "san andres de cuerquia";
		if("mun. puerto berro".equals(municipio)) return "puerto berro";
		if("santa brbara".equals(municipio)) return "santa barbara";
		if("santa brbara".equals(municipio)) return "mutata";
		if("mutat".equals(municipio)) return "mutata";
		if("mun. mutat".equals(municipio)) return "mutata";
		if("guatap".equals(municipio)) return "guatape";
		if("mun. guatap".equals(municipio)) return "guatape";
		if("mun. tmesis".equals(municipio)) return "tmesis";
		if("mun. briceo".equals(municipio)) return "briceo";
		if("yond".equals(municipio)) return "yondo";
		if("anz".equals(municipio)) return "anza";
		if("taraz".equals(municipio)) return "taraza";
		if("taraz&#225;".equals(municipio)) return "taraza";
		if("mun. taraz".equals(municipio)) return "taraza";
		if("viga del fuerte".equals(municipio)) return "vigia del fuerte";
		if("cceres".equals(municipio)) return "caceres";
		if("mun. cceres".equals(municipio)) return "caceres";
		if("c&#225;ceres".equals(municipio)) return "caceres";
		if("titirib".equals(municipio)) return "titiribi";
		if("mun. nario".equals(municipio)) return "nario";
		if("mun. cceres".equals(municipio)) return "cceres";
		if("ro claro".equals(municipio)) return "rio claro";
		if("caracol".equals(municipio)) return "caracoli";
		if("mun. cocorn".equals(municipio)) return "cocorna";
		if("mun. chigorod".equals(municipio)) return "chigorodo";

		return municipio;
	}

}
















