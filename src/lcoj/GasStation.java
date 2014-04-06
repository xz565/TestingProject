package lcoj;

/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique.
 * 
 * @author Xiaodong Zhang
 * 
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        
    	int[] diff = new int[gas.length];
    	for (int i = 0; i < gas.length; i++) {
			diff[i] = gas[i] - cost[i];
		}
    	outer:
    	for(int i = 0; i < diff.length; i++) {
    		int sum = 0;
    		if(diff[i] >= 0) {
    			for(int j = i; j < diff.length; j++) {
    				sum += diff[j];
    				if(sum < 0) {
    					continue outer;
    				}
    			}
    			for(int j = 0; j < i; j++) {
    				sum += diff[j];
    				if(sum < 0) {
    					continue outer;
    				}
    			}
    			if(sum >= 0) {
    				return i;
    			}
    		}
    	}
    	return -1;
    }
}
