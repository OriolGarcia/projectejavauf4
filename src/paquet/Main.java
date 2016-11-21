package paquet;
/**
 * Aquesta classe t� el main del programa, c�rrega la base de dades predefinida 
 * i excecuta l'accessor fins que es tanca.
 * 
 * @author ogs10_000
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseDeDadesV BDVirtual = new BaseDeDadesV();
		// M�tode que carrega una Base de dades al objecte
		// No �s predefineix en el constructor per si en algun moment 
		// volem una BD buida.
		BDVirtual.Predefinir();
		
		while (Accessor.Menu(BDVirtual)!=0);
		
		
	}

	 public static boolean isNumeric(String cadena){
	    	try {
	    		Integer.parseInt(cadena);
	    		return true;
	    	} catch (NumberFormatException nfe){
	    		return false;
	    	}
	    }
	 

}
