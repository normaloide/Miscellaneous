import java.util.*;
import java.lang.*;

public class Calculator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double d = 0;
		while(in.hasNext()) {
			String s = in.next();
			 
			switch(s) {
				case "S":
					d = Double.parseDouble(in.next());
					System.out.println("= " + d);
					break;
					
				case "+":
					d += Double.parseDouble(in.next());
					System.out.println("= " + d);
					break;
					
				case "-":
					d -= Double.parseDouble(in.next());
					System.out.println("= " + d);
					break;
				
				case "*":
					d *= Double.parseDouble(in.next());
					System.out.println("= " + d);
					break;
					
				case "/":
					double d2 = Double.parseDouble(in.next());
					if(d2 == 0) {
						System.out.println("You are trying to divide by zero");
						break;
					}
					
					else {
						d = d / d2;
						System.out.println("= " + d);
						break;
					}
				
				case "E":
					System.exit(0);
					break;
				
				default:
					System.out.println("Unknown operator");
					break;
			}
		}
	}
}
