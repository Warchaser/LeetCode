import java.util.Arrays;

public class Merge {

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        final int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p1 = 0;
        int p2 = 0;

        int p = 0;

        while((p1 < m) && (p2 < n)){
            nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
        }

        final int sum = p1 + p2;
        final int differ = nums1.length - sum;

        if(p1 < m){
            System.arraycopy(nums1_copy, p1, nums1, sum, differ);
        }

        if(p2 < n){
            System.arraycopy(nums2, p2, nums1, sum, differ);
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1;
        int p2 = n - 1;
        int p = nums1.length - 1;
        while ((p1 >= 0) && (p2 >= 0)){
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }


    public static void main(String[] args){
        int[] num1 = new int[]{1,2,3,0,0,0};
        int[] num2 = new int[]{2, 5, 6};
        int m = 3, n = 3;
//        merge(num1, m, num2, n);

        merge2(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));
    }

}
