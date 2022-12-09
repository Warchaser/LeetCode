import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *<br>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *<br>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *<br>
 *  
 *<br>
 * 示例 1：
 *<br>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 *<br>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 *<br>
 * 输入: candidates = [2], target = 1
 * 输出: []
 *  
 *<br>
 * 提示：
 *<br>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都 互不相同
 * 1 <= target <= 500
 *<br>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/combination-sum">CombinationSum</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

public class CombinationSum {

    private final static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        final List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(path, candidates, target, 0, 0);
        return res;
    }

    public static void backtrack(List<Integer> path, int[] candidates, int target, int sum, int begin){
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = begin; i < candidates.length; i++){
            int rs = candidates[i] + sum;
            if(rs <= target){
                path.add(candidates[i]);
                backtrack(path, candidates, target, rs, i);
                path.remove(path.size() - 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        final int[] candidates = new int[]{2,3,6,7};
        final int target = 7;
        Util.printList(combinationSum(candidates, target));
    }

}
