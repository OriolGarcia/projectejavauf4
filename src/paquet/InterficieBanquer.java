package paquet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public interface InterficieBanquer {
	static Scanner Lector = new Scanner(System.in);
	
	public String getContrasenya();
	
	public void setContrasenya(String contrasenya);
	
	// metodes 
	
	public static int menudOperacionsBanquer(BaseDeDadesV BDVirtual) {
		return 0;
	}
	
	
	public static void donardAltaClient(BaseDeDadesV BDVirtual){
	}
	
	public static void donardAltaBanquer(BaseDeDadesV BDVirtual){
	}
	
	public static void donardAltaComptaBancaria(){
		
	}
	
	public static void donarDeBaixaClient() {
		
	}
	
	public static void donarDeBaixaBanquer(){
		
	}
	
	public static void donarDeBaixaComptaBancaria() {
	}
	
	public static void venHipotecaoCredit(){}

}
