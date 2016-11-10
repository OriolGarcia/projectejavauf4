package paquet;



/**
 * 
 * Aqui tenim la classe Acessor, on tenim el menu d'opcions
 * Hola
 */

public class Accessor {
			
			BaseDeDadesV BDVirtual;
		public static int Menu(BaseDeDadesV BDVirtual){
			
			 int resposta;
			 System.out.println("Benvingut a Gringotts Bank" );
			 System.out.println("Que vols fer? Escull opcio escrivint un numero" );
			 System.out.println("      1 - Mode Banquer (només disponible des de a centraleta) " );
			 System.out.println("      2 - Mode Client " );
			 System.out.println("      3 - Veure informació publica del banc " );
			 System.out.println("      4 - Tancar programa " );
			 
			 resposta = EntradaDades.Enter();
			switch (resposta){
			case 1:
				ValidaBanquer(BDVirtual);
				return 1;
			case 2:
				ValidaClient( BDVirtual);
				return 1;
			case 3:
				InfoBanc();
				return 1;
			case 4:
				return 0;
			default:
				return 1;
			}
			
		}
		
		private static void ValidaBanquer(BaseDeDadesV BDVirtual){
			System.out.println("Posa el teu DNI");
			String Dni = EntradaDades.Cadena();
			Banquer Usuari = BDVirtual.CercaBanquerperDNI(Dni);
			if (Usuari==null){System.out.println("No existeix cap banquer registrat amb aquest DNI");}
			else {
				int i = 3;
				System.out.println("Contrasenya: ");
				String contrasenya = EntradaDades.Cadena();
				while(!contrasenya.equals(Usuari.getContrasenya())&&i>0){
					System.out.println("Contrasenya incorrecta, et queden "+i+" intents.");
					i--;
					contrasenya = EntradaDades.Cadena();
				}

				if(i==0){
					System.out.println("Adeu.");
				}else{
					
				Banquer.menudOperacionsBanquer(BDVirtual);
				
			}
			}
		}
		
		
		private static void ValidaClient(BaseDeDadesV BDVirtual){
			System.out.println("Posa el teu DNI");
			String Dni = EntradaDades.Cadena();
			Client Usuari=BDVirtual.CercaClientperDNI(Dni);
			
			if (Usuari==null){System.out.println("No existeix cap client registrat amb aquest DNI");}
			else {
					Client.LlistarComptesBancaries(BDVirtual,Dni);
			}
				
			}
		
		private static void InfoBanc(){}
		
}
