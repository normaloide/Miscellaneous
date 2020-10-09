import java.util.*;

public class Libro {
	
	private String titolo;
	private String[] autori;
	private int identificativo;
	private boolean prestabile;
	
	public Libro(String titolo, String[] autori, boolean presabile) {
		this.titolo = titolo;
		this.autori = autori;
		this.identificativo = this.hashCode();
		this.prestabile = prestabile;
	}
	
	public Libro(String titolo, String autore, boolean prestabile) {
		this.titolo = titolo;
		this.autori[0] = autore;
		this.identificativo = this.hashCode();
		this.prestabile = prestabile;
	}
	
	public Libro(String titolo, String[] autori) {
		this.titolo = titolo;
		this.autori = autori;
		this.identificativo = this.hashCode();
		this.prestabile = true;;
	}
	
	public Libro(String titolo, String autore) {
		this.titolo = titolo;
		this.autori[0] = autore;
		this.identificativo = this.hashCode();
		this.prestabile = true;;
	}
	
	public String getTitolo() {
		return this.titolo;
	}
	
	@Override
	public String toString() {
		String s;
		if(prestabile == true) {
			s = "prestabile";
		}
		
		else {
			s = "non prestabile";
		}
		
		return this.titolo + ", " + Arrays.toString(this.autori) + ", " + s;
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
		
		if(o instanceof Libro) {
			Libro libro = (Libro) o;
			if(this.titolo.equals(libro.titolo) && this.autori == libro.autori && this.identificativo == libro.identificativo) {
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
