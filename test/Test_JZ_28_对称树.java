package test;

public class Test_JZ_28_对称树 {
    public boolean isSymmetric(TreeNode root) {
        // TreeNode mirror = mirrorTree(root);
        // return check(root, mirror);
        return check2(root.left, root.right);
    }

    public boolean check(TreeNode tree, TreeNode mirror) {
        if(tree == null && mirror == null) return true;
        if(tree == null) return false;
        if(mirror == null) return false;
        return tree.val == mirror.val && check(tree.left, mirror.left) && check(tree.right, mirror.right);
    }

    public boolean check2(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null) return false;
        if(right == null) return false;
        return left.val == right.val && check2(left.left,right.right) && check2(left.right, right.left);
    }



    public static void main(String[] args) {
        Test_JZ_28_对称树 solution  = new Test_JZ_28_对称树();
        int[] tree = {1,2,2,3,4,4,3};
        TreeNode A = TreeUitl.buildTree(tree);
        System.out.println(solution.isSymmetric(A));
    }




    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = mirrorTree(root.right);
        node.right = mirrorTree(root.left);
        return node;
    }
}
