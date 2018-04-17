package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.*;

import Logica.Arbol;
import Logica.Id3;

public class Ventana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> tiempo, temperatura, humedad, viento;
	private JPanel contenedor, pDatos, boton;
	private JLabel ext, tmp, hum, vnt;

	public Ventana() {

		//metodos de la ventana
		setTitle("ID3 Algortihm");
		setSize(new Dimension(400, 250));
		setLocationRelativeTo(null);
		setResizable(false); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		contenedor= new JPanel();
		contenedor.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		contenedor.setLayout(new BorderLayout());
		contenedor.setBackground(Color.decode("#81F7F3"));

		//paneles
		pDatos=new JPanel();
		pDatos.setLayout(new GridLayout(4, 2));

		ext=new JLabel("Tiempo exterior:");
		tiempo = new JComboBox<String>();
		tiempo.addItem("Soleado");
		tiempo.addItem("Lluvioso");
		tiempo.addItem("Nublado");
		pDatos.add(ext);
		pDatos.add(tiempo);

		tmp=new JLabel("Temperatura:");
		temperatura= new JComboBox<String>();
		temperatura.addItem("Caluroso");
		temperatura.addItem("Templado");
		temperatura.addItem("Frio");
		pDatos.add(tmp);
		pDatos.add(temperatura);

		hum=new JLabel("Humedad:");
		humedad= new JComboBox<String>();
		humedad.addItem("Alta");
		humedad.addItem("Normal");
		pDatos.add(hum);
		pDatos.add(humedad);
		pDatos.setBackground(Color.decode("#81F7F3"));

		vnt=new JLabel("Viento:");
		viento= new JComboBox<String>();
		viento.addItem("Falso");
		viento.addItem("Verdad");
		pDatos.add(vnt);
		pDatos.add(viento);

		boton=new JPanel();
		JButton btnOk=new JButton("�Puedo jugar?");
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				//creamos el array con los datos recogidos
				String[] atributos = {
						((String) tiempo.getSelectedItem()).toLowerCase(),
						((String) temperatura.getSelectedItem()).toLowerCase(),		
						((String) humedad.getSelectedItem()).toLowerCase(),
						((String) viento.getSelectedItem()).toLowerCase()
				};
				
				Id3 algo = new Id3();
				Arbol arbol = null;

				try {
					arbol = algo.algoritmo(",");
				} catch (IOException e1) {
					e1.printStackTrace();
				} 

				String prediccion=arbol.predecirValor(atributos);

				if(prediccion.equalsIgnoreCase("si"))
					JOptionPane.showMessageDialog(null, "Si puedes jugar :)");
				else
					JOptionPane.showMessageDialog(null, "No puedes jugar :(");		
			}
		});

		boton.add(btnOk);

		contenedor.add(pDatos,BorderLayout.CENTER);
		contenedor.add(btnOk,BorderLayout.SOUTH);

		add(contenedor);
	}
}
