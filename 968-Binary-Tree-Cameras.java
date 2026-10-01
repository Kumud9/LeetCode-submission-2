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
    int cam=0;
    public int minCameraCover(TreeNode root) {
         if(dfs(root)==0) cam++;
         return cam;
    }
    public int dfs(TreeNode root){
              if(root==null)return 2;
              int left= dfs(root.left);
              int right = dfs(root.right);
              if(left==0 || right==0){
                cam++;
                return 1;
              }
              else if(left==1 || right==1){
                return 2;
              }
              else return 0;
    }
}