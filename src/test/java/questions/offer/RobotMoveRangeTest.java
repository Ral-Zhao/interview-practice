package questions.offer;

import org.junit.Assert;
import org.junit.Test;

public class RobotMoveRangeTest {

    @Test
    public void testRangeCount(){
        RobotMoveRange robotMoveRange = new RobotMoveRange();
        Assert.assertEquals(45, robotMoveRange.rangeCount(10,10,8));
        Assert.assertEquals(64, robotMoveRange.rangeCount(10,10,10));
        Assert.assertEquals(9, robotMoveRange.rangeCount(10,1,8));
    }
}
