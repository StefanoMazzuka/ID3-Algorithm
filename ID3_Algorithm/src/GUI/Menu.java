package GUI;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import FilesManagement.Read;

public class Menu extends JFrame {
	
	private JComboBox weather;
	private String[] gameAttributes;

	public Menu() {
		setTitle("Decision Tree ID3 Algorithm");
		setSize(new Dimension(400, 200));
		setLocationRelativeTo(null);
		setResizable(false); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Read read = new Read();
		this.gameAttributes = read.ReadGameAttributes();

		//for 
	}
}
