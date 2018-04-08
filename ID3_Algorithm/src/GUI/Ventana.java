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
	private JComboBox<String> comboEx,comboTmp,comboHum,comboVnt;
	private JPanel contenedor, pDatos, boton;
	private JLabel ext,tmp,hum,vnt;
	
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
		comboEx = new JComboBox<String>();
		comboEx.addItem("Soleado");
		comboEx.addItem("Lluvioso");
		comboEx.addItem("Nublado");
		pDatos.add(ext);
		pDatos.add(comboEx);
		
		tmp=new JLabel("Temperatura:");
		comboTmp= new JComboBox<String>();
		comboTmp.addItem("Caluroso");
		comboTmp.addItem("Templado");
		comboTmp.addItem("Frio");
		pDatos.add(tmp);
		pDatos.add(comboTmp);
		
		hum=new JLabel("Humedad:");
		comboHum= new JComboBox<String>();
		comboHum.addItem("Alta");
		comboHum.addItem("Normal");
		pDatos.add(hum);
		pDatos.add(comboHum);
		
		vnt=new JLabel("Viento:");
		comboVnt= new JComboBox<String>();
		comboVnt.addItem("Falso");
		comboVnt.addItem("Verdad");
		pDatos.add(vnt);
		pDatos.add(comboVnt);
		
		
		boton=new JPanel();
		JButton btnOk=new JButton("¿Jugamos?");
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//creamos el array con los datos recogidos
				String[] atributos = { ((String) comboEx.getSelectedItem()).toLowerCase(),
										((String) comboTmp.getSelectedItem()).toLowerCase(),		
										((String) comboHum.getSelectedItem()).toLowerCase(),
										((String) comboVnt.getSelectedItem()).toLowerCase()};
				Id3 algo=new Id3();
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
				
				if(prediccion.equalsIgnoreCase("si")){
					Icon icono = new ImageIcon(getClass().getResource("/img/posible.png"));
					JOptionPane.showMessageDialog(null, "¡PODEMOS JUGAR!", "¿Jugamos?", JOptionPane.PLAIN_MESSAGE, icono);
				}else {
					Icon icono = new ImageIcon(getClass().getResource("/img/noPosible.png"));
					JOptionPane.showMessageDialog(null, "¡NO PODEMOS JUGAR!", "¿Jugamos?", JOptionPane.PLAIN_MESSAGE, icono);
				}		
			}
		});
		boton.add(btnOk);
		
		contenedor.add(pDatos,BorderLayout.CENTER);
		contenedor.add(btnOk,BorderLayout.SOUTH);
		
		add(contenedor);
		
	}
}
