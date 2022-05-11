package jp.WebScraping.Rw;


import jp.WebScraping.Classes.capturarDados;
import java.io.IOException;
import jp.WebScraping.Classes.Passing;
	

public class RwApplication {
	
	   public static void main(String[] args) throws IOException {
	       
		   /** CAMPO DE BUSCA */
		   System.out.println("Digite o nome do Atleta: (Caso deseje listar todos, digite 1)"); 
		   Passing.nomeAt = Passing.entrada.nextLine(); 
		   /** PROCESSA CLASSE PARA CAPTURAR OS DADOS DO ATLETA BUSCADO*/
		   capturarDados.capturarDados(Passing.nomeAt);
	    }
	   
	    
}


