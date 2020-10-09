import java.util.*;

/**
 * Questa classe mantiene una lista di modelli linguistici di varie
 * lingue, e una lista parallela di nomi di lingue.
 */

public class Addestratore {
	
	/** attributi */
	private ArrayList<ModelloLinguistico> ml;
	private ArrayList<String> lingue;
	
	/** costruttore */
	public Addestratore() {
		this.ml = new ArrayList<ModelloLinguistico>();
		this.lingue = new ArrayList<String>();
	}
	
	/**
	 * se la lingua è conosciuta, viene addestrata col testo
	 * se è sconosciuta, si crea un modello linguistico e si addestra
	 * col dato testo
	 * @param    nomeLingua    nome della lingua
	 * @param    testo    testo usato per addestrare
	 */
	 
	public void addestra(String nomeLingua, String testo) {
		if(this.lingue.contains(nomeLingua)) {
			this.ml.get(this.lingue.indexOf(nomeLingua)).addestra(testo);
		}
		
		else {
			this.lingue.add(nomeLingua);
			this.ml.add(new ModelloLinguistico());
			this.ml.get(this.lingue.indexOf(nomeLingua)).addestra(testo);
		}
	}
	
	/**
	 * costruisce un modello linguistico per il testo passato come
	 * argomento, e lo confronta con tutti i modelli di tutte le lingue
	 * conosciute.
	 * @param    testo    testo usato dal metodo
	 * @return    restituisce il nome della lingua che ha dato luogo
	 *            a differenza minima
	 */
	 
	public String classifica(String testo) {
		String linguadiffminima = "";
		double diffminima = Double.MAX_VALUE;
		ModelloLinguistico modello = new ModelloLinguistico(testo);
		for(int i = 0; i < this.ml.size(); i++) {
			double diff = modello.differenza(this.ml.get(i));
			if(diff < diffminima) {
				linguadiffminima = this.lingue.get(i);
			}
		}
		
		return linguadiffminima;
	}
	
        /**
	 * il metodo stampa tutti gli istogrammi di tutte le lingue
	 * conosciute
	 */
	 
	public void stampa(int larg) {
		for(int i = 0; i < this.lingue.size(); i++) {
			Istogramma ist = new Istogramma(larg);
			System.out.println(this.lingue.get(i));
			System.out.println(ist.toString(this.ml.get(i)));
		}
	}
	
	/**
	 * Override del metodo toString()
	 * @return    stringa contenente informazioni sull'addestratore
	 */
	@Override
	public String toString() {
		return this.ml.toString() + ", " + this.lingue.toString();
	}
	
       /**
	 * Override del metodo equals(Object o)
	 * @param    o    oggetto
	 * @return    true se sono lo stesso Addestratore
	 */
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		if(o instanceof Addestratore) {
			Addestratore ad = (Addestratore) o;
			if(this.ml.equals(ad.ml) && this.lingue.equals(ad.lingue)) {
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
	
	/**
	 * Override del metodo hashCode()
	 * @return    intero dell'hashCode
	 */
	@Override
	public int hashCode() {
		return (this.ml.toString().hashCode() + this.lingue.toString().hashCode()) * 31;
	}
}
