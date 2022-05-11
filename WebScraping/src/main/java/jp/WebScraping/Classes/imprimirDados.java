package jp.WebScraping.Classes;

import java.io.IOException;
import java.util.List;
import org.json.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class imprimirDados {

public static void imprimirDados(List<Passing> playersObjects, String nomeAtleta) throws IOException {
	   
	ObjectMapper mapper = new ObjectMapper();	   
	 
	/** Percorrer Array */
    for (Passing passing: playersObjects) {
    	try {
    	/** TRANSFORMANDO VALOR EM STRING */	
        String json = mapper.writeValueAsString(passing);
        /** CRIAÇÃO DE OBJETO */
        JSONObject obj = new JSONObject(json);
        
        /** VERIFICAÇÃO DE ENTRADA */
        	if (nomeAtleta.equals("1")){
                /** LISTA TODOS OS ATLETAS */
            	System.out.println("O Atleta " + obj.getString("name")  + " possui " + obj.getString("passYds") + " PASS YDS na NFL;");
        	} else {
        		/** FILTRA ATLETA PELO NOME */
        		if (obj.getString("name").equals(nomeAtleta)) {
            	System.out.println("O Atleta " + obj.getString("name")  + " possui " + obj.getString("passYds") + " PASS YDS na NFL.");
            }
        }
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    } 
}
        
  }


	
}	   	

