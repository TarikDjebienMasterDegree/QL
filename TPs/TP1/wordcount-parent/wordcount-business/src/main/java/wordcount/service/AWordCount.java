package wordcount.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

/**
 * @author tarik
 * Abstract WordCount encapsulate and factories the Business logic code
 */
public abstract class AWordCount implements IWordCount {

	/**
	 * Get the text to analyze
	 * @return
	 */
	public abstract String getText();
	
	/* (non-Javadoc)
	 * @see wordcount.service.IWordCount#countAllWordInText()
	 */
	public Map<String, Integer> countAllWordInText() {
		Map<String, Integer> frequencies = new HashMap<String, Integer>();
		String[] textSplit = getText().split("\\s|\\n");
		for(String word: textSplit){
			Integer frequency = frequencies.get(word.trim());
			if(frequency != null){
				frequencies.put(word, frequency + 1);
			}else{
				frequencies.put(word, 1);
			}
		}
		return frequencies;
	}

	/* (non-Javadoc)
	 * @see wordcount.service.IWordCount#countOneWordInText(java.lang.String)
	 */
	public int countOneWordInText(String word) {
		return StringUtils.countMatches(getText(), word);
	}

	/* (non-Javadoc)
	 * @see wordcount.service.IWordCount#isWordInText(java.lang.String)
	 */
	public boolean isWordInText(String word) {
		return StringUtils.contains(getText(),word);
	}

	/* (non-Javadoc)
	 * @see wordcount.service.IWordCount#getAllFrequentWordsInText(java.util.List, int)
	 */
	public List<String> getAllFrequentWordsInText(List<String> words, int N) {
		List<String> frequentWords = new ArrayList<String>(N);
		int cpt = N;
		for(String word : sortByValues(countAllWordInText()).keySet()){
			if(!words.contains(word) && cpt > 0){
				frequentWords.add(word);
				cpt--;
			}
		}
		return frequentWords;
	}

	/**
	 * Sort a map by values on order desc
	 * @param map
	 * @return
	 */
	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
		Comparator<K> valueComparator =  new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k2).compareTo(map.get(k1));
				if (compare == 0) return 1;
				else return compare;
			}
		};
		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

}
