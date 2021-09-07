package questions.leetbook.top_interview_questions.list;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 1000
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xam1wr/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        copyList(head);
        linkRandom(head);
        return splitNewList(head);
    }

    private void copyList(Node head) {
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            Node next = cur.next;
            cur.next = newNode;
            newNode.next = next;
            cur = next;
        }
    }

    private void linkRandom(Node head) {
        Node cur = head;
        while (cur != null) {
            Node dup = cur.next;
            if (cur.random != null) {
                dup.random = cur.random.next;
            }
            cur = dup.next;
        }
    }

    private Node splitNewList(Node head) {
        Node sp = new Node(-1);
        Node p1 = sp;
        Node newSp = new Node(-1);
        Node p2 = newSp;
        Node cur = head;
        while (cur != null) {
            Node newNode = cur.next;
            p1.next = cur;
            cur.next = null;
            p1 = p1.next;
            p2.next = newNode;
            p2 = p2.next;
            cur = newNode.next;
            newNode.next = null;
        }
        sp.next = null;
        sp = newSp.next;
        newSp.next = null;
        return sp;
    }

    public static void main(String[] args) {
        RandomList solution = new RandomList();
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node newNode = solution.copyRandomList(node1);


    }
}
