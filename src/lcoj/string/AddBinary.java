package lcoj.string;

//Given two binary strings, return their sum (also a binary string).
//
//For example,
//a = "11"
//b = "1"
//Return "100".
public class AddBinary {

    public String addBinary(String a, String b) {
        
    	int i = a.length() - 1;
    	int j = b.length() - 1;
    	
    	if(i != j) {
    		String s = "";
    		for(int k = 0; k < Math.abs(i - j); k++) s+="0";
    		if(i < j) a = s + a;
    		else b = s + b;
    	}
    	
    	StringBuilder sb = new StringBuilder("");
    	boolean carry = false;

    	int k = a.length() - 1;
    	while(k >= 0) {
    		int sum = 0;
    		if(a.charAt(k) == '1') sum++;
    		if(b.charAt(k) == '1') sum++;
    		if(carry) sum++;
    		
    		if(sum == 0) {
    			sb.insert(0, '0');
    			carry = false;
    		} else if(sum == 1) {
    			sb.insert(0, '1');
    			carry = false;
    		} else if(sum == 2) {
    			sb.insert(0, '0');
    			carry = true;
    		} else if(sum == 3) {
    			sb.insert(0, '1');
    			carry = true;
    		}
    		k--;
    	}
    	
    	if(carry) sb.insert(0, '1');
    	
    	return sb.toString();
    }
    
    public static void main(String[] args) {
		AddBinary addBinary = new AddBinary();
		System.out.println(addBinary.addBinary("1", "11"));
	}
}
