package day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;

import java.util.List;

public class _02_HomePageDiscountCheckTest extends BaseDriver {

    /**
        Scenario:
        1- Go to the site
        2- Click Your Store, (Go to the home page)
        3- Check the products that are on sale (are there any discounts on all products,
        are there old prices and new prices), find the quantity of products on sale.
        4- After the above process, verify that the previous price of the products on sale
        is higher than the current price.
        -------------------------------------------------------------------------------------------------- *
        Senaryo:
        1- Siteye gidiniz
        2- Your Store tiklayiniz, (Ana sayfaya gidiniz)
        3- Cikan urun lerde (bütün ürünlerde indirim var mı, eski fiyat yeni fiyat var mı) kontrol edin,
        indirimde olan ürünlerin miktarını bulunuz.
        4- Yukarıdaki işlemden sonra indirimde olan ürünleri önceki fiyatının
        şu andaki fiyattan yüksek olduğunu doğrulayınız.
     */

    @Test
    public void test() {
        WebElement homePage = driver.findElement(By.linkText("Your Store"));
        homePage.click();

        List<WebElement> products = driver.findElements(By.cssSelector("p[class='price']"));

        int discountedProductQuantity = 0;
        int productQuantitiesWithoutDiscount = 0;

        for (int i = 0; i < products.size(); i++) {
            List<WebElement> newPrice = products.get(i).findElements(By.cssSelector("span[class='price-new']")); //

            if (!newPrice.isEmpty()) // It means there is a discount
            {
                WebElement nPrice = products.get(i).findElement(By.cssSelector("span[class='price-new']"));
                WebElement oPrice = products.get(i).findElement(By.cssSelector("span[class='price-old']"));

                double newPriceDouble = Double.parseDouble(nPrice.getText().replaceAll("[^0-9,.]", ""));
                double oldPriceDouble = Double.parseDouble(oPrice.getText().replaceAll("[^0-9,.]", ""));
                System.out.println("Old Price = " + oldPriceDouble + " - New Price" + "=" + newPriceDouble);

                Assert.assertTrue(newPriceDouble < oldPriceDouble, "The new price is not lower.");
                discountedProductQuantity++;
            } else // Means no discount
            {
                System.out.println("products.get(i).getText() = " + products.get(i).getText());
                productQuantitiesWithoutDiscount++;
            }
        }
        System.out.println("productQuantitiesWithoutDiscount = " + productQuantitiesWithoutDiscount);
        System.out.println("discountedProductQuantity = " + discountedProductQuantity);
    }
}
