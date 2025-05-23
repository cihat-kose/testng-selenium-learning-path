package day01;

import org.testng.annotations.Test;

public class _01_Intro {

//    public static void main(String[] args) {
//        makeDriverOperations();
//        openWebsite();
//        makeLoginTest();
//    }

//      @Test JUnit Test i
//      public void Test1()

//      {
//          makeDriverOperations();
//          openWebsite();
//          makeLoginTest();
//      }

    //  Works in alphabetical order by default

    @Test(priority = 1) // default : 0 ||| still works alphabetically in the same levels
    public void makeDriverOperations() {
        System.out.println("makeDriverOperations done");
    }

    @Test(priority = 2)
    public void openWebsite() {
        System.out.println("openWebsite done");
    }

    @Test(priority = 3)
    public void makeLoginTest() {
        System.out.println("makeLoginTest done");
    }

    @Test(priority = 4)
    public void closeDriver() {
        System.out.println("closeDriver done");
    }
}