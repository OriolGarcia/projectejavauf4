package paquet;

import java.util.Date;

public class MovimentBancari {
	private Date data;
	private String nom;
	private Double quantitat;

	public MovimentBancari(Date data, String nom, Double quantitat){
		
		this.data = data;
		this.nom = nom;
		this.quantitat = quantitat;
	}
}


