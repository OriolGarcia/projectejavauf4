package paquet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 
 * Aqui tenim la classe Banquer que hereta de persona, on tenim les caracteristiques de Banquer
 *
 */

public class Banquer extends Persona implements InterficieBanquer {
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
	
	public static int menudOperacionsBanquer(BaseDeDadesV BDVirtual){
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
		
		
		resposta = EntradaDades.Enter();
		
		switch(resposta){
		case 1:
			donardAltaClient(BDVirtual);
			return 1;
		case 2:
			donardAltaBanquer(BDVirtual);
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
	
	
	public static void donardAltaClient(BaseDeDadesV BDVirtual){
		System.out.println("Nom: ");
		String nom = EntradaDades.Cadena();
		
		System.out.println("Cognoms: ");
		String cognoms = EntradaDades.Cadena();
		
		System.out.println("Dni: ");
		String dni = EntradaDades.Cadena();
		
		System.out.println("Data de naixement: ");
		String date = EntradaDades.Cadena();
		String dateFormat = "dd-MM-yyyy";
		DateFormat format = new SimpleDateFormat(dateFormat);
		Date dataNaixement = null;
		try {
			dataNaixement = format.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Codi del pais: ");
		String codiPais = EntradaDades.Cadena();
		
		System.out.println("Codi JavaBank: ");
		String codiJavaBank = EntradaDades.Cadena();
		
		System.out.println("Codi sucursal: ");
		String codiSucursal = EntradaDades.Cadena();
		
		System.out.println("Data d'alta: ");
		String date2 = EntradaDades.Cadena();
		Date datadAlta = null;
		try {
			datadAlta = format.parse(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Client NouClient = new Client(nom,cognoms,dni,dataNaixement,codiPais,codiJavaBank,codiSucursal,datadAlta);
		if(BDVirtual.JaExisteixClient(NouClient)){
			System.out.println("Ja existeix un client registrat amb DNI "+ dni);
			menudOperacionsBanquer(BDVirtual);
		}
		BDVirtual.getLlistaClients().add(NouClient);
		System.out.print("S'ha inserit un Client a la BD amb DNI: "+ NouClient.getDni());
		
	}
	
	public static void donardAltaBanquer(BaseDeDadesV BDVirtual){
		System.out.println("Nom: ");
		String nom = EntradaDades.Cadena();
		
		System.out.println("Cognoms: ");
		String cognoms = EntradaDades.Cadena();
		
		System.out.println("Dni: ");
		String dni = EntradaDades.Cadena();
		
		System.out.println("Data de naixement: ");
		String date = EntradaDades.Cadena();
		String dateFormat = "dd-MM-yyyy";
		DateFormat format = new SimpleDateFormat(dateFormat);
		Date dataNaixement = null;
		try {
			dataNaixement = format.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Codi del pais: ");
		String codiPais = EntradaDades.Cadena();
		
		System.out.println("Codi JavaBank: ");
		String codiJavaBank = EntradaDades.Cadena();
		
		System.out.println("Contrsenya: ");
		String contrasenya = EntradaDades.Cadena();
		
		Banquer NouBanquer = new Banquer(nom,cognoms,dni,dataNaixement,codiPais,codiJavaBank,contrasenya);
		if(BDVirtual.JaExisteixBanquer(NouBanquer)){
			System.out.println("Ja existeix un banquer registrat amb DNI "+ dni);
			menudOperacionsBanquer(BDVirtual);
		}
		BDVirtual.getLlistaBanquer().add(NouBanquer);
		System.out.print("S'ha inserit un Banquer a la BD amb DNI: "+ NouBanquer.getDni());
		
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
