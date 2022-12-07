import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class stringCalculatorTest{
    StringCalculator sc;
    @BeforeEach
    public void setUp() {
        sc =new StringCalculator();
    }
    @Test
    void testZero(){
        int result = sc.add("");
        assertEquals(0,result);
    }
    @Test
    void testSingleNumber(){
        int result = sc.add("1");
        assertEquals(1,result);
    }
    @Test
    void testSimpleAdd(){
        int result = sc.add("1,2");
        assertEquals(3,result);
    }
    @Test
    void testNewLineAdding(){
        int result = sc.add("1\n2,3");
        assertEquals(6,result);
    }
    @Test
    void testDifferentDelimiters(){
        int result = sc.add("//;\n1;2");
        assertEquals(3,result);
    }
    @Test
    void testNegativeNumber(){
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            sc.add("1,-2");
        });
        String expectedMessage = "-2";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void testNegativeNumbers(){
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            sc.add("1,-2,-3");
        });
        String expectedMessage = "-2,-3";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}