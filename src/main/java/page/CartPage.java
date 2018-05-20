package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage  extends BasePage {

    //Ссылка на продукт в корзине
    @FindBy(xpath = "//*[@id=\"PageCenter\"]//div[class='eCartItem_name']")
    public List<WebElement> productCart;

    //ссылка на удалить все
    @FindBy(xpath = "//div[contains(@class, 'RemoveAll')]")
    public WebElement deleteAll;

    @FindBy(xpath = "//div[@class = 'bCartPage mBlockActions']")
    public WebElement closeButton;

}
