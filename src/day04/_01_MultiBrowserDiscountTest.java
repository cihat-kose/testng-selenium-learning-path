package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriverParameter;

import java.util.List;

public class _01_MultiBrowserDiscountTest extends BaseDriverParameter {

    /**
        Scenario:
        1- Go to the site,
        2- Click on Specials,
        3- Inquire about the products (is there a discount on all products, is the old price higher than the new price)
        4- After the above process, the previous price of each product will be changed from the current price.
        Verify that it is high.
        5- Test the above process in 2 different browsers and in parallel.
        -----------------------------------------------------------------------------------------------------------------
        Senaryo:
        1- Siteye gidiniz,
        2- Specials'e tıklayınız,
        3- Çıkan ürünlerde (bütün ürünlerde indirim var mı eski fiyat yeni fiyattan büyük mü) şeklinde sogulama yapınız
        4- Yukarıdaki işlemden sonra her ürünün önceki fiyatının şu andaki fiyattan
        yüksek olduğunu doğrulayınız.
        5- Yukarıdaki işlemi 2 farklı browserda ve paralel şekilde test ediniz.
     */

    @Test
    public void test() {
        WebElement specials = driver.findElement(By.linkText("Specials"));
        specials.click();

        List<WebElement> newPrices = driver.findElements(By.cssSelector("span[class='price-new']")); // $80 $90
        List<WebElement> oldPrices = driver.findElements(By.cssSelector("span[class='price-old']")); // $100 $100

        Assert.assertEquals(oldPrices.size(), newPrices.size(), "No discounts were found on all of them."); // 3-

        for (int i = 0; i < newPrices.size(); i++) { // 2 times
            double newPrice = Double.parseDouble(newPrices.get(i).getText().replaceAll("[^0-9.,]", ""));
            double oldPrice = Double.parseDouble(oldPrices.get(i).getText().replaceAll("[^0-9.,]", ""));

            System.out.println(newPrice + " " + oldPrice);
            Assert.assertTrue(newPrice < oldPrice, "The new price is not lower than the old price."); // 4-
        }
    }
}
