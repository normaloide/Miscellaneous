import java.util.*;

public class Carta {
	
	private ArrayList<Piatto> piatti;
	
	public Carta() {
		this.piatti = new ArrayList<Piatto>();
	}
	
	public void add(Piatto p) {
		if(!(this.piatti.contains(p))) {
			this.piatti.add(p);
		}
	}
	
	public Piatto[] lista(Categoria c) {
		ArrayList<Piatto> p = new ArrayList<Piatto>();
		for(int i = 0; i < this.piatti.size(); i++) {
			if(this.piatti.get(i).categoria() == c) {
				p.add(this.piatti.get(i));
			}
		}
		
		return p.toArray(new Piatto[p.size()]);
	}
	
	public Piatto[] lista(Categoria c, Intolleranza[] x) {
		ArrayList<Piatto> p = new ArrayList<Piatto>();
		int cont = 0;
		for(int i = 0; i < this.piatti.size(); i++) {
			if(this.piatti.get(i).categoria() == c) {
				for(int j = 0; j < x.length; j++) {
					if(this.piatti.get(i).causaIntolleranza(x[j])) {
						cont++;
					}
				}
				
				if(cont == 0) {
					p.add(this.piatti.get(i));
				}	
			}
		}
		
		return p.toArray(new Piatto[p.size()]);
	}
	
	public Piatto[] menuDegustazione(Categoria[] c) {
		Piatto[] p = new Piatto[c.length];
		ArrayList<Piatto> piattiMischiati = new ArrayList<Piatto>(piatti);
		Collections.shuffle(piattiMischiati);
		for(int i = 0; i < p.length; i++) {
			if(piattiMischiati.get(i).categoria() == c[i]) {
				p[i] = piattiMischiati.get(i);
			}
		}
		
		for(int i = 0; i < p.length; i++) {
			if(p[i] == null) {
				Categoria cate = new Categoria("nessuna");
				Piatto plate = new Piatto("Non sono presenti piatti per la categoria", cate);
				p[i] = plate;
			}
		}
		
		return p;
	}
	
	public Piatto[] menuDegustazione(Categoria[] c, Intolleranza[] x) {
		Piatto[] p = new Piatto[c.length];
		ArrayList<Piatto> piattiMischiati = new ArrayList<Piatto>(piatti);
		Collections.shuffle(piattiMischiati);
		int cont = 0;
		for(int i = 0; i < p.length; i++) {
			if(piattiMischiati.get(i).categoria() == c[i]) {
				for(int j = 0; j < x.length; j++) {
					if(piattiMischiati.get(i).causaIntolleranza(x[j])) {
						cont++;
					}
				}
				
				if(cont == 0) {
					p[i] = piattiMischiati.get(i);
				}
			}
		}
		
		for(int i = 0; i < p.length; i++) {
			if(p[i] == null) {
				Categoria cate = new Categoria("nessuna");
				Piatto plate = new Piatto("Non sono presenti piatti per la categoria", cate);
				p[i] = plate;
			}
		}
		
		return p;
	}
}
