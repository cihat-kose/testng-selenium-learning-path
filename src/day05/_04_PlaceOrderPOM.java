package day05;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class _04_PlaceOrderPOM extends BaseDriver {

    /**
        Scenario :
        1- Open the site.
        2- Search the word "ipod" on the site
        3- Put the first of the results in the basket.
        4- Click on Shopping Chart.
        5- Checkout.
        6- Click Continue buttons and enter the information.
        7- Confirm that you have placed the order with en confirm.
        Note: Verify with the text "Your order has been placed" on the page that appears.

        Senaryo :
        1- Siteyi açınız.
        2- Sitede "ipod" kelimesini aratınız.
        3- Çıkan sonuçlardan ilkini sepete atınız.
        4- Shopping Carta tıklatınız.
        5- Checkout yapınız.
        6- Continue butonlarına tıklatıp bilgileri giriniz.
        7- En confirm ile siparişi verdiğinizi doğrulayınız.
        Not: Doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
     */

    @Test
    public void proceedToCheckout() {

        _04_PlaceOrderElements elements = new _04_PlaceOrderElements();

        elements.searchBox.sendKeys("ipod" + Keys.ENTER);
        elements.addToChart.click();
        elements.shoppingChart.click();
        elements.checkOut.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continue1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue3)).click();
        elements.agree.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue4)).click();

        elements.confirm.click();

        wait.until(ExpectedConditions.urlContains("success"));

        Assert.assertEquals(elements.msg.getText(), "Your order has been placed!");
    }
}
