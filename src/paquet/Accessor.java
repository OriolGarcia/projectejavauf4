package paquet;

/**
 * Aqui tenim la classe Acessor, on tenim el menu d'opcions on passem la resposta 
 * pel switch
 *
 */
public class Accessor {
			
			BaseDeDadesV BDVirtual;
		public static int Menu(BaseDeDadesV BDVirtual){
			
			 int resposta;
			 System.out.println("\n\nBenvingut a Gringotts Bank" );
			 System.out.println("Que vols fer? Escull opcio escrivint un numero" );
			 System.out.println("      1 - Mode Banquer (només disponible des de a centraleta) " );
			 System.out.println("      2 - Mode Client " );
			 System.out.println("      3 - Afegir diners de forma anònima " );
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
				ComptaBancaria.ingressarDiners(BDVirtual,null);
				return 1;
			case 4:
				return 0;
			default:
				return 1;
			}			
		}
		
		/**
		 * Et demana el DNI i el busca en Client, sino existeix sortirà un missatge
		 * d'error, si accedim, ens demanarà la contrasenya, si fallem ens sortirà
		 * un número d'intents, fins a arribar a 0 amb el missatge d'error, on 
		 * ens mostrarà el missatge d'adeu, si entrem entrarem al menu d'operacions.
		 * @param BDVirtual
		 */
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
		
		/**
		 * Ens demana el DNI, i ens comparà amb els clients creats, sino es igual
		 * et sortirà un missatge d'error.
		 * @param BDVirtual
		 */
		private static void ValidaClient(BaseDeDadesV BDVirtual){
			System.out.println("Posa el teu DNI");
			String Dni = EntradaDades.Cadena();
			Client Usuari=BDVirtual.CercaClientperDNI(Dni);
			
			if (Usuari==null){System.out.println("No existeix cap client registrat amb aquest DNI");}
			else {
					Usuari.LlistarComptesBancaries(BDVirtual,Dni);
			}				
			}			
}