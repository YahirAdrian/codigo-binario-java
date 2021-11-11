package app;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Decimal extends CambiarDecimal implements ActionListener  {
	boolean estados [] = {false, false , false, false, false, false, false, false};
	int valores [] = {128,64, 32, 16, 8, 4,2,1}; 
	//int decimal, contador;
	
	//CambiarDecimal decimal;
	public Decimal()
	{
		//decimal = new CambiarDecimal();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//OBTENER VALORES DE LOS BOTONES
		int botonId =Integer.parseInt(((JButton) e.getSource()).getName()); 
		JButton botonPulsado = (JButton) e.getSource();
		//CREACION DE LAS IMAGENES
		ImageIcon focoApagado = new ImageIcon("src/recursos/apagado.png");
		Icon iconoApagado = new ImageIcon(focoApagado.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
		ImageIcon focoEncendido = new ImageIcon("src/recursos/encendido.png");
		Icon iconoEncendido = new ImageIcon(focoEncendido.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		//VERIFICACION SI ESTA ENCENDIDO O APAGADO
		if(estados[botonId] ==false)
		{
			botonPulsado.setIcon(iconoEncendido);
				
			int button_pressed = valores[botonId];
			
			
			if(super.suma ==0) {
				super.suma+=  button_pressed;
				super.ultimo_boton = valores[botonId];
			}else {
				super.suma += super.ultimo_boton;
			}
			
			System.out.println(super.suma);
			//verificacion(button_pressed);
			
			
			estados[botonId]=true;
			//super.ultimo_boton = valores[botonId];
			//System.out.println(super.ultimo_boton);
			
		}else {
			botonPulsado.setIcon(iconoApagado);
			estados[botonId] = false;
			super.decimal = super.decimal - valores[super.ultimo_boton];
		}
		/*System.out.println("Ultimo boton: " + super.ultimo_boton);
		System.out.println("Decimal: " + super.decimal);*/
	
	}
	
	public void verificacion(int boton_presionado)
	{
		if(super.ultimo_boton != valores[boton_presionado])
		{
			super.suma= boton_presionado + super.ultimo_boton;
		}
	}//contar
}
