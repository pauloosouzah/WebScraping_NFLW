package jp.WebScraping.Classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;




public class capturarDados {




	public static void capturarDados(String nomeAtleta) throws IOException{
    	
	    
    	/** LINK DA TABELA */
        String url = "https://www.nfl.com/stats/player-stats/";
        /** CONECTANDO AO LINK COM COMPONENTE JSOUP */
        Document doc = Jsoup.connect(url).get();
        /** BUSCANDO ELEMENTO PELA CLASSE */
        Element table = doc.getElementsByClass("d3-o-table d3-o-table--detailed d3-o-player-stats--detailed d3-o-table--sortable").first();
        /** BUSCANDO TBODY DA CLASSE*/
        Element tbody = table.getElementsByTag("tbody").first();
        /** BUSCANDO TR DA TBODY*/
        List<Element> players = tbody.getElementsByTag("tr");
        /** CRIANDO ARRAY */
        List<Passing> playersObjects = new ArrayList<>();
        /** PERCORRENDO ARRAY */
        for (Element player: players) {
        	/** PERCORRENDO LINHAS */
            List<Element> attributes = player.getElementsByTag("td");
            /** SETANDO VALORES PARA CAPTURAR */
            Passing passinglist = new Passing(
                    attributes.get(0).text(),
                    attributes.get(1).text()
            );
            /** ADICIONANDO AO ARRAY */
            playersObjects.add(passinglist);
        }
        
        	imprimirDados.imprimirDados(playersObjects, Passing.nomeAt);
 
	}

}
