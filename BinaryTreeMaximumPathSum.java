class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int res[] = new int[1];
        res[0] = root.val;
        dfs(root,res);
        return res[0];
    }

    public int dfs(TreeNode node, int[] res) {
        if(node == null) return 0;

        int leftMax = dfs(node.left, res);
        int rightMax = dfs(node.right, res);

        //omit negative values and keep root.val    
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        //value with splitting at root node. ie adding left and right node
        res[0] = Math.max(res[0], node.val+leftMax+rightMax);

        //value without splitting at root node. ie taking rootval + max(left, right)
        return node.val + Math.max(leftMax, rightMax);
    }
}