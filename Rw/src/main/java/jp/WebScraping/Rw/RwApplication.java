package jp.WebScraping.Rw;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import java.util.Scanner;
	

class Passing{
	
    private String name;
    private String passYds;
	static Scanner entrada = new Scanner(System.in);
	static String nomeAt;
    
public Passing (String name, String passYds){

	this.name= name;
	this.passYds= passYds;
  
}       
        
	
	public String getName() { return name; }
	public void setName(String name) { this.name=name; }
	   
	public String getPassYds() {return passYds;}
	public void setPassYds(String passYds) { this.passYds=passYds; }
	

}



public class RwApplication {
	
	   public static void main(String[] args) throws IOException {
	
		   System.out.println("Digite o nome do Atleta: (Caso deseje listar todos, digite 1)"); 
		   Passing.nomeAt = Passing.entrada.nextLine(); 
		   capturarDados(Passing.nomeAt);
	    }
	   

		private static void capturarDados(String nomeAtleta) throws IOException{
	    	
		    
		    ObjectMapper mapper = new ObjectMapper();
		    
	    	
	        String url = "https://www.nfl.com/stats/player-stats/";
	        Document doc = Jsoup.connect(url).get();
	        Element table = doc.getElementsByClass("d3-o-table d3-o-table--detailed d3-o-player-stats--detailed d3-o-table--sortable").first();
	        Element tbody = table.getElementsByTag("tbody").first();
	        List<Element> players = tbody.getElementsByTag("tr");
	        List<Passing> playersObjects = new ArrayList<>();
	        for (Element player: players) {
	            List<Element> attributes = player.getElementsByTag("td");
	            Passing passinglist = new Passing(
	                    attributes.get(0).text(),
	                    attributes.get(1).text()
	            );
	            playersObjects.add(passinglist);
	        }
	        
	        for (Passing passing: playersObjects) {
            
	        	try {
    	    	
	            String json = mapper.writeValueAsString(passing);
	            JSONObject obj = new JSONObject(json);
	            
	            	if (nomeAtleta.equals("1")){
		            	System.out.println("O Atleta " + obj.getString("name")  + " possui " + obj.getString("passYds") + " PASS YDS na NFL;");
	            	} else {
	            		if (obj.getString("name").equals(nomeAtleta)) {
		            	System.out.println("O Atleta " + obj.getString("name")  + " possui " + obj.getString("passYds") + " PASS YDS na NFL.");
		            }
	            }
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        } 
	    }
 		   	System.out.println("\nDigite o nome do Atleta: (Caso deseje listar todos, digite 1)"); 
 		   	nomeAtleta = Passing.entrada.nextLine(); 
 		   	capturarDados(nomeAtleta); 
	        
	        
		}
	    
}


