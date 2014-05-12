package lcoj.dp;

public class Candy {
	
	
    // 这种两边扫描的方法是一种比较常用的技巧，LeetCode中Trapping Rain Water和这道题都用到了
	// 可以把这种方法作为自己思路的一部分，通常是要求的变量跟左右元素有关系的题目会用到哈。
    public int candy(int[] ratings) {
    	
    	if(ratings == null || ratings.length == 0) return 0;
    	if(ratings.length == 1) return 1;
    	
    	int[] candy = new int[ratings.length];
    	for(int i = 1; i < ratings.length; i++) {
    		if(ratings[i] > ratings[i-1]) {
    			candy[i] = candy[i-1] + 1;
    		}
    	}
    	
    	for(int i = ratings.length - 2; i >=0; i--) {
    		if(ratings[i] > ratings[i+1]) {
    			candy[i] = Math.max(candy[i+1] + 1, candy[i]);
    		}
    	}
    	
    	int rst = ratings.length;
    	for(int i : candy) {
    		rst += i;
    	}
    	
    	return rst;
    }

}
