package app;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 

public class Contenido extends JPanel implements ActionListener{
	JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8;
	JButton botones [] = {boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8};
	JLabel decimalLabel = new JLabel("Decimal = 0");
	
	ImageIcon focoApagado = new ImageIcon("src/recursos/apagado.png");
	Icon iconoApagado = new ImageIcon(focoApagado.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	
	ImageIcon focoEncendido = new ImageIcon("src/recursos/encendido.png");
	Icon iconoEncendido = new ImageIcon(focoEncendido.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	
	boolean estados [] = {false, false , false, false, false, false, false, false};
	int valores [] = {128,64, 32, 16, 8, 4,2,1}; 
	int suma= 0;
	
	public Contenido()
	{
		setBackground(new Color(220,220,220));
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		inicializarBotones(botones);
		decimalLabel.setForeground(Color.BLACK);
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
			arrayBotones[i].addActionListener(this);
		}
		
		add(decimalLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int botonId =Integer.parseInt(((JButton) e.getSource()).getName()); 
		JButton botonPulsado = (JButton) e.getSource();
//		System.out.println(botonId);
		
		if(estados[botonId] ==false)
		{
			botonPulsado.setIcon(iconoEncendido);
			estados[botonId] = true;
				
			
		}else {
			botonPulsado.setIcon(iconoApagado);
			estados[botonId] = false;
			
		}
		
		
		suma = calcularBinario(estados);
		
		decimalLabel.setText("Decimal: " + suma);
	}
	
	public int calcularBinario(boolean[] binario) {
		int resultado = 0;

		for(int i= 0; i<binario.length; i++) {
			if(binario[i] == true) {
				resultado += valores[i];
			}
		}
		
		return resultado;
	}

	}