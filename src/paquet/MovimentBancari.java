package paquet;

import java.util.Date;

public class MovimentBancari {
	private Date data;
	private String concepte;
	private Double quantitat;

	public MovimentBancari(Date data, String concepte, Double quantitat){
		
		this.data = data;
		this.concepte = concepte;
		this.quantitat = quantitat;
	}
}


