package testing;


import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeTest
    public void init() {
        stringCalculator = new StringCalculator();
    }
    @AfterTest
    public void destroy() {
        stringCalculator = null;
    }
    
    @Test
    public void testEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }
    
    @Test
    public void testAddOneNumber() {
        assertEquals(1, stringCalculator.add("1"));
    }
    
    @Test
    public void testAddMultipleNumbers() {
        assertEquals(3, stringCalculator.add("1,2"));
    }
    
    @Test
    public void testAddStringNumbers() {
        assertEquals(4, stringCalculator.add("1,2,a"));
    }
    
    @Test
    public void testAddAlphabets() {
        assertEquals(3, stringCalculator.add("b,a"));
    }
    
    @Test
    public void testNewLine() {
        assertEquals(10, stringCalculator.add("1\n2,3\n4"));
    }
    
    @Test
    public void testNegativeNumber() {
        try {
            stringCalculator.add("-1,2");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negatives not allowed: -1");
        }
        try {
            stringCalculator.add("1,-2,3,-5");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negatives not allowed: -2,-5");
        }
    }

    @Test
    public void testOverThousand() {
        assertEquals(10, stringCalculator.add("1000,10"));
    }

    @Test
    public void testOtherDelimiter() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
        
    }
    @Test
    public void supportOddEvenAddition() {
    	assertEquals(4, stringCalculator.add("0//2,4,6"));
    	assertEquals(8, stringCalculator.add("1//2,4,6"));
    }

}
