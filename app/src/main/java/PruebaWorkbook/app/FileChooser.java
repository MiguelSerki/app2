package PruebaWorkbook.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class FileChooser {
	
	JFileChooser file_chooser = new JFileChooser();
	StringBuilder sb = new StringBuilder ();
	
	public File pickMe () throws FileNotFoundException{
		if(file_chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			File file = file_chooser.getSelectedFile();
				Scanner input = new Scanner(file);

			while(input.hasNext()){
				sb.append(input.nextLine());
				sb.append("\n");
			}
			input.close();
			return file;
		}
		else{
			sb.append("No file was selected");
			return null;
		}
	}
}
