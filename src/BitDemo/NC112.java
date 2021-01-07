package BitDemo;

public class NC112 {
    public String solve (int M, int N) {
        // write code here
        char[] res = new char[32];

        boolean sign = true;

        if(M < 0){
            M = -M;
            sign = false;
        }

        int index = res.length - 1;

        while (M != 0){
            int divid = M / N;
            int rem = M - divid * N;
            if(0 <= rem && rem <= 9){
                res[index--] = (char)('0' + rem);
            }
            else{
                res[index--] = (char)('A' + rem - 10);
            }

            M = divid;
        }

        if(!sign){
            res[index--] = '-';
        }

        return new String(res,index + 1,res.length - index - 1);
    }

    public static void main(String[] args) {
        NC112 nc112 = new NC112();
        String solve = nc112.solve(1054, 12);
        System.out.println(solve);
    }
}
