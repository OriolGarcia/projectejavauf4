package paquet;

public class ComptaBancaria {
   private String IBAN;
   private Double Saldo;
   private String PIN;
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
			else if (PIN!=OldPIN)  System.out.println("El PIN antic és icorrecte. No s'ha pogut canviar el PIN" );
			else if (NewPIN.length()!=4||!Main.isNumeric(NewPIN)) System.out.println("El PIN ha de tenir 4 numeros" );
		}


		public String getIBAN() {
			return IBAN;
		}


		public Double getSaldo() {
			return Saldo;
		}


		public String getNumeroCompta() {
			return numeroCompta;
		}


		public String getNumerodecontrol1() {
			return numerodecontrol1;
		}


		public String getNumerodecontrol2() {
			return numerodecontrol2;
		}


		public static int getNumComptes() {
			return numComptes;
		}


		

	}