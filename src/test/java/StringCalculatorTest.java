import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void mustReturnZeroForEmptyString() throws Exception{
        assertEquals(0, subject.add(""));
    }

    @Test
    public void mustReturn1for1() throws Exception {
        assertEquals(1, subject.add("1"));
    }

    @Test
    public void mustReturn2for2() throws Exception {
        assertEquals(2, subject.add("2"));
    }

    @Test
    public void mustReturn3for3() throws Exception {
        assertEquals(3, subject.add("3"));
    }

    @Test
    public void mustReturn3for1_2() throws Exception {
        assertEquals(3, subject.add("1,2"));
    }

    @Test
    public void mustReturn6for1_2_3() throws Exception {
        assertEquals(6, subject.add("1,2,3"));
    }

    @Test
    public void mustReturn6for1_2_3WithNewLines() throws Exception {
        assertEquals(6, subject.add("1\\n2,3"));
    }

    @Test
    public void mustReturn3for1_2_3WithStrangeString() throws Exception {
        assertEquals(3, subject.add("//;\n1;2"));
    }

    @Test(expected = StringCalculator.NegativesNotAllowedException.class)
    public void mustThrowExceptionForNegativeNumbers() throws Exception {
       subject.add("1,2,3,-4,5");
    }

    @Test
    public void addNegativesThrowsExceptionWithMessageDetailingAllNegatives()  throws Exception {
        try {
            subject.add("-1,-2");
        } catch (StringCalculator.NegativesNotAllowedException e) {
            assertTrue(e.getMessage().contains("-1"));
            assertTrue(e.getMessage().contains("-2"));
        }
    }

}
