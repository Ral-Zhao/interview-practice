package questions.offer;

import org.junit.Assert;
import org.junit.Test;
import questions.common.ListNode;
import utils.ListUtil;

public class LastKNodeInListTest {
    @Test
    public void test(){
        ListNode head = ListUtil.buildList(1,2,3,4,5,6);
        ListNode node = LastKNodeInList.getLastKValue(head,3);
        Assert.assertNotNull(node);
        Assert.assertEquals(4,node.value);

        head = ListUtil.buildList(1,2,3);
        node = LastKNodeInList.getLastKValue(head,4);
        Assert.assertNull(node);
    }
}
