package test;

import java.lang.module.ModuleDescriptor.Builder;

public class Test_JZ_27镜像二叉树 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root.left != null){
            root.left = mirrorTree(root.right);
        }
        if(root.right != null){
            root.right = mirrorTree(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] tree = {1,2,3,4,5,6,7,8};
        TreeNode root = TreeUitl.buildTree(tree);
        
    }
}
