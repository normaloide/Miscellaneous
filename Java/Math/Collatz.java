/**
* @author Edoardo Ferrari
* @version 1.0
*/

import java.util.*;

/* This program will execute the Collatz sequence */

public class Collatz {

	/**
	* This method will decide the Collatz sequence:
	*
	* @return x/2          if the numbder is even
	* @return (3 * x) + 1  if the number is not even
	*/
	
	public static int isEven(int x) {
		if(x % 2 == 0) {
			return x / 2;
		}

		return (3 * x) + 1;
	}

	/* Main method reads from args and prints the Collatz sequence */

	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		System.out.println(x);
		while(x > 1) {
			x = isEven(x);
			System.out.println(x);
		}
	}
}
