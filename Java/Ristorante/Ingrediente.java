import java.util.*;

public class Ingrediente {
	
	private ArrayList<Intolleranza> into;
	private String nome;
	private String unitaMisura;
	private double prezzoUnitario;
	
	public Ingrediente(String nome, String unitaMisura, double prezzoUnitario) {
		this.nome = nome;
		this.unitaMisura = unitaMisura;
		this.prezzoUnitario = prezzoUnitario;
		this.into = new ArrayList<Intolleranza>();
	}
	
	public void addIntolleranza(Intolleranza x) {
		if(!(this.into.contains(x))) {
			into.add(x);
		}
	}
	
	public boolean causaIntolleranza(Intolleranza x) {
		if(this.into.contains(x)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public double prezzo(double qta) {
		return this.prezzoUnitario * qta;
	}
	
	@Override
	public String toString() {
		return this.nome + ", " + this.unitaMisura + ", " + this.prezzoUnitario;
	}
}
