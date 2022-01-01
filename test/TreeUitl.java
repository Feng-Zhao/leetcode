package test;

import java.util.LinkedList;

public class TreeUitl {
    public static TreeNode buildTree(int[] tree){
        if(tree == null || tree.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(tree[0]);
        TreeNode cur = null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(i < tree.length){
            cur = queue.poll();
            cur.left = new TreeNode(tree[i++]);
            if(i < tree.length){
                cur.right = new TreeNode(tree[i++]);
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return root;
    }
}
