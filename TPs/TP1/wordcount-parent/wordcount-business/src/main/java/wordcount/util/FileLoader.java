package wordcount.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;

public class FileLoader {
	
	
	/**
	 * Open a file and read text data, for example .txt file
	 * @param pathFile
	 * @return
	 */
	public static String getTextFile(String pathFile){
		
		String result = "";
		FileInputStream inputStream = null;
		
		try {
	    	inputStream = new FileInputStream(pathFile);
	    	result = IOUtils.toString(new FileInputStream(pathFile));
	    } catch (FileNotFoundException e) {
	    	Logger.getLogger(FileLoader.class.getName()).log(Level.SEVERE, null, e);
		} catch (IOException e) {
			Logger.getLogger(FileLoader.class.getName()).log(Level.SEVERE, null, e);
		} finally {
	        try {
				inputStream.close();
			} catch (IOException e) {
				Logger.getLogger(FileLoader.class.getName()).log(Level.SEVERE, null, e);
			}
	    }
		return result;
	}
	

}
