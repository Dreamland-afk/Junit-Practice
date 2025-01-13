package org.dreamquest;

import org.dreamquest.util.DemoUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class AppTest
{
    DemoUtil demoUtil = null;



    @BeforeEach
    void init()
    {
        System.out.println("Initializing DemoUtils class.");
        demoUtil =  new DemoUtil();
    }

    @AfterEach
    void destroy()
    {
        System.out.println("Destroying DemoUtils class.");
        demoUtil =  null;
    }



    @Test
    public void addTest()
    {
        int result = demoUtil.add(4,6);
        Assertions.assertEquals(10, result);
    }

    @Test
    void checkNullTest()
    {
        Object object = demoUtil ;

        Assertions.assertNotNull(object);
//        Assertions.assertNull(object);
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void checkForSameObject()
    {

        String academy = new String("Luv2Code Academy");

        Assertions.assertSame(demoUtil.getAcademy(),academy);
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @EnabledOnJre(JRE.JAVA_8)
    void isGreaterTest()
    {
        Boolean greater = demoUtil.isGreater(9, 7);

        Assertions.assertTrue(greater);
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void getFirstThreeLettersOfAlphabetTest()
    {
        String arr[] = {"A","C","B"};

        Assertions.assertArrayEquals(demoUtil.getFirstThreeLettersOfAlphabet(),arr);
    }

    @Test
    void getAcademyInListTest()
    {
        List<String> list = Arrays.asList("luv", "2", "code");

        Assertions.assertIterableEquals(demoUtil.getAcademyInList(),list);
    }

    @Test
    void lineTest()
    {
        List<String> list = Arrays.asList("luv", "2", "code");

        Assertions.assertLinesMatch(demoUtil.getAcademyInList(),list);
    }

    @Test
   void throwExceptionTest() throws Exception {
       Assertions.assertThrows(Exception.class,() -> demoUtil.throwException(-1));
   }

   @Test
   @EnabledOnOs(OS.LINUX)
   void checkTimeOutTest()
   {
       Assertions.assertTimeout(Duration.ofMillis(100),()->demoUtil.checkTimeout());
   }


}
