import java.util.Arrays;

/**
 * https://leetcode.cn/problems/3sum-closest/
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        //先排序
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++){
            int start = i + 1, end = nums.length - 1;
            while (start < end){
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum;
                } else if(sum < target){
                    start++;
                } else if(sum > target){
                    end--;
                } else {
                    return ans;
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        final int[] nums = new int[]{-1, 2, 1, -4};
        final int target = 1;
        Util.printCurrentMillis();
        System.out.println(threeSumClosest(nums, target));
        Util.printCurrentMillis();
    }
}
