import java.util.*;

/** 
 * La classe Bicicletta rappresenta le biciclette attraverso
 * un identificatore. La classe inoltre specifica se le biciclette
 * sono elettriche e se sono libere o in utilizzo
 */
 
public class Bicicletta {
	
	/** attributi della classe */
	private String id;
	private boolean elettrica;
	private boolean libera;
	private Utente utente;
	
	/** costruttore della classe
	 * @param	id	Stringa identificatrice
	 * @param	elettrica	ritorna true se e' elettrica
	 */
	public Bicicletta(String id, boolean elettrica) {
	    this.id = id;
            this.elettrica = elettrica;
	    this.libera = true;
            this.utente = null;
	}
	 
	/**
	 * metodo per sapere se la Bicicletta è elettrica
	 * @return true se elettrica, altrimenti false
	 */
	public boolean elettrica() {
		return this.elettrica;
        }
	  
    /**
     * permette all'Utente di ottenere in uso la Bicicletta
     * @param   x	Utente
     */
	public void daiInUso(Utente x) {
		if(this.libera == true) {
			this.libera = false;
		    this.utente = x;
			   
	    }
		   
        else {
			throw new IllegalStateException("La bicicletta è occupata");
		}
	}
	   
	/**
	 * l'Utente che utilizzava la Bicicletta la restituisce
	 */
	public void restituisci() {
		if(this.libera == true) {
			throw new IllegalStateException("La bicicletta è occupata");
		}
			
		else {
			this.libera = true;
			this.utente = null;
		}
	}
		
	/**
	 * esamina se la Bicicletta è in uso da un Utente
	 * @return    se in uso, restituisce l'Utente che la sta usando
	 */
	public Utente utente() {
	    return this.utente;
	}
		 
	/**
	 * Override del metodo toString()
	 * @return    Stringa che identifica la Bicicletta
	 */
	@Override
	public String toString() {
	    if(this.libera == true) {
	        return this.id + ", libera";
	    }
			  
	else {
	    return this.id + ", occupata";
	    }
	}
		  
	/**
     * Override del metodo equals()
	 * @param    o    oggetto da equagliare
	 * @return   true se gli oggetti sono uguali, false se sono diversi
	 */
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
			   
		if(o instanceof Bicicletta) {
			Bicicletta bici = (Bicicletta) o;
				if(this.id.equals(bici.id) && this.elettrica == bici.elettrica) {
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
	 * metodo per ottenere l'hashCode()
	 * @return    restituisce l'hashcode generato
	 */
	@Override
	public int hashCode() {
		String s;
		if(this.elettrica == true) {
			s = "libera";
		}
				
		else {
			s = "occupata";
		}
				
		return (this.id.hashCode() + s.hashCode())*31;
	}
}
