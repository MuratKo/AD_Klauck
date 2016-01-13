package helper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class TextBuilder {
	
	private String path;
	private int amountOfDifferentWords;
	Random rand;

	public TextBuilder(String path, int amountOfDifferentWords){
		this.path = path;
		this.amountOfDifferentWords = amountOfDifferentWords;
		rand = new Random();
	}
	
	public String createWord(){
		
		// ASCII: a..z
		
		int sizeOfWord = rand.nextInt(10 - 1 + 1) + 1;
		String word = "";
		for(int i = 0; i < sizeOfWord; i++){
			char c = (char) (rand.nextInt(122 - 97 + 1) + 97); 
			word += c;
		}
		return word;
	}
	
	
	public String[] createWordList(){
		String[] words = new String[amountOfDifferentWords];
		for(int x = 0; x < amountOfDifferentWords; x++){
			int sizeOfWord = rand.nextInt(10 - 1 + 1) + 1;
			words[x] = createWord();
		}
		return words;
	}
	
	public File createFile(String filename, int amountOfTotalWords){
		File f = new File(path);
		
		try {
			File file = new File(path + filename);
			file.createNewFile();
			PrintWriter writer = new PrintWriter(file, "UTF-8");
			
			String[] words = createWordList();
			List<String> wordsToShuffle = new ArrayList<>();
			
			int min = 1;
			int max = 200;
			for(String word : words){
				int amountOfWordsInText = (int) (Math.random()*max+min);
				for(int i = 0; i < amountOfWordsInText; i++){
					wordsToShuffle.add(word);
				}
			}
			java.util.Collections.shuffle(wordsToShuffle);
			
			for(int i = 0; i < amountOfTotalWords; i++){
				writer.write(wordsToShuffle.get(i) + " ");
			}
			writer.close();
			return file;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
		
	}
}
