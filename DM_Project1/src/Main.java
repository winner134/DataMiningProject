import java.io.File;
import java.io.FileNotFoundException;


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		DocmentWordsVectorConstructor doc = new DocmentWordsVectorConstructor();
		doc.createDocumentsWordTables(new File("20_news_groups_training/alt.atheism"));
	}

}
