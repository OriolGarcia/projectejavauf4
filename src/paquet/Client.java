package paquet;

import java.util.ArrayList;
import java.util.Date;

/**
 * Aqui tenim la clase client que hereta de Persona, on tenim les caracteristiques de client.
 * 
 *
 */
public class Client extends Persona implements InterficieClient {
	
	private String Codisucursal;
	private Double TotalSaldo;

	private Date datadAlta;
	public  ArrayList<CompteBancari> LlistaComptesdelClient= new ArrayList<CompteBancari>();


	// constructor
	public Client(String nom, String cognoms, String dni, Date dataNaixement, String Codipais, String codiJavaBank,
			 String Codisucursal, Date datadAlta){
		
		super(nom,cognoms,dni,dataNaixement,Codipais,codiJavaBank);
		
		while(Codisucursal.length()!=4||!Main.isNumeric(Codisucursal)){
			System.out.println("El codi de de la sucursal  ha de ser un numero d 4 digits. Insereixi un nou codi.");
					
					Codisucursal = EntradaDades.Cadena();
		}
		this.Codisucursal = Codisucursal;
		this.datadAlta = datadAlta;
		
	}
	
	public void setTotalSaldo(double TotalSaldo){
		this.TotalSaldo = TotalSaldo;
	}
	public Double getTotalSaldo() {
		return TotalSaldo;
	}
	public int compareTo(Client cli){
		if(TotalSaldo<cli.TotalSaldo){
			return -1;
		}
		if(TotalSaldo>cli.TotalSaldo){
			return 1;
		}
		return nom.compareTo(cli.nom);
	}
	
	
	// getters i setters	
	
	public ArrayList<CompteBancari> getLlistaComptesdelClient() {
		return LlistaComptesdelClient;
	}

	public void setLlistaComptesdelClient(ArrayList<CompteBancari> llistaComptesdelClient) {
		LlistaComptesdelClient = llistaComptesdelClient;
	}

	
	public void setSucursal(String Codisucursal){
		this.Codisucursal = Codisucursal;
	}
	
	public Date getDatadAlta(){
		return datadAlta;
	}
	
	public Date setDatadAlta(Date datadAlta){
		this.datadAlta = datadAlta;
		return null;
	}
	/**
	 * Crea una llista dels comptes bancaris del client amb el que hem ingressat
	 * i ens dona a escollir.
	 * @param BDVirtual
	 * @param Dni
	 */
public void LlistarComptesBancaries(BaseDeDadesV BDVirtual,String Dni){	
		
		Client cli = BDVirtual.CercaClientperDNI(Dni);
		System.out.println("Escull en quina de les teves comptes vols fer les operacions");
		int opcio= -1;
		while (opcio<1|| opcio> cli.LlistaComptesdelClient.size()){

		for(int i=0;i<cli.LlistaComptesdelClient.size();i++){
			System.out.println((i+1)+" - IBAN:"+cli.LlistaComptesdelClient.get(i).getIBAN());	
		}
		opcio = EntradaDades.Enter();
		}
		String IBAN=cli.LlistaComptesdelClient.get(opcio-1).getIBAN();
		CompteBancari.Menudoperacions(BDVirtual,IBAN);
	}


/**
 * Podem afegir comptes bancaris entrant dades.
 */
	public boolean AfegirComptaBancaria(){
		System.out.println("Quin PIN vol colocar al compte? (4 digits enters)");
		String PIN=EntradaDades.Cadena();
		while (PIN.length()!=4&&!Main.isNumeric(PIN)){
			System.out.println("PIN erroni (4 digits enters)");
			 PIN=EntradaDades.Cadena();
			
		}
		System.out.println("Quina quantitat de diners vol ingressar?");
		double Saldoinicial=EntradaDades.Double();
		 try{
		CompteBancari NovaCompta =new CompteBancari(Saldoinicial,PIN,Codipais,codiJavaBank,Codisucursal);
		LlistaComptesdelClient.add(NovaCompta);
		 
		return true;
		
		 } catch(IllegalArgumentException e){
			  return false;
		 }
	}
	
	public void SubstitueixCC(int i,CompteBancari CC){
		
		LlistaComptesdelClient.set(i, CC);		
				
	}
	/**
	 * Afegim comptes bancaris a traves de paràmetres.
	 */
	public boolean AfegirComptaBancariaAmbParametres(String PIN,double Saldoinicial){
		if (PIN.length()!=4&&!Main.isNumeric(PIN))
			return false;
			
		 try{
		CompteBancari NovaCompta =new CompteBancari(Saldoinicial,PIN,Codipais,codiJavaBank,Codisucursal);
		LlistaComptesdelClient.add(NovaCompta);
		 
		return true;
		
		 } catch(IllegalArgumentException e){
			  return false;
		 }
	}
}

