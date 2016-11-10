package paquet;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * Aquesta es una classe de Compta bancaria
 *
 */

public class ComptaBancaria {
   private String IBAN;
   private Double Saldo;
   private String PIN;
   private String numeroCompta;
   private String numerodecontrol1;
   private String numerodecontrol2;
   private ArrayList<MovimentBancari> LlistaMoviments = new ArrayList<MovimentBancari>();
   private static int numComptes;
   

// Constructor
	ComptaBancaria(double SaldoInicial, String PIN ,
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
		}
		numComptes++;
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
		LlistaMoviments.add(new MovimentBancari(data, concepte, Quantitat));
		
	}
	public void RestaSaldo(double Quantitat, String concepte){
		Date data = new Date();
		Saldo-=Quantitat;
		LlistaMoviments.add(new MovimentBancari(data, concepte, -Quantitat));
	}

	
	/**
	 * Creem el menú, on se'ns demanarà el PIN de la compta, tenim 3 intents
	 * Quan haguem entrar podrem elegir diferentes opcions
	 */
	
	public static void Menudoperacions(BaseDeDadesV BDVirtual,String IBAN){
		
		ComptaBancaria CCtemporal=BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
		
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
						System.out.println("Que vols fer? Escull opcio escrivint un numero.");
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
							ComptaBancaria.ingressarDiners(BDVirtual);
							break;
						case 2:
							ComptaBancaria.TreureDiners(BDVirtual,IBAN);
							break;
						case 3:
							ComptaBancaria.ferTransferencia(BDVirtual,IBAN);
							break;
						case 4:
							ComptaBancaria.ConusltaSaldo(BDVirtual,IBAN);
							break;
						case 5:
							//ComptaBancaria.UltimsMoviments(BDVirtual,IBAN);
							break;
						case 6:
							ComptaBancaria.CanviarPIN(BDVirtual,IBAN);
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
		
		public static void ingressarDiners(BaseDeDadesV BDVirtual){
			
			System.out.println("Escrigui el IBAN complet de la compta destinataria");
			String IBAN = EntradaDades.Cadena();
			ComptaBancaria CCtemporal=BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
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
	
	
	private static void TreureDiners(BaseDeDadesV BDVirtual, String IBAN) {
			
			ComptaBancaria CCtemporal=BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
			if(CCtemporal!=null){
				Double Quantitat;
				System.out.println("Quina quantitat vol treure?");
				Quantitat = EntradaDades.Double();
				while(Quantitat<10){
					System.out.println("La quantitat ha de ser major a 10€. ");
					Quantitat = EntradaDades.Double();
					
				}
				String Concepte = "Extracció";
				CCtemporal.RestaSaldo(Quantitat, Concepte);
				BDVirtual.CercaComptaBancariaperIBAN(CCtemporal, IBAN);
				System.out.println("S'ha fet l'extraccíó amb èxit");	
				
			}
			
		}
	
	
	
	public void UltimsMoviments(BaseDeDadesV BDVirtual,String IBAN){
		 
	}
	
	public static void ferTransferencia(BaseDeDadesV BDVirtual, String IBAN){
		System.out.println("Concepte de la transferència?");
		String Concepte=EntradaDades.Cadena();
		ComptaBancaria CCOrigen=BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
		
		boolean sortir=false;
		while(!sortir){
			
			System.out.println("Ingressi l'IBAN de la compta en la que vol fer la transferencia");
			String IBANdesti = EntradaDades.Cadena();
			ComptaBancaria CCDesti=BDVirtual.CercaComptaBancariaperIBAN(null, IBANdesti);
			if(CCDesti!=null){
				
				System.out.println("Ingressi la quantitat de diners que vol transferir, si us plau");
				Double Quantitat = EntradaDades.Double();
					while (Quantitat<0){
						System.out.println("La quantitat a ingressar ha des ser un nombre positiu o 0");
						EntradaDades.Double();	
					}
					CCOrigen.RestaSaldo(Quantitat, Concepte);
					CCDesti.SumaSaldo(Quantitat, Concepte);
					BDVirtual.CercaComptaBancariaperIBAN(CCOrigen, IBAN);
					BDVirtual.CercaComptaBancariaperIBAN(CCDesti, IBANdesti);
					System.out.println("S'ha fet la transferència amb èxit");
				sortir=true;
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
	
	public static void CanviarPIN(BaseDeDadesV BDVirtual,String IBAN) {
		ComptaBancaria CCtemporal=BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
		
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
	
	private static void ConusltaSaldo(BaseDeDadesV BDVirtual, String IBAN) {
		ComptaBancaria CCtemporal=BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
		System.out.println("En la compta "+IBAN+" hi ha "+ CCtemporal.Saldo+ " €");
		
	}
	
	
	}