package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {
	
	//LinkedList<String> dizionarioInglese = new LinkedList<String>();
	//LinkedList<String> dizionarioItaliano = new LinkedList<String>();
	LinkedList<String> dizionario = new LinkedList<String>();
	
	public Dictionary() {
		dizionario.clear();
		
	}

	public void loadDictionary(String language) {
		
		//if(language.compareTo("English") == 0) {
		
		//dizionario.clear();
		
		try { 
			
		FileReader fr = new FileReader("rsc/"+language+".txt");
		BufferedReader br = new BufferedReader(fr);   
		String word;  
		
		while ((word = br.readLine()) != null) { 
			dizionario.add(word);
		}
			 br.close();       
	    } catch (IOException e){   
				 System. out.println("Errore nella lettura del file"); 
	    }   
		//}
		
		/*if(language.compareTo("Italian") == 0) {
		
		try { 
			
		FileReader fr = new FileReader("rsc/Italian.txt");
		BufferedReader br = new BufferedReader(fr);   
		String word;  
		
		while ((word = br.readLine()) != null) { 
			dizionarioItaliano.add(word);
		}
			 br.close();       
	    } catch (IOException e){   
				 System. out.println("Errore nella lettura del file"); 
	    }   
		}*/
		
	}

	public List<RichWord> spellCheckText(List<String> inputTextList){ //nel controller trasformare il testo di input in una lista di parole
		
		LinkedList<RichWord> richWordTemp = new LinkedList<RichWord>();
		
		for(String a : inputTextList) {
			if(dizionario.contains(a)) {
				RichWord rTemp = new RichWord(a,true);
				richWordTemp.add(rTemp);
			}else {
				RichWord rTemp1 = new RichWord(a,false);
				richWordTemp.add(rTemp1);
			}
				
			
			/*for(String e : dizionario) {
				if(a.compareTo(e) == 0) {
					RichWord rTemp = new RichWord(a,true);
					richWordTemp.add(rTemp);
				}else {
					RichWord rTemp = new RichWord(a,false);
					richWordTemp.add(rTemp);
				}
			
			}*/
		}
		
		/*for(String a : inputTextList) {
			for(String e : dizionarioItaliano) {
				if(a.compareTo(e) == 0) {
					RichWord rTemp = new RichWord(a,true);
					richWordTemp.add(rTemp);
				}else {
					RichWord rTemp = new RichWord(a,false);
					richWordTemp.add(rTemp);
				}
			
			}
		}*/
		
		
		return richWordTemp;
	}
}
