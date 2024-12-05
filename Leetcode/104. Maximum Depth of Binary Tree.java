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
    public int maxDepth(TreeNode root) {
        if(root ==null) {
            return 0;
        }
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueD = new LinkedList<>();
        queue.add(root);
        queueD.add(1);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int depth = queueD.poll();
            maxDepth = Math.max(maxDepth, depth);
            if (node.left != null) {
                queue.offer(node.left);
                queueD.offer(depth+1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                queueD.offer(depth+1);
            }
        }
        return maxDepth;
    }
}