import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res);
        return String.join(",",res);
    }

    private void dfs(TreeNode node, List<String> res) {
        if(node==null) {
            res.add("N");
            return;
        }
        
        res.add(String.valueOf(node.val));
        dfs(node.left,res);
        dfs(node.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] i = {0};
        return dfs(vals,i);
    }

    private TreeNode dfs(String[] vals, int[] i) {
        if(vals[i[0]].equals("N")) {
            i[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left = dfs(vals,i);
        node.right = dfs(vals,i);
        return node;
    }
}
