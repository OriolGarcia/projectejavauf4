package paquet;

import java.util.Scanner;

/**
 * 
 * Aquesta es una classe de Compta bancaria
 *
 */

public class ComptaBancaria {
   private String IBAN;
   private Double Saldo;
   private Double Deutes;
   private String PIN;
   private String Historial;
   private String numeroCompta;
   private String numerodecontrol1;
   private String numerodecontrol2;
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
	public void setPIN(String OldPIN, String NewPIN) {
			if (PIN==OldPIN && NewPIN.length()==4&&Main.isNumeric(NewPIN))
			PIN = NewPIN;
			else if (PIN!=OldPIN)  System.out.println("El PIN antic és incorrecte. No s'ha pogut canviar el PIN" );
			else if (NewPIN.length()!=4||!Main.isNumeric(NewPIN)) System.out.println("El PIN ha de tenir 4 numeros" );
		}

	public String getPIN() {
		return PIN;
	}
	public void SumaSaldo(double Quantitat){
		
		Saldo+=Quantitat;
	}
	
/**
 * Aqui ens demanarà l'IBAN, en cas de possar l'IBAN incorrecte, ens mostrarà un missatge d'error
 * Després Ingresarem la quantitat desitjada
 * Si no posem més de 10€ ens dirà que ha de ser major que 10.
 */
	
	public static void ingressarDiners(BaseDeDadesV BDVirtual){
		Scanner Lector = new Scanner(System.in);
		System.out.println("Escrigui el IBAN complet de la compta destinataria");
		String IBAN = Lector.nextLine();
		ComptaBancaria CCtemporal=BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
		if(CCtemporal!=null){
			Double Quantitat;
			System.out.println("Ingressi la quantitat de diners desitjada, si us plau");
			Quantitat = Lector.nextDouble();
			while(Quantitat<10){
				System.out.println("La quantitat ha de ser major a 10€. ");
				Quantitat = Lector.nextDouble();
			}
			CCtemporal.SumaSaldo(Quantitat);
			BDVirtual.CercaComptaBancariaperIBAN(CCtemporal, IBAN);
			System.out.println("S'ha fet l'ingrés amb èxit");	
			
		}
		else{
			
			System.out.println("Aquest IBAN no pertany a cap compta bancaria registrada. ");
		}
	}
	
	/**
	 * Aqui creem el menú, on se'ns demanarà el PIN de la compta, tenim 3 intents
	 * Quan haguem entrar podrem elegir diferentes opcions
	 */
	
	public static void Menudoperacions(BaseDeDadesV BDVirtual,String IBAN){
		Scanner Lector = new Scanner(System.in);
		ComptaBancaria CCtemporal=BDVirtual.CercaComptaBancariaperIBAN(null, IBAN);
		
		if(CCtemporal!=null){
			String PIN=""; int n=3;
			while((!PIN.equals(CCtemporal.PIN)&&(n>0))){
				System.out.println("Escrigui el PIN per la compta");
				PIN = Lector.nextLine();
				if(!PIN.equals(CCtemporal.PIN)){
					n--;
					System.out.println("PIN incorrecte. Queden "+n+" intents.");
				}
			}
			if(PIN.equals(CCtemporal.PIN)){
				
				System.out.println("Has entrat al tauler d'operacions de la compta amb IBAN:"+IBAN);
			}
		
			int resposta=0;
		
			System.out.println("Que vols fer? Escull opcio escrivint un numero.");
			System.out.println("	1 - Ingressar diners");
			System.out.println("	2 - Fer transferencia");
			System.out.println("	3 - Visualitzar últims moviments");
			System.out.println("	4 - Canviar el PIN");
			System.out.println("	5 - Sortir");
			
			Scanner scan = new Scanner(System.in);
			resposta = scan.nextInt();
			
			switch(resposta){
			
			case 1:
				ComptaBancaria.ingressarDiners(BDVirtual);
			case 2:
				ComptaBancaria.ferTransferencia(BDVirtual,IBAN);
			case 3:
				
			case 4:
	
			}
			}
			}
						
	public String getIBAN() {
		return IBAN;
	}
	public static void ferTransferencia(BaseDeDadesV BDVirtual, String IBAN){
		Scanner Lector = new Scanner(System.in);
		Double y;
		String x;
		System.out.println("Ingressi l'IBAN de la compta en la que vol fer la transferencia");
		x = Lector.next();
		System.out.println("Ingressi la quantitat de diners que vol transferir, si us plau");
		y = Lector.nextDouble();	
		
	}
	}