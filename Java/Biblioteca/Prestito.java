import java.util.*;

public class Prestito {
	
	private Libro x;
	private Utente u;
	private Data da;
	private Data a;
	
	public Prestito(Libro x, Utente u, Data da, Data a) {
		this.x = x;
		this.u = u;
		this.da = da;
		this.a = a;
	}
	
	public Prestito(Libro x, Utente u, Data da) {
		this.x = x;
		this.u = u;
		this.da = da;
		this.a = a.successiva();
	}
	
	public boolean riguardaLibro(Libro t) {
		if(this.x == t) {
			return true;
		}
		
		else {
			return false;
		}
	}		
	
	public boolean riguardaData(Data d) {
		if(d.vienePrimaDi(this.a)) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return this.x.toString() + ", " + this.u.toString() + ". Prestito valido dal " + this.da.toString() + " al " + this.a.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		if(o instanceof Prestito) {
			Prestito p = (Prestito) o;
			if(this.x == p.x && this.u == p.u) {
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
	
	@Override
	public int hashCode() {
		return (this.x.toString().hashCode() + this.u.toString().hashCode() + this.da.toString().hashCode() + this.a.toString().hashCode()) + 31;
	}
}
