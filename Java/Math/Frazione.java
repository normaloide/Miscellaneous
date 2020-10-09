import java.util.*;

public class Frazione {

	private int num = 0;
	private int den = 0;

	public Frazione(int num, int den) {
		this.num = num;
		this.den = den;
	}

	public Frazione(int num) {
		this.num = num;
		this.den = 1;
	}

	public Frazione piu(Frazione f) {
		int num = this.num * f.getDen() + this.den * f.getNum();
		int den = this.den * f.getDen();
		return new Frazione(num, den).sempl();
	}

	public Frazione meno(Frazione f) {
		int num = this.num * f.getDen() - this.den * f.getNum();
		int den = this.den * f.getDen();
		return new Frazione(num, den).sempl();
	}

	public Frazione per(Frazione f) {
		int num = this.num * f.getNum();
		int den = this.den * f.getDen();
		return new Frazione(num, den).sempl();
	}

	public Frazione diviso(Frazione f) {
		int num = this.num * f.getDen();
		int den = this.den * f.getNum();
		return new Frazione(num, den).sempl();
	}

	public boolean isMinore(Frazione f) {
		Frazione g = this.sempl().meno(f.sempl());
		if((g.num < 0 && g.den > 0) || (g.num > 0 && g.den < 0)) {
			return true;
		}

		else {
			return false;
		}
	}

	public boolean isMaggiore(Frazione f) {
		Frazione g = this.sempl().meno(f.sempl());
		if((g.num < 0 && g.den < 0) || (g.num > 0 && g.den > 0)) {
			return true;
		}

		else {
			return false;
		}
	}

	public Frazione sempl() {
		if(this.num == this.den) {
			return new Frazione(1, 1);
		}

		if(this.num > this.den) {
			int n = checkMult(this.den, this.num);
			if(n != -1) {
				return new Frazione(this.num/n, this.den/n);
			}

			else {
				return this;
			}
		}

		else {
			int m = checkMult(this.num, this.den);
			if(m != -1) {
				return new Frazione(this.num/m, this.den/m);
			}

			else {
				return this;
			}
		}
	}

	//da n a 2, se i divide sia n che m, i è un sottomultiplo
	public int checkMult(int n, int m) {
		for(int i = n; i >= 2; i--) {
			if(n % i == 0 && m % i == 0) {
				return i;
			}
		}

		return -1;
	}

	public int getNum() {
		return this.num;
	}

	public int getDen() {
		return this.den;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setDen(int den) {
		this.den = den;
	}

	@Override
	public String toString() {
		Frazione f = this.sempl();
		if(f.getNum() == 0) {
			if(f.getDen() == 0) {
				return "indeterminata";
			}

			else {
				return "0";
			}
		}

		if(f.getDen() == 0 && f.getNum() != 0) {
			return "impossibile";
		}

		else {
			return f.getNum() + "/" + f.getDen();
		}
	}

	@Override
	public int hashCode() {
		return (this.num + this.den) * 31;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}

		if(o instanceof Frazione) {
			Frazione f = (Frazione) o;
			if(this.num == f.getNum() && this.den == f.getDen()) {
				return true;
			}

			if(this.hashCode() == f.hashCode()) {
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
