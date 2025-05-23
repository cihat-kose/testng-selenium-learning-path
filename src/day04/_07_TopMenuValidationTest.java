package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;

import java.util.ArrayList;
import java.util.List;

public class _07_TopMenuValidationTest extends BaseDriver {

    /**
        Scenario
        1- Open the site.
        2- Verify that the menu items in the Top Menu exist. (menuValidation)
        3- Desktops, Laptops & Notebooks, Components, Tablets, Software, Phones & PDAs, Cameras, MP3 Players

        Senaryo
        1- Siteyi açınız.
        2- Top Menudeki menu elemanlarının olduğunu doğrulayınız.(menuValidation)
        3- Desktops, Laptops & Notebooks, Components, Tablets, Software, Phones & PDAs, Cameras, MP3 Players
     */

    @Test
    public void menuValidation() {
        // Our Expected List
        List<String> menuExpectedList = new ArrayList<>();
        menuExpectedList.add("Desktops");
        menuExpectedList.add("Laptops & Notebooks");
        menuExpectedList.add("Components");
        menuExpectedList.add("Tablets");
        menuExpectedList.add("Software");
        menuExpectedList.add("Phones & PDAs");
        menuExpectedList.add("Cameras");
        menuExpectedList.add("MP3 Players");

        // Let's get our menu list from the web.
        List<WebElement> menuActualList = driver.findElements(By.cssSelector("[class='nav navbar-nav'] > li"));

        for (int i = 0; i < menuExpectedList.size(); i++) {
            Assert.assertEquals(menuActualList.get(i).getText(),
                    menuExpectedList.get(i),
                    "Menu is not as expected");
        }
    }
}
