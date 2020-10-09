import java.util.*;
import java.lang.*;

/**
 * la classe Stazione definisce una Stazione dove si possono depositare
 * Biciclette. Ogni Stazione ha un nome, una locazione, un numero di
 * posizioni disponibili e puo' o meno ospitare Biciclette elettriche
 */
 
public class Stazione {
	
	/** attributi della classe */
	private String nome;
	private double x;
	private double y;
	private int posizioni;
	private boolean elettriche;
	private Bicicletta[] totale;
	
	/** costruttore della classe */
	public Stazione(String nome, double x, double y, int posizioni, boolean elettriche) {
		this.nome = nome;
		this.x = x;
		this.y = y;
		this.posizioni = posizioni;
		this.elettriche = elettriche;
		this.totale = new Bicicletta[posizioni];
	}
	
	/**
	 * il metodo restituisce il numero di posizioni della Stazione
	 * @return    restituisce le posizioni
	 */
	public int nPosizioni() {
		return this.posizioni;
	}
	 
	/**
	* il metodo restituisce il numero di posizioni occupate contando
	* le biciclette presenti
	* @return    intero delle posizioni occupate
	*/
	public int nBiciclette() {
		int cont = 0;
		for(int i = 0; i < this.totale.length; i++) {
			if(this.totale[i] != null) {
				cont++;
			}
		}
		  
		return cont;
	}
	 
	/**
	 * il metodo dice se la stazione è piena
	 * @return    true se è piena
	 */
	public boolean piena() {
		for(int i = 0; i < this.totale.length; i++) {
		    if(this.totale[i] == null) {
		        return false;
			}
		}
		  
		return true;
	}
	  
	/**
	 * il metodo dice se la stazione è vuota
	 * @return    true se è vuota
	 */
	public boolean vuota() {
	    ArrayList<Bicicletta> lista = new ArrayList<Bicicletta>(Arrays.asList(this.totale));
		if(lista.isEmpty()) {
			return true;
		}
		  
		else {
			return false;
		}
	}
	 
	/**
	 * il metodo dice se la Stazione può ospitare biciclette elettriche
	 * @return    true se può ospitare biciclette elettriche
	 */
	public boolean ammetteElettriche() {
	    return this.elettriche;
	}
	  
	/**
	 * il metodo dice se la Stazione contiene almeno una Bicicletta
	 * elettrica
	 * @return    true se contiene
	 */
	public boolean ciSonoElettriche() {
		if(this.elettriche == false) {
			return false;
		}
		   
	    else {
			for(int i = 0; i < this.totale.length; i++) {
				if(this.totale[i].elettrica() == true) {
					return true;
				}
			}
			   
			return false;
		}
	}
	   
	/**
     * restituisce la Bicicletta legata alla posizione i
     * @param    i    intero che rivela la posizione
	 * @return    Bicicletta alla posizione richiesta
	 */
	public Bicicletta posizione(int i) {
		return this.totale[i];
	}
		
	/**
	 * il metodo aggancia la Bicicletta alla Stazione, l'Utente non
	 * non possiede piu' la Bicicletta e la Bicicletta si libera.
	 * Se il posto è occupato solleva un'eccezione
	 * @param    u    Utente
	 * @param    i    luogo dove l'Utente lascia la Bicicletta
	 */
	public void aggancia(Utente u, int i) {
		if(this.totale[i] != null) {
			throw new IllegalStateException("posizione occupata");
		}
			 
		else {
			this.totale[i] = u.bicicletta();
			u.bicicletta().restituisci();
			u.restituisci();
		}
	}
		 
	/**
	* il metodo serve per prelevare una Bicicletta, se il posto
	* e' vuoto o se l'utente sta usando gia' un'altra Bicicletta
	* solleva un'eccezione
	* @param    u    Utente
	* @param    i    luogo dove l'Utente preleva la Bicicletta
	*/
	public void prendi(Utente u, int i) {
	    if(this.totale[i] == null || u.bicicletta() != null) {
            throw new IllegalStateException("richiesta non valida");
	    }
	  
	    else {
		    u.prendiInUso(this.totale[i]);
		    u.bicicletta().daiInUso(u);
		    this.totale[i] = null;
		}
	}
	
	/**
	 * restituisce la prima posizione che contiene una Bicicletta
	 * (se elettrica e' true, considera solo le biciclette elettriche
	 * @param    elettrica    true se si vogliono solo bici elettriche
	 * @return    restituisce l'intero relativo alla posizione della bici
	 */
	public int disponibile(boolean elettrica) {
		for(int i = 0; i < this.totale.length; i++) {
			if(elettrica == this.totale[i].elettrica()) {
				return i;
			}
		}
		 
		return -1;
	}
	 
	/**
	 * restituisce la distanza tra la stazione e le coordinate (x,y)
	 * @param    x    coordinata x
	 * @param    y    coordinata y
	 * @return    distanza fisica
	 */
	public double distanzaDa(double x, double y) {
		return Math.sqrt(Math.pow(Math.abs(this.x - x), 2) + Math.pow(Math.abs(this.y - y), 2));
	}
	  
	/**
	 * metodo per sovrascrivere il toString()
	 * @return    Stringa identificativa della Stazione
	 */
	@Override
	public String toString() {
		String s;
		if(this.elettriche == true) {
			s = "La Stazione puo' contenere biciclette elettriche";
		}
		   
		else {
			s = "La Stazione non puo' contenere biciclette elettriche";
		}
		   
		return this.nome + ": " + this.x + ", " + this.y + ". " + s;
	}
}
