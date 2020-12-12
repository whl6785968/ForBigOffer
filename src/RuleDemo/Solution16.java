package RuleDemo;

public class Solution16 {

    public double myPow(double x, int n) {
        double res = 1;

        for(int i = 0;i < n;i++){
            res *= x;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        double v = solution16.myPow(2.10000, 3);
        System.out.println(v);
    }
}
