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


    public static Node buildTreeWithNode(int[] tree){
        if(tree == null || tree.length == 0){
            return null;
        }
        Node root = new Node(tree[0]);
        Node cur = null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(i < tree.length){
            cur = queue.poll();
            cur.left = new Node(tree[i++]);
            if(i < tree.length){
                cur.right = new Node(tree[i++]);
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return root;
    }

    public static void printTree(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            System.out.format("%s,",cur.val);
            if(cur.left != null) queue.offer(cur.left);
            if(cur.right != null) queue.offer(cur.right);
        }
    }

    public static void main(String[] args) {
        int[] tree = {1,2,3,4,5};
        Node head = buildTreeWithNode(tree);
        System.out.println(head);
    }
}

