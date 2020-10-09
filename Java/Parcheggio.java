import java.util.*;

public class Parcheggio {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] p = in.nextLine().split(" ");
		String[] c = in.nextLine().split(" ");
		in.close();

		ArrayList<String> park = new ArrayList<String>(Arrays.asList(p));
		ArrayList<String> cars = new ArrayList<String>(Arrays.asList(c));

		boolean[] occ = new boolean[park.size()];

		for(int i = 0; i < park.size(); i++) {
			String posto = park.get(i);
			for(int j = 0; j < cars.size(); j++) {
				if(cars.get(j).equals(posto)) {
					cars.remove(j);
					occ[i] = true;
					break;
				}
			}
		}

		for(int i = 0; i < occ.length; i++) {
			if(occ[i] == false) {
				System.out.print(park.get(i) + " ");
			}
		}
	}
}