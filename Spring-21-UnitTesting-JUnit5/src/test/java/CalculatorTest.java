import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    @BeforeAll
    static void setUpAll(){
        System.out.println("Before all is executed");
    }


    @AfterAll
    static void tearDownAll(){
        System.out.println("After all is executed");
    }


    @BeforeEach
    void setUpEach(){
        System.out.println("Before each is executed");
    }


    @AfterEach
    void tearDownEach(){
        System.out.println("After each is executed");
    }


    @Test
    void testCase1(){

        System.out.println("Test case 1");
        assertTrue(Calculator.operator.equals("add"));
        assertEquals("add", Calculator.operator);

    }

    @Test
    void testCase2(){
        System.out.println("Test case 2");
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
    }

    @Test
    void testCase3(){
        System.out.println("Test case 3");
        String nullString=null;
        String notNullString="Aya";
        assertNull(nullString);
        assertNotNull(notNullString);


    }

    @Test
    void testCase4(){
        System.out.println("Test case 4");
        Calculator c1=new Calculator();
        Calculator c2=c1;
        assertSame(c1, c2);
        Calculator c3=new Calculator();
        assertNotSame(c1, c3);

    }
    @Test
    void testCase5(){
        System.out.println("Test case 5");

    }

    @Test
    void add(){
        System.out.println("Test case 6");
        int actual=Calculator.add(2,3);
        assertEquals(5,actual,"It is not matching with expected value.");


    }
    @Test
    void add2(){
        System.out.println("Test case 7");
        assertThrows(IllegalArgumentException.class,()->Calculator.add2(5,2));

    }

}