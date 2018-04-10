package FilesManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Read {
	public String[] ReadGameAttributes() {
		String[] content = new String[5];
		String userPath = System.getProperty("user.dir");
		String separator = File.separator;
		String filePath = userPath + separator + "src" + separator + "Files" + separator + "AtributosJuego.txt";

		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);

			String currentLine = br.readLine();
			content = currentLine.split(",");

		} catch (Exception e) {}
		
		try {
			br.close();
			fr.close();

		} catch (Exception e) {}

		return content;
	}
}