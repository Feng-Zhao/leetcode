package test;

import java.util.ArrayList;
import java.util.List;


public class Test_JZ_36树转循环链表 {
    List<Node> list = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        enq(root);
        reLink();
        return list.get(0);
    }
    private void enq(Node root){
        if(root.left != null){
            enq(root.left);
        }
        list.add(root);
        if(root.right != null){
            enq(root.right);
        }
    }
    private void reLink(){
        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        list.get(0).left = list.get(list.size() - 1);
        list.get(list.size()-1).right = list.get(0);
    }

    public static void main(String[] args) {
        int[] tree = {1,2,3,4,5,6,7};
        Node root = TreeUitl.buildTreeWithNode(tree);
        Test_JZ_36树转循环链表 solution = new Test_JZ_36树转循环链表();
        Node head = solution.treeToDoublyList(root);
        System.out.println(head);
    }
   
}


