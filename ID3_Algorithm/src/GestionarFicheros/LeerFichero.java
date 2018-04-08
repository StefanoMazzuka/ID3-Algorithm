package GestionarFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LeerFichero {

	private File archivo;
	private FileReader fr;
	private BufferedReader br;
	private String nom;

	public LeerFichero() {		
		  String userPath = System.getProperty("user.dir");
		  String separator = File.separator;
		  String folderPath = userPath + separator + "Files";
		  File folder = new File(folderPath);
		  String[] files = folder.list();
		  
		this.nom = files[0];

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File (this.nom);
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while((linea=br.readLine())!=null)
				System.out.println(linea);    
		}
		catch(Exception e){
			e.printStackTrace();
		} finally {	    	  
			try {                    
				if( null != fr )  
					fr.close();     

			} catch (Exception e2){ 
				e2.printStackTrace();
			}
		}//finally

	}//Leer

//		  String userPath = System.getProperty("user.dir");
//		  String separator = File.separator;
//		  String folderPath = userPath + separator + "Files";
//
//		  File folder = new File(folderPath);
//		  if (!folder.exists()) folder.mkdir();
//		  
//		  String[] files = folder.list();
//		  for (int i = 0; i< files.length; i++) {
//		  System.out.println((i + 1) + " - " + carpeta + separador + ficheros[i]);
//		   }
}
