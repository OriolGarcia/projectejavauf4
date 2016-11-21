package paquet;

import java.util.Date;
/**
 * 
 * La classe moviment bancari es una classe que guarda informaci� d'un moviment per despres emmagazemar-la
 * @author ogs10_000
 *
 */
public class MovimentBancari {
	private Date data;
	private String concepte;
	private Double quantitat;

	/**
	 * Tenim moviment bancari on ens mostrar� la data el concepte de la transfer�ncia o ingr�s,
	 * i la quantitat que haguem possat o extreta.
	 * @param data
	 * @param concepte
	 * @param quantitat
	 */
	public MovimentBancari(Date data, String concepte, Double quantitat){
		
		this.data = data;
		this.concepte = concepte;
		this.quantitat = quantitat;
	}

	//getters i setters
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getConcepte() {
		return concepte;
	}

	public void setConcepte(String concepte) {
		this.concepte = concepte;
	}

	public Double getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(Double quantitat) {
		this.quantitat = quantitat;
	}

}