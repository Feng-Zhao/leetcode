package test;

import java.util.HashMap;
import java.util.Map;

public class Test_JZ_35复杂链表复制 {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Map<Integer,Node> orderedMap = new HashMap<>();
        Node emptyHead = new Node(0);
        Node myHead = head;
        Node cur = emptyHead;
        int pos = 0;
        // 建立 next 链表, 记录各个节点位置
        while (myHead != null){
            cur.next = new Node(myHead.val);
            cur = cur.next;
            orderedMap.put(pos,cur);
            pos++;
            myHead = myHead.next;
        }
        linkRandom(emptyHead,head,orderedMap);
        return emptyHead.next;
    }

    private void linkRandom(Node emptyHead, Node head, Map<Integer,Node> map){
        Node oldCur = head;
        Node newCur = emptyHead.next;
        while (oldCur != null){
            if(oldCur.random == null) newCur.random = null;
            else{
                Node inner = head;
                int pos = 0;
                while (inner != oldCur.random){
                    inner = inner.next;
                    pos++;
                }
                newCur.random = map.get(pos);
            }
            oldCur = oldCur.next;
            newCur = newCur.next;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node(10);
        Node e = new Node(1);
        a.next = b; a.random = null;
        b.next = c; b.random = a;
        c.next = d; c.random = null;
        d.next = e; d.random = c;
        e.random = a;

        Test_JZ_35复杂链表复制 solution = new Test_JZ_35复杂链表复制();
        Node result = solution.copyRandomList(a);
        System.out.println(result);
    }

    static class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

