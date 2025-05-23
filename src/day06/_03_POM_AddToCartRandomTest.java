package day06;

import day05._04_PlaceOrderElements;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;
import utility.Tools;

/**
     Scenario :
     1- Open the site.
     2- Search the word "ipod" on the site
     3- Add a random one of the results to the basket.
     4- Click on Shopping Cart.
     5- Verify that the selected product is in the basket.
     6- Solve with POM.

     Senaryo :
     1- Siteyi açınız.
     2- Sitede "ipod" kelimesini aratınız
     3- Çıkan sonuçlardan random birini sepete atınız.
     4- Shopping Cart'a tıklatınız.
     5- Seçilen ürünün sepette olduğunu doğrulayınız.
     6- POM ile çözünüz.
 */

public class _03_POM_AddToCartRandomTest extends BaseDriver {

    @Test
    public void addToCart() {
        _04_PlaceOrderElements poe = new _04_PlaceOrderElements();
        _02_WishListElements wle = new _02_WishListElements();
        poe.searchBox.sendKeys("ipod" + Keys.ENTER);

        int randomSelection = Tools.randomGenerator(wle.productList.size()); // A random number is generated
        String cartItemText = wle.productList.get(randomSelection).getText(); // The name of the product in random was taken

        wle.addToChart.get(randomSelection).click(); // The wish button of the relevant random product was clicked
        wle.shoppingCart.click();

        boolean found = Tools.listContainsString(wle.wishList, cartItemText);
        Assert.assertTrue(found, "The requested product was not found in the cart list.");
    }
}
