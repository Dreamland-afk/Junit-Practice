package org.dreamquest.fizbuzz;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {

//    Check if number is divided by 3 and return "Fizz"
    @DisplayName("Divided by 3")
    @Test
    @Order(1)
    void testDividedByThree()
    {
        Assertions.assertEquals("Fizz", FizzBuzz.compute(9));
    }

    //    Check if number is divided by 5 and return "Buzz"
    @DisplayName("Divided by 5")
    @Test
    @Order(2)
    void testDividedByFive()
    {
        Assertions.assertEquals("Buzz", FizzBuzz.compute(10));
    }

    //    Check if number is divided by 5 and return "Buzz"
    @DisplayName("Divided by 3 and 5")
    @Test
    @Order(3)
    void testDividedByThreeAndFive()
    {
        Assertions.assertEquals("FizzBuzz", FizzBuzz.compute(15));
    }

    //    Return the number if it is not divided by any if the the numbers i.e 3 and 5
    @DisplayName("Not divided by 3 and 5")
    @Test
    @Order(4)
    void returnNumber()
    {
        Assertions.assertEquals("14" , FizzBuzz.compute(14));
    }

    //    ParameterizedTest
    @DisplayName("Test the app with bulk data ")
    @ParameterizedTest(name = "Input {0} Expected {1} ")
//    @CsvSource({
//            "1,1","3,Fizz"
//    })
    @CsvFileSource(resources = "/TestSet.csv")
    @Order(5)
    void TesttheApp(String input, String expected)
    {
        Assertions.assertEquals(expected, FizzBuzz.compute(Integer.parseInt(input)));
    }

}
