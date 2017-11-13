package wordcount.service.impl;

import wordcount.service.AWordCount;
import wordcount.util.FileLoader;

/**
 * @author tarik
 * Word count who parse text from File System
 */
public class WordCountBrut extends AWordCount {

	/**
	 * The text path on the file system
	 */
	private String textPathFile;

	public WordCountBrut(String textPathFile) {
		this.setTextPathFile(textPathFile);
	}
	
	@Override
	public String getText() {
		return FileLoader.getTextFile(getTextPathFile());
	}

	/**
	 * @return the textPathFile
	 */
	public String getTextPathFile() {
		return textPathFile;
	}

	/**
	 * @param textPathFile the textPathFile to set
	 */
	public void setTextPathFile(String textPathFile) {
		this.textPathFile = textPathFile;
	}

}
