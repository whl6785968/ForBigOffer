package MathDemo;

public class Solution69 {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;

        long left = 0;
        long right = (x / 2) + 1;

        while (left < right){
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;

            if(square > x){
                right = mid - 1;
            }
            else{
                left = mid;
            }
        }

        return (int) left;
    }

    public double mySqrtByNewton(int x){
        long a = x;
        while (a * a > x){
            a = (a + x / a) / 2;
        }

        return a;
    }

    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        double i = solution69.mySqrtByNewton(8);
        System.out.println(i);
    }
}
