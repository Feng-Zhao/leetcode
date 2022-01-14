package test;


public class Test_JZ_27镜像二叉树 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = mirrorTree(root.right);
        node.right = mirrorTree(root.left);
        return node;
    }

    public static void main(String[] args) {
        Test_JZ_27镜像二叉树 solution = new Test_JZ_27镜像二叉树();
        int[] tree = {1,2,3,4,5,6,7,8};
        TreeNode A = TreeUitl.buildTree(tree);
        TreeUitl.printTree(A);
        A = solution.mirrorTree(A);
        System.out.println("==============================");
        TreeUitl.printTree(A);
    }
}
