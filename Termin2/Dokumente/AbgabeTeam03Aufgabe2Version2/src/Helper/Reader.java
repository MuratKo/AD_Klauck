package Helper;

import adtarray.ADTArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Exceptions.NoFileSelectedException;


public class Reader {
	public static ADTArray reader() throws NoFileSelectedException{
		
		
		try{
			File file = chooseFile();
			ADTArray array = ADTArray.initA();
			
			FileReader fileReader = new FileReader(file);
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			String line = "";
			String[] numbers;
			int actualPos = 0;
			
			 while((line = reader.readLine()) != null){
		            numbers = line.split(" ");
		            for(int i = 0; i < numbers.length; i++){
		            	array = array.setA(actualPos, Integer.parseInt(numbers[i]));
		            	actualPos++;
		            }
		     }
			return array;
						
		}catch(NoFileSelectedException e){
			throw e;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	private static File chooseFile() throws NoFileSelectedException{
		JFileChooser chooser = new JFileChooser("C:/Users/abp516/Documents/AD_Klauck/Termin2/Programm/zahlen");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("ONLY .dat", "dat");
		chooser.setFileFilter(filter);
		
		
		int state = chooser.showOpenDialog(null);
		
		if(state == JFileChooser.APPROVE_OPTION){
			return chooser.getSelectedFile();
		}else {
			throw new NoFileSelectedException();
		}
		
		
	}

}


	
