import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.util.Version;


public class DocmentWordsVectorConstructor {

	private static final int TRAINING_MODE = 1;
	private static final int TESTING_MODE = 2;
	private BaseTokenizer tokens;
	private StopAnalyzer stopWordRemover;
	private CharArraySet stopWords;
	
	public DocmentWordsVectorConstructor() {
		
		tokens = new BaseTokenizer();
		stopWordRemover = new StopAnalyzer(Version.LUCENE_47);
	}
	
	
	public void createDocumentsWordTables(File folder) throws FileNotFoundException {
		
		
	    for (File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        	createDocumentsWordTables(fileEntry);
	        } else {
	        	
	        	createDocumentWordTable(fileEntry);
	        }
	    }
	}
	
	private void createDocumentWordTable(File file) throws FileNotFoundException {
	
		List<String> baseTokens = tokens.tokenizeTextFromFile(file);
		stopWords = stopWordRemover.getStopwordSet();
		
		for(int i = 0; i < baseTokens.size(); i++) {
			
			if(stopWords.contains(baseTokens.get(i).toLowerCase()) || stopWords.contains(baseTokens.get(i)))
				baseTokens.remove(i);
		}
		
		for(int i = 0; i < baseTokens.size(); i++) {
			
			System.out.println(baseTokens.get(i));
		}
	}

}
