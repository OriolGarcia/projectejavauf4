package paquet;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * 
 * Aqui guardem les dades de clients i banquers
 *
 */

public class BaseDeDadesV {
		private String codiJavaBank;
		private ArrayList<Client> LlistaClients= new ArrayList<Client>();
		private ArrayList<Banquer> LlistaBanquers= new ArrayList<Banquer>();
		public void Predefinir(){
				codiJavaBank = "0622";
				Client cli = AfegirClientaBD("Joan","Perez Gimenez","47294219M","30-10-1984",
						"ES",codiJavaBank, "0310","04-10-2000");
				if (cli !=null){
					cli.AfegirComptaBancariaAmbParametres("7589", 1500.00);
					cli.AfegirComptaBancariaAmbParametres("0742", 1200.00);
					LlistaClients.set(LlistaClients.indexOf(cli), cli);
				}
				
				
				
				Client cli2 = AfegirClientaBD("Pepet","Llovera Pallarés","33342194F","30-10-1984",
						"ES",codiJavaBank, "0310","04-10-1997");
				if (cli2!=null){
					cli2.AfegirComptaBancariaAmbParametres("7589", 8500.00);
					cli2.AfegirComptaBancariaAmbParametres("0742", 4000.00);
					LlistaClients.set(LlistaClients.indexOf(cli2), cli2);
					}
				
				
				Banquer ban = AfegirBanquerBD("Carlos","Sanchez Romero","12345678P","24-09-1982", "ES", codiJavaBank,
												"Holaquetal1234");
				
		
				Banquer ban2 = AfegirBanquerBD("Maria","Garcia Martinez","66612345V","16-05-1983", "ES", codiJavaBank,
												"Holaquetal4321");
		}
				
				
						
		private Client AfegirClientaBD(String nom,String Cognoms,String dni,String ddMMyyyyNaixement,String CodiPais,
				String codiJavaBank, String codiSucursal, String ddMMyyyyAlta){
			
			
			String	patro="dd-MM-yyyy";
			SimpleDateFormat FormatData = new SimpleDateFormat(patro);
			
			try {
				
				Date Dnaixement =  FormatData.parse(ddMMyyyyNaixement);
				Date Dalta = FormatData.parse(ddMMyyyyAlta);
				Client C1 =new Client(nom,Cognoms,dni,Dnaixement,CodiPais,
						codiJavaBank,codiSucursal,Dalta);
				if(JaExisteixClient(C1)){System.out.println("Ja existeix un client registrat amb DNI "+ dni); 
				return null;}
				
				LlistaClients.add(C1);
				System.out.println("S'ha inserit un Client a la BD amb DNI: "+ C1.getDni());
				
				return C1;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		public ArrayList<Client> getLlistaClients() {
			return LlistaClients;
		}
		public void setLlistaClients(ArrayList<Client> llistaClients) {
			LlistaClients = llistaClients;
		}
		
		
		private Banquer AfegirBanquerBD(String nom,String Cognoms,String dni,String ddMMyyyyNaixement,String CodiPais,
				String codiJavaBank, String contrasenya){
			
			String	patro="dd-MM-yyyy";
			SimpleDateFormat FormatData = new SimpleDateFormat(patro);
			
			try {
				
				Date Dnaixement =  FormatData.parse(ddMMyyyyNaixement);
				Banquer B1 =new Banquer(nom,Cognoms,dni,Dnaixement,CodiPais,
						codiJavaBank,contrasenya);
				if(JaExisteixBanquer(B1)){System.out.println("Ja existeix un banquer registrat amb DNI "+ B1.getDni()); 
				return null;}
				
				LlistaBanquers.add(B1);
<<<<<<< Upstream, based on branch 'master' of https://github.com/OriolGarcia/projectejavauf4
				System.out.println("S'ha inserit un Banquer a la BD amb DNI: "+ B1.getDni() + " amb contrasenya: " + B1.getContrasenya());
=======
				System.out.println("S'ha inserit un Banquer a la BD amb DNI: "+ B1.getDni()+"i amb contrasenya: "+B1.getContrasenya());
>>>>>>> e2df535 Coses
				
				return B1;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
			
		
		
		public ArrayList<Banquer> getLlistaBanquer() {
			return LlistaBanquers;
		}
		public void setLlistaBanquer(ArrayList<Banquer> llistaBanquer) {
			LlistaBanquers = llistaBanquer;
		}
		
		public boolean JaExisteixBanquer(Banquer ban) {
		    
		    for (Banquer index : LlistaBanquers) {
		        if (index.equals(ban)) {
		            return true;
		        }
		    }
		    return false;
		}
		
		public boolean JaExisteixClient(Client cli) {
		    
		    for (Client index : LlistaClients) {
		        if (index.equals(cli)) {
		            return true;
		        }
		    }
		    return false;
		}
		
		
		public ComptaBancaria CercaComptaBancariaperIBAN(ComptaBancaria CC, String IBAN){
			 Client cli = null;
			 ComptaBancaria CCretorn =null;
			    for (int i=0;i<LlistaClients.size();i++) {
			    	cli = LlistaClients.get(i);
			    	
					for (int k=0;k<cli.getLlistaComptesdelClient().size();k++) {
						LlistaClients.get(i);
						if (cli.getLlistaComptesdelClient().get(k).getIBAN().equals(IBAN)) {
			    			LlistaClients.get(i);
							CCretorn=cli.getLlistaComptesdelClient().get(k);
			    			if (CC!=null){
			    				
			    				LlistaClients.get(i).SubstitueixCC(k,CC);
			    				CCretorn=CC;
			    			}
			    			break;
			        }
					}
			    }
			    return CCretorn;
			
		}
		
		
		public void eliminarComptaBancaria(String IBAN){
			 Client cli = null;
			 
			    for (int i=0;i<LlistaClients.size();i++) {
			    	cli = LlistaClients.get(i);
					for (int k=0;k<cli.getLlistaComptesdelClient().size();k++) {
						LlistaClients.get(i);
						if (cli.getLlistaComptesdelClient().get(k).getIBAN().equals(IBAN)) {
			    			LlistaClients.get(i);
							cli.getLlistaComptesdelClient().remove(k);
								
			    			}
			    			break;
			        }
					}
			    }

		
		
		
		public Banquer CercaBanquerperDNI(String DNI) {
		    Banquer ban = null;
		    for (Banquer index : LlistaBanquers) {
		        if (index.getDni().equals(DNI)) {
		            ban = index;
		            break;
		        }
		    }
		    return ban;
		}
		
		public Client CercaClientperDNI(String DNI) {
		    Client cli = null;
		    for (Client index : LlistaClients) {
		        if (index.getDni().equals(DNI)) {
		            cli = index;
		            break;
		        }
		    }
		    return cli;
		}
		

	
}
