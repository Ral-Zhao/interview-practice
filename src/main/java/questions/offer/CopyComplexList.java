package questions.offer;

import questions.common.ComplexListNode;

/**
 * 题目35 复制链表的复制
 * <p>
 * 复制一个复杂链表。在复杂链表中，每个节点除了一个指向它下一个节点的指针外，还有一个指向任一节点的指针。
 */
public class CopyComplexList {
    public static ComplexListNode copy(ComplexListNode head) {
        if (head == null) {
            return null;
        }
        copyNode(head);
        linkRandom(head);
        return getCopyList(head);
    }

    //复制每个节点，并连接到该节点之后
    private static void copyNode(ComplexListNode head) {
        ComplexListNode current = head;
        while (current != null) {
            ComplexListNode next = current.next;
            ComplexListNode newNode = new ComplexListNode(current.value);
            newNode.next = next;
            current.next = newNode;
            current = next;
        }
    }

    //设置新复制节点的random指向
    private static void linkRandom(ComplexListNode head) {
        ComplexListNode current = head;
        while (current != null) {
            ComplexListNode copy = current.next;
            if (current.random != null) {
                copy.random = current.random.next;
            }
            current = copy.next;
        }
    }

    //拆解复制的节点
    private static ComplexListNode getCopyList(ComplexListNode head) {
        ComplexListNode newHead = head.next;
        ComplexListNode newCurrent = newHead;
        //newHead.next = newCurrent;
        while (newCurrent.next != null) {
            ComplexListNode next = newCurrent.next;
            head.next = next;
            head = next;
            newCurrent.next = next.next;
            newCurrent = next.next;
        }
        return newHead;
    }
}
