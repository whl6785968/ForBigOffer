package ArrayDemo;

import java.util.Arrays;

public class NC110 {
    public int[] solve (int n, int m, int[] a) {
        // write code here
        while (m-- > 0){
            int temp = a[n-1];
            for(int i = n - 1;i >= 1;i--){
                a[i] = a[i-1];
            }

            a[0] = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        NC110 nc110 = new NC110();
        int[] arr = {1,2,3,4,5,6};
        int[] solve = nc110.solve(6, 2, arr);
        System.out.println(Arrays.toString(solve));
    }
}
