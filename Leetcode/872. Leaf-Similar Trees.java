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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getLeaves(root1);
        List<Integer> list2 = getLeaves(root2);
        System.out.println(list1);
        System.out.println(list2);
        if(list1.size() != list2.size()) {
            return false;
        }
        for(int i=0;i<list1.size();i++) {
            if(!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getLeaves(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left == null && node.right == null) {
                list.add(node.val);
            }
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        return list;
    }
}