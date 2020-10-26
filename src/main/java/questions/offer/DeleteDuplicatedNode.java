package questions.offer;

/**
 *  题目18-2 删除链表中的重复节点
 *
 *  在一个排序的链表中，删除所有重复的节点
 */
public class DeleteDuplicatedNode {

    public static Node deleteDuplicatedNode(Node head) {
        if (head == null) {
            return null;
        }
        Node sp = new Node(-1);
        sp.next = head;
        Node pre = sp;

        while (pre.next != null) {
            Node cur = pre.next;
            if (cur.next != null && cur.next.val == cur.val) {
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                Node temp = cur;
                pre.next = temp.next;
                temp.next = null;
            } else {
                pre = pre.next;
            }

        }

        return sp.next;
    }


    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }


}
