package app;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame mimarco = new JFrame("Binario a decimal");
		mimarco.setBounds(200, 250, 900, 150);
		mimarco.add(new Contenido());
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
