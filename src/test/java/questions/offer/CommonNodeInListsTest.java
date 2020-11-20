package questions.offer;

import org.junit.Assert;
import org.junit.Test;
import questions.common.ListNode;

public class CommonNodeInListsTest {
    @Test
    public void testMethod1() {
        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(4);
        head1.next = node11;
        node11.next = node12;
        node12.next = node13;
        ListNode head2 = new ListNode(10);
        ListNode node21 = new ListNode(21);
        ListNode node22 = new ListNode(13);
        head2.next = node21;
        node21.next = node22;
        node22.next = node11;

        Assert.assertNull(CommonNodeInLists.method1(head1, null));
        Assert.assertNull(CommonNodeInLists.method1(null, head1));
        ListNode common = CommonNodeInLists.method1(head1, head2);
        Assert.assertNotNull(common);
        Assert.assertEquals(2, common.value);
        node22.next = null;
        Assert.assertNull(CommonNodeInLists.method1(head1, head2));
        node22.next = node13;
        common = CommonNodeInLists.method1(head1, head2);
        Assert.assertNotNull(common);
        Assert.assertEquals(4, common.value);
        common = CommonNodeInLists.method1(head2, head2);
        Assert.assertNotNull(common);
        Assert.assertEquals(10, common.value);
    }

    @Test
    public void testMethod2() {
        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(4);
        head1.next = node11;
        node11.next = node12;
        node12.next = node13;
        ListNode head2 = new ListNode(10);
        ListNode node21 = new ListNode(21);
        ListNode node22 = new ListNode(13);
        head2.next = node21;
        node21.next = node22;
        node22.next = node11;

        Assert.assertNull(CommonNodeInLists.method2(head1, null));
        Assert.assertNull(CommonNodeInLists.method2(null, head1));
        ListNode common = CommonNodeInLists.method2(head1, head2);
        Assert.assertNotNull(common);
        Assert.assertEquals(2, common.value);
        node22.next = null;
        Assert.assertNull(CommonNodeInLists.method2(head1, head2));
        node22.next = node13;
        common = CommonNodeInLists.method2(head1, head2);
        Assert.assertNotNull(common);
        Assert.assertEquals(4, common.value);
        common = CommonNodeInLists.method2(head2, head2);
        Assert.assertNotNull(common);
        Assert.assertEquals(10, common.value);
    }

}
