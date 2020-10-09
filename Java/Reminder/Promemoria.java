import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Promemoria {

	private boolean bool = false;

	public Promemoria() {
		Calendar cal = Calendar.getInstance();
		int giorno = cal.get(Calendar.DAY_OF_MONTH);
		if(giorno == gg) {	//CHANGE gg WITH A DAY_OF_MONTH
			this.bool = true;
		}
	}

	public boolean getBool() {
		return this.bool;
	}
	
	public static void main(String[] args) {
		Promemoria promemoria = new Promemoria();
		if(promemoria.getBool() == true) {
			JFrame frame = new JFrame("DAY TO SHOW");	//DAY TO SHOW HERE
			JLabel testo = new JLabel("TEXT TO SHOW", SwingConstants.CENTER);	//TEXT TO SHOW HERE
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setPreferredSize(new Dimension(300, 300));
			frame.getContentPane().add(testo, BorderLayout.CENTER);
			frame.pack();
			frame.setVisible(true);
		}

		else {
			System.exit(0);
		}
	}
}