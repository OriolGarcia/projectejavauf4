package paquet;

import java.util.Scanner;

public class Accessor {
			private static Scanner Lector = new Scanner(System.in);
			BaseDeDadesV BDVirtual;
		public static int Menu(BaseDeDadesV BDVirtual){
			
			 
			 int resposta;
			 System.out.println("Que vols fer? Escull opcio escrivint un numero" );
			 System.out.println("      1 - Mode Banquer (només disponible des de a centraleta) " );
			 System.out.println("      2 - Mode Client " );
			 System.out.println("      3 - Veure informació publica del banc " );
			 System.out.println("      4 - Tancar programa " );
			 
			 resposta = Lector.nextInt();
			switch (resposta){
			case 1:
				ValidaBanquer();
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
		
		private static void ValidaBanquer(){
			
		}
		
		
		private static void ValidaClient(BaseDeDadesV BDVirtual){
			System.out.println("Posa el teu DNI");
			String Dni = Lector.next();
			Client Usuari=BDVirtual.CercaClientperDNI(Dni);
			
			if (Usuari==null){System.out.println("no existeix cap client registrat amb aquest DNI");}
			else {
				int resposta=0;
				while (resposta!=3){
			
				System.out.println("Que vols fer? Escull opcio escrivint un numero");
				System.out.println("	1 - Ingressar diners a una Compta Bancaria qualsevol");
				System.out.println("	2 - Fer operacions amb una de les meves comptes bancaries");
				System.out.println("	3 - Sortir");
				
				Scanner scan = new Scanner(System.in);
				resposta = scan.nextInt();
				
				switch(resposta){
				
				case 1:
					ComptaBancaria.ingressarDiners(BDVirtual);
					
				case 2: 
					//ComptaBancaria.setPIN();
				case 3:
				
					
				}
				}
				
			}
			}
			
		
		private static void InfoBanc(){}
		
}
