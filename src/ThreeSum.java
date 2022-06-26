import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();

        final int numsLength = nums.length;
        //长度小于3时，直接退出
        if(numsLength < 3){
            return result;
        }

        //将数组进行排序
        Arrays.sort(nums);
        for(int i = 0; i < numsLength; i++){
            //如果遍历的起始元素大于0，就直接退出
            //原因，此时数组为有序的数组，最小的数都大于0了，三数之和肯定大于0
            if(nums[i] > 0){
                return result;
            }
            //去重，当起始的值等于前一个元素，那么得到的结果将会和前一次相同
            //减少算法消耗时间
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int leftPointer = i + 1;
            int rightPointer = numsLength - 1;
            while (leftPointer < rightPointer){
                int sum = nums[i] + nums[leftPointer] + nums[rightPointer];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[leftPointer], nums[rightPointer]));

                    //去重，当起始的值等于前一个元素，那么得到的结果将会和前一次相同
                    //减少算法消耗时间
                    while(leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer + 1]){
                        leftPointer++;
                    }

                    //去重，当起始的值等于前一个元素，那么得到的结果将会和前一次相同
                    //减少算法消耗时间
                    while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer - 1]){
                        rightPointer--;
                    }

                    leftPointer++;
                    rightPointer--;
                } else if(sum < 0){
                    //如果结果小于0，将左指针右移
                    leftPointer++;
                } else {
                    //如果结果大于0，将右指针左移
                    rightPointer--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums).toString());
    }
}
