package paquet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 * Aquesta interfície és innecessaria però la implementem perque s'ha de fer
 *
 */
public interface InterficieClient {
	/**
	 * Es declara un ArrayList de comptes Bancaris
	 */
	public ArrayList<CompteBancari> LlistaComptesdelClient= new ArrayList<CompteBancari>();
	/**
	 * Es declara un Sacanner
	 */
	Scanner Lector = new Scanner(System.in);
	// constructor
	public static ArrayList<CompteBancari> getLlistaComptesdelClient() {
		return null;
	}

	public void setLlistaComptesdelClient(ArrayList<CompteBancari> llistaComptesdelClient);

	public void setSucursal(String Codisucursal);
	public Date getDatadAlta();
	
	public Date setDatadAlta(Date datadAlta);
	public boolean AfegirComptaBancaria();
	public void SubstitueixCC(int i,CompteBancari CC);
	public boolean AfegirComptaBancariaAmbParametres(String PIN,double Saldoinicial);	
	public static void LlistarComptesBancaries(BaseDeDadesV BDVirtual,String Dni){}
}
