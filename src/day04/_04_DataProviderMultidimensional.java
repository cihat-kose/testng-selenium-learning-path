package day04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _04_DataProviderMultidimensional {

    @Test(dataProvider = "getUserData")
    public void userTest(String username, String password) {
        //username,password
        System.out.println(username + " " + password);
    }

    @DataProvider
    public Object[][] getUserData() {
        Object[][] objects = {
                {"Kerem", "122334"},
                {"Said", "said5"},
                {"Zeynep", "zeynep111"},
                {"Salih", "salih500"}
        };
        return objects;
    }
}
