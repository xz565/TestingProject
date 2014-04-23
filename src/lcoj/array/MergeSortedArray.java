package lcoj.array;

public class MergeSortedArray {

public void merge(int A[], int m, int B[], int n) {
        
        int aIdx = m - 1;
        int bIdx = n - 1;
        
        for(int i = m + n - 1; i >= 0; i--) {
            
            if(aIdx < 0 || bIdx < 0) {
                break;
            }
            
            if(A[aIdx] >= B[bIdx]) {
                A[i] = A[aIdx];
                aIdx--;
            } else {
                A[i] = B[bIdx];
                bIdx--;
            }
        }
        
        if(aIdx < 0) {
            for(int i = 0; i <= bIdx; i++) {
                A[i] = B[i];
            }
        }
    }
}
