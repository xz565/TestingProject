package lcoj.array.sum;

import java.util.ArrayList;
import java.util.Arrays;

//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//Note:
//Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//The solution set must not contain duplicate triplets.
//    For example, given array S = {-1 0 1 2 -1 -4},
//
//    A solution set is:
//    (-1, 0, 1)
//    (-1, -1, 2)
public class ThreeSum {

    public ArrayList<ArrayList<Integer>> threeSum_wrong(int[] num) {
     
    	Arrays.sort(num); // O(NlgN)
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	int head = 0;
    	int tail = num.length - 1;
    	while(head < tail) {
    		int twoSum = num[head] + num[tail];
    		int diff = 0 - twoSum;
    		for(int i = head + 1; i < tail; i++) {
    			if(num[i] == diff) {
    				ArrayList<Integer> al = new ArrayList<Integer>();
    				al.add(num[head]);
    				al.add(num[i]);
    				al.add(num[tail]);
    				result.add(al);
    				break;
    			}
    		}
    		
    		if(twoSum >= 0) {
    			while(tail >= 1 && num[tail] == num[--tail]);
    		} else {
    			while(head < num.length - 1 && num[head] == num[++head]);
    		}
    	}
		return result ;
    }
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	
    	Arrays.sort(num); // O(NlgN)
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	for(int i = 0; i < num.length; i++) {
    		int curt = num[i];
    		int diff = 0 - curt;
    		
    		int head = i + 1;
    		int tail = num.length - 1;
    		while(head < tail) {
    			if(num[head] + num[tail] == diff) {
    				ArrayList<Integer> al = new ArrayList<Integer>();
    				al.add(num[i]);
    				al.add(num[head]);
    				al.add(num[tail]);
    				result.add(al);
    				
    				while(tail >= 1 && num[tail] == num[tail - 1]) {
    					tail--;
    				}
    				tail--;
    				
    				while(head < num.length - 1 && num[head] == num[head + 1]) {
    					head++;
    				}
    				head++;
    			}
    			
    			if(head < num.length && tail >= 0 && num[head] + num[tail] > diff) {
    				while(tail >= 1 && num[tail] == num[tail - 1]) {
    					tail--;
    				}
    				tail--;
    			}
    				
    			if(head < num.length && tail >= 0 && num[head] + num[tail] < diff) {
    				while(head < num.length - 1 && num[head] == num[head + 1]) {
    					head++;
    				}
    				head++;
    			}
    		}
    		
    		while(i+1 < num.length && num[i+1] == num[i]) {
    			i++;
    		}
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
		
//    	int[] S = {-1, 0, 1, 2, -1, -4};
//    	int[] S2 = {0,0,0,0};
//    	int[] S3 = {-2,0,0,2,2};
    	int[] S4 = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
    	ThreeSum threeSum = new ThreeSum();
    	System.out.println(threeSum.threeSum(S4));
	}
}