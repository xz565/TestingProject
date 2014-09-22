package lcoj.recursive.dfs;

import java.util.ArrayList;
import java.util.List;

//Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//For example:
//Given "25525511135",
//
//return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
public class RestoreIPAddresses {
	
	// TODO
	// There is another dfs solution, will do later

	// divide the string into four parts, and validate each part
	// O(N^3)
	// Not a good solution
    public ArrayList<String> restoreIpAddresses(String s) {
        
    	ArrayList<String> result = new ArrayList<String>();
    	int len = s.length();
    	if(len < 4 || len > 12) return result;
    	
    	int first = 0;
    	int second = 0;
    	int third = 0;
    	int forth = 0;
    	
    	String curt;
    	
    	for(int i = 0; i < 3; i++) {
    		curt = s.substring(0, i+1);
    		if(curt.isEmpty()) continue;
    		if(curt.length() > 1 && curt.charAt(0) == '0') continue;
    		
    		first = Integer.parseInt(curt);
    		if(first > 255) continue;
    		
    		for(int j = i+1; j < Math.min(len, i+4); j++) {
    			curt = s.substring(i+1, j+1);
    			if(curt.isEmpty()) continue;
    			if(curt.length() > 1 && curt.charAt(0) == '0') continue;
    			
    			second = Integer.parseInt(curt);
    			if(second > 255) continue;
    			
    			for(int k = j+1; k < Math.min(len, j+4); k++) {
    				curt = s.substring(j+1, k+1);
    				String last = s.substring(k+1);
    				if(curt.isEmpty() || last.isEmpty()) continue;
    				if(curt.length() > 1 && curt.charAt(0) == '0') continue;
    				if(last.length() > 1 && last.charAt(0) =='0') continue;
    				
    				third = Integer.parseInt(curt);
    				forth = Integer.parseInt(last);
    				if(third > 255 || forth > 255) continue;
    				
    				StringBuilder sb = new StringBuilder();
    				sb.append(first).append(".").append(second).append(".").append(third).append(".").append(forth);
    				result.add(sb.toString());
    			}
    		}
    	}
    	
		return result;
    }

    public List<String> restoreIpAddresses2(String s) {
        
        List<String> rst = new ArrayList<String>();
        if(s == null || s.length() == 0) {
            return rst;
        }
        
        List<String> tmp = new ArrayList<String>();
        helper(s, 0, rst, tmp);
        
        return rst;
    }
    
    private void helper(String s, int idx, List<String> rst, List<String> tmp) {
        
    	if(idx > s.length() || tmp.size() > 4) {
    		return;
    	}
    	
    	if(idx == s.length() && tmp.size() == 4) {
    		StringBuffer sb = new StringBuffer();
    		for(String str : tmp) {
    			sb.append(str).append(".");
    		}
    		sb.deleteCharAt(sb.length() - 1);
    		rst.add(sb.toString());
    		return;
    	}
    	
    	if(idx < s.length()) {
    		tmp.add(s.substring(idx, idx + 1));
    		helper(s, idx + 1, rst, tmp);
    		tmp.remove(tmp.size() - 1);
    		
    		if(s.charAt(idx) == '0') {
    			return;
    		}
    	}
    	
		if (idx + 1 < s.length()) {
			tmp.add(s.substring(idx, idx + 2));
			helper(s, idx + 2, rst, tmp);
			tmp.remove(tmp.size() - 1);
		}
		
		if(idx + 2 < s.length()) {
			String ss = s.substring(idx, idx + 3);
			if(Integer.valueOf(ss) <= 255) {
				tmp.add(ss);
				helper(s, idx + 3, rst, tmp);
				tmp.remove(tmp.size() - 1);
			}
		}
    }
    
    public static void main(String[] args) {
    	RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
    	String s = "";
		s = "25525511135";
		System.out.println(restoreIPAddresses.restoreIpAddresses2(s));
		s = "0279245587303";
		System.out.println(restoreIPAddresses.restoreIpAddresses2(s));
		s = "010010";
		System.out.println(restoreIPAddresses.restoreIpAddresses2(s));
	}
}
