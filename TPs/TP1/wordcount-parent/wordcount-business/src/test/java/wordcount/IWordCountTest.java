package wordcount;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import wordcount.service.IWordCount;
import wordcount.service.impl.WordCountBrut;
import wordcount.service.impl.WordCountUrl;

/**
 * Unit test for wordCount Implementation.
 */
public class IWordCountTest {

	public IWordCount wordCountTextBrut;
	public IWordCount wordCountTextUrl;
	
	@Before
	public void setUp(){
		//A CHANGER AVEC VOTRE FICHIER TEXTE BRUT
		String textPathFile = "/Users/tarik/Desktop/test.txt";
		String textPathUrl = "http://djebien.tarik.perso.sfr.fr/test.txt";
		
		wordCountTextBrut = new WordCountBrut(textPathFile);
		wordCountTextUrl = new WordCountUrl(textPathUrl);
	}
	
	@Test
	public void countAllWordInTextTest(){
		Map<String, Integer> mapExpected = new HashMap<String, Integer>();
		mapExpected.put("Tarik", new Integer(4));
		mapExpected.put("Djebien", new Integer(2));
		
		Map<String, Integer> mapResult = wordCountTextBrut.countAllWordInText();
		
		assertTrue(mapExpected.equals(mapResult));
	}
	
	@Test
	public void isWordInTextTest(){
		assertTrue(wordCountTextBrut.isWordInText("Tarik"));
	}
	
	@Test
	public void isNotWordInTextTest(){
		assertFalse(wordCountTextBrut.isWordInText("Miage"));
	}
	
	@Test
	public void countOneWordInTextTest(){
		assertTrue(wordCountTextBrut.countOneWordInText("Tarik") == 4);
	}
    
	@Test
	public void getAllFrequentWordsInTextTest(){
		int maxFrequentWords = 1;
		List<String> forbiddenWords = new ArrayList<String>();
		forbiddenWords.add("Tarik");
		
		List<String> frequentWordsExpected = new ArrayList<String>();
		frequentWordsExpected.add("Djebien");
		
		List<String> frequentWordsResult = wordCountTextBrut.getAllFrequentWordsInText(forbiddenWords, maxFrequentWords);
		
		assertTrue(frequentWordsExpected.equals(frequentWordsResult));
	}
	
	@Test
	public void countAllWordInTextURLTest(){
		Map<String, Integer> mapExpected = new HashMap<String, Integer>();
		mapExpected.put("Tarik", new Integer(4));
		mapExpected.put("Djebien", new Integer(2));
		
		Map<String, Integer> mapResult = wordCountTextUrl.countAllWordInText();
		
		assertTrue(mapExpected.equals(mapResult));
	}
	
	@Test
	public void isWordInTextURLTest(){
		assertTrue(wordCountTextUrl.isWordInText("Tarik"));
	}
	
	@Test
	public void isNotWordInTextURLTest(){
		assertFalse(wordCountTextUrl.isWordInText("Miage"));
	}
	
	@Test
	public void countOneWordInTextURLTest(){
		assertTrue(wordCountTextUrl.countOneWordInText("Tarik") == 4);
	}
    
	@Test
	public void getAllFrequentWordsInTextURLTest(){
		int maxFrequentWords = 1;
		List<String> forbiddenWords = new ArrayList<String>();
		forbiddenWords.add("Tarik");
		
		List<String> frequentWordsExpected = new ArrayList<String>();
		frequentWordsExpected.add("Djebien");
		
		List<String> frequentWordsResult = wordCountTextUrl.getAllFrequentWordsInText(forbiddenWords, maxFrequentWords);
		
		assertTrue(frequentWordsExpected.equals(frequentWordsResult));
	}
}
