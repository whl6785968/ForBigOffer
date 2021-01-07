package Sort;

public class BubbleSort {
    public void sort(int[] a){
        int n = a.length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n - i - 1;j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

        for(int num : a){
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] a = {5,3,8,1,2,4};
        bubbleSort.sort(a);
    }
}
