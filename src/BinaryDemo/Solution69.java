package BinaryDemo;

public class Solution69 {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;

        long l = 0;
        long r = x / 2;

        while (l < r){
            long mid = (l + r + 1) / 2;
            long sqrt = mid * mid;

            if(sqrt > x){
                r = mid - 1;
            }
            else{
                l = mid;
            }

        }

        return (int)l;
    }

    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        int i = solution69.mySqrt(5);
        System.out.println(i);
    }
}
