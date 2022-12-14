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
    void testZero() throws Exception {
        int result = sc.add("");
        assertEquals(0,result);
    }
    @Test
    void testSingleNumber() throws Exception {
        int result = sc.add("1");
        assertEquals(1,result);
    }
    @Test
    void testSimpleAdd() throws Exception {
        int result = sc.add("1,2");
        assertEquals(3,result);
    }
    @Test
    void testNewLineAdding() throws Exception {
        int result = sc.add("1\n2,3");
        assertEquals(6,result);
    }
    @Test
    void testDifferentDelimiters() throws Exception {
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
        String expectedMessage = "-2, -3";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void testnumbersGreaterThat1000() throws Exception {
        int result = sc.add("2,1001");
        assertEquals(2,result);
    }
    @Test
    void testLongDelimiters() throws Exception {
        int result = sc.add("//[;;;]\n1;;;2;;;3");
        assertEquals(6,result);
    }
    @Test
    void testLongDelimitersWithRegexCharacter() throws Exception {
        int result = sc.add("//[|.*]\n1*.*2*.*3");
        assertEquals(6,result);
    }
    @Test
    void testDelimitersWithRegexCharacter() throws Exception {
        int result = sc.add("//*\n1*2*3");
        assertEquals(6,result);
    }
    @Test
    void testDelimitersWithRegexCharacter2() throws Exception {
        int result = sc.add("//.\n1.2.3");
        assertEquals(6,result);
    }
    @Test
    void testDelimitersWithRegexCharacter3() throws Exception {
        int result = sc.add("//|\n1|2|3");
        assertEquals(6,result);
    }
}