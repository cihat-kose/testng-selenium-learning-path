package day01;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utility.BaseDriver;
import utility.Tools;

public class _09_SubscribeNewsletter extends BaseDriver {

    /**
          Scenario:
          1- Open the site.
          2- Subscribe to the Newsletter Subscribe operation (YES), check that the operation is successful.
          3- Unsubscribe from Newsletter Subscribe with a separate test (NO).
          4- Check the Newsletter Subscriber status with a separate test; If YES, say NO, if NO, say YES.
          --------------------------------------------------------------------------------------------------
          Senaryo:
          1- Siteyi açınız.
          2- Newsletter  Subscribe işlemini abone olunuz(YES), işlemin başarılı olduğunu kontrol ediniz.
          3- Ayrı bir test ile Newsletter Subscribe işlemini abonelikten çıkınız(NO).
          4- Ayrı bir test ile Newsletter Subscribe durumunu kontrol ediniz; YES ise NO, NO ise YES yapınız.
     */

    By newsLetterLinkLoc = By.linkText("Newsletter");
    By subscribeYesLoc = By.xpath("//input[@value='1']");
    By subscribeNoLoc = By.xpath("//input[@value='0']");
    By continueButtonLoc = By.xpath("//input[@value='Continue']");

    @Test(priority = 1)
    public void subscribeFunctionYes() {
        WebElement newsLetterLink = driver.findElement(newsLetterLinkLoc);
        newsLetterLink.click();

        WebElement subscribeYes = driver.findElement(subscribeYesLoc);
        subscribeYes.click();

        WebElement continueButton = driver.findElement(continueButtonLoc);
        continueButton.click();

        Tools.successMessageValidation();
    }

    @Test(priority = 2)
    public void subscribeFunctionNo() {
        WebElement newsLetterLink = driver.findElement(newsLetterLinkLoc);
        newsLetterLink.click();

        WebElement subscribeNo = driver.findElement(subscribeNoLoc);
        subscribeNo.click();

        WebElement continueButton = driver.findElement(continueButtonLoc);
        continueButton.click();

        Tools.successMessageValidation();
    }

    @Test(priority = 3)
    public void subscribeFunctionForBoth() {
        WebElement newsLetterLink = driver.findElement(newsLetterLinkLoc);
        newsLetterLink.click();

        WebElement subscribeYes = driver.findElement(subscribeYesLoc);
        WebElement subscribeNo = driver.findElement(subscribeNoLoc);

        // Click no if yes is selected, click yes if no is selected
        if (subscribeYes.isSelected()) {
            subscribeNo.click();
        } else {
            subscribeYes.click();
        }

        WebElement continueButton = driver.findElement(continueButtonLoc);
        continueButton.click();

        Tools.successMessageValidation();
    }
}
