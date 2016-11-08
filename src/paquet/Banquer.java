package paquet;

import java.util.Date;
import java.util.Scanner;

/**
 * 
 * Aqui tenim la classe Banquer que hereta de persona, on tenim les caracteristiques de Banquer
 *
 */

public class Banquer extends Persona {
	private String contrasenya;
	
	// constructor
	public Banquer(String nom, String cognoms, String dni, Date dataNaixement, String pais, String codiJavaBank,
					String contrasenya){
		
		super(nom,cognoms,dni,dataNaixement,pais,codiJavaBank);
		this.contrasenya = contrasenya;
	}
	
	
	// getters i setters
	public String getContrasenya(){
		return contrasenya;
	}
	
	public void setContrasenya(String contrasenya){
		this.contrasenya = contrasenya;
	}
	
	// metodes 
	
	public static int menudOperacionsBanquer(){
		int resposta=0;
		
		System.out.println("Que vols fer? Escull opcio escrivint un numero");
		System.out.println("	1 - Donar d'alta a un client");
		System.out.println("	2 - Donar d'alta a un banquer");
		System.out.println("	3 - Donar d'alta una compta bancaria");
		System.out.println("	4 - Donar de baixa a un client");
		System.out.println("	5 - Donar de baixa a un banquer");
		System.out.println("	6 - Donar de baixa una compta bancaria");
		System.out.println("	7 - Fer un préstec");
		System.out.println("	8 - Hipoteques");
		System.out.println("	9 - Sortir");
		
		Scanner scan = new Scanner(System.in);
		resposta = scan.nextInt();
		
		switch(resposta){
		case 1:
			donardAltaClient();
			return 1;
		case 2:
			donardAltaBanquer();
			return 1;
		case 3:
			donardAltaComptaBancaria();
			return 1;
		case 4:
			donarDeBaixaClient();
			return 1;
		case 5: 
			donarDeBaixaBanquer();
			return 1;
		case 6:
			donarDeBaixaComptaBancaria();
			return 1;
		case 7: 
			venHipotecaoCredit();
			return 1;
		case 8:
			venHipotecaoCredit();
			return 1;
		case 9: 
			return 0;
		default:
			return 1;
		}
	}
	
	
	public static void donardAltaClient(){
		
	}
	
	public static void donardAltaBanquer(){
		
	}
	
	public static void donardAltaComptaBancaria(){
		
	}
	
	public static void donarDeBaixaClient() {
		
	}
	
	public static void donarDeBaixaBanquer(){
		
	}
	
	public static void donarDeBaixaComptaBancaria(){
		
	}
	
	public static void venHipotecaoCredit(){
		
	}

}
