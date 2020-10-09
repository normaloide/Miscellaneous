import java.util.*;
/**
 * La classe Utente rappresenta un utente dotato di nome e cognome
 * e che ogni istante può avere al massimo una bicicletta in possesso
 */
 
public class Utente {
	
	/** attributi della classe */
	private String nome;
	private String cognome;
	private Bicicletta bici;
	
	/** costruttore della classe
	 * @param	nome	Stringa contenente il nome dell'Utente
	 * @param	cognome	   Stringa contenente il cognome dell'Utente
	 */
	public Utente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		this.bici = null;
	}
	 
	/**
	 * metodo per esaminare se l'Utente sta utilizzando una bicicletta
	 * @return	   bici	   il metodo restituisce la Bicicletta se in uso
	 */
	public Bicicletta bicicletta() {
	    return this.bici;
	}
	  
	/**
	 * prende in uso la Bicicletta indicata
	 * @param    x    oggetto Bicicletta
	 */
	public void prendiInUso(Bicicletta x) {
		if(this.bici != null) {
			throw new IllegalStateException("l'utente sta utilizzando una bicicletta");
		}
		   
		else {
			this.bici = x;
		}
	}
	   
	/**
	 * l'Utente restituisce la Bicicletta
	 */
	public void restituisci() {
		if(this.bici == null) {
			throw new IllegalStateException("l'utente non sta usando biciclette");
		}
			
		else {
			this.bici.restituisci();
			this.bici = null;
		}
	}
		
	/**
	 * Override del metodo toString()
	 * @return    Stringa contenente informazioni sull'Utente
	 */
	@Override
	public String toString() {
		String s;
		if(this.bici == null) {
			s = "l'utente non sta utilizzando biciclette";
		}
			 
		else {
			s = "l'utente sta utilizzando la bicicletta " + this.bici.toString();
		}
			 
		return this.nome + ", " + this.cognome + ", " + s;
	}
}
