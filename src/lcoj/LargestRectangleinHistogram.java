package lcoj;

public class LargestRectangleinHistogram {
    
	
	// O(N^2) TLE
	
	// use pruning technique to optimize; and OJ got really good test cases
	public int largestRectangleArea(int[] height) {
        
		int max = 0;
		
		int lastHeight = Integer.MAX_VALUE;
		
		for (int i = 0; i < height.length; i++) {
			
			if(i != 0 && height[i] == lastHeight) {
				continue;
			}
			lastHeight = height[i];
			
			int leftCount = i - 1;
			int rightCount = i + 1;
			
			int leftNum = 0;
			int rightNum = 0;
			
			while(leftCount >= 0) {
				if(height[leftCount] >= height[i]) {
					leftCount--;
					leftNum++;
				} else {
					break;
				}
			}
			
			while(rightCount < height.length) {
				if(height[rightCount] >= height[i]) {
					rightCount++;
					rightNum++;
				} else {
					break;
				}
			}
			
			int currtMax = (leftNum + rightNum + 1) * height[i];
			
			System.out.println(i + " " + currtMax);
			
			if(currtMax > max)
				max = currtMax;
			
		}
		
		return max;
    }
	
	public static void main(String[] args) {
		
		System.out.println(Integer.MAX_VALUE);
		
		int[] arr = {2147483647};
		LargestRectangleinHistogram largestRectangleinHistogram = new LargestRectangleinHistogram();
		System.out.println(largestRectangleinHistogram.largestRectangleArea(arr));
	}
}
