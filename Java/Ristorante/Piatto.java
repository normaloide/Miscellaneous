import java.util.*;

public class Piatto {
	
	private String nome;
	private Categoria cat;
	private ArrayList<Ingrediente> ingr;
	private ArrayList<Double> quant;
	
	public Piatto(String nome, Categoria cat) {
		this.nome = nome;
		this.cat = cat;
		this.ingr = new ArrayList<Ingrediente>();
		this.quant = new ArrayList<Double>();
	}
	
	public void aggiungiIngrediente(Ingrediente x, double qta) {
		if(!(this.ingr.contains(x))) {
			this.ingr.add(x);
			this.quant.set(this.ingr.indexOf(x), qta);
		}
	}
	
	public double ingrediente(Ingrediente x) {
		if(this.ingr.contains(x)) {
			return this.quant.get(this.ingr.indexOf(x));
		}
		
		else {
			return 0;
		}
	}
	
	public double prezzo() {
		double totale = 0;
		for(int i = 0; i < this.ingr.size(); i++) {
			totale += this.ingr.get(i).prezzo(this.quant.get(i));
		}
		
		return totale + (totale * 0.4);
	}
	
	public boolean causaIntolleranza(Intolleranza x) {
		for(int i = 0; i < this.ingr.size(); i++) {
			if(this.ingr.get(i).causaIntolleranza(x)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Categoria categoria() {
		return this.cat;
	}
	
	public String descrizione() {
		return this.nome + ", " + this.cat + ", " + this.prezzo() + ", " + Arrays.toString(this.ingr.toArray());
	}
	
	@Override
	public String toString() {
		return this.nome + ", " + this.cat + ", " + this.prezzo();
	}
}
