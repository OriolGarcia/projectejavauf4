package paquet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 * Aquesta interfície és innecessaria però la implementem perque s'ha de fer
 *
 */
public interface InterficieBanquer {
	/**
	 * Es declara un Sacanner
	 */
	static Scanner Lector = new Scanner(System.in);
	/**
	 * Es declara un mètode per aconseguir la contrasenya
	 */
	public String getContrasenya();
	/**
	 * Es declara un mètode per posar la contrasenya
	 */
	public void setContrasenya(String contrasenya);
	
	/**
	 * Es declara un mètode per al menu d'eoperacions del banquer
	 */
	
	public static int menudOperacionsBanquer(BaseDeDadesV BDVirtual) {
		return 0;
	}
	
	/**
	 *Es declara el metode de donar alta un client
	 */
	public static void donardAltaClient(BaseDeDadesV BDVirtual){
	}
	/**
	 *Es declara el metode per donar d'alta al banquer
	 *
	 */
	public static void donardAltaBanquer(BaseDeDadesV BDVirtual){
	}
	/**
	 *Es declara el metode de donar alta unna compta bancaria
	 */
	public static void donardAltaComptaBancaria(){
		
	}	/**
	 *Es declara el metode de donar baixa un client
	 */
	public static void donarDeBaixaClient() {
		
	}
	/**
	 *Es declara el metode per donar de baixa al banquer
	 *
	 */
	public static void donarDeBaixaBanquer(){
		
	}
	/**
	 *Es declara el metode de donar de baixa una compta bancaria
	 */
	public static void donarDeBaixaComptaBancaria() {
	}


}
