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
    public int goodNodes(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int count =0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> pathStack = new Stack<>();
        stack.push(root);
        pathStack.push(Integer.MIN_VALUE);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            int currMax = pathStack.pop();
            if(node.val >= currMax) {
                count++;
            }
            if(node.left != null) {
                stack.push(node.left);
                pathStack.push(Math.max(node.val,currMax));
            }
            if(node.right != null) {
                stack.push(node.right);
                pathStack.push(Math.max(node.val,currMax));
            }
        }
        return count;
    }
}