package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage{

    @FindBy(xpath = "//div[contains(text(),'Добавить')]")
    public WebElement buttonCart;
}
