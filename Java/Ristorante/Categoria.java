import java.util.*;

public class Categoria {

	private String nome;
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	@Override
	public int hashCode() {
		return 31*this.nome.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		if(o instanceof Categoria) {
			Categoria cat = (Categoria) o;
			if(this.nome.equals(cat.nome)) {
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
