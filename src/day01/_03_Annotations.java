package day01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _03_Annotations {

    @AfterClass // It works after the inside of the class
    public void finishingOperations() {
        System.out.println("After class operations worked.");
    }

    @Test // Annotation : specifies the type of method and its working properties
    public void test1() {  // Test1 : test metodunun adı
        System.out.println("test1 done.");
    }

    @Test // Annotation : specifies the type of method and its working properties
    public void test2() {  // Test1 : test metodunun adı
        System.out.println("test2 done.");
    }

    @BeforeClass  // It works before the inside of the class
    public void startUpOperations() {
        System.out.println("Before class operations worked.");
    }
}