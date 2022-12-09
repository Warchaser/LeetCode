import java.util.ArrayList;

/**
 *给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *<br>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *<br>
 * 进阶：
 *<br>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *<br>
 * 致谢：
 *<br>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *<br>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/is-subsequence">IsSubsequence</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class IsSubsequence {

    public static boolean isSubsequence(String s, String t){

        final int sLength = s.length(), tLength = t.length();
        final ArrayList<Integer>[] index = new ArrayList[256];
        for(int i = 0; i < tLength; i++){
            char c = t.charAt(i);
            if(index[c] == null){
                index[c] = new ArrayList<>();
            }
            index[c].add(i);
        }

        //串t 上的指针
        int j = 0;

        for(int i = 0; i < sLength; i++){
            char c = s.charAt(i);
            if(index[c] == null){
                return false;
            }

            int position = leftBound(index[c], j);
            //到头也没有子序列串
            if(position == index[c].size()){
                return false;
            }

            j = index[c].get(position) + 1;
        }

        return true;

    }

    public static int leftBound(ArrayList<Integer> arrayList, int target){
        int low = 0, high = arrayList.size();
        while (low < high){
            int middle = low + (high - low) / 2;
            if(target > arrayList.get(middle)){
                low = middle + 1;
            } else {
                high = middle;
            }
        }

        return low;
    }

    /**
     * 短字符串版本
     * */
    public static boolean isSubsequence2(String s, String t){
        final char[] sArray = s.toCharArray();
        int index = 0;
        for(char tChar : t.toCharArray()){
            //index指针到子序列末尾，且字符相等index才后移，说明子序列完全在t序列中
            if(index == sArray.length){
                return true;
            }

            if(sArray[index] == tChar){
                index++;
            }
        }
        return index == sArray.length;
    }

    public static void main(String[] args) {
        final String s = "abc";
        final String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

}
