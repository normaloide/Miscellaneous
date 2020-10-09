import java.util.*;

/** La classe Prodotto genera un prodotto definito
  * tramite il costruttore dal nome prelevato in lettere minuscole.
  * La classe genera un hashCode del rodotto ed è dotata dei metodi 
  * toString() e equals()
  */
 
public class Prodotto {
	
	//attributo
	private String nome;
	
	//costruttore
	public Prodotto(String nome) {
		this.nome = nome.toLowerCase();
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	@Override
	public int hashCode() {
		return this.toString().hashCode() * 31;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		/** crea un'istanza dell'oggetto Prodotto e vede se
		  * sono uguali per nome o per hashCode
		  */
		 
		if(o instanceof Prodotto) {
			Prodotto p = (Prodotto) o;
			if(this.nome == p.toString()) {
				return true;
			}
			
			if(this.hashCode() == p.hashCode()) {
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
}
