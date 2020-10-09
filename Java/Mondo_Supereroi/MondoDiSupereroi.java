import java.util.*;

public class MondoDiSupereroi {
	
	private String nome;
	private ArrayList<Team> team;
	
	public MondoDiSupereroi(String nome) {
		this.nome = nome;
		this.team = new ArrayList<Team>();
	}
	
	public void add(Team x) {
		if(!(this.team.contains(x))) {
			this.team.add(x);
		}
	}
	
	public int quantiSupereroi() {
		ArrayList<Supereroe> list = new ArrayList<Supereroe>();
		for(int i = 0; i < this.team.size(); i++) {
			for(int j = 0; j < this.team.get(i).componenti().length; j++) {
				if(list.contains(this.team.get(i).componenti()[j])) {
					list.add(this.team.get(i).componenti()[j]);
				}
			}
		}
		
		return list.size();
	}
	
	public Team cercaGrande(Caratteristica x, double v) {
		for(int i = 0; i < this.team.size(); i++) {
			if(this.team.get(i).cercaGrande(x, v) != null) {
				return this.team.get(i);
			}
		}
		
		return null;
	}
	
	public Team cercaPiccolo(Caratteristica x, double v) {
		for(int i = 0; i < this.team.size(); i++) {
			if(this.team.get(i).cercaPiccolo(x, v) != null) {
				return this.team.get(i);
			}
		}
		
		return null;
	}
}
