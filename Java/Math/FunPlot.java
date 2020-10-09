import java.util.*;
import java.lang.*;

public class FunPlot {
	public static void main(String[] args) {
		if(args.length != 4) {
        		System.out.println("Dati non validi");
            		System.exit(1);
       	}

		try {
			double fvalue = 0;
			double xmin = Double.parseDouble(args[0]);
			double xmax = Double.parseDouble(args[1]);
			double passo = Double.parseDouble(args[2]);
			String s = args[3];

			int ymin = -40;
			int ymax = 40;

			for(double x = xmin; x < xmax; x += passo) {
				switch(s) {
					case "identica":
						fvalue = x;
						break;

					case "square":
						fvalue = Math.pow(x, 2);
						break;

					case "terza":
						fvalue = Math.pow(x, 3);
						break;

					case "3x2":
						fvalue = 3*x + 2;
						break;

					case "resto10":
						fvalue = x % 10;
						break;

					case "pow4":
						fvalue = Math.pow(x, 4);
						break;

					case "sin":
						fvalue = Math.sin(x);
						break;

					case "cos":
						fvalue = Math.cos(x);
						break;

					case "tan":
						fvalue = Math.tan(x);
						break;

					case "exp":
						fvalue = Math.exp(x);
						break;

					case "log":
						fvalue = Math.log(x);
						break;

					default:
						System.out.println("Funzione non implementata");
						System.exit(1);
				}

				System.out.printf("%.2f: ", x);
				if(fvalue >= ymin && fvalue <= ymax) {
				    for(int i = ymin; i < fvalue; i++) {
					System.out.print(" ");
				    }

				System.out.println("* ");
				}
			}

		} catch (Exception e) {
			System.out.println("Dati non validi");
		}
	}
}
