//Given a binary search tree, return a balanced binary search tree with the same
// node values. 
//
// A binary search tree is balanced if and only if the depth of the two subtrees
// of every node never differ by more than 1. 
//
// If there is more than one answer, return any of them. 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,null,2,null,3,null,4,null,null]
//Output: [2,1,3,null,null,null,4]
//Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is 
//also correct.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is between 1 and 10^4. 
// The tree nodes will have distinct values between 1 and 10^5. 
// Related Topics Binary Search Tree 
// 👍 395 👎 22


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sorted = new ArrayList<>();
        toList(root, sorted);
        return  balanceBST(0, sorted.size() - 1, sorted);
    }

    private TreeNode balanceBST(int l, int r, List<Integer> sorted) {
        if(l > r) return  null;
        int mid = (l+r) / 2;
        TreeNode node = new TreeNode(sorted.get(mid));
        node.left = balanceBST(l, mid-1, sorted);
        node.right = balanceBST(mid + 1, r, sorted);
        return  node;
    }

    private void toList(TreeNode node, List<Integer> sorted){
        if(node == null) return;
        toList(node.left, sorted);
        sorted.add(node.val);
        toList(node.right, sorted);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)














