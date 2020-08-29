package hardlevel;

public class Solution {

    //数组逆序对
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    //对 a[lo,lo+1,... hi] 进行归并排序
    public int mergeSort(int []a, int lo, int hi){
        if (lo >= hi){
            return 0;
        }
        int res = 0;
        int mid = (hi - lo)/ 2 + lo;
        res += mergeSort(a, lo, mid);
        res += mergeSort(a, mid + 1, hi);
        if(a[mid] > a[mid + 1])
            res += merge(a, lo, mid, hi);
        return res;
    }
    // 进行归并
    private int merge(int []a, int lo, int mid, int hi){
        int count = 0;
        int []aux = new int[hi - lo + 1];
        for (int i = lo; i <= hi ; i++) {
            aux[i-lo] = a[i];
        }
        int left = lo, right = mid + 1;
        for (int i = lo; i <= hi ; i++) {
            if (left > mid){
                a[i] = aux[right - lo];
                right ++;
            }else if (right > hi){
                a[i] = aux[left - lo];
                left ++;
            }else if (aux[left-lo] <= aux[right - lo]){
                a[i] = aux[left - lo];
                left ++;
            }else{
                a[i] = aux[right - lo];
                right++;
                count += mid - left + 1;
            }
        }
        return count;
    }

}
