import java.util.*;

public class Biblioteca {
	
	private String nome;
	private ArrayList<Libro> libri;
	private ArrayList<Utente> utenti;
	private ArrayList<Prestito> prestiti;
	
	public Biblioteca(String nome) {
		this.nome = nome;
		this.libri = new ArrayList<Libro>();
		this.utenti = new ArrayList<Utente>();
		this.prestiti = new ArrayList<Prestito>();
	}
	
	public void nuovoUtente(Utente x){
		this.utenti.add(x);
	}
	
	public void nuovoLibro(Libro x){
		if(!(this.libri.contains(x))) {
			this.libri.add(x);
		}
	}
	
	public int numeroUtenti() {
		HashSet<Utente> hs = new HashSet<Utente>();
		ArrayList<Utente> lista = new ArrayList<Utente>();
		hs.addAll(this.utenti);
		lista.addAll(hs);
		return lista.size();
	}
	
	public int numeroLibri() {
		return this.libri.size();
	}
	
	public Libro[] cercaLibro(String x) {
		ArrayList<Libro> lista = new ArrayList<Libro>();
		for(int i = 0; i < this.libri.size(); i++) {
			if(this.libri.get(i).toString().contains(x)) {
				lista.add(this.libri.get(i));
			}
		}
		
		return lista.toArray(new Libro[lista.size()]);
	}
	
	public boolean disponibile(Libro x) {
		if((!(x.toString().contains("non prestabile")))) {
			if(!(this.prestiti.get(this.libri.indexOf(x)).riguardaData(new Data(Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.YEAR))))) {
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
	
	public int quantiPrestiti(Utente x) {
		int cont = 0;
		for(int i = 0; i < this.utenti.size(); i++) {
			if(this.utenti.get(i) == x) {
				cont++;
			}
		}
		
		return cont;
	}
	
	public boolean daiInPrestito(Libro x, Utente u, Data finoA) {
		int occ = 0;
		for(int i = 0; i < this.utenti.size(); i++) {
			if(this.utenti.get(i) == u) {
				occ++;
			}
		}
		
		if((!(x.toString().contains("non prestabile"))) == true && occ < 4) {
			this.prestiti.add(new Prestito(x, u, new Data(Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.YEAR)), finoA));
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public boolean daiInPrestito(Libro x, Utente u) {
		int occ = 0;
		for(int i = 0; i < this.utenti.size(); i++) {
			if(this.utenti.get(i) == u) {
				occ++;
			}
		}
		
		if((!(x.toString().contains("non prestabile"))) == true && occ < 4) {
			Data d = new Data(Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.YEAR));
			this.prestiti.add(new Prestito(x, u, d, d.successiva()));
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public Utente chiHaInPrestito(Libro x) {
		for(int i = 0; i < this.prestiti.size(); i++) {
			if(this.prestiti.get(i).toString().contains(x.getTitolo())) {
				return this.utenti.get(i);
			}
		}
		
		return null;
	}
}
