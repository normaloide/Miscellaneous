import java.util.*;

/** La Dispensa è caratterizzata da un elenco senza ripetizioni
  * dei prodotti, per ogni prodotto una quantità presente attualmente
  * nell'oggetto Dispensa e per ogni prodotto, una quantità minima
  * che è possibile avere in Dispensa
  */

public class Dispensa {
	
	//attributi
	private Prodotto p;
	private int q;
	private ArrayList<Prodotto> prodotti;
	private ArrayList<Integer> qesistente;
	private ArrayList<Integer> qminima;
	private ListaDellaSpesa lds;
	
	//costruttore
	public Dispensa() {
		this.prodotti = new ArrayList<Prodotto>();
		this.qesistente = new ArrayList<Integer>();
		this.qminima = new ArrayList<Integer>();
	}
	
	// imposta q come valore all'indice del Prodotto p
	public void scortaMinima(Prodotto p, int q) {
		this.qminima.set(this.prodotti.indexOf(p), q);
	}
	
	// ritorna la quantità q all'indice del Prodotto p
	public int qta(Prodotto p) {
		return this.qesistente.get(this.prodotti.indexOf(p));
	}
	
	// metodo che permettere di rimuovere quantità q del Prodotto p
	public void consuma(Prodotto p, int q) throws NoSuchElementException {
		try {
			this.qesistente.set(this.prodotti.indexOf(p), this.qesistente.get(this.prodotti.indexOf(p) - q));
		} catch (NoSuchElementException e) {
		}
	}
	
	/** restituisce la lista della spesa contenente tutti i prodotti
	  * la cui quantità è inferiore della quantità minima prevista
	  */ 
	 public ListaDellaSpesa preparaLista() {
		 this.lds = new ListaDellaSpesa();
		 for(int i = 0; i < this.prodotti.size(); i++) {
			 if(this.qesistente.get(i) < this.qminima.get(i)) {
				 int newq = this.qminima.get(i) - this.qesistente.get(i);
				 this.lds.aggiungi(this.prodotti.get(i), newq);
			 }
		 }
		 return lds;
	 }
	 
	 //ripone oggetti della lista nella dispensa
	 public void riponi(ListaDellaSpesa s) {
		 Prodotto[] a = s.prodotti();
		 for(int i = 0; i < a.length; i++) {
			this.qesistente.set(this.prodotti.indexOf(a[i]),s.qta(a[i]));
		 }
		 
		 s = new ListaDellaSpesa();
	 }
	 
	 public void aggiungi(Prodotto p, int q) {
		 if(this.prodotti.indexOf(p) == -1) {
			 this.prodotti.add(p);
			 this.qesistente.add(q);
		 }
		 
		 else {
			 this.qesistente.set(this.prodotti.indexOf(p), this.qesistente.get(this.prodotti.indexOf(p)) + q);
		 }
	 }
}
