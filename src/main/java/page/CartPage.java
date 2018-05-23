package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step.BaseStep;

import java.util.List;

public class CartPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(BaseStep.getDriver(), 3);
    //Ссылка на продукт в корзине
    @FindBy(xpath = "//*[@id=\"PageCenter\"]//div[class='eCartItem_name']")
    public List<WebElement> productCart;

/*    //ссылка на удалить все
    @FindBy(xpath = "//div[contains(@class, 'RemoveAll')]")
    public WebElement deleteAll;*/



    @FindBy(xpath = "//*[text()='Удалить всё']/..")
    WebElement clearAllButton;


    @FindBy(xpath = "//*[contains(text(),'пуста')]")
    public WebElement emptyCart;


    public void removeAll() {
//        wait.until(ExpectedConditions.visibilityOfAllElements(info));
        while (isElementPresent(By.xpath("//*[text()='Удалить всё']"))) {
            wait.until(ExpectedConditions.elementToBeClickable(clearAllButton)).click();
            BaseStep.getDriver().navigate().refresh();
        }
    }

    public boolean isElementPresent(By by) {
        try {
            WebElement webElement = BaseStep.getDriver().findElement(by);
            if (webElement.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
