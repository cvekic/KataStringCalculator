import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mladjan on 24.3.2014.
 */
public class StringCalculatorTest {

    StringCalculator subject;


    @Before
    public void setUp() {
        subject = new StringCalculator();
    }

    @Test
    public void mustReturnZeroForEmptyString() {
        assertEquals(0, subject.add(""));
    }

    @Test
    public void mustReturn1for1() {
        assertEquals(1, subject.add("1"));
    }

    @Test
    public void mustReturn2for2() {
        assertEquals(2, subject.add("2"));
    }

    @Test
    public void mustReturn3for3() {
        assertEquals(3, subject.add("3"));
    }

    @Test
    public void mustReturn3for1_2() {
        assertEquals(3, subject.add("1,2"));
    }

    @Test
    public void mustReturn6for1_2_3() {
        assertEquals(6, subject.add("1,2,3"));
    }

    @Test
    public void mustReturn6for1_2_3WithNewLines() {
        assertEquals(6, subject.add("1\\n2,3"));
    }

    @Test
    public void mustReturn3for1_2_3WithStrangeString() {
        assertEquals(3, subject.add("//;\n1;2"));
    }

}
