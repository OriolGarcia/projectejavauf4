package paquet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 
 * Aqui tenim la classe Banquer que hereta de persona, on tenim les caracteristiques de Banquer
 * Banquer
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
	
	public static void menudOperacionsBanquer(BaseDeDadesV BDVirtual){
		int resposta=-1;
		while(resposta!=0){
		System.out.println("\n\nQue vols fer? Escull opcio escrivint un numero");
		System.out.println("	1 - Donar d'alta a un client");
		System.out.println("	2 - Donar d'alta a un banquer");
		System.out.println("	3 - Donar d'alta una compta bancaria");
		System.out.println("	4 - Donar de baixa a un client");
		System.out.println("	5 - Donar de baixa a un banquer");
		System.out.println("	6 - Donar de baixa una compta bancaria");
		System.out.println("	7 - Veure llista de clients");
		System.out.println("	8 - Sortir");
		
		
		resposta = EntradaDades.Enter();
		
		switch(resposta){
		
			
		case 1:
			donardAltaClient(BDVirtual);
			break;
		case 2:
			donardAltaBanquer(BDVirtual);
			break;
		case 3:
			donardAltaComptaBancaria(BDVirtual);
			break;
		case 4:
			donarDeBaixaClient(BDVirtual);
			break;
		case 5: 
			donarDeBaixaBanquer(BDVirtual);
			break;
		case 6:
			donarDeBaixaComptaBancaria(BDVirtual);
			break;
			case 7: 
			veureLlistadeClients(BDVirtual);
			break;
		case 8:
			break;
		default:
			break;
		}
		}
	}
	
	
	private static void donardAltaClient(BaseDeDadesV BDVirtual){
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
			
		}
		BDVirtual.getLlistaClients().add(NouClient);
		System.out.print("S'ha inserit un Client a la BD amb DNI: "+ NouClient.getDni());
		
	}
	
	private static void donardAltaBanquer(BaseDeDadesV BDVirtual){
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
			
		}
		BDVirtual.getLlistaBanquer().add(NouBanquer);
		System.out.print("S'ha inserit un Banquer a la BD amb DNI: "+ NouBanquer.getDni());
		
	}
	


	public static void donardAltaComptaBancaria(BaseDeDadesV BDVirtual){
		System.out.println("DNI del client: ");
		String dni= EntradaDades.Cadena();
		Client cli=BDVirtual.CercaClientperDNI(dni);
		if (cli==null){
			System.out.println("No s'ha trobat cap Client amb aquest DNI. ");
		
		}else{
			System.out.println("PIN per la nova compta bancaria: ");
		String PIN = EntradaDades.Cadena();
		System.out.println("Quantitat a ingressar en la nova compta bancaria. ");
		Double Quantitat = EntradaDades.Double();
		cli.AfegirComptaBancariaAmbParametres(PIN, Quantitat);
		menudOperacionsBanquer(BDVirtual);
		}
	}
	
	private static void donarDeBaixaClient(BaseDeDadesV BDVirtual) {
		System.out.println("Dni: ");
		String Dni = Lector.next();
		Client UsuariDel = BDVirtual.CercaClientperDNI(Dni);
		if(UsuariDel == null){
			System.out.println("No existeix cap client amb aquest dni.");
			
		}else{
		System.out.println("Donar de baixa el Client amb dni "+Dni+" ?");
		System.out.println("	1 - Si");
		System.out.println("	2 - No");
		int r = Lector.nextInt();
		switch(r){
		case 1:
			BDVirtual.getLlistaClients().remove(UsuariDel);
			System.out.println("S'ha donat de baixa el client amb dni "+Dni);
			
		case 2:
			
		}
		}
	}
	
	private static void donarDeBaixaBanquer(BaseDeDadesV BDVirtual){
		System.out.println("Dni: ");
		String Dni = Lector.next();
		Banquer UsuariDel = BDVirtual.CercaBanquerperDNI(Dni);
		if(UsuariDel == null){
			System.out.println("No existeix cap banquer amb aquest dni.");
			
		}else{
		System.out.println("Contrasenya: ");
		String contrasenya = Lector.next();
		
		if(!contrasenya.equals(UsuariDel.getContrasenya())){
			System.out.println("Contrasenya incorrecta.");
			
		}else{
			
		System.out.println("Donar de baixa el Banquer amb dni "+Dni+" ?");
		System.out.println("	1 - Si");
		System.out.println("	2 - No");
		int r = Lector.nextInt();
		switch(r){
		case 1:
			BDVirtual.getLlistaClients().remove(UsuariDel);
			System.out.println("S'ha donat de baixa el banquer amb dni "+Dni);
			break;
		case 2:
			
		}
		}
		}
	}
	

	private static void donarDeBaixaComptaBancaria(BaseDeDadesV BDVirtual){
		System.out.println("Ingresa el IBAN de la compta bancaria que vulguis donar de baixa: ");
		String IBAN = EntradaDades.Cadena();
		ComptaBancaria ComptaDel = BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
		if(ComptaDel == null){
			System.out.println("No existeix cap compta bancaria amb aquest IBAN");
			
		}else{
			System.out.println("PIN: ");
			String PIN = EntradaDades.Cadena();
			if(!PIN.equals(ComptaDel.getPIN())){
				System.out.println("PIN incorrecte.");
				
			}else{
			
			System.out.println("Donar de baixa la compta bancaria amb IBAN "+IBAN+" ?");
			System.out.println("	1 - Si");
			System.out.println("	2 - No");
			int r = EntradaDades.Enter();
			switch(r){
			case 1:
				BDVirtual.eliminarComptaBancaria(IBAN);
				
			case 2:
				
			}
			}}		
		}

	public static void donarDeBaixaComptaBancaria(){
		

	}
		
		
	private static void veureLlistadeClients(BaseDeDadesV BDVirtual){
		for(int i=0;i<BDVirtual.getLlistaClients().size();i++){
			System.out.println(BDVirtual.getLlistaClients().get(i).getNom() + " "
			+BDVirtual.getLlistaClients().get(i).getCognoms() + " "
			+BDVirtual.getLlistaClients().get(i).getDni());
		}
	}

}
