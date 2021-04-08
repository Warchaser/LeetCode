public class MaxSubArray {

    public static int maxSubArray(int[] nums){
        int pre = 0, maxN = nums[0];
        for(int num : nums){
            pre = Math.max(pre + num, num);
            maxN = Math.max(pre, maxN);
        }
        return maxN;
    }

    public static void main(String[] args) {
        final int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

}
