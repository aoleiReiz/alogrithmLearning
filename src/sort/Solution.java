package sort;

import java.util.Arrays;
import java.util.Random;

public class Solution {

    public void swap(int []arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int selectK(int[] arr, int l, int r, int k){

        int p = partition(arr, l, r);

        if(k == p) return arr[p];

        if(k < p) return selectK(arr, l, p - 1, k);
        return selectK(arr, p + 1, r, k);
    }

    private int partition(int []nums, int lo, int hi){
        Random random = new Random();
        int randomIndex = lo + random.nextInt(hi -lo + 1);
        swap(nums, lo, randomIndex);
        // nums[lo, ....i] <= v, nums[j+1, ...hi] >= v
        int i = lo + 1, j = hi;
        while (true){
            while (i <= j && nums[i] < nums[lo]){
                i ++;
            }
            while (j >= i && nums[j] > nums[lo]){
                j --;
            }
            if (i >= j)
                break;
            swap(nums, i, j);
            i ++;
            j --;
        }
        swap(nums, lo, j);
        return j;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0) return new int[0];

        selectK(arr, 0, arr.length - 1, k - 1);

        return Arrays.copyOf(arr, k);
    }

    public int[] smallestK(int[] arr, int k) {
        if(k == 0) return new int[0];

        selectK(arr, 0, arr.length - 1, k - 1);

        return Arrays.copyOf(arr, k);
    }

    public int findKthLargest(int[] nums, int k) {
        return selectK(nums, 0, nums.length -1 , nums.length - k);
    }

    public void sortColors(int[] nums) {
        if (null == nums || nums.length <= 1)
            return;
        int zero = -1, i =0, two = nums.length;
        //nums[0,....zero] == 0, nums[zero+1, ...., two - 1]==1, nums[two, ..., nums.lengg-1] == 2
       while (i < two) {
            if (nums[i] == 0){
                zero ++;
                swap(nums,i, zero);
                i++;
            }else if (nums[i] == 2){
                two --;
                swap(nums, i, two);
            }else{
                i ++;
            }
        }
    }
}
