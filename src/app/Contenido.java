package app;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.*; 

public class Contenido extends JPanel{
	JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8;
	JButton botones [] = {boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8};
	JLabel decimalLabel = new JLabel("Decimal = 0");
	
	
	public Contenido()
	{
		setBackground(new Color(125,119,104));
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		inicializarBotones(botones);
		//setLayout(new BorderLayout());
		
	}
	
	public void inicializarBotones(JButton [] arrayBotones)
	{
		int width = 50, height = 50; 
		ImageIcon imagen = new ImageIcon("src/recursos/apagado.png");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		
		String nombres [] = {"128", "64", "32", "16", "8", "4", "2", "1"};
		for(int i = 0; i< arrayBotones.length; i++)
		{
			arrayBotones[i] = new JButton(nombres[i]);
			arrayBotones[i].setName(Integer.toString(i));
			arrayBotones[i].setIcon(icono);
			arrayBotones[i].setBackground(Color.white);
			add(arrayBotones[i]);
			arrayBotones[i].addActionListener(new Decimal());
		}
		
		add(decimalLabel);
	}

}