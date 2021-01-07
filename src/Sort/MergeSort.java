package Sort;

import java.util.Arrays;

public class MergeSort {

    int[] aux;

    public void mergeSort(int[] a){
        aux = new int[a.length];
        mergeSort(a,0,a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public void mergeSort(int[] a,int lo,int hi){
        if(hi <= lo) return;

        int mid = lo + (hi - lo) / 2;
        mergeSort(a,lo,mid);
        mergeSort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public void merge(int[] a,int lo,int mid,int hi){
        int i = lo;
        int j = mid + 1;

        for(int k = lo;k <= hi;k++){
            aux[k] = a[k];
        }

        for(int k = lo;k <= hi;k++){
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(a[i] > a[j]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a = {3,1,2,4,5};
        mergeSort.mergeSort(a);
    }
}
