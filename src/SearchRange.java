/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 难度
 * 中等
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/">SearchRange</a>
 * */
public class SearchRange {


    private static int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if(leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target){
            return new int[]{leftIdx, rightIdx};
        }

        return new int[]{-1, -1};
    }

    private static int binarySearch(int[] nums, int target, boolean lower){
        int left = 0, right = nums.length - 1, ans = nums.length;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] > target || (lower && nums[mid] >= target)){
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        final int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        Util.printArray(searchRange(nums, 8));
    }
}
