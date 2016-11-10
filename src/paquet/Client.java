package paquet;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * Aqui tenim la clase client que hereta de Persona, on tenim les caracteristiques de client
 *
 */

public class Client extends Persona implements InterficieClient {
	
	private String Codisucursal;
	private Date datadAlta;
	public ArrayList<ComptaBancaria> LlistaComptesdelClient= new ArrayList<ComptaBancaria>();

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
			
	// getters i setters	
	
	public ArrayList<ComptaBancaria> getLlistaComptesdelClient() {
		return LlistaComptesdelClient;
	}

	public void setLlistaComptesdelClient(ArrayList<ComptaBancaria> llistaComptesdelClient) {
		LlistaComptesdelClient = llistaComptesdelClient;
	}

	public String sucursal(){
		while(Codisucursal.length()!=4||Main.isNumeric(Codisucursal)){
			System.out.println("El codi de del Bank ha de ser un numero d 4 digits. Insereixi un nou codi.");
			
					Codisucursal = EntradaDades.Cadena();
		}
		return Codisucursal;
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
public static void LlistarComptesBancaries(BaseDeDadesV BDVirtual,String Dni){
		
		
		Client cli = BDVirtual.CercaClientperDNI(Dni);
		System.out.println("Escull en quina de les teves comptes vols fer les operacions");
		int opcio= -1;
		while (opcio<1|| opcio>cli.LlistaComptesdelClient.size()){
		for(int i=0;i<cli.LlistaComptesdelClient.size();i++){
			System.out.println((i+1)+" - IBAN:"+cli.LlistaComptesdelClient.get(i).getIBAN());	
		}
		opcio = EntradaDades.Enter();
		}
		String IBAN=cli.LlistaComptesdelClient.get(opcio-1).getIBAN();
		ComptaBancaria.Menudoperacions(BDVirtual,IBAN);
	}
	
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
		ComptaBancaria NovaCompta =new ComptaBancaria(Saldoinicial,PIN,Codipais,codiJavaBank,Codisucursal);
		LlistaComptesdelClient.add(NovaCompta);
		 
		return true;
		
		 } catch(IllegalArgumentException e){
			  return false;
		 }
	}
	public void SubstitueixCC(int i,ComptaBancaria CC){
		
		LlistaComptesdelClient.set(i, CC);
		
				
	}
	
	public boolean AfegirComptaBancariaAmbParametres(String PIN,double Saldoinicial){
		if (PIN.length()!=4&&!Main.isNumeric(PIN))
			return false;
			
		 try{
		ComptaBancaria NovaCompta =new ComptaBancaria(Saldoinicial,PIN,Codipais,codiJavaBank,Codisucursal);
		LlistaComptesdelClient.add(NovaCompta);
		 
		return true;
		
		 } catch(IllegalArgumentException e){
			  return false;
		 }
	}
	
	
		
	public void veureDadesPersonalsPubliques(){
		
	}
   
}
