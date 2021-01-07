package BinaryDemo;

public class NC48 {
    public int search (int[] A, int target) {
        // write code here
        int n = A.length;

        int low = 0;
        int hi = n - 1;

        while (low <= hi){
            int mid = low + (hi - low) / 2;

            if(A[mid] == target){
                return mid;
            }
            else{
                //左侧有序
                if(A[low] <= A[mid]){
                    if(A[mid] > target && target >= A[low]){
                        hi = mid - 1;
                    }
                    else{
                        low = mid + 1;
                    }
                }
                else{
                    //如果右侧有序
                    if(A[mid] < target && target <= A[hi]){
                        low = mid + 1;
                    }
                    else{
                        hi = mid - 1;
                    }
                }
            }
        }

        return -1;
    }
}
