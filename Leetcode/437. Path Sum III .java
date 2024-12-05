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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) {
            return 0;
        }
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<List<Long>> secStack = new Stack<>();
        stack.push(root);
        secStack.push(new ArrayList<Long>());
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            List<Long> currList = secStack.pop();
            currList.add(0L);
            System.out.println(currList);
            for(int i=0 ; i< currList.size(); i++) {
                currList.set(i, currList.get(i) + node.val);
                if(currList.get(i) == targetSum) {
                    
                    count++;
                } 
            }
            if(node.left!=null){
                stack.push(node.left);
                List<Long> deepCopy = new ArrayList<>(currList);
                secStack.push(deepCopy);
            }
            if(node.right!=null){
                stack.push(node.right);
                List<Long> deepCopy = new ArrayList<>(currList);
                secStack.push(deepCopy);
            }
        }
        return count;
    }
}