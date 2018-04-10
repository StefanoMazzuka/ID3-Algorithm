package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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

	public Ventana(String titulo) {

		//metodos de la ventana
		setTitle(titulo);
		setSize(new Dimension(400, 200));
		setLocationRelativeTo(null);
		setResizable(false); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		contenedor= new JPanel();
		contenedor.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 40));
		contenedor.setLayout(new BorderLayout());

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

		vnt=new JLabel("Viento:");
		viento= new JComboBox<String>();
		viento.addItem("Falso");
		viento.addItem("Verdad");
		pDatos.add(vnt);
		pDatos.add(viento);

		boton=new JPanel();
		JButton btnOk=new JButton("¿Jugamos?");
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
					String userPath = System.getProperty("user.dir");
					String separator = File.separator;
					String folderPath = userPath + separator + "src" + separator + "Ficheros" + separator + "Juego.txt";
					System.out.println(folderPath);
					arbol = algo.algoritmo(folderPath, ",");
				} catch (IOException e1) {
					e1.printStackTrace();
				} 

				String prediccion=arbol.predecirValor(atributos);

				if(prediccion.equalsIgnoreCase("si"))
					JOptionPane.showMessageDialog(null, "Si puedes jugar.");
				else
					JOptionPane.showMessageDialog(null, "No puedes jugar.");		
			}
		});

		boton.add(btnOk);

		contenedor.add(pDatos,BorderLayout.CENTER);
		contenedor.add(btnOk,BorderLayout.SOUTH);

		add(contenedor);

	}
}
