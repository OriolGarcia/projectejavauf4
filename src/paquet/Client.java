package paquet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Client extends Persona {
	
	private String Codisucursal;
	private Date datadAlta;
	private ArrayList<ComptaBancaria> LlistaComptesdelClient= new ArrayList<ComptaBancaria>();
	Scanner Lector = new Scanner(System.in);
	// constructor
	public Client(String nom, String cognoms, String dni, Date dataNaixement, String Codipais, String codiJavaBank,
			 String Codisucursal, Date datadAlta){
		
		super(nom,cognoms,dni,dataNaixement,Codipais,codiJavaBank);
		
		while(Codisucursal.length()!=4||!Main.isNumeric(Codisucursal)){
			System.out.println("El codi de de la sucursal  ha de ser un numero d 4 digits. Insereixi un nou codi.");
					Scanner Lector = new Scanner(System.in);
					Codisucursal = Lector.nextLine();
		}
		this.Codisucursal = Codisucursal;
		this.datadAlta = datadAlta;
		
	}
	
		
	// getters i setters
	
	
	public String sucursal(){
		while(Codisucursal.length()!=4||Main.isNumeric(Codisucursal)){
			System.out.println("El codi de del Bank ha de ser un numero d 4 digits. Insereixi un nou codi.");
					
					Codisucursal = Lector.nextLine();
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
	
	public boolean AfegirComptaBancaria(){
		System.out.println("Quin PIN vol colocar al compte? (4 digits enters)");
		String PIN=Lector.nextLine();
		while (PIN.length()!=4&&!Main.isNumeric(PIN)){
			System.out.println("PIN erroni (4 digits enters)");
			 PIN=Lector.nextLine();
			
		}
		System.out.println("Quina quantitat de diners vol ingressar?");
		double Saldoinicial=Lector.nextDouble();
		 try{
		ComptaBancaria NovaCompta =new ComptaBancaria(Saldoinicial,PIN,Codipais,codiJavaBank,Codisucursal);
		LlistaComptesdelClient.add(NovaCompta);
		 
		return true;
		
		 } catch(IllegalArgumentException e){
			  return false;
		 }
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





