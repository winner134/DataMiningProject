import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class TextDirectoryToARFF {

	private static String dataFolderPath;
	private static String arrfFilePath;
	private static BufferedWriter outARFF;
	
	private static  void listFilesForFolder(File folder) throws IOException {
	    for (File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            writeFileARFFData(fileEntry);
	        }
	    }
	}
	
	private static void writeFileARFFData(File textFile) throws IOException {
		
		Scanner text = new Scanner(new BufferedReader(new FileReader(textFile)));
		
		outARFF.write("\"" + textFile.getName() + "\" , \"");
		
		while(text.hasNext()) {
			
			outARFF.write(text.next().trim() + " ");
		}
		
		outARFF.write("\", \"" + textFile.getParent() + "\"");
		outARFF.newLine();
		text.close();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		if(args.length == 2) {
						
			dataFolderPath = args[0];
			arrfFilePath = args[1];
			
			outARFF = new BufferedWriter(new FileWriter(arrfFilePath));
			
			File dataFolder = new File(dataFolderPath);
			
			outARFF.write("@relation text_files_in_" + dataFolderPath + "\n\n");
			outARFF.write("@attribute filename string\n");
			outARFF.write("@attribute contents string\n");
			outARFF.write("@attribute class string\n\n");
			outARFF.write("@data\n");
			
			listFilesForFolder(dataFolder);
			
			outARFF.close();
		}
		
		else {
			
		}
	}

}
