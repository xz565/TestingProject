package lcoj.dp.area;


//Given n non-negative integers a1, a2, ..., an, 
//where each represents a point at coordinate (i, ai). n vertical lines are drawn 
//such that the two endpoints of line i is at (i, ai) and (i, 0). 

//Find two lines, which together with x-axis forms a container, 
//such that the container contains the most water.
//
//Note: You may not slant the container.
public class ContainerWithMostWater {

	// find i, j such that Max[Abs(i-j) * Min(ai, aj)]
	// Obviously, an O(N^2) algorithm will do
	// let's try to find a linear solution
	public int maxArea_wrong(int[] height) {

		if (height.length < 2) {
			return 0;
		}

		// This is actually not corrent thought
		// need some smart to work this out!
		// 当从两边�?�中间考虑时，乘水的�?�积是由（两端较�?的高度）×（两个�?�之间的宽度）决定的。
		// 记录最开始的乘水�?�积为ans1，然�?�L�?��?��?动，R�?�左�?动，截止�?�件是L >= R,并且记录乘水的�?�积ans，�?�最大值
		//
		// 以L�?�左�?动为例，当宽度�?�?时，如果�?�积�?�大，必然高度�?增加，因此L�?�需�?�比�?一个L大的值�?��?�，�?始L的高度为L1。R�?��?��?动�?��?�
		int len = height.length;
		int leftH = height[0];
		int leftHIdx = 0;
		int rightH = height[len - 1];
		int rightHIdx = len - 1;
		int max = Math.min(leftH, rightH) * (len - 1);

		int i = 1, j = len - 2;
		while(i < j) {
			while(i < j && height[i] <= leftH) {
				i++;
			}
			if(i < j) {
				leftH = height[i];
				leftHIdx = i;
			}
			while(i < j && height[j] <= rightH) {
				j--;
			}
			if(i < j) {
				rightH = height[j];
				rightHIdx = j;
			}
			int temp = Math.min(leftH, rightH) * (rightHIdx - leftHIdx);
			if(temp > max) {
				max = temp;
			}
		}
		
		return max;
	}
	
	// right though is: two pointer scan
	// each round, simply move the SHORTER one!!!
	public int maxArea(int[] height) {
		
		if (height.length < 2) {
			return 0;
		}
		
		int head = 0, tail = height.length-1;
		int max = Math.min(height[head], height[tail]) * (tail - head);
		
		while(head < tail) {
			
			if(height[head] <= height[tail]) {
				head++;
			} else {
				tail--;
			}
			
			if(head < tail) {
				int temp = Math.min(height[head], height[tail]) * (tail - head);
				if(temp > max) {
					max = temp;
				}
			}
		}
		
		return max;
	}

	public static void main(String[] args) {

		int[] height = { 2, 3,4,9,9,4};
		ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
		System.out.println(containerWithMostWater.maxArea(height));
	}
}