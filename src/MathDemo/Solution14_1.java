package MathDemo;

public class Solution14_1 {
    public int cuttingRope(int n) {
        if(n <= 3){
            return n - 1;
        }

        int a = n / 3;
        int b = n % 3;



        double res = 0;
        if(b == 0){
            res = Math.pow(3,a);
        }
        else if(b == 1){
            res = Math.pow(3,a-1) * 4;
        }
        else{
            res = Math.pow(3,a) * 2;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        Solution14_1 solution14_1 = new Solution14_1();
        int i = solution14_1.cuttingRope(5);
        System.out.println(i);
    }
}
