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
			String Dni = Lector.next();
			Banquer Usuari = BDVirtual.CercaBanquerperDNI(Dni);
			if (Usuari==null){System.out.println("no existeix cap banquer registrat amb aquest DNI");}
			else {
				
				int resposta=0;
				
				System.out.println("Que vols fer? Escull opcio escrivint un numero");
				System.out.println("	1 - Donar d'alta a un client");
				System.out.println("	2 - Donar d'alta a un banquer");
				System.out.println("	3 - Donar d'alta una compta bancaria");
				System.out.println("	4 - Donar de baixa a un client");
				System.out.println("	5 - Donar de baixa a un banquer");
				System.out.println("	6 - Donar de baixa una compta bancaria");
				System.out.println("	7 - Fer un préstec");
				System.out.println("	8 - Hipoteques");
				System.out.println("	9 - Sortir");
				
				Scanner scan = new Scanner(System.in);
				resposta = scan.nextInt();
				
				switch(resposta){
				
				
				}
				
			}
			}
			
		
		
		private static void ValidaClient(BaseDeDadesV BDVirtual){
			System.out.println("Posa el teu DNI");
			String Dni = Lector.next();
			Client Usuari=BDVirtual.CercaClientperDNI(Dni);
			
			if (Usuari==null){System.out.println("no existeix cap client registrat amb aquest DNI");}
			else {
					Client.LlistarComptesBancaries(BDVirtual,Dni);
			}
				
			}
		
		private static void InfoBanc(){}
		
}
