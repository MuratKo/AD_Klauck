package helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextUmwandler {

	public static String[] umwandeln(String pfad) throws Exception{
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
		
		if(result == null) throw new Exception();
		
		return result;
	}
}
