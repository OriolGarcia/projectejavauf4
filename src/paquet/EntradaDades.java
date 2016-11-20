package paquet;

import java.util.Scanner;

/**
 * La Classe EntradaDades fa que no hi hagi errors quan s'entren dades.
 * 
 */
import java.io.Console;
import java.text.DecimalFormat;
public class EntradaDades {
	private static Scanner Lector = new Scanner(System.in);

/**
 * El metode Enter accepta un enter si entres una altra cosa et torna a demanar un enter
 * @return
 */
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
	
	/**
	 * El metode Double Enter accepta un  double i entres una altra cosa et torna a demanar un Double
	 * A més, el doble el redondeja perque hi hagi com a molt 2 decimals
	 * @return
	 */
	public  static double Double(){
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
	
	/**
	 * El metode caracter retorna el primer caracter de la linea
	 * @return
	 */
	public static double Caracter(){
		return Lector.nextLine().charAt(0);
				
	}
	
	/**
	 * El mètode Cadana retorna una linea però que estigui plena
	 * @return
	 */
	public static String Cadena(){
		 String Cadena = Lector.nextLine();
		    while(Cadena.length()<=0) {
		    	if (Lector.hasNextLine()) {
		            Cadena = Lector.nextLine();
		        }}
		return Cadena;
	}
}
