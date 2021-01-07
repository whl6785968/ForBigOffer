package CalcDemo;

import java.util.Arrays;

public class NC10 {
    public String solve (String s, String t) {
        // write code here
        char[] num1 = s.toCharArray();
        char[] num2 = t.toCharArray();

        if(s.equals("0") || t.equals("0")) return "0";

        int n1 = num1.length;
        int n2 = num2.length;

        char[] answer = new char[n1+n2];
        Arrays.fill(answer,'0');

        int index = n1 + n2;

        for(int i = n1 - 1; i >= 0;i--){
            index--;
            int cur = index;
            int carry = 0;

            for(int j = n2 - 1;j >= 0;j--){
                int temp = (num1[i] - '0') * (num2[j] - '0') + carry + (answer[cur] - '0');
                answer[cur] = (char) (temp % 10 + '0');
                carry = temp / 10;
                cur--;
            }

            while (carry != 0){
                int temp = carry + answer[cur] - '0';
                answer[cur] = (char)(temp%10+'0');
                carry = temp / 10;
                cur --;
            }
        }

        index = 0;
        while (answer[index] == '0') index++;

        return new String(answer,index,n1+n2-index);

    }
}
