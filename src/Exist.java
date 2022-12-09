/**
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *<br>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *<br>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/word-search">SearchWords</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Exist {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static boolean exist(char[][] board, String word){
        int[][] marked = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(backTrack(board, marked, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean backTrack(char[][] board, int[][] marked, int i, int j, int k, String word){
        System.out.println("i is " + i + " j is " + j + " k is " + k + " charK is " + word.charAt(k));
        if(word.charAt(k) != board[i][j]){
            return false;
        } else if(k == word.length() - 1){
            return true;
        }

        marked[i][j] = 1;
        boolean result = false;
        for(int[] direction : DIRECTIONS){
            int newI = i + direction[0], newJ = j + direction[1];
            if(newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length){
                if(marked[newI][newJ] == 1){
                    continue;
                }
                if(backTrack(board, marked, newI, newJ, k + 1, word)){
                    result = true;
                    break;
                }
            }
        }

        marked[i][j] = 0;
        return result;
    }

    public static void main(String[] args) {
        final char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        final String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}
