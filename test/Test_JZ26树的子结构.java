package test;

import java.util.LinkedList;


public class Test_JZ26树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null && A != null) {
            return false;
        }
        return bfsCheck(A, B);
    }

    // 广度优先遍历, 先序遍历 外部 n
    boolean bfsCheck(TreeNode A, TreeNode B) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        TreeNode cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(checkEquals(cur, B)){
                return true;
            }
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        return false;
    }

    // dfs
    boolean checkEquals(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null && B != null) {
            return false;
        }

        if (checkEquals(A.left, B.left) && checkEquals(A.right, B.right)) {
            return A.val == B.val;
        }
        return false;
    }

    public static void main(String[] args) {
        Test_JZ26树的子结构 solution = new Test_JZ26树的子结构();
        int[] treeA = {4,2,3,4,5,6,7,8,9};
        int[] treeB = {4,8,9};
        TreeNode A = buildTree(treeA);
        TreeNode B = buildTree(treeB);
        System.out.println(solution.isSubStructure(A,B));
    }

    static TreeNode buildTree(int[] tree){
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

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode(int x) {
//         val = x;
//     }
// }