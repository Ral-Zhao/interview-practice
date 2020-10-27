package questions.offer;

import org.junit.Test;
import questions.common.ListNode;
import utils.ListUtil;

public class MergeSortedListTest {
    @Test
    public void test(){
        ListNode list1 = ListUtil.buildList(1,3,5,7,9);
        ListNode list2 = ListUtil.buildList(2,4,5,6,8,9);
        ListNode result = MergeSortedList.merge(list1,list2);
        ListUtil.printList(result);

        list1 = null;
        list2 = ListUtil.buildList(2,4,5,6,8,9);
        result = MergeSortedList.merge(list1,list2);
        ListUtil.printList(result);
    }
}
