package lcoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

/*
 * solve this problem with BFS building search graph + DFS build paths.
 * 
 * divide apart this two stages: searching the end and reversely building paths.
 * 
 * 
 * Description of algorithm:
 * 
 * First use BFS to traverse layer by layer, until reached the end.
 * 
 * In the process of traversing, build a search graph: key is work in current layer, value is a list of value in next layer
 * 
 * Then use DFS to traverse the search graph recursively to get all the paths.
 */
public class WordLadderII {

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {

		HashSet<String> visited = new HashSet<String>();
		visited.add(start);

		Map<String, Set<String>> pathGraph = new HashMap<String, Set<String>>();
		pathGraph.put(start, null);
		
		HashSet<String> layer = new HashSet<String>();
		layer.add(start);
		
		layer = getNextLayer(layer, dict, end, visited, pathGraph);

		ArrayList<ArrayList<String>> pathList = new ArrayList<ArrayList<String>>();

		while (!layer.contains(end)) {
			
			if(layer.isEmpty()) {
				return pathList;
			}
			
			System.out.println(layer);
			layer = getNextLayer(layer, dict, end, visited, pathGraph);
		}
		
		System.out.println(pathGraph);
		
		ArrayList<String> path = new ArrayList<String>();
		path.add(start);

		getPath(pathGraph, pathList, path, start, end);
		
		return pathList;
	}

	private HashSet<String> getNextLayer(HashSet<String> currtLayer,
			HashSet<String> dict, String end, HashSet<String> visited, Map<String, Set<String>> path) {

		HashSet<String> nextLayer = new HashSet<String>();
		
		HashSet<String> visitedTemp = new HashSet<String>();
		
		for (String currtStr : currtLayer) {

			StringBuffer sb = new StringBuffer(currtStr);
			for (int i = 0; i < sb.length(); i++) {
				char currtChar = sb.charAt(i);

				for (char ch = 'a'; ch <= 'z'; ch++) {
					sb.setCharAt(i, ch);

					if (dict.contains(sb.toString())
							&& !visited.contains(sb.toString())) {
						nextLayer.add(sb.toString());
						visitedTemp.add(sb.toString());
						
						Set<String> pathSet = path.get(currtStr);
						if(pathSet == null) {
							pathSet = new HashSet<String>();
							pathSet.add(sb.toString());
							path.put(currtStr, pathSet);
						} else {
							pathSet.add(sb.toString());
						}
						
					}
				}
				sb.setCharAt(i, currtChar);
			}
		}
		
		visited.addAll(visitedTemp);
		return nextLayer;
	}

	@SuppressWarnings("unchecked")
	private void getPath(Map<String, Set<String>> pathGraph, ArrayList<ArrayList<String>> pathList, ArrayList<String> path, String start, String end) {

		if(start.equals(end)) {
			pathList.add((ArrayList<String>) path.clone());
		}

		Set<String> nextSet = pathGraph.get(start);
		if(nextSet != null) {
			for(String str : nextSet) {
				path.add(str);
				getPath(pathGraph, pathList, path, str, end);
				path.remove(str);
			}
		}
	}

	public static void main(String[] args) {

		HashSet<String> dict = new HashSet<String>();
		WordLadderII wl = new WordLadderII();

		dict.clear(); dict.add("hot"); dict.add("dog");
		System.out.println(wl.findLadders("hot", "dog", dict));
		
		String[] b = { "ted", "tex", "red", "tax", "tad", "den", "rex", "pee", "reo" };
		dict.clear();
		dict.addAll(Arrays.asList(b));
		Long start = System.currentTimeMillis();
		System.out.println(wl.findLadders("red", "tax", dict));
		System.out.println(System.currentTimeMillis() - start);

		String[] arrStrings = {"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
		dict.clear();
		dict.addAll(Arrays.asList(arrStrings));
		start = System.currentTimeMillis();
		System.out.println(wl.findLadders("nape", "mild", dict));
		System.out.println(System.currentTimeMillis() - start);

	}
}
