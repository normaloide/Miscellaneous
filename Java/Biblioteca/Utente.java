import java.util.*;

public class Utente {
	
	private String nome;
	private String cognome;
	private Data dataDiNascita;
	private int identificativo;
	
	public Utente(String nome, String cognome, Data dataDiNascita, int identificativo) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.identificativo = this.hashCode();
	}
	
	@Override
	public String toString() {
		return this.nome + ", " + this.cognome + ", " + this.dataDiNascita + ", " + this.identificativo;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		if(o instanceof Utente) {
			Utente u = (Utente) o;
			if(this.nome.equals(u.nome) && this.cognome.equals(u.cognome) && this.dataDiNascita == u.dataDiNascita) {
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
		return (this.nome.toString().hashCode() + this.cognome.toString().hashCode() + this.dataDiNascita.toString().hashCode()) * 31;
	}
}
