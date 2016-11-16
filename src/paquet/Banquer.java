package paquet;

import java.awt.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Dictionary;


/**
 * Aqui tenim la classe Banquer que hereta de persona, on tenim les caracteristiques de Banquer
 * després amb el super implementem el que tenim en persona.
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
	
	/**
	 * En aquest menu tenim les opcions que podrem elegir una vegada haguem entrat
	 * com a Banquer, li posem a resposta -1 per que com comencem per 1, el programa
	 * ho detectarà com a 0, es a dir, que si no possesim la variable resposta, 
	 * quan escrivissim 2 ens agafaria el 1. En el while farà el bucle mentre resposta
	 * no sigui igual a 8.
	 * @param BDVirtual
	 */
	public static void menudOperacionsBanquer(BaseDeDadesV BDVirtual){
		int resposta=-1;
		while(resposta!=8){
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
		DateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date2 = new Date();
		System.out.println(dateFormat2.format(date2));
		
		Client NouClient = new Client(nom,cognoms,dni,dataNaixement,codiPais,codiJavaBank,codiSucursal,date2);
		if(BDVirtual.JaExisteixClient(NouClient)){
			System.out.println("Ja existeix un client registrat amb DNI "+ dni);
			
		}

		BDVirtual.getLlistaPersones().add(NouClient);
		System.out.print("\nS'ha inserit un Client a la BD amb DNI: "+ NouClient.getDni());
		
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
		
		System.out.println("Contrasenya: ");
		String contrasenya = EntradaDades.Cadena();
		
		Banquer NouBanquer = new Banquer(nom,cognoms,dni,dataNaixement,codiPais,codiJavaBank,contrasenya);
		if(BDVirtual.JaExisteixBanquer(NouBanquer)){
			System.out.println("Ja existeix un banquer registrat amb DNI "+ dni+" i contrasenya "+contrasenya);
			
		}
		BDVirtual.getLlistaPersones().add(NouBanquer);
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
			BDVirtual.getLlistaPersones().remove(UsuariDel);
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
			BDVirtual.getLlistaPersones().remove(UsuariDel);
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
				System.out.println("S'ha donat de baixa la compta bancaria amb IBAN "+IBAN+" amb èxit.");
			case 2:
				
			}
			}}		
	}
		
		
	private static void veureLlistadeClients(BaseDeDadesV BDVirtual){
		Dictionary<Client, Double > llistaordenada = new Dictionary();
		for(int i=0;i<BDVirtual.getLlistaPersones().size();i++){
		Client cli;
			cli = BDVirtual.LlistaPersones.get(i);
	    	if (cli instanceof Client){
	    	Double sumatori;	
	    	ArrayList<ComptaBancaria> llistacomptesbancaries = ((Client) cli).getLlistaComptesdelClient();
			for (int k=0;k<llistacomptesbancaries.size();k++) {
				llistacomptesbancaries.get(k).getSaldo();
				sumatori++;
			
			}
	    	cli.setTotalSaldo(sumatori);
	    	BDVirtual.SetClientperDNI(cli.getDni(), cli);
			System.out.println(BDVirtual.getLlistaPersones().get(i).getNom() + " "
			+BDVirtual.getLlistaPersones().get(i).getCognoms() + " "
			+BDVirtual.getLlistaPersones().get(i).getDni());
			}
	    	List<Persona> llistapersones2 = (List<Persona>)BDVirtual.getLlistaPersones(); 
	    	Collections.sort(llistapersones2);
	    	
		}
	}
}
