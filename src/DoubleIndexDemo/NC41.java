package DoubleIndexDemo;

import java.util.HashMap;
import java.util.Map;

public class NC41 {
    public int maxLength (int[] arr) {
        // write code here
        int[] lastPos = new int[100005];
        int len = arr.length;
        int start = 0;
        int res = 0;
        for(int i =0;i<len;i++){
            int now = arr[i];
            start = Math.max(start,lastPos[now]);
            res = Math.max(res,i-start+1);
            lastPos[now] = i+1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,4,3};
        NC41 nc41 = new NC41();
        nc41.maxLength(arr);
    }
}
