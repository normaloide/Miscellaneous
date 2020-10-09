import java.util.*;

public class Intolleranza {
	
	private String nome;
	private String descr;
	
	public Intolleranza(String nome, String desc) {
		this.nome = nome;
		this.descr = desc;
	}
	
	@Override
	public String toString() {
		return this.nome + ": " + this.descr;
	}
	
	@Override
	public int hashCode() {
		return 31 * (this.nome.hashCode() + this.descr.hashCode());
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		if(o instanceof Categoria) {
			Intolleranza into = (Intolleranza) o;
			if(this.nome.equals(into.nome) && this.descr.equals(into.descr)) {
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
