class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode node, int maxVal) {

          if (node == null) {
            return 0;
        }
        
        int res = node.val >= maxVal ? 1 : 0;
        maxVal = Math.max(node.val,maxVal);
        res += dfs(node.left, maxVal);
        
        res += dfs(node.right, maxVal);
        
        return res;
    }
}