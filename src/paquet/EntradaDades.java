package paquet;

import java.util.Scanner;
import java.io.Console;
import java.text.DecimalFormat;
public class EntradaDades {
	private static Scanner Lector = new Scanner(System.in);


	public static int Enter (){
		int nombre=0;
		boolean correcte=false;
		do{
	        if(Lector.hasNextInt()){
	            nombre = Lector.nextInt();
	            correcte = true;
	        }else{
	            Lector.nextLine();
	            System.out.println("En aquest camp has d'entrar un Enter");
	        }
	    }while(!correcte);
	return nombre;
		
	}
	public static double Double(){
		double nombre=0;
	boolean correcte=false;
	do{
        if(Lector.hasNextDouble()){
            nombre = Lector.nextDouble();
             nombre = (double) Math.round(nombre * 100) / 100;
            correcte = true;
        }else{
            Lector.nextLine();
            System.out.println("En aquest camp has d'entrar un Nombre decimal amb màxim dos decimals.");
        }
    }while(!correcte);
return nombre;
	}
	public static double Caracter(){
		return Lector.nextLine().charAt(0);
		
		
	}
	public static String Cadena(){
		 String Cadena = Lector.nextLine();
		    while(Cadena.length()<=0) {
		    	if (Lector.hasNextLine()) {
		            Cadena = Lector.nextLine();
		        }}
		return Cadena;
	}
}
