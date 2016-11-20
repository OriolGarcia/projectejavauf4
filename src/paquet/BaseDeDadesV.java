package paquet;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/**
 * Aqui guardem les dades de clients i banquers
 * 
 */
public class BaseDeDadesV {
		private String codiJavaBank;
		
		private ArrayList<Persona> LlistaPersones= new ArrayList<Persona>();
		public void Predefinir(){
				codiJavaBank = "0622";
				Client cli = AfegirClientaBD("Joan","Perez Gimenez","47294219M","30-10-1984",
						"ES",codiJavaBank, "0310","04-10-2000");
				if (cli !=null){
					cli.AfegirComptaBancariaAmbParametres("7589", 1500.00);
					cli.AfegirComptaBancariaAmbParametres("0742", 1200.00);
					LlistaPersones.set(LlistaPersones.indexOf(cli), cli);
				}
				
							
				Client cli2 = AfegirClientaBD("Pepet","Llovera Pallarés","33342194F","30-10-1984",
						"ES",codiJavaBank, "0310","04-10-1997");
				if (cli2!=null){
					cli2.AfegirComptaBancariaAmbParametres("7589", 8500.00);
					cli2.AfegirComptaBancariaAmbParametres("0742", 4000.00);
					LlistaPersones.set(LlistaPersones.indexOf(cli2), cli2);
					}
				
				
				Banquer ban = AfegirBanquerBD("Carlos","Sanchez Romero","12345678P","24-09-1982", "ES", codiJavaBank,
												"Holaquetal1234");
				
		
				Banquer ban2 = AfegirBanquerBD("Maria","Garcia Martinez","66612345V","16-05-1983", "ES", codiJavaBank,
												"Holaquetal4321");
		}
								
		/**
		 * Per afegir client a la BD		
		 * @param nom
		 * @param Cognoms
		 * @param dni
		 * @param ddMMyyyyNaixement
		 * @param CodiPais
		 * @param codiJavaBank
		 * @param codiSucursal
		 * @param ddMMyyyyAlta
		 * @return
		 */
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
				
				LlistaPersones.add(C1);
				System.out.println("S'ha inserit un Client a la BD amb DNI: "+ C1.getDni());
				
				return C1;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}

		//getter i setter
		public ArrayList<Persona> getLlistaPersones() {
			return LlistaPersones;
		}
		public void setLlistaPersones(ArrayList<Persona> llistaPersones) {
			LlistaPersones = llistaPersones;
		}
		
		/**
		 * Per afegir un Banquer a la BD
		 * @param nom
		 * @param Cognoms
		 * @param dni
		 * @param ddMMyyyyNaixement
		 * @param CodiPais
		 * @param codiJavaBank
		 * @param contrasenya
		 * @return
		 */
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
				
				LlistaPersones.add(B1);

				System.out.println("S'ha inserit un Banquer a la BD amb DNI: "+ B1.getDni() + " amb contrasenya: " + B1.getContrasenya());

				
				return B1;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
			
		
		
/**
 * Si existeix Banquer o no.
 * @param ban
 * @return
 */
		public boolean JaExisteixBanquer(Banquer ban) {
		    
		    for (Persona index : LlistaPersones) {
		        if (index.equals(ban)&&index instanceof Banquer ) {
		            return true;
		        }
		    }
		    return false;
		}
		
		/**
		 * 
		 * @param cli
		 * @return
		 */
		public boolean JaExisteixClient(Client cli) {
		    
		    for (Persona index : LlistaPersones) {
		        if (index.equals(cli)&& index instanceof Client) {
		            return true;
		        }
		    }
		    return false;
		}
		
		/**
		 * Buscar compta bancaria per l'IBAN
		 * @param CC
		 * @param IBAN
		 * @return
		 */
		public ComptaBancaria CercaComptaBancariaperIBAN(ComptaBancaria CC, String IBAN){
			 Persona cli = null;
			 ComptaBancaria CCretorn =null;
			    for (int i=0;i<LlistaPersones.size();i++) {
			    	cli = LlistaPersones.get(i);
			    	if (cli instanceof Client){
					for (int k=0;k<((Client) cli).getLlistaComptesdelClient().size();k++) {
						LlistaPersones.get(i);
						if (((Client) cli).getLlistaComptesdelClient().get(k).getIBAN().equals(IBAN)) {
			    			cli =LlistaPersones.get(i);
							CCretorn=((Client) cli).getLlistaComptesdelClient().get(k);
			    			if (CC!=null){
			    				
			    				((Client) cli).SubstitueixCC(k,CC);
			    				CCretorn=CC;
			    			}
			    			break;
			        }
					}
			    }
			    }
			    return CCretorn;			
		}
		
		
		public void eliminarComptaBancaria(String IBAN){
			 Persona cli = null;
			 
			    for (int i=0;i<LlistaPersones.size();i++) {
			    	cli = LlistaPersones.get(i);
			    	if (cli instanceof Client){
					for (int k=0;k<((Client) cli).getLlistaComptesdelClient().size();k++) {
						LlistaPersones.get(i);
						if (((Client) cli).getLlistaComptesdelClient().get(k).getIBAN().equals(IBAN)) {
			    			LlistaPersones.get(i);
			    			((Client) cli).getLlistaComptesdelClient().remove(k);
								
			    			}
			    			break;
			        }
					}
			    }
			    }

		
		
		/**
		 * Cercador per buscar el DNI d'un banquer
		 * @param DNI
		 * @return
		 */
		public Banquer CercaBanquerperDNI(String DNI) {
		    Persona ban = null;
		    for (Persona index : LlistaPersones) {
		        if (index.getDni().equals(DNI)&& index instanceof Banquer) {
		            ban = index;
		            break;
		        }
		    }
		    return (Banquer) ban;
		}
		
		/**
		 * Cercador per buscar el DNI d'un Client
		 * @param DNI
		 * @return
		 */
		public Client CercaClientperDNI(String DNI) {
		    Persona cli = null;
		    for (Persona index : LlistaPersones) {
		        if (index.getDni().equals(DNI)&& index instanceof Client) {
		            cli = index;
		            break;
		        }
		    }
		    return (Client) cli;
		}
		
		
		/**
		 * 
		 * @param DNI
		 * @param cli2
		 * @return
		 */
		public Client SetClientperDNI(String DNI, Client cli2) {
		    Persona cli = null;
		    for (Persona index : LlistaPersones) {
		        if (index.getDni().equals(DNI)&& index instanceof Client) {
		            index = cli2;
		            break;
		        }
		    }
		    return (Client) cli;
		}

	
}
