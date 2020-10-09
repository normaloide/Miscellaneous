import java.util.*;

/** classe atta alla realizzazione della lista della spesa
  * la lista viene creata aggiungendo prodotti
  */
 
public class ListaDellaSpesa {
	
	//attributi
	private Prodotto p;
	private int q;
	private ArrayList<Prodotto> prodotti;
	private ArrayList<Integer> quantita;
	private ListaDellaSpesa lds;
	
	//costruttore
	public ListaDellaSpesa() {
		this.prodotti = new ArrayList<Prodotto>();
		this.quantita = new ArrayList<Integer>();
	}
	
	//aggiunge quantità del Prodotto
	public void aggiungi(Prodotto p, int q) {
		if(!(prodotti.contains(p))) {
			this.prodotti.add(p);
			this.quantita.set(this.prodotti.indexOf(p), q);
		}
	}
	
	//restituisce quantità del prodotto
	public int qta(Prodotto p) {
		return this.quantita.get(this.prodotti.indexOf(p));
	}
	
	public Prodotto[] prodotti() {
		return this.prodotti.toArray(new Prodotto[this.prodotti.size()]);
	}
}
