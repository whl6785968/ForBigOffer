package DoubleIndexDemo;

public class NC127 {
    public String LCS (String str1, String str2) {
        StringBuilder sb = new StringBuilder();

        int start = 0,end = 1;

        while (end < str1.length() + 1){
            if(str2.contains(str1.substring(start,end))){
                if(sb.length() < end - start){
                    sb.delete(0,sb.length());
                    sb.append(str1,start,end);
                }

                end++;
            }
            else{
                start++;
            }
        }

        if(sb.length() == 0){
            return "-1";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        NC127 nc127 = new NC127();
        String str1 = "1AB2345CD";
        String str2 = "12345EF";

        String lcs = nc127.LCS(str1, str2);
        System.out.println(lcs);
    }
}
