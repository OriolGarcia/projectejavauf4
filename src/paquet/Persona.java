package paquet;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

/** 
 * 
 * Aquesta es una clase abstracte de Persona
 *
 */

public abstract class Persona {
	protected String nom;
	protected String cognoms;
	protected String dni;
	protected String Codipais;
	protected String codiJavaBank;
	
	SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
	private Date dataNaixement;
	
	// constructor
	public Persona(String nom, String cognoms, String dni, Date dataNaixement, String Codipais, String codiJavaBank){
		this.nom = nom;
		this.cognoms = cognoms;
		this.dni = dni;
		this.dataNaixement = dataNaixement;
		while(Codipais.length()!=2||!Nomeslletres(Codipais)){
			System.out.println("El codi de del pais han de ser 2 lletres. Introdueix un codi pais vàlid per a" + nom);
					Scanner Lector = new Scanner(System.in);
				 Codipais = Lector.nextLine();
		}
		this.Codipais = Codipais;
		while(codiJavaBank.length()!=4||!isNumeric(codiJavaBank)){
			System.out.println("El codi de del Bank ha de ser un numero d 4 digits. Introdueix codi del Banc vàlid per a" + nom);
					Scanner Lector = new Scanner(System.in);
					codiJavaBank = Lector.nextLine();
		}
		this.codiJavaBank = codiJavaBank;
	}
	
	  @Override
		public boolean equals(Object o) {
			return this.dni.equals(((Persona)o).dni);
		}
	
	// getters i setters
	public String getNom(){
		return nom;
	}
	
	public void setNom(String nom){
		this.nom= nom;
	}
	
	public String getCognoms(){
		return cognoms;
	}
	
	public void setCognoms(String cognoms){
		this.cognoms = cognoms;
	}
	
	public String getDni(){
		return dni;
	}
	
	public void setDni(String dni){
		this.dni = dni;
	}
	
	public Date getDataNaixement(){
		return dataNaixement;
	}
	
	public void setDataNaixement(Date dataNaixement){
		this.dataNaixement = dataNaixement;
	
	}
	
	public String getCodiPais(){
		return Codipais;
	}
	
	public void setPais(String Codipais){
		while(Codipais.length()!=2){
			System.out.println("El codi de pais ha de tenir una mida de 2. Insereixi un nou codi.");
					Scanner Lector = new Scanner(System.in);
					Codipais = Lector.nextLine();
		}
		
		this.Codipais = Codipais;
	}
	
	public String getCodiJavaBank(){
		
		return codiJavaBank;
	}
	
	public void setCodiJavaBank(String codiJavaBank){
		while(codiJavaBank.length()!=4||isNumeric(codiJavaBank)){
			System.out.println("El codi de del Bank ha de ser un numero d 4 digits. Insereixi un nou codi.");
					Scanner Lector = new Scanner(System.in);
					codiJavaBank = Lector.nextLine();
		}
		this.codiJavaBank = codiJavaBank;
	}
	
    private static boolean isNumeric(String cadena){
    	try {
    		Integer.parseInt(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
    }
    public static boolean Nomeslletres(String str){
    	boolean resposta = true;
    	if ((str).matches("[0-9]")) {
    	resposta= false;
    	}
    	return resposta;
    	} 
} 