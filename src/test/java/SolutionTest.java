import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void multiplyTest1() {
        String num1 = "2";
        String num2 = "3";
        String expected = "6";
        String actual = new Solution().multiply(num1, num2);

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void multiplyTest2() {
        String num1 = "123";
        String num2 = "456";
        String expected = "56088";
        String actual = new Solution().multiply(num1, num2);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void multiplyTest3() {
        String num1 = "9";
        String num2 = "99";
        String expected = "891";
        String actual = new Solution().multiply(num1, num2);

        Assert.assertEquals(expected, actual);

    }
}
