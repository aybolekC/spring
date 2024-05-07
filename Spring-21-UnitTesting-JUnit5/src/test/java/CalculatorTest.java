import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testCase1(){

        assertTrue(Calculator.operator.equals("add"));
        assertEquals("add", Calculator.operator);

    }

    @Test
    void testCase2(){
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});

    }

    @Test
    void testCase3(){
        String nullString=null;
        String notNullString="Aya";
        assertNull(nullString);
        assertNotNull(notNullString);


    }

    @Test
    void testCase4(){

        Calculator c1=new Calculator();
        Calculator c2=c1;
        assertSame(c1, c2);
        Calculator c3=new Calculator();
        assertNotSame(c1, c3);

    }
    @Test
    void testCase5(){

    }

    @Test
    void add(){
        int actual=Calculator.add(2,3);
        assertEquals(5,actual,"It is not matching with expected value.");


    }
    @Test
    void add2(){

        assertThrows(IllegalArgumentException.class,()->Calculator.add2(5,2));

    }

}