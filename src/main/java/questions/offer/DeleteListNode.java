package questions.offer;

/**
 *  题目18-1 删除链表的节点
 *
 *  给定单链表的头结点和目标节点，在O(1)时间内删除该节点
 *
 */
public class DeleteListNode {

    public static Node deleteNode(Node head, Node target) {
        if (target.next != null) {
            Node next = target.next;
            target.val = next.val;
            target.next = next.next;
            next.next = null;
        } else if (target == head) {
            head = null;
        } else {
            Node pre = head;
            while (pre.next != target) {
                pre = pre.next;
            }
            pre.next = null;
        }
        return head;
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
