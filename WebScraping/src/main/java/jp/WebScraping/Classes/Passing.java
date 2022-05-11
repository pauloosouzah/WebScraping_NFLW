package jp.WebScraping.Classes;

import java.util.Scanner;

public class Passing{
	
    private String name;
    private String passYds;
	public static Scanner entrada = new Scanner(System.in);
	public static String nomeAt;
    
public Passing (String name, String passYds){

	this.name= name;
	this.passYds= passYds;
  
}       
        
	
	public String getName() { return name; }
	public void setName(String name) { this.name=name; }
	   
	public String getPassYds() {return passYds;}
	public void setPassYds(String passYds) { this.passYds=passYds; }
	

}
