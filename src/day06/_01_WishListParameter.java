package day06;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utility.BaseDriver;
import utility.Tools;

import java.util.List;

public class _01_WishListParameter extends BaseDriver {

    /**
        Scenario ;
        1- Go to the site...
        2- Search "ipod" product, send "ipod" from xml
        3- Click on the Add Wish button of a random element among the resulting elements.
        4- Then click on WishList
        5- Verify whether the name of the product that appears here is the same as the product that was clicked.
        ========================================================================================================
        Senaryo ;
        1- Siteye gidiniz.
        2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
        3- Çıkan elemanlardan random bir elemanın Add Wish butonuna tıklayınız.
        4- Daha sonra WishList e tıklatınız
        5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
     */

    @Test
    @Parameters("searchText")
    public void addToWishList(String searchWord) {
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys(searchWord + Keys.ENTER);

        List<WebElement> wishButtons = driver.findElements(  // Wish buttons of products
                By.xpath("//button[@data-original-title='Add to Wish List']"));

        List<WebElement> productNameList = driver.findElements( // Titles of products
                By.xpath("//div[@class='caption']//h4"));

        int randomSelection = Tools.randomGenerator(productNameList.size()); // A random number is generated
        String wishItemText = productNameList.get(randomSelection).getText(); // The name of the product in random was taken
        System.out.println("wishItemText = " + wishItemText);            // Written for checking

        wishButtons.get(randomSelection).click(); // The wish button of the relevant Random product was clicked

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("wish list")));
        WebElement wishListLink = driver.findElement(By.xpath("//span[contains(text(),'Wish List')]"));
        wishListLink.click();

        //  Wish List navigated
        List<WebElement> wishList = driver.findElements(By.xpath("//td[@class='text-left']/a"));

        // Is the product we are looking for on the list or not?
        boolean found = Tools.listContainsString(wishList, wishItemText);

        Assert.assertTrue(found, "The product assigned to the Wish List could not be found.");
    }
}
