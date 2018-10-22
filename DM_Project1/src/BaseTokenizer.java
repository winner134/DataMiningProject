

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.Tokenizer;
import com.aliasi.tokenizer.TokenizerFactory;
import com.aliasi.tokenizer.WhitespaceNormTokenizerFactory;

public class BaseTokenizer {

	private TokenizerFactory TOKENIZER_FACTORY = IndoEuropeanTokenizerFactory.INSTANCE;
	private List<String> tokenList;
	private List<String> whiteList;
	private Tokenizer tokenizer;

	public TokenizerFactory getTOKENIZER_FACTORY() {
		return TOKENIZER_FACTORY;
	}

	public List<String> tokenizeTextFromFile(File file) throws FileNotFoundException {
		
		tokenList = new LinkedList<String>();
		whiteList = new LinkedList<String>();
		
		Scanner scanDischargeSummary = new Scanner(new BufferedReader(new FileReader(file)));
		String text = new String("");
		
		while(scanDischargeSummary.hasNext()) {
			
			//System.out.println(scanDischargeSummary.next());
			String next = scanDischargeSummary.next();
			text = text + " " + next;
		}
		
		scanDischargeSummary.close();
		
		tokenizer = TOKENIZER_FACTORY.tokenizer(text.toCharArray(),0,text.length());
		tokenizer.tokenize(tokenList,whiteList);
		
		return tokenList;
	}

	public List<String> getTokenList() {
		return tokenList;
	}

	public List<String> getWhiteList() {
		return whiteList;
	}
	
	
	
	
}
