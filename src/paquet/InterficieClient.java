package paquet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public interface
InterficieClient {
	public ArrayList<ComptaBancaria> LlistaComptesdelClient= new ArrayList<ComptaBancaria>();
	Scanner Lector = new Scanner(System.in);
	// constructor
	public ArrayList<ComptaBancaria> getLlistaComptesdelClient();

	public void setLlistaComptesdelClient(ArrayList<ComptaBancaria> llistaComptesdelClient);

	public String sucursal();
	
	public void setSucursal(String Codisucursal);
	public Date getDatadAlta();
	
	public Date setDatadAlta(Date datadAlta);
	public boolean AfegirComptaBancaria();
	public void SubstitueixCC(int i,ComptaBancaria CC);
	
	public boolean AfegirComptaBancariaAmbParametres(String PIN,double Saldoinicial);	
	public void veureDadesPersonalsPubliques();
public static void LlistarComptesBancaries(BaseDeDadesV BDVirtual,String Dni){}
}
