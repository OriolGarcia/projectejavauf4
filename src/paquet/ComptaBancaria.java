package paquet;

import java.util.Scanner;

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
			System.out.println("L'IBAN generat és el següent:"+IBAN );
		}
		numComptes++;
	}
	public void setPIN(String OldPIN, String NewPIN) {
			if (PIN==OldPIN && NewPIN.length()==4&&Main.isNumeric(NewPIN))
			PIN = NewPIN;
			else if (PIN!=OldPIN)  System.out.println("El PIN antic és incorrecte. No s'ha pogut canviar el PIN" );
			else if (NewPIN.length()!=4||!Main.isNumeric(NewPIN)) System.out.println("El PIN ha de tenir 4 numeros" );
		}


	public static void ingressarDiners(){
		Scanner Lector = new Scanner(System.in);
		Double i;
		System.out.println("Ingressi la quantitat de diners desitjada, si us plau");
		i = Lector.nextDouble();
		while(i<10){
			System.out.println("La quantitat ha de ser major a 10€. ");
			i = Lector.nextDouble();
		}
		System.out.println("S'ha fet l'ingrés amb èxit");	
	}
	
	public static void ferTransferencia(){
		Scanner Lector = new Scanner(System.in);
		Double i;
		String x;
		System.out.println("Ingressi la quantitat de diners que vol transferir, si us plau");
		i = Lector.nextDouble();
		System.out.println("Ingressi l'IBAN de la compta en la que vol fer la transferencia");
		x = Lector.next();
		
		
	}

	}