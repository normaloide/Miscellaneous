import java.util.*;

public class Supereroe {
	
	private String nome;
	private ArrayList<Caratteristica> car;
	private ArrayList<Double> valori;
	
	public Supereroe(String nome) {
		this.nome = nome;
		this.car = new ArrayList<Caratteristica>();
		this.valori = new ArrayList<Double>();
	}
	
	public void addCaratteristica(Caratteristica x, double v) {
		if(!(this.car.contains(x))) {
			this.car.add(x);
			this.valori.add(v);
		}
	}
	
	public double valore(Caratteristica x) {
		if(x.valoreNormale() == this.valori.get(this.car.indexOf(x))) {
			return x.valoreNormale();
		}
		
		else {
			return this.valori.get(this.car.indexOf(x));
		}
	}
	
	public Caratteristica[] superpotereGrande(double t) {
		ArrayList<Caratteristica> sol = new ArrayList<Caratteristica>();
		for(int i = 0; i < car.size(); i++) {
			if(this.valori.get(i) >= this.car.get(i).valoreNormale() * t) { 
				sol.add(this.car.get(i));
			}
		}
		
		return sol.toArray(new Caratteristica[sol.size()]);
	}
	
	public Caratteristica[] superpoterePiccolo(double t) {
		ArrayList<Caratteristica> sol = new ArrayList<Caratteristica>();
		for(int i = 0; i < car.size(); i++) {
			if(this.valori.get(i) <= this.car.get(i).valoreNormale() * t) { 
				sol.add(this.car.get(i));
			}
		}
		
		return sol.toArray(new Caratteristica[sol.size()]);
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		if(o instanceof Supereroe) {
			Supereroe s = (Supereroe) o;
			if(this.nome.equals(s.nome)) {
				return true;
			}
			
			else {
				return false;
			}
		}
		
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return this.nome.hashCode()*31;
	}
}
