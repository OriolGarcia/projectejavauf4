package paquet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public interface
InterficieClient {
	public ArrayList<ComptaBancaria> LlistaComptesdelClient= new ArrayList<ComptaBancaria>();
	Scanner Lector = new Scanner(System.in);
	// constructor
	public static ArrayList<ComptaBancaria> getLlistaComptesdelClient() {
		return null;
	}

	public void setLlistaComptesdelClient(ArrayList<ComptaBancaria> llistaComptesdelClient);

	
	public void setSucursal(String Codisucursal);
	public Date getDatadAlta();
	
	public Date setDatadAlta(Date datadAlta);
	public boolean AfegirComptaBancaria();
	public void SubstitueixCC(int i,ComptaBancaria CC);
	
	public boolean AfegirComptaBancariaAmbParametres(String PIN,double Saldoinicial);	
public static void LlistarComptesBancaries(BaseDeDadesV BDVirtual,String Dni){}
}
