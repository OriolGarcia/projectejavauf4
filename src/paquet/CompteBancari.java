package paquet;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 
 * Aquesta es una classe de Compta bancaria
 *
 */

public class CompteBancari {
   private String IBAN;
   private Double Saldo;
   private String PIN;
   private String numeroCompta;
   private String numerodecontrol1;
   private String numerodecontrol2;
   private ArrayList<MovimentBancari> llistamoviments;
   private static int numComptes;
   

// Constructor
	CompteBancari(double SaldoInicial, String PIN ,
			String Codipais, String codibanc, String codisucursal ){  
		boolean error=false;
		if ( PIN.length()!=4){ error=true;
		      throw new IllegalArgumentException( "Error: El PIN ha de tenir 4 digits!");   
		}
		if ( Codipais.length()!=2) { error=true;
		      throw new IllegalArgumentException( "Error: El codi de pais ha de tenir 2 digits!");
		}
		if ( codibanc.length()!=4){ error=true;
		      throw new IllegalArgumentException( "Error: El codi del banc ha de tenir 4 digits!");
		}
		if ( codisucursal.length()!=4){ error=true;
		      throw new IllegalArgumentException( "Error: El codi de la sucursal ha de tenir 4 digits!");
		}
		if(!error){
			this.numeroCompta=String.format("%010d", numComptes);
			this.numerodecontrol1=String.format("%02d",(Integer.parseInt(codibanc)*Integer.parseInt(codisucursal))%100);
			this.numerodecontrol2=String.format("%02d",(Integer.parseInt(numeroCompta)*3)%100);
			this.IBAN=Codipais+ numerodecontrol1+codibanc+codisucursal+numerodecontrol2+numeroCompta;
			this.Saldo=SaldoInicial;
			this.PIN = PIN;
			System.out.println("L'IBAN generat és: "+IBAN +" té el PIN: "+PIN);
			llistamoviments =  new ArrayList<MovimentBancari>();
		}
		numComptes++;
	}
	
	public double getSaldo(){
		return Saldo;
	}
	
	public void setSaldo(double Saldo){
		this.Saldo = Saldo;
		
	}
	
	public String getIBAN() {
		return IBAN;
	}
	
	public String getPIN() {
		return PIN;
	}
	
	public void SumaSaldo(double Quantitat, String concepte){
		Date data = new Date();
		Saldo+=Quantitat;
		llistamoviments.add(new MovimentBancari(data, concepte, Quantitat));
		
	}
	
	public void RestaSaldo(double Quantitat, String concepte){
		Date data = new Date();
		Saldo-=Quantitat;
		llistamoviments.add(new MovimentBancari(data, concepte, -Quantitat));
	}
	
