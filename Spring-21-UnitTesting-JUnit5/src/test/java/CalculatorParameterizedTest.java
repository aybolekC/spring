import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorParameterizedTest {


    @ParameterizedTest
    @ValueSource(strings = {"TS","JS", "Java"})
//    @EmptySource
//    @NullSource
//    @NullAndEmptySource
    void testCase1(String args){

        Assertions.assertTrue(!args.isEmpty());

    }


    @ParameterizedTest
    @ValueSource(ints = {3,6,9})
    void testCase2(int nums){

        Assertions.assertEquals(0,nums%3);

    }



    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase3(String args){

        Assertions.assertNotNull(args);

    }


    static String[] stringProvider(){
        return new String[]{"Java","JS","TS"};
    }

    @ParameterizedTest
    @CsvSource({"10,20,30","20,20,40", "30,20,50"})
    void testCase4(int num1,int num2,int result){
        Assertions.assertEquals(result, Calculator.add(num1,num2));

    }

    @ParameterizedTest
    @CsvFileSource(resources="/test.csv",numLinesToSkip = 1)
    void testCase5(int num1,int num2,int result){
        Assertions.assertEquals(result, Calculator.add(num1,num2));

    }


}
