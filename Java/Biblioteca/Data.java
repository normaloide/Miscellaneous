import java.util.*;

public class Data {
	
	private int g;
	private int m;
	private int a;
	
	public Data(int g, int m, int a) {
		this.g = g;
		this.m = m;
		this.a = a;
	}
	
	public Data() {
		this.g = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		this.m = Calendar.getInstance().get(Calendar.MONTH) + 1;
		this.a = Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public boolean isBisestile(int a) {
		if(this.a > 1584 && ((this.a % 400 == 0) || (this.a % 4 == 0 && this.a % 100 != 0))) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public int giorniMese(int m, int a) {
		switch(m) {
			case 2:
				return isBisestile(a) ? 29 : 28;
			
			case 4: 
				return 30;
			
			case 6: 
				return 30;
			
			case 9: 
				return 30;
			
			case 11: 
				return 30;
			
			default: 
				return 31;
		}
	}
	
	public int giorniDaEpoca() {
		int cont = 0;
		for(int i = 1970; i < this.a; i++) {
			if(isBisestile(this.a)) {
				cont += 366;
			}
			
			else {
				cont += 365;
			}
		}
		
		for(int i = 1; i < this.m; i++) {
			cont += giorniMese(i, this.a);
		}
		
		return cont + this.g - 2;
	}
	
	public int giorniDa(Data d) {
		return this.giorniDaEpoca() - d.giorniDaEpoca();
	}
	
	public boolean vienePrimaDi(Data d) {
		if(this.a < d.a) {
			return true;
		}
		
		else {
			if(this.a == d.a && this.m < d.m) {
				return true;
			}
			
			if(this.a == d.a && this.m == d.m && this.g < d.g) {
				return true;
			}
			
			else {
				return false;
			}
		}
	}
	
	public Data successiva() {
		if(m <= 10) {
			return new Data(1, this.m + 2, this.a);
		}
		
		else {
			return new Data(1, (this.m + 2) % 12, this.a + 1);
		}
	}
	
	@Override
	public String toString() {
		return this.g + "/" + this.m + "/" + this.a;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		if(o instanceof Data) {
			Data d = (Data) o;
			if(this.g == d.g && this.m == d.m && this.a == d.a) {
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
		return this.toString().hashCode() * 31;
	}
}
