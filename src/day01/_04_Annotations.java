package day01;


import org.testng.annotations.*;

/**
       @BeforeClass --> will run at the beginning of the class (driver processes)

            @BeforeMethod --> It will run before every method(test methods)
                @Test --> methods in which tests run
            @AfterMethod --> It will run after every method

            @BeforeMethod --> It will run before every method(test methods)
                @Test --> methods in which tests run
            @AfterMethod --> It will run after every method

         @AfterClass --> It will run at the end of Class's execution (driver off)

beforeClass

beforeMethod
test1
afterMethod

beforeMethod
test2
afterMethod

afterClass
     */


public class _04_Annotations {

    @Test
    public void test1() { System.out.println("test1 done"); }

    @Test
    public void test2() { System.out.println("test2 done"); }

    @BeforeClass
    public void beforeClass() { System.out.println("beforeClass done"); }

    @AfterClass
    public void afterClass() { System.out.println("afterClass done"); }

    @BeforeMethod
    public void beforeMethod() { System.out.println("beforeMethod done"); }

    @AfterMethod
    public void afterMethod() { System.out.println("afterMethod done"); }

}
