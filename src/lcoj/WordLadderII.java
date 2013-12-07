package lcoj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * Given two words (start and end), and a dictionary, 
 * find all shortest transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * 
 * For example, Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 * [
 *  ["hit","hot","dot","dog","cog"],
 *  ["hit","hot","lot","log","cog"]
 * ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */

public class WordLadderII {

    public ArrayList<ArrayList<String>> findLadders(String start, String end,
	    HashSet<String> dict) {

	WordNode startNode = new WordNode(start);

	Set<WordNode> visited = new HashSet<WordNode>();
	visited.add(startNode);

	Set<WordNode> currtLayer = new HashSet<WordNode>();
	currtLayer.add(startNode);

	Set<WordNode> nextLayer = getNextLayer(currtLayer, end, dict, visited);

	return null;
    }

    private Set<WordNode> getNextLayer(Set<WordNode> currtLayer, String end,
	    HashSet<String> dict, Set<WordNode> visited) {

	Set<WordNode> nextLayer = new HashSet<WordNode>();

	for (WordNode wordNode : currtLayer) {
	    StringBuffer sb = new StringBuffer(wordNode.value);

	    for (int i = 0; i < sb.length(); i++) {

	    }
	}

	return nextLayer;
    }

    class WordNode {
	String value;
	WordNode previous;

	public WordNode(String str) {
	    value = str;
	}
    }
}
