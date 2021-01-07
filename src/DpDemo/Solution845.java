package DpDemo;

import java.util.Arrays;

public class Solution845 {
    public int longestMountain(int[] arr) {
        int n = arr.length;

        if(n == 0) return 0;

        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 1;i < n ;i++){
            if(arr[i] > arr[i-1]){
                left[i] = left[i-1] + 1;
            }
        }

        for(int j = n - 2;j >= 0;j--){
            if(arr[j] > arr[j+1]){
                right[j] = right[j+1] + 1;
            }
        }

        int res = 0;

        for(int i = 0;i < n;i++){
            res = Math.max(left[i] + right[i] + 1,res);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution845 solution845 = new Solution845();
        int[] arr = {2,1,4,7,3,2,5};

        int i = solution845.longestMountain(arr);
        System.out.println(i    );
    }
}
