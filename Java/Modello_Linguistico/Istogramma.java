import java.util.*;

/**
 * La classe seguente permette di visualizzare piu'
 * facilmente i risultati ottenuti dalla classe ModelloLinguistico
 */
 
public class Istogramma {
	
	/** attributi */
	private int larg;
	
	/** costruttore */
	public Istogramma(int larg) {
		this.larg = larg;
	}
	
	/**
	 * restituisce una stringa di larghezza massima this.larg,
	 * composta da un carattere, un TAB e la frequenza relativa
	 * rappresentata in asterischi
	 * @param    m    un modello linguistico
	 * @return    una stringa
	 */
	
	public String toString(ModelloLinguistico m) {
		StringBuilder sb = new StringBuilder();
		for(int i = 97; i < 115; i ++) {
			char c = (char) i;
			sb.append(c);
			sb.append("\t");
			for(int j = 0; j < this.larg - 1; j++) {
				if(m.frequenzaRelativa(c) < this.larg - 1 && m.frequenzaRelativa(c) > 0) {
					if(j == 0) {
						sb.append("\t");
					}
					
					sb.append("*");
				}
				
				else {
					sb.append(" ");
				}
			}
			
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	/**
	 * Override del metodo toString()
	 * @return    stringa contenente informazioni sulla larghezza
	 */
	 
	@Override
	public String toString() {
		return "Larghezza massima istogramma: " + this.larg;
	}
	
	/**
	 * Override del metodo equals(Object o)
	 * @param    o    oggetto
	 * @return    true se hanno la stessa larg
	 */
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		if(o instanceof Istogramma) {
			Istogramma ist = (Istogramma) o;
			if(this.larg == ist.larg) {
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
	 * @return    restituisce l'intero
	 */
	@Override
	public int hashCode() {
		return this.larg * 31;
    }
}
