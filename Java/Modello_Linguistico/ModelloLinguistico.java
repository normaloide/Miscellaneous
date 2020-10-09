import java.util.*;

/**
 * Questa classe tiene traccia delle frequenze assolute, del numero di
 * lettere viste e del numero di testi su cui il
 * modello e' stato addestrato
 */
 
public class ModelloLinguistico {
	
	/** attributi */
	private String testo;
	private ArrayList<Character> car;
	private ArrayList<Integer> cont;
	private int cartot;
	private int testi;
	
	/** costruttori */
	public ModelloLinguistico() {
		this.testo = new String();
		this.car = new ArrayList<Character>();
		this.cont = new ArrayList<Integer>();
		
		for(int i = 0; i < 26; i++) {
			this.cont.add(0);
		}
		
		this.cartot = 0;
		this.testi = 0;
	}
	
	public ModelloLinguistico(String testo) {
		this.testo = testo.toLowerCase();
		this.car = new ArrayList<Character>();
		this.cont = new ArrayList<Integer>();
		
		for(int i = 0; i < 26; i++) {
			this.cont.add(0);
		}
		
		this.cartot = 0;
		this.testi = 1;    //il testo inserito nel costruttore
	}
	
	/**
	 * vengono considerati uno alla volta i caratteri del testo
	 * escludento quelli non alfabetici. Ogni carattere
	 * alfabetico viene minuscolizzato e il contatore incrementato
	 * @param    testo    Stringa contenente il testo
	 */
	 
	public void addestra(String testo) {
		this.testi++;
		for(int i = 0; i < testo.length(); i++) {
			char c = testo.charAt(i);
			if(Character.isLetter(c)) {
				this.cartot++;
				if(!(this.car.contains(c))) {
					this.car.add(c);
				}
				
				this.cont.set(this.car.indexOf(c), this.cont.get(this.car.indexOf(c)) + 1);
			}
		}
	}
	
	/**
	 * restituisce il numero totale di testi su cui il modello e'
	 * stato addestrato
	 * @return    numero di testi
	 */
	 
	public int quantiTesti() {
		return this.testi;
	}
	
	/**
	 * restituisce il numero totale di caratteri utilizzati
	 * per addestrare
	 * @return    numero di caratteri
	 */
	
	public int quantiCaratteri() {
		return this.cartot;
	}
	
	/**
	 * restituisce la frequenza assoluta del carattere
	 * se questo carattere è alfabetico
	 * @param    c    carattere
	 * @return    il valore se è un carattere, altrimenti -1
	 */
	
	public int frequenzaAssoluta(char c) {
		c = Character.toLowerCase(c);
		if(Character.isLetter(c)) {
			return this.cont.get(this.car.indexOf(c));
		}
		
		else {
			return -1;
		}
	}
	
	/**
	 * il seguente metodo restituisce la frequenza relativa del
	 * carattere, ovvero la frequenza assoluta divisa per il numero
	 * di caratteri visti
	 * @param    c    carattere analizzato
	 * @return    la frequenza double
	 */
	
	public double frequenzaRelativa(char c) {
		if(this.quantiCaratteri() > 0) {
			return this.frequenzaAssoluta(c)/this.cartot;
		}
		
		else {
			return 1.0/26;
		}
	}
	
	/**
	 * calcolo la differenza in norma L2 tra questo modello linguistico
	 * e m. La differenza si calcola sommando il quadrato delle
	 * differenze tra le due frequenze relative, per ogni carattere, di
	 * entrambi i linguaggi, e calcolando la radice quadrata
	 * @param    m    un modello linguistico
	 * @return    la differenza in norma L2
	 */
	
	public double differenza(ModelloLinguistico m) {
		int totale = 0;
		for(int i = 0; i < this.car.size(); i++) {
			totale += Math.pow(this.frequenzaRelativa(this.car.get(i)) - m.frequenzaRelativa(m.car.get(i)), 2);
		}
		
		return Math.sqrt(totale);
	}
	
	/**
	 * Override del metodo toString()
	 * @return    stringa che identifica la classe
	 */
	@Override
	public String toString() {
		return this.car.toString() + ", " + this.cont.toString();
	}
	
	/**
	 * Override del metodo equals(Object o)
	 * @param    o    oggetto da analizzare
	 * @return    true se è uguale
	 */
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		if(o instanceof ModelloLinguistico) {
			ModelloLinguistico ml = (ModelloLinguistico) o;
			if(this.car.equals(ml.car) && this.cont.equals(ml.cont) && this.testi == ml.testi) {
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
	 * @return    intero rappresentante l'hashCode
	 */
	@Override
	public int hashCode() {
		return this.toString().hashCode() * 31;
	}
}
