package lcoj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {

	Set<String> cache = new HashSet<String>();
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        
    	cache.clear();
    	ArrayList<String> results = new ArrayList<String>();
    	
    	for(int i = 1; i <= s.length(); i++) {
    		
    		String prefix = s.substring(0, i);
    		if(dict.contains(prefix)) {
    			
    			String suffix = s.substring(i);
    			if(cache.contains(suffix)) {
    				continue;
    			}
    			
    			
    		}
    	}
    	
    	return results;
    }
}
