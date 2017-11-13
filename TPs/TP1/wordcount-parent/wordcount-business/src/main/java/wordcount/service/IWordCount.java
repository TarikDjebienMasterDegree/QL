package wordcount.service;

import java.util.List;
import java.util.Map;

/**
 * @author tarik
 * Service contract for a word count implementation
 */
public interface IWordCount {
	
	/**
	 * Compter le nombre d'occurences de chaque mot dans un texte passé en paramètre (depuis un text brut ou une URL)
	 * @return
	 */
	Map<String, Integer> countAllWordInText();
	
	/**
	 * Compter le nombre d'occurences d'un mot particulier dans un texte passé en paramètre (depuis un text brut ou une URL)
	 * @param text
	 * @return
	 */
	int countOneWordInText(String word);
	
	
	/**
	 * Déterminer si un mot particulier est présent dans un texte passé en paramètre
	 * @param text
	 * @return
	 */
	boolean isWordInText(String word);
	
	/**
	 * Retourner la liste des n mots les plus fréquents dans un texte et qui ne sont pas dans une liste de mots courants (passée en paramètre)
	 * @param text
	 * @param words
	 * @return
	 */
	List<String> getAllFrequentWordsInText(List<String> words, int N);
	
}
