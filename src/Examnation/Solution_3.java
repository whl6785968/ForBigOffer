package Examnation;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Solution_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double p = sc.nextDouble();


        double cnt = 0.0;
        for(int i = m;i <= n;i++){
            double got = got(n, i, p) * got(n,i);
            cnt += got;
        }

        DecimalFormat decimalFormat = new DecimalFormat("0.0000");

        System.out.println(decimalFormat.format(cnt));
    }

    public static double got(int n,int m,double p){
        return Math.pow(p,m) * Math.pow(1-p,n - m);
    }

    public static double got(int n,int m){
        int m1 = m;

        double mod = 1.0;

        while (m1 > 0){
            mod *= m1;
            m1--;
        }

        double res = 1.0;
        while (m > 0){
            res *= n;
            m--;
            n--;
        }

        return res / mod;
    }
}
