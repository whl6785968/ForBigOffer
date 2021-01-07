package ArrayDemo;

public class NC77 {
    public void reOrderArray(int [] array) {
        int n = array.length;
        int odd = 0;
        int even = 0;

        while (even < n){
            if(array[even] % 2 != 0){
                int temp = array[even];

                for(int i = even;i > odd;i--){
                    array[i] = array[i-1];
                }

                array[odd] = temp;
                odd++;
                even++;
            }
            else{
                even++;
            }
        }
    }
}
