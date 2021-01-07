package Sort;

public class QuickSort {
    public void sort(int[] a){
        sort(a,0,a.length-1);

        for(int num : a){
            System.out.println(num);
        }
    }

    public void sort(int[] a,int left,int right){
        if(left >= right) return;

        int k = partition(a,left,right);

        sort(a,left,k-1);
        sort(a,k+1,right);
    }

    public int partition(int[] a,int lo,int hi){
        int left = lo;
        int right = hi + 1;

        int v = a[lo];

        while (true){
            while (a[++left] < v){
                if(left == hi){
                    break;
                }
            }

            while (a[--right] > v){
                if(right == lo){
                    break;
                }
            }

            if(left >= right) break;

            swap(a,left,right);
        }

        swap(a,lo,right);
        return right;
    }

    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = {5,3,8,1,2,4};
        quickSort.sort(a);
    }
}
