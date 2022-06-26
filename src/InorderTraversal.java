import Bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * */
public class InorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root){
        final List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cursor = root;
        while(cursor != null || !stack.isEmpty()){
            if(cursor != null){
                stack.push(cursor);
                cursor = cursor.left;
            } else {
                cursor = stack.pop();
                result.add(cursor.val);
                cursor = cursor.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final Integer[] nodesArray = new Integer[]{1, null, 2, 3};
        System.out.println(inorderTraversal(Util.arrayToBTree(nodesArray)).toString());
    }

}
