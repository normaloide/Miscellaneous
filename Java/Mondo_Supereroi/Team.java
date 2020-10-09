import java.util.*;

public class Team {
	
	private String nome;
	private ArrayList<Supereroe> eroi;
	
	public Team(String nome) {
		this.nome = nome;
		this.eroi = new ArrayList<Supereroe>();
	}
	
	public void add(Supereroe x) {
		if(!(this.eroi.contains(x))) {
			this.eroi.add(x);
		}
	}
	
	public Supereroe[] componenti() {
		return this.eroi.toArray(new Supereroe[this.eroi.size()]);
	}
	
	public Supereroe cercaGrande(Caratteristica x, double t) {
		for(int i = 0; i < this.eroi.size(); i++) {
			if(this.eroi.get(i).valore(x) >= x.valoreNormale() + t) {
				return this.eroi.get(i);
			}
		}
		
		return null;
	}
	
	public Supereroe cercaPiccolo(Caratteristica x, double t) {
		for(int i = 0; i < this.eroi.size(); i++) {
			if(this.eroi.get(i).valore(x) <= x.valoreNormale() + t) {
				return this.eroi.get(i);
			}
		}
		
		return null;
	}
}
