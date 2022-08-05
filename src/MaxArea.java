public class MaxArea {

    /**
     * https://leetcode.cn/problems/container-with-most-water/
     * 11. 盛最多水的容器
     * 双指针分别指向数组的0和length-1
     * 移动指针的策略,由于最大容量为i~j之间的距离乘（height[i]或height[j]的最小值）
     * 那么先移动i还是j?取决于height[x]的最小值。因移动大的height[x]可能会导致最终的容积变小；
     * 而移动小的height[x]有可能会导致最终的容积变大。
     * 所以先移动大的height[x]
     * */
    public static int maxArea(int[] height){
        int i = 0, j = height.length - 1, res = 0;
        while (i < j){
            res = height[i] < height[j] ? Math.max(res, (j - i) * height[i++]) :  Math.max(res, (j - i) * height[j--]);
        }

        return res;
    }

    public static void main(String[] args) {
        final int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
