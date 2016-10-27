package paquet;

import java.util.Date;

public class Banquer extends Persona {
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
	public void donardAltaClient(){
		
	}
	
	public void donardAltaComptaBancaria(){
		
	}
	
	public void donarDeBaixa() {
		
	}
	
	public void donarDeBaixaComptaBancaria(){
		
	}
	
	public void venHipetecaoCredit(){
		
	}

}