	/**
	 * Et mostra els ultims moviments efectuats, on et mostrarà la data en format SHORT(dd/mm/yyyy)
	 * despres si s'ha fet un ingrés o una extracció, i per últim, ens mostrarà la quantitat extreta
	 * o ingresada.
	 */
	public void mostraMoviments(){
		System.out.println("Mostrant els últims moviments ...");
		for(MovimentBancari entry : llistamoviments){
			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,Locale.getDefault());
			String dataFormatada = df.format(entry.getData());
			System.out.print(dataFormatada+"   "); 
			System.out.print(entry.getConcepte().toString()+"   ");
			System.out.print(entry.getQuantitat().toString()+"€");
			System.out.println(" ");
	}
	}

	
	/**
	 * Creem el menú, on se'ns demanarà el PIN de la compta, tenim 3 intents
	 * Quan haguem entrar podrem elegir diferentes opcions
	 */
	public static void Menudoperacions(BaseDeDadesV BDVirtual,String IBAN){
		
		CompteBancari CCtemporal=BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
		
		if(CCtemporal!=null){
			String PIN=""; int n=3;
			while((!PIN.equals(CCtemporal.PIN)&&(n>0))){
				System.out.println("Escrigui el PIN per la compta");
				PIN = EntradaDades.Cadena();
				if(!PIN.equals(CCtemporal.PIN)){
					n--;
					System.out.println("PIN incorrecte. Queden "+n+" intents.");
				}
			}
			if(PIN.equals(CCtemporal.PIN)){
				
				System.out.println("Has entrat al tauler d'operacions de la compta amb IBAN:"+IBAN);
			
					
						int resposta=0;
					while(resposta!=7){
						System.out.println("\n\nQue vols fer? Escull opcio escrivint un numero.");
						System.out.println("	1 - Ingressar diners");
						System.out.println("	2 - Treure diners");
						System.out.println("	3 - Fer transferencia");
						System.out.println("	4 - Consulta saldo");
						System.out.println("	5 - Visualitzar últims moviments");
						System.out.println("	6 - Canviar el PIN");
						System.out.println("	7 - Sortir");
						
						
						resposta = EntradaDades.Enter();
					
						switch(resposta){
						
						case 1:
							CompteBancari.ingressarDiners(BDVirtual, IBAN);
							break;
						case 2:
							CompteBancari.TreureDiners(BDVirtual,IBAN);
							break;
						case 3:
							CompteBancari.ferTransferencia(BDVirtual,IBAN);
							break;
						case 4:
							CompteBancari.ConusltaSaldo(BDVirtual,IBAN);
							break;
						case 5:
							CompteBancari.UltimsMoviments(BDVirtual, IBAN);
							break;
						case 6:
							CompteBancari.CanviarPIN(BDVirtual,IBAN);
							break;
						default:
							break;
						}
			}	}
			}
	}			
	
	
	
	/**
	 * Aqui ens demanarà l'IBAN, en cas de possar l'IBAN incorrecte, ens mostrarà un missatge d'error
	 * Després Ingresarem la quantitat desitjada.
	 * Si no posem més de 10€ ens dirà que ha de ser major que 10.
	 */		
		public static void ingressarDiners(BaseDeDadesV BDVirtual,String IBAN){
			if(IBAN==null){
			System.out.println("Escrigui el IBAN complet de la compta destinataria");
			IBAN = EntradaDades.Cadena();
			}
			CompteBancari CCtemporal=BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
			if(CCtemporal!=null){
				Double Quantitat;
				System.out.println("Ingressi la quantitat de diners desitjada, si us plau");
				Quantitat = EntradaDades.Double();
				while(Quantitat<10){
					System.out.println("La quantitat ha de ser major a 10€. ");
					Quantitat = EntradaDades.Double();
				}
				String Concepte = "Ingrés";
				CCtemporal.SumaSaldo(Quantitat, Concepte);
				
				BDVirtual.CercaComptaBancariaperIBAN(CCtemporal, IBAN);
				System.out.println("S'ha fet l'ingrés amb èxit");	
				
			}
			else{
				
				System.out.println("Aquest IBAN no pertany a cap compta bancaria registrada. ");
			}
		}
	
		/**
		 * 
		 * @param BDVirtual
		 * @param IBAN
		 */
	private static void TreureDiners(BaseDeDadesV BDVirtual, String IBAN) {
			
			CompteBancari CCtemporal=BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
			if(CCtemporal!=null){
				Double Quantitat;
				System.out.println("Quina quantitat vol treure?");
				Quantitat = EntradaDades.Double();
				while(Quantitat<10||Quantitat>1000){
					System.out.println("La quantitat ha de ser major a 10€ i menor a 1000€. ");
					Quantitat = EntradaDades.Double();
					
				}
				if(CCtemporal.Saldo-Quantitat<0){
					System.out.println("No pots treure tants diners.");
				}else{
				String Concepte = "Extracció";
				CCtemporal.RestaSaldo(Quantitat, Concepte);
				BDVirtual.CercaComptaBancariaperIBAN(CCtemporal, IBAN);
				System.out.println("S'ha fet l'extraccíó amb èxit");	
				}
			}
			
		}
		
	/**
	 * Ens mostrà els últims moviments efectuats i després 
	 * @param BDVirtual
	 * @param IBAN
	 */
	public static void UltimsMoviments(BaseDeDadesV BDVirtual,String IBAN){
		CompteBancari CCtemporal=BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
		if(CCtemporal!=null){
			CCtemporal.mostraMoviments();
		}
		else{			
			System.out.println("Hi ha hagut un problema al cercar la seva compta. ");
		}
		
//		System.out.println("Mostran els últims 10 moviments ...");
//		for(MovimentBancari entry : llistamoviments){
//			System.out.print(entry.getData().toString()+"   "); 
//			System.out.print(entry.getConcepte().toString()+"   ");
//			System.out.print(entry.getQuantitat().toString());
//			System.out.println();
//	}
	}
	
	/**
	 * Fem les transferencies 
	 * @param BDVirtual
	 * @param IBAN
	 */
	public static void ferTransferencia(BaseDeDadesV BDVirtual, String IBAN){
		System.out.println("Concepte de la transferència?");
		String Concepte=EntradaDades.Cadena();
		CompteBancari CCOrigen=BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
		
		boolean sortir=false;
		while(!sortir){
			
			System.out.println("Ingressi l'IBAN de la compta en la que vol fer la transferencia");
			String IBANdesti = EntradaDades.Cadena();
			CompteBancari CCDesti=BDVirtual.CercaComptaBancariaperIBAN(null, IBANdesti);
			if(CCDesti!=null){
				
				System.out.println("Ingressi la quantitat de diners que vol transferir, si us plau");
				Double Quantitat = EntradaDades.Double();
					while (Quantitat<0){
						System.out.println("La quantitat a ingressar ha des ser un nombre positiu o 0");
						EntradaDades.Double();	
					}
					if(CCOrigen.Saldo-Quantitat<0){
						System.out.println("No es poden transferir tants diners.");
					}else{
					CCOrigen.RestaSaldo(Quantitat, Concepte);
					CCDesti.SumaSaldo(Quantitat, Concepte);
					BDVirtual.CercaComptaBancariaperIBAN(CCOrigen, IBAN);
					BDVirtual.CercaComptaBancariaperIBAN(CCDesti, IBANdesti);
					System.out.println("S'ha fet la transferència amb èxit");
				sortir=true;
					}
			}else {
				System.out.println("El IBAN no és vàlid. Voleu tornar-ho a intentar?");
				System.out.println("   1- Si");
				System.out.println("   2- No");
				int resposta = EntradaDades.Enter();
				
				if(resposta==1)
					sortir=false;
				else sortir = true;
				
			}
			}
	}
	
	/**
	 * Canviem el PIN
	 * @param BDVirtual
	 * @param IBAN
	 */
	public static void CanviarPIN(BaseDeDadesV BDVirtual,String IBAN) {
		CompteBancari CCtemporal=BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
		
			System.out.println("Quin és el PIN actual?");
			String OldPIN= EntradaDades.Cadena();
			if (CCtemporal.getPIN().equals(OldPIN)){
				System.out.println("Posa el nou PIN");
				String NewPIN= EntradaDades.Cadena();
				if (NewPIN.length()==4&&Main.isNumeric(NewPIN))
					CCtemporal.PIN = NewPIN;
				else System.out.println("El PIN ha de tenir 4 numeros" );
			}
			else  System.out.println("El PIN antic és incorrecte. No s'ha pogut canviar el PIN" );			
		}
	
	/**
	 * Consultem el saldo que tenim en el compte, on ens fa una cerca de la compta bancaria que tenim
	 * i t'ensenyna el saldo de la compte.
	 * @param BDVirtual
	 * @param IBAN
	 */
	private static void ConusltaSaldo(BaseDeDadesV BDVirtual, String IBAN) {
		CompteBancari CCtemporal=BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
		System.out.println("En el compte "+IBAN+" hi ha "+ CCtemporal.Saldo+ " €");
		
	}

	}