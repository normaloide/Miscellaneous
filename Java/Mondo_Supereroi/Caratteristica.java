import java.util.*;

public class Caratteristica {
	
	private String nome;
	private String unitaMisura;
	private double valoreNormale;
	
	public Caratteristica(String nome, String unitaMisura, double valoreNormale) {
		this.nome = nome;
		this.unitaMisura = unitaMisura;
		this.valoreNormale = valoreNormale;
	}
	
	public double valoreNormale() {
		return this.valoreNormale;
	}
	
	public double confrontoCon(double v) {
		return v/this.valoreNormale;
	}
	
	@Override
	public String toString() {
		return this.nome + ", " + this.unitaMisura + ", " + this.valoreNormale;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		if(o instanceof Caratteristica) {
			Caratteristica car = (Caratteristica) o;
			if(this.nome.equals(car.nome)) {
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
		return (this.nome.hashCode() + this.unitaMisura.hashCode() + (int)valoreNormale) * 31;
	} 
}
