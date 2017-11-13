package wordcount.service.impl;

import wordcount.service.AWordCount;
import wordcount.util.HTTPLoader;

/**
 * @author tarik
 * Word count who parse text from URL
 */
public class WordCountUrl extends AWordCount {
	
	/**
	 * Text path given from an URL resource
	 */
	private String textPathUrl;
	
	public WordCountUrl(String textPathUrl) {
		this.setTextPathUrl(textPathUrl);
	}
	
	@Override
	public String getText() {
		return HTTPLoader.getTextURL(getTextPathUrl());
	}

	/**
	 * @return the textPathUrl
	 */
	public String getTextPathUrl() {
		return textPathUrl;
	}

	/**
	 * @param textPathUrl the textPathUrl to set
	 */
	public void setTextPathUrl(String textPathUrl) {
		this.textPathUrl = textPathUrl;
	}

}
