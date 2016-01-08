package helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import exception.TextNotSplittedException;

public class TextUmwandler {

	public static String[] umwandeln(String pfad) throws TextNotSplittedException, FileNotFoundException, IOException{
		BufferedReader reader = null;
		String[] result = null;
		try {
		    File file = new File(pfad);
		    reader = new BufferedReader(new FileReader(file));
		    String content = "";
		    String line;
		    
		    while ((line = reader.readLine()) != null) {
		        content += line;
		        
		    }

		    result = content.split("[!?, .]+");
		    
		} catch (IOException e) {
		    throw new FileNotFoundException();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        throw new IOException();
		    }
		}
		
		if(result == null) throw new TextNotSplittedException();
		
		return result;
	}
}
